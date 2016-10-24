package br.com.predojo.model;

/**
 * The Class Arma.
 */
public class Arma {

	/** The nome. */
	private String nome;
	
	/** The numero mortes. */
	private Integer numeroMortes = 0;

	/**
	 * Instantiates a new arma.
	 *
	 * @param nome the nome
	 */
	public Arma(String nome){
		this.nome = nome;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * Sets the nome.
	 *
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * Gets the numero mortes.
	 *
	 * @return the numeroMortes
	 */
	public Integer getNumeroMortes() {
		return numeroMortes;
	}


	/**
	 * Sets the numero mortes.
	 *
	 * @param numeroMortes the numeroMortes to set
	 */
	public void setNumeroMortes(Integer numeroMortes) {
		this.numeroMortes = numeroMortes;
	}

	/**
	 * Adiciona morte.
	 */
	public void adicionaMorte(){
		this.numeroMortes += 1;
	}

}
