import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);
	static int numFamilias, numEmpresas;
	static ArrayList<ArrayList<Individuos>> familias = new ArrayList<ArrayList<Individuos>>(numFamilias);
	static Random r = new Random();
	static int contadorIndividuos;
	static int numFuncionariosGov;
	static ArrayList<Individuos> a;
	static int probabilidade;

	public static void main(String[] args) {
		System.out.print("Indique o numero de familias que quer criar: ");
		numFamilias = s.nextInt();
		criarFamilias();
		funcGov();
		printFamilias();
		System.out.print("Indique o numero de empresas que quer criar: ");
		numEmpresas = s.nextInt();
		funcEmp();
		printFamilias();

	}

	public static void criarFamilias() {

		contadorIndividuos = 0;

		for (int i = 0; i < numFamilias; i++) {
			probabilidade = r.nextInt(101);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				contadorIndividuos += 2;
			} else {
				a = new ArrayList<Individuos>(1);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				contadorIndividuos++;
			}
		}

		System.out.println("Número total de individuos: " + contadorIndividuos);

		System.out.println("Número de Familias Inicial: " + familias.size());

	}

	public static void funcGov() {
		numFuncionariosGov = 100 + r.nextInt(401);
		// numFuncionariosGov = 150;

		System.out.println("Individuos do governo: " + numFuncionariosGov);

		int b, c;
		int diferençaGovTotal = contadorIndividuos - numFuncionariosGov;

		while (diferençaGovTotal < 0) {

			// System.out.println("diferençaGovTotal = " + diferençaGovTotal);
			probabilidade = r.nextInt(101);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaGovTotal += 2;
				contadorIndividuos += 2;
			} else {
				a = new ArrayList<Individuos>(1);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaGovTotal++;
				contadorIndividuos++;
			}

		}

		System.out.println("Número total de individuos depois da funcGov: " + contadorIndividuos);

		System.out.println("Número de Familias depois da funcGov: " + familias.size());

		if (contadorIndividuos == (numFuncionariosGov + 1)) {
			if (familias.get(familias.size() - 1).size() == 2) {
				familias.get(familias.size() - 1).remove(1);
				contadorIndividuos--;

			}

			else {
				familias.remove(familias.size() - 1);
				contadorIndividuos--;

			}

			System.out
					.println("Número total de individuos depois da funcGov e depois de apagar o individuo excdentário: "
							+ contadorIndividuos);

			System.out.println("Número de Familias depois da funcGov e depois de apagar o individuo excdentário:: "
					+ familias.size());
		}

		for (int i = 0; i < numFuncionariosGov; i++) {
			do {
				b = r.nextInt(familias.size());
				c = 0;
				if (familias.get(b).size() == 2) {
					c = r.nextInt(2);
				}
			} while (familias.get(b).get(c).getLocalTrabalho().equals("") == false);
			familias.get(b).get(c).setLocalTrabalho("Governo");

		}

	}

	public static void funcEmp() {
		int numFuncionariosEmp, b, c, numeroDeIndQueFaltaAlocar;

		System.out.println("contadorIndividuos " + contadorIndividuos);
		System.out.println(" numFuncionariosGov " + numFuncionariosGov);
		int diferençaEntreContadorEFuncionariosGov = contadorIndividuos - numFuncionariosGov;
		
		if(diferençaEntreContadorEFuncionariosGov > 0){
			numeroDeIndQueFaltaAlocar = diferençaEntreContadorEFuncionariosGov;
			System.out.println("numeroDeIndQueFaltaAlocar" + numeroDeIndQueFaltaAlocar);
			while(numeroDeIndQueFaltaAlocar > 0)	
			{

				for (int i = 0; i < numEmpresas; i++) {
					numFuncionariosEmp = 1 + r.nextInt(51); 
					for (int k = 0; k < numFuncionariosEmp; k++) {
						numeroDeIndQueFaltaAlocar --;
						do {
							b = r.nextInt(familias.size());
							c = 0;
							if (familias.get(b).size() == 2) {
								c = r.nextInt(2);
							}
							
							
						} while (familias.get(b).get(c).getLocalTrabalho().equals("Governo") == true);
						familias.get(b).get(c).setLocalTrabalho("Empresa " + (i+1) + "(Nº Trabalhadores: " + numFuncionariosEmp + " )");
						
						
						
					}
					
					System.out.println("numeroDeIndQueFaltaAlocar" + numeroDeIndQueFaltaAlocar);
				}
			
			}
			
			
		}
			
		
		
		
		/*while(diferençaEmpTotal < 0) {
			System.out.println("OLA");
			probabilidade = r.nextInt(101);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaEmpTotal +=2;
				contadorIndividuos += 2;
			} else {
				a = new ArrayList<Individuos>(1);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaEmpTotal ++;
				contadorIndividuos++;
			}

		}*/

		/*	for (int i = 0; i < numFuncionariosGov; i++) {
			do {
				b = r.nextInt(familias.size());
				c = 0;
				if (familias.get(b).size() == 2) {
					c = r.nextInt(2);
				}
			} while (familias.get(b).get(c).getLocalTrabalho().equals("") == false);
			familias.get(b).get(c).setLocalTrabalho("Governo");*/
		
		
			
		

		

	}

	public static void printFamilias() {

		for (int i = 0; i < familias.size(); i++) {
			System.out.println("Familia " + (i + 1));
			for (int k = 0; k < familias.get(i).size(); k++) {
				System.out.print("Individuo " + (k + 1) + " ");
				familias.get(i).get(k).print();
			}
			System.out.println();
		}

	}
}
