
public class Computador
{
	private Aleatorio aleatorio; // Gerador de números aleatórios
	private Tabuleiro tabuleiro; // Tabuleiro onde as jogadas automáticas serão inseridas
	private int nivel; // Nível de dificuldade
	private char letra; // Letra do computador

	/** Constructor */
	public Computador( Tabuleiro tabuleiro, int nivel, char letra)
	{
		this.aleatorio = new Aleatorio();
		this.tabuleiro = tabuleiro;
		this.nivel = nivel;
		this.letra = letra;
	}

	/** Para modificar o nível */
	public void setNivel( int nivel )
	{
		this.nivel = nivel;
	}

	/** Processador de jogo automático */
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
	 * Jogada aleatória
	 * !!! Só para utilização nesta classe !!!
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
	 * !!! Só para utilização nesta classe !!!
	 */
	private boolean ataque()
	{
		// TODO
		return false;
	}

	/**
	 * Jogada de defesa
	 * !!! Só para utilização nesta classe !!!
	 */
	private boolean defesa()
	{
		// TODO
		return false;
	}
}
