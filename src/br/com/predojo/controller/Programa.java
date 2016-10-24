package br.com.predojo.controller;

import java.io.IOException;

import br.com.predojo.util.LogUtil;

/**
 * Thiago Mello
 * The Class Programa.
 */
public class Programa {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		try {
			String logFilePath = "log.txt";
			LogUtil.resultadoPartida(LogUtil.parse(logFilePath));
		} catch (IOException ioException) {
			System.out.println("File cannot be read. Exception:" + ioException);
		}


	}
}
