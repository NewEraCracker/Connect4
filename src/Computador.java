
public class Computador
{
	private Aleatorio aleatorio; // Gerador de n�meros aleat�rios
	private Tabuleiro tabuleiro; // Tabuleiro onde as jogadas autom�ticas ser�o inseridas
	private int nivel; // N�vel de dificuldade
	private char letra; // Letra do computador

	/** Constructor */
	public Computador( Tabuleiro tabuleiro, int nivel, char letra)
	{
		this.aleatorio = new Aleatorio();
		this.tabuleiro = tabuleiro;
		this.nivel = nivel;
		this.letra = letra;
	}

	/** Para modificar o n�vel */
	public void setNivel( int nivel )
	{
		this.nivel = nivel;
	}

	/** Processador de jogo autom�tico */
	public void auto()
	{
		switch(nivel)
		{
			case 1:
				break;
			case 2:
				if( defesa() ) return;
				break;
			case 3:
				if( defesa() ) return;
				if( ataque() ) return;
				break;
			default:
				break;
		}
		random();
	}

	/**
	 * Jogada aleat�ria
	 * !!! S� para utiliza��o nesta classe !!!
	 */
	private boolean random()
	{
		int x = aleatorio.nextInt( tabuleiro.getTabuleiro().length );
		boolean ret = tabuleiro.setTabuleiro( x, letra);
		if( !ret && !tabuleiro.isFull() )
		{
			ret = random();
		}
		return ret;
	}

	/**
	 * Jogada de ataque
	 * !!! S� para utiliza��o nesta classe !!!
	 */
	private boolean ataque()
	{
		// TODO
		return false;
	}

	/**
	 * Jogada de defesa
	 * !!! S� para utiliza��o nesta classe !!!
	 */
	private boolean defesa()
	{
		// TODO
		return false;
	}
}
