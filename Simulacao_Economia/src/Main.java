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
		System.out.print("Indique o numero de empresas que quer criar: ");
		numEmpresas = s.nextInt();
		funcEmp();

		for (int i = 0; i < familias.size(); i++) {
			System.out.println("Familias " + (i + 1) + familias.get(i));
		}

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

		System.out.println("1: " + familias.size());
		// for (int i = 0; i < familias.size(); i++) {
		// System.out.println("Familias 1 vez" + (i + 1) + familias.get(i));
		// }

	}

	public static void funcGov() {
		numFuncionariosGov = 100 + r.nextInt(401);
		System.out.println("Individuos do governo: " + numFuncionariosGov);

		int b, c;
		int diferençaGovTotal = contadorIndividuos - numFuncionariosGov;

		while (diferençaGovTotal < 0) {

			System.out.println("diferençaGovTotal = " + diferençaGovTotal);
			probabilidade = r.nextInt(101);
			if (probabilidade <= 70) {
				a = new ArrayList<Individuos>(2);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaGovTotal += 2;
			} else {
				a = new ArrayList<Individuos>(1);
				a.add(new Individuos(500 + r.nextInt(5001), ""));
				familias.add(a);
				diferençaGovTotal++;
			}

		}

		System.out.println("2: " + familias.size());
		// for (int i = 0; i < familias.size(); i++) {
		// System.out.println("Familias 2 vez" + (i + 1) + familias.get(i));
		// }

		for (int i = 0; i < numFuncionariosGov; i++) {
			do {
				b = r.nextInt(numFamilias);
				c = 0;
				if (familias.get(b).size() == 2) {
					c = r.nextInt(2);
				}
			} while (familias.get(b).get(c).getLocalTrabalho().equals("") == false);
			familias.get(b).get(c).setLocalTrabalho("Governo");

		}

	}

	public static void funcEmp() {
		int numFuncionariosEmp, a, b;
		for (int i = 0; i < numEmpresas; i++) {
			numFuncionariosEmp = 1 + r.nextInt(51);
			for (int k = 0; k < numFuncionariosEmp; k++) {
				do {
					a = r.nextInt(numFamilias);
					b = 0;
					if (familias.get(a).size() == 2) {
						b = r.nextInt(2);
					}
				} while (familias.get(a).get(b).getLocalTrabalho().equals("") == false);
				familias.get(a).get(b).setLocalTrabalho("Empresa " + k);
			}
		}
	}
}
