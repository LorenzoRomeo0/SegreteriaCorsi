package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Studente;

public class StudenteDAO {

	List<Studente> studenti;
	public List<Studente> getStudenti(){
		return this.studenti;
	}
	 
	public StudenteDAO() {
		studenti=getAllStudenti();
	}
	
	public List<Studente> getAllStudenti() {
		final String sql = "SELECT * FROM studente";
		List<Studente> studenti = new LinkedList<Studente>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("cds");
				//System.out.println(matricola + " " + cognome + " " + nome + " " + cds);
				Studente s=new Studente();
				s.setMatricola(matricola);
				s.setCognome(cognome);
				s.setNome(nome);
				s.setCds(cds);
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public Studente getStudenteWithMatricola(String matricola) {
		int matricola1=Integer.parseInt(matricola);
		for(Studente s:studenti) 
			if(s.getMatricola()==matricola1) {
				return s;
			}
		return null;
	}
	
	public List<Studente> getStudentiWithMatricolaDB(List<String> matricola) {
		//int matricola1=Integer.parseInt(matricola);
		List<Studente>st=new ArrayList<Studente>();
		for(String m:matricola) {
			int m1=Integer.parseInt(m);
			try {
				Studente studente=new Studente();
				PreparedStatement sta= ConnectDB.getConnection().prepareStatement("SELECT matricola, cognome, nome, cds WHERE matricola=? LIMIT 1");
				sta.setInt(1, m1);
				ResultSet result=sta.executeQuery();
				studente.setMatricola(m1);
				studente.setNome(result.getString("nome"));
				studente.setCognome(result.getString("cognome"));
				studente.setCds(result.getString("cds"));
				st.add(studente);
			} catch (SQLException e) {
				System.out.println("errore getStudenteWithMatricola");
				e.printStackTrace();
			}
		}
		return st;
	}
	
	public List<Studente> getStudentiWithMatricola(List<String> matricola) {
		List<Studente> st=new ArrayList<Studente>();
		for(String ma:matricola) {
			for(Studente s: studenti) {
				if(s.getMatricola()==Integer.parseInt(ma))
					st.add(s);
			}
		}
		return st;
	}
}
