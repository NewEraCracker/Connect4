import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Pontuacao
{
	private int maxTopScores;
	private String topScoresFile;

	/** Constructor */
	public Pontuacao(int maxTopScores, String topScoresFile)
	{
		this.maxTopScores = maxTopScores;
		this.topScoresFile = topScoresFile;
	}

	/** Retorna o conteúdo do ficheiro com as pontuações */
	public String toString()
	{
		String ret = new String("");

		Scanner in = FileAcess.toRead(topScoresFile);

		if(in == null)
			return null;

		while( in.hasNextLine() )
			ret += in.nextLine() + Util.EOL;

		in.close();

		return ret;
	}

	/** Adiciona uma pontuação ao ficheiro das pontuações */
	public boolean add( int pontos, String jogador )
	{
		// Obter pontuações
		String contents = toString();

		// Preparar para escrita
		PrintStream out = FileAcess.toWrite(topScoresFile);

		if(out == null)
			return false;

		// Escrever os conteúdos do ficheiro
		if(contents != null)
			out.print(contents);

		// Adicionar nova pontuação
		out.println(pontos+"\t"+jogador);

		// Fechar o ficheiro
		out.close();

		// Correr a função de ordenação e retornar o seu resultado
		return sort();
	}

	/**
	 * Organiza o ficheiro das pontuações
	 * !!! Só para utilização nesta classe !!!
	 */
	private boolean sort()
	{
		// Obter pontuações
		String contents = toString();

		if(contents == null)
			return false;

		String[] scoresArr = contents.split( Util.EOL ); // Array de pontuações
		int[] scoresVals = new int[ scoresArr.length ]; // Array com valores
		String[][] scoresNomes = new String[ scoresArr.length ][2]; // Array com valores e nomes

		// Preencher scoreVals e scoreNomes
		for(int i=0; i<scoresArr.length; i++)
		{
			String[] scoresTemp = scoresArr[i].trim().split("\t");

			scoresVals[i] = Util.parseInt( scoresTemp[0] ); // Valor
			scoresNomes[i][0] = scoresTemp[0]; // Valor
			scoresNomes[i][1] = scoresTemp[1]; // Nome
		}

		// Ordenar scoreVals
		Arrays.sort( scoresVals );

		// Preparar para escrita
		PrintStream out = FileAcess.toWrite(topScoresFile);

		if(out == null)
			return false;

		// Escrever no ficheiro
		for(int i=0; i<scoresArr.length; i++)
		{
			// Para só escrever até ao máximo de pontuações
			if( i>=maxTopScores )
				break;

			int pos = scoresArr.length-1-i; // Posição do valor
			int valor = scoresVals[pos]; // Valor

			// Encontrar o nome
			String nome = new String("");
			for(int j=0; j<scoresArr.length; j++)
			{
				if( scoresNomes[j][0].equals( ""+scoresVals[pos] ) )
				{
					nome = scoresNomes[j][1]; // Nome
					break;
				}
			}

			out.println(valor+"\t"+nome); // Escrever
		}

		// Fechar o ficheiro
		out.close();

		return true;
	}
}