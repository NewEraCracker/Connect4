
public class Teste
{
	// Constantes
	private static final String TOP_SCORES_FILE="TopScoresTest.txt";
	private static final int MAX_TOP_SCORES=10;
	private static final int MAX_LINES=6;
	private static final int MAX_COLUMNS=7;
	private static final int IN_LINE=4;

	// Objectos
	private static Tabuleiro tabuleiro = new Tabuleiro( MAX_LINES, MAX_COLUMNS, IN_LINE );
	private static Pontuacao pontuacao = new Pontuacao(MAX_TOP_SCORES, TOP_SCORES_FILE);

	/** Programa principal */
	public static void main(String[] args)
	{
		// Corre o teste da classe util
		testeUtil();
		Util.println();

		// Corre o teste da pontuação
		testePontuacao();
		Util.println();

		// Corre o teste das jogadas automáticas
		testeComputador();
		Util.println();

		// Corre o teste do verificador de victória
		testeWinCheck();
		Util.println();
	}

	/**
	 * Teste de jogadas automáticas
	 * !!! Só para utilização nesta classe !!!
	 */
	private static void testeComputador()
	{
		Computador a = new Computador( tabuleiro, 1, 'X');
		Computador b = new Computador( tabuleiro, 1, 'O');

		while( !tabuleiro.isFull() )
		{
			a.auto();
			if( tabuleiro.runWinCheck('X') )
			{
				tabuleiro.print();
				System.out.println('X');
				return;
			}

			b.auto();
			if( tabuleiro.runWinCheck('O') )
			{
				tabuleiro.print();
				System.out.println('O');
				return;
			}

		}
	}

	/**
	 * Teste de verificador de vitória
	 * !!! Só para utilização nesta classe !!!
	 */
	private static void testeWinCheck()
	{
		// X na vertical
		tabuleiro.clear();
		for(int i=0; i<4; i++) tabuleiro.setTabuleiro(0,'X');
		tabuleiro.print();
		if( tabuleiro.runWinCheck('X') ) Util.println("OK");

		// O na horizontal
		tabuleiro.clear();
		for(int i=1; i<5; i++) tabuleiro.setTabuleiro(i,'O');
		tabuleiro.print();
		if( tabuleiro.runWinCheck('O') ) Util.println("OK");

		// X na diagonal
		tabuleiro.clear();
		for(int i=2; i<=6; i++)
		{
			int j = i;
			while( j-- >= 0 )
			{
				if( j != 0 || i == 6) tabuleiro.setTabuleiro(i,'O');
				if( j == 0 && i != 6) tabuleiro.setTabuleiro(i,'X');
			}
		}
		tabuleiro.print();
		if( tabuleiro.runWinCheck('X') ) Util.println("OK");

		// O na diagonal
		tabuleiro.clear();
		for(int i=2; i<=6; i++)
		{
			int j = i;
			while( j >= 0 )
			{
				if( j != 0 || i == 6) tabuleiro.setTabuleiro(i,'O');
				if( j == 0 && i != 6) tabuleiro.setTabuleiro(i,'X');
				j--;
			}
		}
		tabuleiro.print();
		if( tabuleiro.runWinCheck('X') ) Util.println("OK");

		// O na diagonal
		tabuleiro.clear();
		for(int i=6; i>=2; i--)
		{
			int j = 6-i;
			while( j >= 0 )
			{
				if( j != 0 || i == 6) tabuleiro.setTabuleiro(i,'X');
				if( j == 0 && i != 6) tabuleiro.setTabuleiro(i,'O');
				j--;
			}
		}
		tabuleiro.print();
		if( tabuleiro.runWinCheck('O') ) Util.println("OK");
	}

	/**
	 * Teste da classe da pontuação
	 * !!! Só para utilização nesta classe !!!
	 */
	private static void testePontuacao()
	{
		pontuacao.add(1,"João");
		pontuacao.add(10,"Maria");
		pontuacao.add(2,"Jorge");

		Util.println( pontuacao.toString() );
	}

	/**
	 * Teste de métodos implementados na classe Util
	 * !!! Só para utilização nesta classe !!!
	 */
	private static void testeUtil()
	{
		Util.println( "1337" );
		Util.println( Util.parseInt("1337") );
	}
}