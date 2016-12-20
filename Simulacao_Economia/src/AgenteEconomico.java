import java.util.ArrayList;
public abstract class AgenteEconomico {
	protected int income;
	protected int contadorIncome;
	
	public AgenteEconomico (int income, int contadorIncome){
		this.income=income;
		this.contadorIncome= contadorIncome;
	}
	
	public AgenteEconomico(int contadorIncome)
	{
		this.contadorIncome = contadorIncome;
	}


	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getContadorIncome() {
		return contadorIncome;
	}

	public void setContadorIncome(int contadorIncome) {
		this.contadorIncome = contadorIncome;
	}

	public abstract void destinoGasto(ArrayList<ArrayList<Individuos>> familias,ArrayList<Empresas> emps, Governo gov);
	

}
