package br.com.predojo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Autor: Thiago Mello
 * The Class Jogador.
 */
public class Jogador {

	/** The nome. */
	private String nome;
	
	/** The mortes provocadas. */
	private Integer mortesProvocadas = 0;
	
	/** The mortes sofridas. */
	private Integer mortesSofridas = 0;
	
	/** The armas. */
	private Map<String, Arma> armas = new HashMap<String, Arma>();
	
	/**
	 * Adds the arma.
	 *
	 * @param a the a
	 */
	public void addArma(Arma a) {
		if(armas.containsKey(a.getNome())){
			armas.get(a.getNome()).adicionaMorte();
		}else{
			a.adicionaMorte();
			armas.put(a.getNome(), a);
		}
	}
	
	/**
	 * Gets the armas mais utilizada.
	 *
	 * @return the armas mais utilizada
	 */
	public String getArmasMaisUtilizada(){
		List<Arma> list = new ArrayList<Arma>(armas.values());
		Collections.sort(list, new Comparator<Arma>() {

			@Override
			public int compare(Arma o1, Arma o2) {
				return -o1.getNumeroMortes().compareTo(o2.getNumeroMortes());
			}
		});
		
		String retorno = this.nome + ": ";
		int num = 0;
		for(Arma arma : list){
			if(num == 0 || num == arma.getNumeroMortes().intValue()){
				retorno += (num == 0 ? "" : ", ") + arma.getNome();
				num = arma.getNumeroMortes();
			}else{
				break;
			}
		}
		
		return retorno;
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
	 * Gets the mortes provocadas.
	 *
	 * @return the mortesProvocadas
	 */
	public Integer getMortesProvocadas() {
		return mortesProvocadas;
	}
	
	/**
	 * Sets the mortes provocadas.
	 *
	 * @param mortesProvocadas the mortesProvocadas to set
	 */
	public void setMortesProvocadas(Integer mortesProvocadas) {
		this.mortesProvocadas = mortesProvocadas;
	}
	
	/**
	 * Gets the mortes sofridas.
	 *
	 * @return the mortesSofridas
	 */
	public Integer getMortesSofridas() {
		return mortesSofridas;
	}
	
	/**
	 * Sets the mortes sofridas.
	 *
	 * @param mortesSofridas the mortesSofridas to set
	 */
	public void setMortesSofridas(Integer mortesSofridas) {
		this.mortesSofridas = mortesSofridas;
	}

	
	/**
	 * Gets the armas.
	 *
	 * @return the armas
	 */
	public Map<String, Arma> getArmas() {
		return armas;
	}
	
	/**
	 * Sets the armas.
	 *
	 * @param armas the armas to set
	 */
	public void setArmas(Map<String, Arma> armas) {
		this.armas = armas;
	}
	
	/**
	 * Adiciona morte sofrida.
	 */
	public void adicionaMorteSofrida(){
		this.mortesSofridas += 1;
	}

	/**
	 * Adiciona morte provocada.
	 */
	public void adicionaMorteProvocada(){
		this.mortesProvocadas += 1;
	}

}
