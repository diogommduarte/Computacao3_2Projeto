import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner a = new Scanner(System.in);
	static int numFamilias;
	static int numEmpresas;

	static Random r = new Random();
	static int minimoIndividuos;
	static int maximoIndividuos;

	public static void main(String[] args) {

		// Gerar o numero de individuos do governo [100,500]
		// Perguntar ao utilizador quantas empresas quer? // FEITO
		// Gerar numero de individuos para cada empresa [1,50]
		// Perguntar o numero de familias com restrição de minimo e maximo de familias
		

		utilizador();

	}

	public static void utilizador() {

		System.out.println("***Quantas empresas deseja inserir?***");
		numEmpresas = a.nextInt();
		/*
		 * minimoFamilias = numEmpresas * 1 + 100; maximoFamilias =
		 * numEmpresas*50 + 500;
		 */
		// ideia, em vez de familias é individuos!
		System.out.println("**Quantas familias deseja inserir?***\nDeve de inserir entre " + minimoIndividuos + " e "
				+ maximoIndividuos);
		numFamilias = a.nextInt();

		economia();

	}

	public static void economia() {

		/*
		 * Individuos I = new Individuos();
		 * 
		 * do{ I.getTotalIndividuos();//soma total do individuos
		 * 
		 * 
		 * 
		 * }while(); }
		 */

	}
}
