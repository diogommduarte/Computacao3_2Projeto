import java.util.Random;

public class Individuos {

	protected int numFamilias;
	protected int salarioFamilia;
	protected String tipoEmprego;
	protected Random r = new Random();
	protected int totalIndividuos;

	Object[][] familia;

	public Individuos() {

		familia = new Object[numFamilias][];

		for (int i = 0; i < numFamilias; i++) {
			familia[i] = new Object[2];// fazer metodo auxiliar
			for (int k = 0; k < familia[i].length; k++) {
				salarioFamilia = 500 + r.nextInt(5000 - 500 + 1);
				familia[i][k] = salarioFamilia;
				//fazer soma total individuos!

			}

		}

	}

	public int getTotalIndividuos() {
		return totalIndividuos;
	}

	public void setTotalIndividuos(int totalIndividuos) {
		this.totalIndividuos = totalIndividuos;
	}

	public Object[][] getFamilia() {
		return familia;
	}

	public void setFamilia(Object[][] familia) {
		this.familia = familia;
	}

	public int getNumFamilias() {
		return numFamilias;
	}

	public void setNumFamilias(int numFamilias) {
		this.numFamilias = numFamilias;
	}

	public int getSalarioFamilia() {
		return salarioFamilia;
	}

	public void setSalarioFamilia(int salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	public String getTipoEmprego() {
		return tipoEmprego;
	}

	public void setTipoEmprego(String tipoEmprego) {
		this.tipoEmprego = tipoEmprego;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

}
