import java.util.Scanner;

public class Teclado
{
	private static Scanner scanner = new Scanner(System.in);

	/** Constructor deixado vazio intencionalmente */
	public Teclado(){}

	/** Ler string */
	public String next()
	{
		return scanner.next();
	}

	/** Imprimir quest�o e ler string */
	public String next( String question )
	{
		Util.print(question+" ");
		return scanner.next();
	}

	/** Ler inteiro */
	public int nextInt()
	{
		return scanner.nextInt();
	}

	/** Imprimir quest�o e ler inteiro */
	public int nextInt( String question )
	{
		Util.print(question+" ");
		return nextInt();
	}

	/** Ler char */
	public char nextChar()
	{
		return next().charAt(0);
	}

	/** Imprimir quest�o e ler char */
	public char nextChar( String question )
	{
		Util.print(question+" ");
		return nextChar();
	}
}