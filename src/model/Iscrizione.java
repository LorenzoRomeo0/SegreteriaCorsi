package model;

public class Iscrizione implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	String matricola;
	String codins;
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	
	
}
