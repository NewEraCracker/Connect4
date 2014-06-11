import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Classe utilitária para acesso a ficheiros.<br/>
 * Para utilização na unidade curricular <em> Programação </em> dos cursos do ISEL.
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
	 * Método estático que recebe como parâmetro o nome do ficheiro de texto a ler
	 * e retorna uma referência para um objecto do tipo {@code Scanner}
	 * para acesso de leitura.
	 * <br/>
	 * Retorna null quando o ficheiro não é encontrado.
	 * <br/>
	 * No final da utilização, deve ser chamado o método {@code close()}
	 * do objecto {@code Scanner}.
	 * </p>
	 *
     * @param	fileName Nome do ficheiro de texto a abrir para leitura.
     *
     * @return  referência para objecto do tipo Scanner para acesso de leitura,
     * 			{@code null} se o ficheiro não existe.
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
	 * 	Método estático que recebe como argumento o nome do ficheiro de texto a escrever,
	 * 	e retorna uma referência para um objecto do tipo {@code PrintStream} para acesso
	 *  de escrita.<br/>
	 *  Retorna null quando houver um erro na criacao do ficheiro.<br/>
	 *  No final, deve ser chamado o método {@code close()} do objecto {@code PrintStream}.
	 *
     * @param	fileName Nome do ficheiro de texto a abrir para escrita.
     *
     * @return  referência para objecto do tipo {@code PrintStream} para acesso de escrita,
     * 			{@code null} se houve erro na criação do ficheiro.
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
	 * Exemplo de utilização da classe {@code FileAcess}.<br/>
	 * Lê os valores inteiros que constam no ficheiro de texto <em>Valores.txt</em>.<br/>
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