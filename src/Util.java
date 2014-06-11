
public class Util
{
	/** Contém o separador de linhas */
	public static final String EOL = System.getProperty("line.separator");

	/** Imprime um inteiro */
	public static void print( int n )
	{
		System.out.print(n);
	}

	/** Imprime uma string */
	public static void print( String txt )
	{
		System.out.print(txt);
	}

	/** Imprime uma nova linha */
	public static void println()
	{
		System.out.println();
	}

	/** Imprime um inteiro e uma nova linha */
	public static void println( int n )
	{
		System.out.println(n);
	}

	/** Imprime uma string e uma nova linha */
	public static void println( String txt )
	{
		System.out.println(txt);
	}

	/** Verifica se uma string pode ser convertida para inteiro */
	public static boolean isInteger( String txt )
	{
		txt = txt.trim();

		for(int i=0; i<txt.length(); i++)
		{
			if( txt.charAt(i) < '0' || txt.charAt(i) > '9' )
				return false;
		}

		return true;
	}

	/** Retorna um inteiro obtido a partir da String */
	public static int parseInt( String txt )
	{
		txt = txt.trim();

		int ret = 0;

		for(int i=0; i<txt.length(); i++)
			ret += (txt.charAt(i)-'0') * powInt( 10, (txt.length()-1-i) );

		return ret;
	}

	/**
	 * Retorna o resultado de um número 'n' elevado à potência 'pow'.
	 * Só usar para 'n' e 'pow' positivos.
	 */
	public static int powInt( int n, int pow )
	{
		int ret = 1;

		while( pow > 0 )
		{
			ret *= n;
			pow--;
		}

		return ret;
	}
}