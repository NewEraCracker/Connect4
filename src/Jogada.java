
public class Jogada
{
	private Tabuleiro tabuleiro;
	private Menu menu;
	private Teclado teclado;

	/** Constructor */
	public Jogada( Tabuleiro tabuleiro, Pontuacao pontuacao )
	{
		this.tabuleiro = tabuleiro;
		this.menu = new Menu( tabuleiro, pontuacao);
		this.teclado = new Teclado();
	}

	/** Pedir jogada e inserir no tabuleiro */
	public void askJogada( char jogador )
	{
		String read = teclado.next(jogador+" >");

		if( Util.isInteger(read) )
		{
			int xPos = Util.parseInt(read);

			if( !tabuleiro.setTabuleiro( xPos, jogador ) )
				askJogada( jogador );
		}
		else
		{
			if( !menu( read.charAt(0), jogador) )
				askJogada( jogador );
		}
	}

	/** Menu com opções */
	public boolean menu( char option, char jogador )
	{
		return menu.run( option, jogador );
	}

	/** Verificar se houve vitória do jogador */
	public boolean winJogada( char jogador )
	{
		return tabuleiro.runWinCheck( jogador );
	}
}