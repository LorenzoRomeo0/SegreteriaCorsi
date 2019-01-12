package model;

import java.util.ArrayList;

import DAO.CorsoDAO;
import DAO.IscrizioneDAO;
import DAO.StudenteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	IscrizioneDAO i;
	CorsoDAO c;
	StudenteDAO s;
	
	public Model(){
		i=new IscrizioneDAO();
		c=new CorsoDAO();
		s=new StudenteDAO();
	}
	
	public ObservableList<String> getCorsi(){
		ArrayList<String> l=new ArrayList<String>();
		l.add(" ");
		for(Corso co:c.getCorsi())
			l.add(co.getNome());
		return FXCollections.observableArrayList(l);
	}

	public String findStudentName(int matricola) {
		for(Studente st:s.getStudenti())
			if(st.getMatricola()==matricola)
				return st.getNome();
		return "";
	}
	public String findStudentSurname(int matricola) {
		for(Studente st:s.getStudenti())
			if(st.getMatricola()==matricola)
				return st.getCognome();
		return "";
	}
	
	public String findStudentiByCorso(String nomeCorso) {
		for(Studente st:s.getStudentiWithMatricola(i.getMatricolaStudentiWithCodins(c.getCorsoByNome(nomeCorso).getCodins())));
	}
	
}
