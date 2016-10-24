package br.com.predojo.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.predojo.util.LogUtil;

public class LogUtilTest {

	@Test
	public final void testaParse() {

		try {
			String logFilePath = "log.txt";
			assertTrue(!LogUtil.parse(logFilePath).isEmpty());
		} catch (IOException ioException) {
			fail();
		}
	}

	
	@Test
	public final void testaResultadoPartida() {

		try {
			String logFilePath = "log.txt";
			
			LogUtil.resultadoPartida(LogUtil.parse(logFilePath));
		} catch (Exception Exception) {
			fail();
		}
		
	}
}
