package model;

import java.util.ArrayList;
import java.util.List;

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
		String result="";
		Corso corso= c.getCorsoByNome(nomeCorso);
		if(corso!=null) {
			List<String> matricole=i.getMatricolaStudentiWithCodins(corso.getCodins());
			List<Studente> studenti=s.getStudentiWithMatricola(matricole);
			for(Studente st:studenti)
				result+=st.toString()+"\n";
		}
		return result;
	}
	
	/*public String findCorsiByCodins(String codins) {
		String result="";
		List<Corso> co=c.getCorsiWithCodins(codins);
		if(co.size()>0) {
			for(Corso st:co)
				result+=st.toString()+"\n";
		}
		return result;
	}*/
	
	public String findCorsiByMatricola(String matricola) {
		List<Corso> corso=c.getCorsiWithCodin(i.getCodinsWithMatricola(matricola));
		String result="";
		for(Corso c:corso)
			result+=c.toString()+"\n";
		return result;
	}

	public String checkByMatricolaIfInCorso(String matricola, String corso) {
		String result=(i.checkIscrizioneStudente(matricola, c.getCorsoByNome(corso).getCodins()))?"Lo studente e' iscritto al corso "+ corso+".":"Lo studente non e' iscritto al corso "+corso+"";
		return result;
	}

	public String iscriviStudente(String matricola, String corso) {
		return i.iscriviStudente(s.getStudenteWithMatricola(matricola), c.getCorsoByNome(corso));
	}
}
