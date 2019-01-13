package model;

public class Studente implements java.io.Serializable{
	@Override
	public String toString() {
		return "matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", cds=" + cds;
	}
	private static final long serialVersionUID = 1L;
	int matricola;
	String cognome;
	String nome;
	String cds;
	
	public Studente() {
		
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
}
