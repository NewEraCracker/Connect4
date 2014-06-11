
public class Jogo
{
	// Constantes
	private static final String TOP_SCORES_FILE="TopScores.txt";
	private static final int MAX_TOP_SCORES=10;
	private static final int MAX_LINES=6;
	private static final int MAX_COLUMNS=7;
	private static final int IN_LINE=4;

	// Para jogar contra o computador
	private static final char LETRA_COMPUTADOR = 'O';
	private boolean contraComputador = false;

	// Objectos
	private Tabuleiro tabuleiro = new Tabuleiro( MAX_LINES, MAX_COLUMNS, IN_LINE );
	private Pontuacao pontuacao = new Pontuacao( MAX_TOP_SCORES, TOP_SCORES_FILE );
	private Computador computador = new Computador( tabuleiro, 0, LETRA_COMPUTADOR);
	private Jogada jogada = new Jogada( tabuleiro, pontuacao );

	/** Constructor */
	public Jogo( boolean contraComputador, int nivelComputador )
	{
		this.contraComputador = contraComputador;
		computador.setNivel( nivelComputador );
	}

	/** Jogo individual */
	public char run()
	{
		tabuleiro.clear();

		while( !tabuleiro.isFull() )
		{
			if( jogada('X') )
			{
				tabuleiro.print();
				return 'X';
			}

			if( jogada('O') )
			{
				tabuleiro.print();
				return 'O';
			}
		}

		tabuleiro.print();
		return ' ';
	}

	/**
	 * Pede e processa a jogada de um jogador
	 * !!! Só para utilização nesta classe !!!
	 */
	private boolean jogada( char jogador)
	{
		tabuleiro.print();

		if( jogador == LETRA_COMPUTADOR && contraComputador )
			computador.auto();
		else
			jogada.askJogada(jogador);

		return jogada.winJogada(jogador);
	}
}