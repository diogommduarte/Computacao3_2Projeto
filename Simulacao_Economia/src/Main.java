import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);
	static int numFamilias, numEmpresas, ano, trimestre;
	static ArrayList<ArrayList<Individuos>> familias = new ArrayList<ArrayList<Individuos>>(numFamilias);
	static ArrayList<Empresas> empresas;// onde � utilizado
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
	static int numeroDesempregadosDepoisGov;
	static int minimoInteiro;
	static int contadorFuncionariosEmp;
	static int numeroDesempregadosDepoisGovDes;
	static int repeteProcesso;
	static int selecaoMenu;
	static String numTemp;
	static int numMesesPassados;

	public static void main(String[] args) {
		System.out.println("***CONSTRU��O DA ECONOMIA***\n");
		System.out.print("Indique o n�mero de fam�lias que deseja criar: ");
		numFamilias = s.nextInt();
		criarFamilias();
		funcionariosGov();

		do {

			if (numeroDesempregadosDepoisGov == 0) {
				System.out.println(
						"A economia n�o tem empresas porque todos os individuos disponiveis trabalham no Governo.\n Se desejar criar uma outra economia com empresas insira 1, se deseja continuar insira qualquer outra tecla");
				repeteProcesso = s.nextInt();
				// � PRECISO DAR RESET AOS ARRAYLIST

				familias.clear();
				System.out.println("Familias: \n");
				printFamilias();
				main(args);
			}

			else {
				repeteProcesso = 2;
				numeroEmpresas();
				empresas = criarEmpresas(numEmpresas);
				funcionariosEmp();
				printFamilias();
				printEmpresas();
				System.out.println("N�mero de desempregados depois da aloca��o dos individuos nas empresas -> "
						+ numeroDesempregadosDepoisGovDes);
			}
		} while (repeteProcesso == 1);

		do {
			System.out.println("\n*** MENU DA ECONOMIA ***");
			System.out.println("1 - Avan�ar no Tempo");
			System.out.println("2 - Mostrar Estatisticas (M�dia e Mediana)");
			System.out.println("3 - PIB semestre/ano");
			System.out.println("Escolha o menu que deseja -> ");
			selecaoMenu = s.nextInt();

		} while (selecaoMenu != 1 && selecaoMenu != 2 && selecaoMenu != 3);

		switch (selecaoMenu) {
		case 1:

			avancarTempo();

			break;
		case 2:

			// chamar classe estatistica com print das medias e medianas

			break;
		case 3:

			// imprimir PIB por semestre e por ano

			break;
		}

	}

	public static void criarFamilias() {

		contadorIndividuos = 0;

		for (int i = 0; i < numFamilias; i++) {
			probabilidade = r.nextInt(101);
			salario1 = 500 + r.nextInt(5000);
			salario2 = 500 + r.nextInt(5000);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);

				a.add(new Individuos(salario1, salario1, "", i, 0));
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

		System.out.println("\nN�mero de individuos -> " + contadorIndividuos);

		System.out.println("N�mero de Familias -> " + familias.size() + "\n");

		printFamilias();

	}

	public static void funcionariosGov() {
		int b, c;
		numFuncionariosGov = 100 + r.nextInt(400);
		// numFuncionariosGov = 100;

		System.out.println("***Cria��o do Governo***");
		System.out.println("Individuos do governo -> " + numFuncionariosGov + "(gerado aleat�riamente)");
		System.out.println(
				"\nSe o n�mero de individuos do governo � maior que o n�mero de individuos, o sistema ir� criar ");
		System.out.println(
				"famil�as e individuos de modo a que haja individuos suficientes para trabalhar no governo!\n");

		criarFamiliasGov();

		System.out.println("N�mero de Familias depois da funcionariosGov -> " + familias.size());
		System.out.println("\nN�mero total de individuos depois da funcionariosGov -> " + contadorIndividuos + "\n");

		apagarIndGov();

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

		if (contadorIndividuos > numFuncionariosGov) {

			for (int k = 0; k < familias.size(); k++) {
				for (int j = 0; j < familias.get(k).size(); j++) {
					if (familias.get(k).get(j).getLocalTrabalho().equals("")) {
						numeroDesempregadosDepoisGov++;
					}
				}
			}
		}

		System.out.println("N�mero de individuos desempregados -> " + numeroDesempregadosDepoisGov);

		printFamilias();

	}

	public static void funcionariosEmp() {

		int b, c;
		for (int k = 0; k < numEmpresas; k++) {
			for (int i = 0; i < empresas.get(k).getNumTrabalhadores(); i++) {
				do {
					b = r.nextInt(familias.size());
					c = 0;
					if (familias.get(b).size() == 2) {
						c = r.nextInt(2);
					}
				} while (familias.get(b).get(c).getLocalTrabalho().equals("") == false);
				familias.get(b).get(c).setLocalTrabalho("Empresa " + (k + 1));

			}
		}

		System.out.println("N�mero de desempregados antes da aloca��o dos individuos nas empresas -> "
				+ numeroDesempregadosDepoisGov);

	}

	public static void numeroEmpresas() {

		if (numeroDesempregadosDepoisGov % 50 == 0) {
			minimoInteiro = (int) (numeroDesempregadosDepoisGov / 50);
			do {
				System.out.print("Indique o numero de empresas que quer criar (entre "
						+ (int) (numeroDesempregadosDepoisGov / 50) + ", " + numeroDesempregadosDepoisGov + ") ->");
				numEmpresas = s.nextInt();
			} while (numEmpresas < minimoInteiro || numEmpresas > numeroDesempregadosDepoisGov);

		}

		else {
			minimoInteiro = (((int) (numeroDesempregadosDepoisGov / 50)) + 1);
			do {
				System.out.print("Indique o numero de empresas que quer criar (entre "
						+ (((int) (numeroDesempregadosDepoisGov / 50)) + 1) + ", " + numeroDesempregadosDepoisGov
						+ ") ->");
				numEmpresas = s.nextInt();
			} while (numEmpresas < minimoInteiro || numEmpresas > numeroDesempregadosDepoisGov);

		}
	}

	public static void funcEmp(ArrayList<Empresas> emps) {
		// int b, c, numeroDeIndQueFaltaAlocar;
		// System.out.println("");
		// // System.out.println("contadorIndividuos " + contadorIndividuos);
		// // System.out.println(" numFuncionariosGov " + numFuncionariosGov);
		// int diferen�aEntreContadorEFuncionariosGov = contadorIndividuos -
		// numFuncionariosGov;
		//
		//// if (diferen�aEntreContadorEFuncionariosGov > 0) {
		//// numeroDeIndQueFaltaAlocar = diferen�aEntreContadorEFuncionariosGov;
		////
		//// while (numeroDeIndQueFaltaAlocar > 0) { for (int i = 0; i <
		//// numEmpresas; i++) {
		////
		//// for (int k = 0; k < emps.get(i).getNumTrabalhadores(); k++) {// <=?
		////
		//// do { b = r.nextInt(familias.size()); c = 0; if
		//// (familias.get(b).size() == 2) { c = r.nextInt(2); }
		////
		//// } while
		// (familias.get(b).get(c).getLocalTrabalho().equals("Governo")
		//// == true); familias.get(b).get(c).setLocalTrabalho("Empresa " + (i +
		//// 1)); numeroDeIndQueFaltaAlocar--; }
		////
		//// System.out.println("numeroDeIndQueFaltaAlocar" +
		//// numeroDeIndQueFaltaAlocar); }
		////
		//// }
		////
		//// }
		//
		//
		// if (diferen�aEntreContadorEFuncionariosGov == 0) {
		// // System.out.println("Total Funcionarios Empresas: " +
		// // somaNumFuncionarioEmp);
		//
		// while (somaNumFuncionarioEmp > 0) {
		//
		// // System.out.println("diferen�aGovTotal = " +
		// // diferen�aGovTotal);
		//
		// int i = 0;
		//
		// if (i <= familias.size()) {
		// probabilidade = r.nextInt(101);
		// salario1 = 500 + r.nextInt(5001);
		// salario2 = 500 + r.nextInt(5001);
		// if (probabilidade <= 70) {
		// a = new ArrayList<Individuos>(2);
		//
		// a.add(new Individuos(salario1, salario1, "", i, 0));
		// a.add(new Individuos(salario2, salario2, "", i, 1));
		// familias.add(a);
		// contadorIndividuos += 2;
		// somaNumFuncionarioEmp -= 2;
		// } else {
		// a = new ArrayList<Individuos>(1);
		// a.add(new Individuos(salario1, salario1, "", i, 0));
		// familias.add(a);
		// contadorIndividuos++;
		// somaNumFuncionarioEmp--;
		// }
		//
		// i++;
		//
		// }
		//
		// }
		//
		// for (int i = 0; i < numEmpresas; i++) {
		//
		// for (int k = 0; k < empresas.get(i).getNumTrabalhadores(); k++) {//
		// <=?
		//
		// do {
		// b = r.nextInt(familias.size());
		// c = 0;
		// if (familias.get(b).size() == 2) {
		// c = r.nextInt(2);
		// }
		//
		// } while (familias.get(b).get(c).getLocalTrabalho().equals("") ==
		// false);
		// familias.get(b).get(c).setLocalTrabalho("Empresa " + (i + 1));
		//
		// }
		//
		// }
		//
		// if (contadorIndividuos != (numFuncionariosGov + numFuncionariosEmp))
		// {
		//
		// for (int g = 0; g < familias.size(); g++) {
		// for (int d = 0; d < familias.get(g).size(); d++) {
		// if (familias.get(g).get(d).getLocalTrabalho().equals("") &&
		// familias.get(g).size() == 2) {
		// familias.get(g).remove(d);
		// contadorIndividuos--;
		//
		// }
		//
		// else {
		// familias.remove(g);
		// contadorIndividuos--;
		//
		// }
		// }
		// }
		//
		// }
		//
		// printFamilias();
		//
		// }
		//
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

		System.out.println("N�mero Total de Individuos na Economia -> " + contadorIndividuos);

	}

	public static void criarFamiliasGov() {
		int diferen�aGovTotal = contadorIndividuos - numFuncionariosGov;

		while (diferen�aGovTotal < 0) {

			int i = 0;

			if (i <= familias.size()) {
				probabilidade = r.nextInt(101);
				salario1 = 500 + r.nextInt(5000);
				salario2 = 500 + r.nextInt(5000);
				if (probabilidade <= 70) {
					a = new ArrayList<Individuos>(2);

					a.add(new Individuos(salario1, salario1, "", i, 0));
					a.add(new Individuos(salario2, salario2, "", i, 1));
					familias.add(a);
					diferen�aGovTotal += 2;
					contadorIndividuos += 2;
				} else {
					a = new ArrayList<Individuos>(1);
					a.add(new Individuos(salario1, salario1, "", i, 0));
					familias.add(a);
					diferen�aGovTotal++;
					contadorIndividuos++;
				}

				i++;

			}

		}
	}

	public static ArrayList<Empresas> criarEmpresas(int numEmpresas) {
		ArrayList<Empresas> emps = new ArrayList<Empresas>(numEmpresas);

		if (numEmpresas == numeroDesempregadosDepoisGov) {

			for (int i = 0; i < numEmpresas; i++) {
				numFuncionariosEmp = 1;
				emps.add(new Empresas(0, 0, "Empresa " + (i + 1), numFuncionariosEmp));
			}

			return emps;

		}

		else if (numEmpresas == minimoInteiro) {
			contadorFuncionariosEmp = numeroDesempregadosDepoisGov;
			for (int k = 0; k < numEmpresas; k++) {

				numFuncionariosEmp = 50;

				if (contadorFuncionariosEmp > 50) {
					emps.add(new Empresas(0, 0, "Empresa " + (k + 1), numFuncionariosEmp));
					contadorFuncionariosEmp -= numFuncionariosEmp;
				} else if (contadorFuncionariosEmp < 50) {
					emps.add(new Empresas(0, 0, "Empresa " + (k + 1), contadorFuncionariosEmp));
				} else if (numeroDesempregadosDepoisGov < 50) {
					emps.add(new Empresas(0, 0, "Empresa " + (k + 1), numeroDesempregadosDepoisGov));
				}
			}

			return emps;

		}

		else {

			numeroDesempregadosDepoisGovDes = numeroDesempregadosDepoisGov;

			for (int i = 0; i < numEmpresas; i++) {

				if (i == (numEmpresas - 1)) {
					int modulus = (int) (numeroDesempregadosDepoisGovDes / 50);
					for (int k = 0; k < modulus; k++) {
						numFuncionariosEmp = 50;
						emps.add(new Empresas(0, 0, "Empresa " + (emps.size() + 1), numFuncionariosEmp));
					}
					if (numeroDesempregadosDepoisGovDes - (50 * modulus) > 0) {
						numFuncionariosEmp = numeroDesempregadosDepoisGovDes - (50 * modulus);

					}

					System.out.println(" O sistema criou automaticamente " + (modulus)
							+ " empresas para que n�o houvesse pessoas desempregadas");

				}

				else if (numeroDesempregadosDepoisGovDes > 50 + numEmpresas) {
					numFuncionariosEmp = 1 + r.nextInt(50);
				}

				else {
					numFuncionariosEmp = 1 + r.nextInt(numeroDesempregadosDepoisGovDes - (numEmpresas - i));
				}
				emps.add(new Empresas(0, 0, "Empresa " + (emps.size() + 1), numFuncionariosEmp));
				numeroDesempregadosDepoisGovDes -= numFuncionariosEmp;

			}

		}

		return emps;

	}

	public static void apagarIndGov() {

		if (contadorIndividuos == (numFuncionariosGov + 1)) {
			if (familias.get(familias.size() - 1).size() == 2) {
				familias.get(familias.size() - 1).remove(1);
				contadorIndividuos--;

				System.out.println(
						"N�mero de Fam�lias depois da funcionariosGov e depois de apagar o individuo excdent�rio:: "
								+ familias.size());

				System.out.println(
						"\nN�mero total de individuos depois da funcionariosGov e depois de apagar o individuo excdent�rio: "
								+ contadorIndividuos);

			}

			else {
				familias.remove(familias.size() - 1);
				contadorIndividuos--;

				System.out.println(
						"N�mero de Fam�lias depois da funcionariosGov e depois de apagar o individuo excdent�rio:: "
								+ familias.size());

				System.out.println(
						"\nN�mero total de individuos depois da funcionariosGov e depois de apagar o individuo excdent�rio: "
								+ contadorIndividuos + "\n");

			}

		}

	}

	public static void avancarTempo() {

		do {
			System.out.println("Insira o n�mero de meses/anos que deseja avan�ar na economia (Exemplo: 1y ou 6m) -> ");
			numTemp = s.nextLine().toLowerCase();

		} while (!(numTemp.substring(numTemp.length() - 1, numTemp.length() - 1).equals("y")
				|| !(numTemp.substring(numTemp.length() - 1, numTemp.length() - 1).equals("m"))));

		if (!(numTemp.substring(numTemp.length() - 1, numTemp.length() - 1).equals("y"))) {

			// efectuarTransacoes(12*Integer.parseInt(numTemp.substring(0,
			// numTemp.length() - 2)));

		}

		else {

			// efectuarTransacoes(Integer.parseInt(numTemp.substring(0,
			// numTemp.length() - 2)));
		}

	}

	public static void efectuarTransacoes(int mes) {

		for (int i = 1; i <= mes; i++) {
			numMesesPassados++;

			if ((numMesesPassados - 1) % 12 == 0) {

				calcularEstatisticas(familias, governo, empresas);
				// colocar no array list respetivo na classe estatistica!!
			}

			if (mes % 3 == 0) {
				// calcularPib();
			}
			
			for(int fam = 0; fam < familias.size(); fam++)
			{
				for(int ind = 0; ind < familias.get(fam).size(); ind++)
				{
					while(familias.get(fam).get(ind).getContadorIncome() > 0){
						
						familias.get(fam).get(ind).destinoGasto(familias, empresas, governo);
						
					}
					
					familias.get(fam).get(ind).receberSalario();
				}
			}
			
			for(int j = 0; j < empresas.size(); j++)
			{
				for(int k = 0; k < empresas.size(); k++){
					
					empresas.get(j).pagarSalarios();
					
					if(empresas.get(j).getContadorIncome() < 0)
					{
						//pedir emprestimo ao banco
						//banco.pedirEmprestimo(Math.abs(empresas.get(j).getContadorIncome()));
						empresas.get(j).setContadorIncome(0);
					}
					
					else{
						while(empresas.get(j).getContadorIncome() > 0)
						{
							empresas.get(j).destinoGasto(familias, empresas, governo);
						}
					}
				}
			}
			
			
			governo.pagarSalarios();
			if(governo.getContadorIncome() < 0)
			{
				//pedir emprestimo ao banco
				//banco.pedirEmprestimo(Math.abs(empresas.get(j).getContadorIncome()));
				governo.setContadorIncome(0);
			}
			
			else{
				while(governo.getContadorIncome() > 0){
					governo.destinoGasto(familias, empresas, governo);
				}
			}
			
		}
	}

}
