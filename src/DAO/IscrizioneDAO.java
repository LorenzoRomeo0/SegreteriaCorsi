package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Corso;
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
		final String sql = "SELECT matricola, codins FROM iscrizione";
		System.out.println(sql);
		List<Iscrizione> iscrizioni = new LinkedList<Iscrizione>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String matricola = rs.getString("matricola");
				String codins = rs.getString("codins");
			    System.out.println(matricola + " " + codins);
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
	
	public List<String> getCodinsWithMatricola(String matricola) {
		List<String> codins=new ArrayList<String>();
		for(Iscrizione s:iscrizioni) 
			if(s.getMatricola().equals(matricola)) {
				codins.add(s.getCodins());
			}
		return codins;
	}

	public boolean checkIscrizioneStudente(String matricola, String codins) {
		boolean result=false;
		final String sql="SELECT matricola, codins FROM iscrizione WHERE matricola=? AND codins=?";
		Connection conn=ConnectDB.getConnection();
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(2, codins);
			statement.setString(1, matricola);
			ResultSet re=statement.executeQuery();
			if(re.next()) {
				result=true;
			}
		} catch (SQLException e) {
			System.out.println("Errore checkIscrizioneStudente");
			e.printStackTrace();
		}
		return result;
	}

	public String iscriviStudente(Studente studente, Corso corso) {
		String result="Iscrizione avvenuta.";
		Connection c=ConnectDB.getConnection();
		try {
			PreparedStatement sql=c.prepareStatement("INSERT INTO iscrizione (matricola, codins) VALUES (?,?); ");
			if(studente!=null && corso!=null) {
				if(!checkIscrizioneStudente(studente.getMatricola()+"", corso.getCodins())) {
					sql.setInt(1, studente.getMatricola());
					sql.setString(2, corso.getCodins());
					sql.executeUpdate();
			}else result="Lo studente e' gia' iscritto al corso selezionato, oppure non e' un utente valido.";
				}else
					result="Lo studente e' gia' iscritto al corso selezionato, oppure non e' un utente valido. ";
		} catch (SQLException e) {
			result="Errore nell'iscrizione";
			System.out.println("Errore iscriviStudente"); 
			e.printStackTrace();
		}
		return result;
		
	}
}
