package br.com.predojo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.predojo.model.Arma;
import br.com.predojo.model.Jogador;
import br.com.predojo.model.Partida;

/**
 * The Class LogUtil.
 */
public class LogUtil {

	/** The jogador excecao. */
	private static String JOGADOR_EXCECAO = "<WORLD>";
	
	/** The formatter. */
	private static DateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	/**
	 * Parses the.
	 *
	 * @param filePath the file path
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<Partida> parse(String filePath) throws IOException {

		List<Partida> partidas = new ArrayList<Partida>();
		
		File file = new File(filePath);
		// Creates a FileReader Object
		FileReader input = new FileReader(file);
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		Partida partida = null;

		while ((myLine = bufRead.readLine()) != null) {
			
			String[] fraseComNumeroDaPartida = null;
			if (myLine.contains("started")) {
				String[] array = myLine.split(" - ");
				partida = new Partida();
				
				try {
					Date date = (Date) formatter.parse(array[0]);
					partida.setInicioJogo(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				fraseComNumeroDaPartida = array[1].split("New match ");
				String numPartida = (fraseComNumeroDaPartida[1].split(" ")[0]);
				partida.setNumeroDaPartida(Integer.parseInt(numPartida));
			}
			
			if (partida == null){
				continue;
			}

			if (myLine.contains("killed")) {
				String s = myLine.split(" - ")[1];

				String nomeMatador = s.split(" ")[0];
				String nomeMorto = s.split(" ")[2];
				String armaUtilizada = s.split(" ")[4];

				if (!nomeMatador.equals(JOGADOR_EXCECAO)){
					
					Jogador jogadorMatador = new Jogador();
					jogadorMatador.setNome(nomeMatador);
					Arma arma = new Arma(armaUtilizada);
					partida.addJogadorMatador(jogadorMatador, arma);
				}

				if (!nomeMorto.equals(JOGADOR_EXCECAO)){
					Jogador jogadorMorto = new Jogador();
					jogadorMorto.setNome(nomeMorto);
					partida.addJogadorMorto(jogadorMorto);
				}

			}
			
			if (myLine.contains("ended")) {
				
				/** Corta a linha do fim do jogo e coloca a data em que o jogo acabou **/
				String[] dataInfoPartida = myLine.split(" - ");
				try {
					Date date = (Date) formatter.parse(dataInfoPartida[0]);
					partida.setFimJogo(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				/** Fim data fimJogo **/
				partidas.add(partida);
			}
		}

		input.close();
		return partidas;
	}

	
	/**
	 * Resultado partida.
	 *
	 * @param partidas the partidas
	 */
	public static void resultadoPartida(List<Partida> partidas){
		for(Partida partida : partidas){
			System.out.println("Partida: " + partida.getNumeroDaPartida());
			System.out.println("- Ranking:");
			for(Jogador jogador : partida.getJogadoresOrdenados()){
				System.out.println("Jogador: " + jogador.getNome());
				System.out.println("Mortes Provocadas: " + jogador.getMortesProvocadas());
				System.out.println("Mortes Sofridas: " + jogador.getMortesSofridas());
				System.out.println("");
			}
			System.out.println("Arma mais utilizada do matador: " + partida.getJogadoresOrdenados().get(0).getArmasMaisUtilizada());
			System.out.println("==================================");
			System.out.println("");
		}
	}

}
