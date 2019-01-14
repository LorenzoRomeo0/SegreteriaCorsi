package DAO;

import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import model.Iscrizione;
import model.Model;
import model.Studente;


public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		Model model=new Model();
		IscrizioneDAO iscr=new IscrizioneDAO();
		StudenteDAO s=new StudenteDAO();
		
		cdao.getCorsi();
		List<Studente> s1=cdao.getStudentiIscrittiAlCorso("02CIXPG");
		for(Studente o:s1) {
			System.out.println(o.toString());
		}
		System.out.println();
		System.out.println("Classe test");
		System.out.println(model.findStudentName(148072));
		System.out.println(model.findStudentiByCorso("Economia e finanza d'impresa"));
		System.out.println("-------------");
		System.out.println(model.findCorsiByMatricola("200600"));
		System.out.println("----------------");
		for(Iscrizione i:iscr.getIscrizioni()) System.out.println(i.toString());
		System.out.println(iscr.checkIscrizioneStudente("200630", "01OVYPG"));
		System.out.println(iscr.iscriviStudente(s.getStudenteWithMatricola("200630"), cdao.getCorsoByNome("Gestione dell'innovazione e sviluppo prodotto")));
	
	
	}

}
