import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Classe utilit�ria para acesso a ficheiros.<br/>
 * Para utiliza��o na unidade curricular <em> Programa��o </em> dos cursos do ISEL.
 * @author Pedro Pereira
 */
public final class FileAcess {

	/**
	 * Proibe instanciar objectos desta classe.
	 */
	private FileAcess() {} // Construtor privado

	/**
	 * Permite a leitura de ficheiros de texto.
	 * <p>
	 * M�todo est�tico que recebe como par�metro o nome do ficheiro de texto a ler
	 * e retorna uma refer�ncia para um objecto do tipo {@code Scanner}
	 * para acesso de leitura.
	 * <br/>
	 * Retorna null quando o ficheiro n�o � encontrado.
	 * <br/>
	 * No final da utiliza��o, deve ser chamado o m�todo {@code close()}
	 * do objecto {@code Scanner}.
	 * </p>
	 *
     * @param	fileName Nome do ficheiro de texto a abrir para leitura.
     *
     * @return  refer�ncia para objecto do tipo Scanner para acesso de leitura,
     * 			{@code null} se o ficheiro n�o existe.
 	 *
	 */
	public static Scanner toRead(String fileName){
		try {
			return new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * Permite a escrita de ficheiros de texto.
	 * <p>
	 * 	M�todo est�tico que recebe como argumento o nome do ficheiro de texto a escrever,
	 * 	e retorna uma refer�ncia para um objecto do tipo {@code PrintStream} para acesso
	 *  de escrita.<br/>
	 *  Retorna null quando houver um erro na criacao do ficheiro.<br/>
	 *  No final, deve ser chamado o m�todo {@code close()} do objecto {@code PrintStream}.
	 *
     * @param	fileName Nome do ficheiro de texto a abrir para escrita.
     *
     * @return  refer�ncia para objecto do tipo {@code PrintStream} para acesso de escrita,
     * 			{@code null} se houve erro na cria��o do ficheiro.
 	 *
	 */
	public static PrintStream toWrite(String fileName){
		try {
			return new PrintStream(new File(fileName));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Exemplo de utiliza��o da classe {@code FileAcess}.<br/>
	 * L� os valores inteiros que constam no ficheiro de texto <em>Valores.txt</em>.<br/>
	 * Escreve o total da soma dos valores lidos no ficheiro de texto <em>Total.txt</em>.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int sum=0, val;
		Scanner in = FileAcess.toRead("Valores.txt");
		if (in==null) {  // Erro ao abrir o ficheiro para leitura
			System.out.println("Erro ao aceder a Valores.txt"); return;
		}
		for(int i=1 ; in.hasNextInt() ; ++i ) {
			val = in.nextInt();	sum += val;
			System.out.println("valor 1 = "+val);
		}
		in.close(); // Fechar o ficheiro
		PrintStream out = FileAcess.toWrite("Total.txt");
		if (out!=null) { // Erro ao abrir o ficheiro para escrita
			out.println("Total = "+sum);
			out.close(); // Fechar o ficheiro
		}
	}
}