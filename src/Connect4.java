
public class Connect4
{
	/** Programa principal */
	public static void main(String[] args)
	{
		boolean contraComputador = false;
		int nivelComputador = 0;

		// Verifica argumentos
		if( args != null && args.length == 2 && args[0].equals("auto") )
		{
			// Calculamos o nível
			nivelComputador = args[1].charAt(0)-'0';

			// E ligamos o contraComputador
			if( nivelComputador >= 1 && nivelComputador <= 3 )
				contraComputador = true;
		}

		// Criar jogo
		Jogo jogo = new Jogo( contraComputador, nivelComputador );

		int nEmpates=0, xGanhos=0, oGanhos=0;

		for(int nJogos = 0; nJogos < 3; nJogos++)
		{
			char vencedor = jogo.run();

			switch(vencedor)
			{
				case 'X':
					xGanhos++;
					break;
				case 'O':
					oGanhos++;
					break;
				default:
					nEmpates++;
					break;
			}
		}

		Util.println("O jogador X ganhou "+xGanhos+" "+( (xGanhos==1)?"vez":"vezes") );
		Util.println("O jogador O ganhou "+oGanhos+" "+( (oGanhos==1)?"vez":"vezes") );
		Util.println("O jogo ficou empatado "+nEmpates+" "+( (nEmpates==1)?"vez":"vezes") );
	}
}