
@SuppressWarnings("unused")
public class Menu
{
	private Pontuacao pontuacao;
	private Tabuleiro tabuleiro;
	
	/** Constructor */
	public Menu( Tabuleiro tabuleiro, Pontuacao pontuacao )
	{
		this.tabuleiro = tabuleiro;
		this.pontuacao = pontuacao;
	}

	/**
	 * Menu com as op��es
	 * Retorna true se houve uma jogada ou ac��o processada
	 */
	public boolean run( char option, char jogador )
	{
		switch( option )
		{
			case 'P':
				// TODO
				break;
			case 'N':
				// TODO
				break;
			case 'U':
				// TODO
				break;
			case 'F':
				// TODO
				break;
			case 'T':
				return runTabela();
			case 'H':
				return runHelp();
		}

		Util.println( "Op��o n�o implementada." );
		return false;
	}

	/**
	 * Imprime o texto de ajuda
	 * Retorna falso para for�ar o utilizador a introduzir uma op��o.
	 */
	private boolean runHelp()
	{
		Util.println(
				"P � Pontua��o"+Util.EOL+
				"N � Novo jogo"+Util.EOL+
				"U � Undo"+Util.EOL+
				"F � Fim"+Util.EOL+
				"T � Tabela Top 10"+Util.EOL+
				"H � Help"
				);
		return false;
	}
	
	/**
	 * Imprime a tabela Top 10
	 * Retorna falso para for�ar o utilizador a introduzir uma op��o.
	 */
	private boolean runTabela()
	{
		String tabela = pontuacao.toString();

		if( tabela != null )
			Util.println( tabela );
		else
			Util.println( "N�o existe tabela Top 10." );

		return false;
	}
}