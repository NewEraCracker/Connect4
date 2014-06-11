import java.util.Random;

public class Aleatorio
{
	private static Random random = new Random();

	/** Constructor deixado vazio intencionalmente */
	public Aleatorio(){}

	/** Gera um inteiro aleatório entre 0 (inclusivé) e n (exculsivé) */
	public int nextInt(int n)
	{
		return random.nextInt(n);
	}
}