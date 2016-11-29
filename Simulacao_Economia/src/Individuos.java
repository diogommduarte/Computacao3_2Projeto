import java.util.Random;

public class Individuos {

	int numFamilias;
	int salarioFamilia;
	Random r = new Random();
	Object[][] familia;

	public Individuos() {

		familia = new Object[numFamilias][];

		for (int i = 0; i < numFamilias; i++) {
			familia[i] = new Object[2];//fazer metodo auxiliar 
			for (int k = 0; k < familia[i].length; k++) {
				salarioFamilia = 500+ r.nextInt(5000-500+1);
				familia[i][k] = salarioFamilia;
			}
		}

	}

}
