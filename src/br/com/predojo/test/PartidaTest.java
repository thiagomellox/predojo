package br.com.predojo.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import br.com.predojo.model.Arma;
import br.com.predojo.model.Jogador;
import br.com.predojo.model.Partida;
import br.com.predojo.util.LogUtil;

public class PartidaTest {

	@Test
	public final void testAdiconarJogador() {
		Partida partida = new Partida();
		
		Jogador jogador = new Jogador();
		jogador.setNome("Teste");
		
		Arma arma = new Arma("Mk5");
		
		partida.addJogadorMatador(jogador, arma);
		partida.addJogadorMorto(jogador);
		assertTrue(!partida.getJogadoresOrdenados().isEmpty());
	}


}
