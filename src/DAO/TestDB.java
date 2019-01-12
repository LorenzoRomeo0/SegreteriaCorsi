package DAO;

import java.util.List;

import model.Model;
import model.Studente;


public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		Model model=new Model();
		//cdao.getCorsi();
		//List<Studente> s =cdao.getStudentiIscrittiAlCorso("02CIXPG");
		/*for(Studente o:s) {
			System.out.println(o.toString());
		}
		System.out.println();*/
		System.out.println("Classe test");
		System.out.println(model.findStudentName(148072));

	}

}
