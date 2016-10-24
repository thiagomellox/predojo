package br.com.predojo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Autor: Thiago Mello
 * The Class Partida.
 */
public class Partida {

	/** The numero da partida. */
	private int numeroDaPartida;
	
	/** The jogadores. */
	private Map<String,Jogador> jogadores = new HashMap<String,Jogador>();
	
	/** The inicio jogo. */
	private Date inicioJogo;
	
	/** The fim jogo. */
	private Date fimJogo;
	
	/**
	 * Adds the jogador matador.
	 *
	 * @param jogador the jogador
	 * @param arma the arma
	 */
	public void addJogadorMatador(Jogador jogador, Arma arma) {
		if(jogadores.containsKey(jogador.getNome())){
			jogadores.get(jogador.getNome()).adicionaMorteProvocada();
			jogadores.get(jogador.getNome()).addArma(arma);
		}else{
			jogador.adicionaMorteProvocada();
			jogador.addArma(arma);
			jogadores.put(jogador.getNome(), jogador);
		}
	}
	
	/**
	 * Adds the jogador morto.
	 *
	 * @param jogador the jogador
	 */
	public void addJogadorMorto(Jogador jogador) {
		if(jogadores.containsKey(jogador.getNome())){
			jogadores.get(jogador.getNome()).adicionaMorteSofrida();
		}else{
			jogador.adicionaMorteSofrida();
			jogadores.put(jogador.getNome(), jogador);
		}
	}
	
	/**
	 * Gets the jogadores ordenados.
	 *
	 * @return the jogadores ordenados
	 */
	public List<Jogador> getJogadoresOrdenados(){
		List<Jogador> list =  new ArrayList<Jogador>(jogadores.values());
		
		Collections.sort(list, new Comparator<Jogador>() {

			@Override
			public int compare(Jogador o1, Jogador o2) {
				int i = -o1.getMortesProvocadas().compareTo(o2.getMortesProvocadas());
				if(i == 0){
					i = o1.getMortesSofridas().compareTo(o2.getMortesSofridas());
				}
				return i;
			}
		});
		
		return list;
	}

	/**
	 * Gets the numero da partida.
	 *
	 * @return the numeroDaPartida
	 */
	public int getNumeroDaPartida() {
		return numeroDaPartida;
	}

	/**
	 * Sets the numero da partida.
	 *
	 * @param numeroDaPartida the numeroDaPartida to set
	 */
	public void setNumeroDaPartida(int numeroDaPartida) {
		this.numeroDaPartida = numeroDaPartida;
	}

	/**
	 * Gets the jogadores.
	 *
	 * @return the jogadores
	 */
	public Map<String, Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * Sets the jogadores.
	 *
	 * @param jogadores the jogadores to set
	 */
	public void setJogadores(Map<String, Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	/**
	 * Gets the inicio jogo.
	 *
	 * @return the inicioJogo
	 */
	public Date getInicioJogo() {
		return inicioJogo;
	}

	/**
	 * Sets the inicio jogo.
	 *
	 * @param inicioJogo the inicioJogo to set
	 */
	public void setInicioJogo(Date inicioJogo) {
		this.inicioJogo = inicioJogo;
	}

	/**
	 * Gets the fim jogo.
	 *
	 * @return the fimJogo
	 */
	public Date getFimJogo() {
		return fimJogo;
	}

	/**
	 * Sets the fim jogo.
	 *
	 * @param fimJogo the fimJogo to set
	 */
	public void setFimJogo(Date fimJogo) {
		this.fimJogo = fimJogo;
	}
	
	
}
