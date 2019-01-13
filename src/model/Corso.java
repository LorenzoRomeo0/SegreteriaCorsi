package model;
//BEAN CORSO

public class Corso  implements java.io.Serializable{
	@Override
	public String toString() {
		return "codins=" + codins + ", numeroCrediti=" + numeroCrediti + ", nome=" + nome + ", periodoDidattico="
				+ periodoDidattico;
	}

	private static final long serialVersionUID = 2L;
	String codins;
	int numeroCrediti;
	String nome;
	int periodoDidattico;
	
	//i bean hanno per convenzione un costruttore vuoto, e poi e setters e getters. i getter per i boolean si fanno con is al posto di get.
	public Corso (){
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}
}
