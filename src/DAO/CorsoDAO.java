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
public class CorsoDAO {
	List<Corso> corsi;
	
	public CorsoDAO() {
		
		corsi=getAllCorsi();
	}
	public List<Corso> getCorsi(){
		return this.corsi;	
	}
	
	public List<String> getNomeCorsi(){
		List<String> nomi=new ArrayList<String>();
		for(Corso c:corsi)
			nomi.add(c.getNome());
		return nomi;
	}
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getAllCorsi() {
		final String sql = "SELECT * FROM corso";
		List<Corso> corsi = new LinkedList<Corso>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");				
				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				Corso c=new Corso();
				c.setCodins(codins);
				c.setNome(nome);
				c.setNumeroCrediti(numeroCrediti);
				c.setPeriodoDidattico(periodoDidattico);
				corsi.add(c);
				}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(String codins) {
		for(Corso c:corsi) 
			if(c.getCodins().equals(codins))
				return c;
		return null;
	}
	
	public Corso getCorsoByNome(String nome) {
		for(Corso c:corsi) 
			if(c.getNome().equals(nome))
				return c;
		return null;
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(String codins) {
		List<Studente> result=new ArrayList<Studente>();
		IscrizioneDAO iscrizioni=new IscrizioneDAO();
		StudenteDAO studenti=new StudenteDAO();
		for(Iscrizione i: iscrizioni.getIscrizioni())
			if(i.getCodins().equals(codins)) {
				//System.out.println("studenti trovati: "+result.size());
				result.add(studenti.getStudenteWithMatricola(i.getMatricola()));
			}
		//System.out.println("iscrizioni totali: "+iscrizioni.getIscrizioni().size());
		return result;
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean iscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

	//!!!!! il break è da rivedere
	public List<Corso> getCorsiWithCodin(List<String> codins) {
		System.out.println("GetCorsiWithCodin");
		List<Corso> st=new ArrayList<Corso>();
			for(String codin:codins)
				for(Corso co:corsi) {
					System.out.println(corsi.size());
					if(co.getCodins().equals(codin)) {
						System.out.println("uno");
						st.add(co);
						break;
					}
				}
		return st;
	}
	
	
	

}
