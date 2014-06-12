
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
		int ret = 0;

		for(int i=0; i<txt.length(); i++)
		{
			// Converter char para inteiro
			if('0' <= txt.charAt(i) && txt.charAt(i) <= '9')
			{
				ret *= 10;
				ret += txt.charAt(i) - '0';
			}
		}

		// Alterar o sinal se necessário
		if(txt.charAt(0) == '-')
		{
			ret *= -1;
		}

		return ret;
	}
}