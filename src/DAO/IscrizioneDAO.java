package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Iscrizione;
import model.Studente;

public class IscrizioneDAO {
	List<Iscrizione> iscrizioni;
	public List<Iscrizione> getIscrizioni(){
		return this.iscrizioni;
	}
	public IscrizioneDAO() {
		iscrizioni=getAllIscrizioni();
	}
	
	public List<Iscrizione> getAllIscrizioni() {
		final String sql = "SELECT * FROM iscrizione";
		List<Iscrizione> iscrizioni = new LinkedList<Iscrizione>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String matricola = rs.getString("matricola");
				String codins = rs.getString("codins");
				//System.out.println(matricola + " " + codins);
				Iscrizione s=new Iscrizione();
				s.setMatricola(matricola);
				s.setCodins(codins);
				iscrizioni.add(s);
			}
			return iscrizioni;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db iscrizioni");
		}
	}
	
	public List<String> getMatricolaStudentiWithCodins(String codins) {
		List<String> matricole=new ArrayList<String>();
		for(Iscrizione s:iscrizioni) 
			if(s.getCodins().equals(codins)) {
				matricole.add(s.getMatricola());
			}
		return matricole;
	}

}
