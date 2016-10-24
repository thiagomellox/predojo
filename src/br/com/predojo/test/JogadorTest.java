package br.com.predojo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.predojo.model.Arma;
import br.com.predojo.model.Jogador;

public class JogadorTest {

	@Test
	public final void testaAdicionarArma() {
		Arma arma = new Arma("B54");
		Jogador jogador = new Jogador();
		jogador.addArma(arma);
		
		
		assertTrue(jogador.getArmasMaisUtilizada() != null);
	}


}
