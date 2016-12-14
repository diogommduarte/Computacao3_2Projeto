public abstract class AgenteEconomico {
	protected int income;
	
	public AgenteEconomico (int income){
		this.income=income;
	}

public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public abstract int gastos();

}
