import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);
	static int numFamilias, numEmpresas, ano, trimestre;
	static ArrayList<ArrayList<Individuos>> familias = new ArrayList<ArrayList<Individuos>>(numFamilias);
	static ArrayList<Empresas> empresas;//onde é utilizado?
	static Random r = new Random();
	static int contadorIndividuos;
	static int numFuncionariosGov;
	static ArrayList<Individuos> a;
	static int probabilidade;
	static Governo governo = new Governo(0);
	static int salario1;
	static int salario2;
	static int numFuncionariosEmp;
	static int somaNumFuncionarioEmp;

	public static void main(String[] args) {
		System.out.print("Indique o numero de familias que quer criar: ");
		numFamilias = s.nextInt();
		criarFamilias();
		funcGov();
		printFamilias();
		System.out.print("Indique o numero de empresas que quer criar: ");
		numEmpresas = s.nextInt();
		empresas = criarEmpresas(numEmpresas);
		funcEmp(empresas);
		printFamilias();
		printEmpresas();

	}

	public static void criarFamilias() {

		contadorIndividuos = 0;

		for (int i = 0; i < numFamilias; i++) {
			probabilidade = r.nextInt(101);
			salario1 = 500 + r.nextInt(5001);
			salario2 = 500 + r.nextInt(5001);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);
				
				a.add(new Individuos(salario1,salario1, "", i, 0));
				a.add(new Individuos(salario2, salario2, "", i, 1));
				familias.add(a);
				contadorIndividuos += 2;
			} else {
				a = new ArrayList<Individuos>(1);
				
				a.add(new Individuos(salario1, salario1, "", i, 0));
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

			int i = 0;

			if (i <= familias.size()) {
				probabilidade = r.nextInt(101);
				salario1 = 500 + r.nextInt(5001);
				salario2 = 500 + r.nextInt(5001);
				if (probabilidade <= 70) {
					a = new ArrayList<Individuos>(2);
					
					a.add(new Individuos(salario1, salario1, "", i, 0));
					a.add(new Individuos(salario2, salario2, "", i, 1));
					familias.add(a);
					diferençaGovTotal += 2;
					contadorIndividuos += 2;
				} else {
					a = new ArrayList<Individuos>(1);
					a.add(new Individuos(salario1, salario1, "", i, 0));
					familias.add(a);
					diferençaGovTotal++;
					contadorIndividuos++;
				}

				i++;

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

	public static ArrayList<Empresas> criarEmpresas(int numEmpresas) {
		ArrayList<Empresas> emps = new ArrayList<Empresas>(numEmpresas);//Nao e necessario
		
		for (int i = 0; i < numEmpresas; i++) {
			numFuncionariosEmp = 1 + r.nextInt(51);
			emps.add(new Empresas(0, 0, "Empresa " + (i+1), numFuncionariosEmp) );
			
			somaNumFuncionarioEmp += numFuncionariosEmp;

		}
		return emps;
	}

	public static void funcEmp(ArrayList<Empresas> emps) {
		int b, c, numeroDeIndQueFaltaAlocar;

		System.out.println("contadorIndividuos " + contadorIndividuos);
		System.out.println(" numFuncionariosGov " + numFuncionariosGov);
		int diferençaEntreContadorEFuncionariosGov = contadorIndividuos - numFuncionariosGov;

		if (diferençaEntreContadorEFuncionariosGov > 0) {
			numeroDeIndQueFaltaAlocar = diferençaEntreContadorEFuncionariosGov;

			
			while (numeroDeIndQueFaltaAlocar > 0) {
				for (int i = 0; i < numEmpresas; i++) {
					
					for (int k = 0; k < emps.get(i).getNumTrabalhadores() ; k++) {// <=?

						do {
							b = r.nextInt(familias.size());
							c = 0;
							if (familias.get(b).size() == 2) {
								c = r.nextInt(2);
							}

						} while (familias.get(b).get(c).getLocalTrabalho().equals("Governo") == true);
						familias.get(b).get(c).setLocalTrabalho("Empresa " + (i + 1));
						numeroDeIndQueFaltaAlocar--;
					}

					System.out.println("numeroDeIndQueFaltaAlocar" + numeroDeIndQueFaltaAlocar);
				}

			}

		}

		if(diferençaEntreContadorEFuncionariosGov == 0)
		{
			//System.out.println("Total Funcionarios Empresas: " + somaNumFuncionarioEmp);
			
			while (somaNumFuncionarioEmp > 0) {

				// System.out.println("diferençaGovTotal = " + diferençaGovTotal);
				
				int i = 0;

				if (i <= familias.size()) {
					probabilidade = r.nextInt(101);
					salario1 = 500 + r.nextInt(5001);
					salario2 = 500 + r.nextInt(5001);
					if (probabilidade <= 70) {
						a = new ArrayList<Individuos>(2);
						
						a.add(new Individuos(salario1, salario1, "", i, 0));
						a.add(new Individuos(salario2, salario2, "", i, 1));
						familias.add(a);
						
						somaNumFuncionarioEmp -= 2;
					} else {
						a = new ArrayList<Individuos>(1);
						a.add(new Individuos(salario1, salario1, "", i, 0));
						familias.add(a);
						
						somaNumFuncionarioEmp--;
					}

					i++;

				}

			}
			
			
			for (int i = 0; i < numEmpresas; i++) {
				
				for (int k = 0; k < empresas.get(i).getNumTrabalhadores() ; k++) {// <=?

					do {
						b = r.nextInt(familias.size());
						c = 0;
						if (familias.get(b).size() == 2) {
							c = r.nextInt(2);
						}

					} while (familias.get(b).get(c).getLocalTrabalho().equals("") == false);
					familias.get(b).get(c).setLocalTrabalho("Empresa " + (i + 1));
					
				}

				
			}
			
		}
		
		
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
	
	public static void printEmpresas() {

		for (int i = 0; i < empresas.size(); i++) {
			
			empresas.get(i).print();
			
			
		}

	}
}
