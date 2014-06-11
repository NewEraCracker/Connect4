
public class Tabuleiro
{
	// Array que contém o tabuleiro
	private char[][] tabuleiro;

	// Número de peças em linha para considerar jogo ganho
	private int inLine;

	/** Inicia o tabuleiro de forma a ser possivel jogar */
	public Tabuleiro( int linhas, int colunas, int inLine)
	{
		// Número de peças em linha para considerar jogo ganho
		this.inLine = inLine;

		// Criar tabuleiro
		this.tabuleiro = new char[colunas][linhas];

		// Inicializar
		clear();
	}

	/** Retorna o tabuleiro em forma de string */
	public String toString()
	{
		String ret = new String("");
		for(int y=tabuleiro[0].length-1; y>=0; y--)
		{
			if( y == tabuleiro[0].length-1 )
			{
				for(int x=0; x<tabuleiro.length; x++)
					ret += " "+x;

				ret += Util.EOL;
			}

			for(int x=0; x<tabuleiro.length; x++)
				ret += "|"+tabuleiro[x][y];

			ret += "|"+Util.EOL;

			for(int x=0; x<tabuleiro.length; x++)
				ret += "+-";

			ret += "+"+Util.EOL;
		}
		return ret;
	}

	/** Limpar tabuleiro */
	public void clear()
	{
		// Preencher tabuleiro com espaços
		for(int x=0; x<tabuleiro.length; x++)
		{
			for(int y=0; y<tabuleiro[x].length; y++)
				tabuleiro[x][y] = ' ';
		}
	}

	/** Imprimir tabuleiro */
	public void print()
	{
		Util.print( toString() );
	}

	/** Retorna o número de peças em linha para considerar jogo ganho */
	public int getInLine()
	{
		return inLine;
	}

	/** Retorna o array com o tabuleiro */
	public char[][] getTabuleiro()
	{
		return tabuleiro;
	}

	/** Retorna o valor de uma posição do tabuleiro */
	public char getTabuleiro( int x, int y )
	{
		return tabuleiro[x][y];
	}

	/** Insere uma jogada no tabuleiro */
	public boolean setTabuleiro( int x, char jogador )
	{
		if( x < 0 || x >= tabuleiro.length ) return false;

		for(int y=0; y<tabuleiro[x].length; y++)
		{
			// Posição não preenchida
			if( isPosJogador(x, y, ' ') )
			{
				tabuleiro[x][y] = jogador;
				return true;
			}
		}
		return false;
	}

	/** Verificar se o tabuleiro se encontra cheio */
	public boolean isFull()
	{
		for(int x=0; x<tabuleiro.length; x++)
		{
			for(int y=0; y<tabuleiro[x].length; y++)
			{
				// Se for encontrada uma posição não preenchida
				if( isPosJogador(x, y, ' ') )
					return false;
			}
		}
		return true;
	}

	/** Verifica se jogador ganhou */
	public boolean runWinCheck( char jogador )
	{
		int count = 0;

		// X do início para o fim
		for(int x=0; x<tabuleiro.length; x++)
		{
			// Vertical
			count = 0;
			for(int y=0; y<tabuleiro[x].length; y++)
			{
				count = countIncrement(x, y, jogador, count);

				if(count >= inLine)
					return true;
			}

			// Diagonal
			count = 0;
			for(int i=0;i<tabuleiro[0].length; i++)
			{
				int _x = x+i;
				if( _x >= tabuleiro.length ) break;

				count = countIncrement(_x, i, jogador, count);

				if(count >= inLine)
					return true;
			}
		}

		// Y do início para o fim
		for(int y=0; y<tabuleiro[0].length; y++)
		{
			// Horizontal
			count = 0;
			for(int x=0; x<tabuleiro.length; x++)
			{
				count = countIncrement(x, y, jogador, count);

				if(count >= inLine)
					return true;
			}

			// Diagonal
			count = 0;
			for(int i=0;i<tabuleiro.length; i++)
			{
				int _y = y+i;
				if( _y >= tabuleiro[0].length ) break;

				count = countIncrement(i, _y, jogador, count);

				if(count >= inLine)
					return true;
			}
		}

		// X do fim para o início
		for(int x=tabuleiro.length-1; x>=0; x--)
		{
			// Diagonal
			count = 0;
			for(int i=0;i<tabuleiro[0].length; i++)
			{
				int _x = x-i;
				if( _x < 0 ) break;

				count = countIncrement(_x, i, jogador, count);

				if(count >= inLine)
					return true;
			}
		}

		// Y do fim para o início
		for(int y=tabuleiro[0].length-1; y>=0; y--)
		{
			// Diagonal
			count = 0;
			for(int i=0;i<tabuleiro.length; i++)
			{
				int _y = y-i;
				if( _y < 0 ) break;

				count = countIncrement(i, _y, jogador, count);

				if(count >= inLine)
					return true;
			}
		}

		return false;
	}

	/**
	 * Retorna uma contagem incrementada se o jogador ocupar x.y, senão retorna 0
	 * !!! Só para utilização nesta classe !!!
	 */
	private int countIncrement( int x, int y, char jogador, int count )
	{
		count = isPosJogador(x, y, jogador) ? (count+1) : 0;
		return count;
	}

	/**
	 * Verifica se a posição indicada contém uma jogada do jogador
	 * !!! Só para utilização nesta classe !!!
	 */
	private boolean isPosJogador( int x, int y, char jogador )
	{
		return ( getTabuleiro(x, y) == jogador );
	}
}