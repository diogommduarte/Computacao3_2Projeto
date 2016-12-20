import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Individuos extends AgenteEconomico {

	protected String localTrabalho;
	protected int familia;
	protected int individuo;
	static Random r = new Random();

	public Individuos(int income, int contadorIncome, String localTrabalho, int familia, int individuo) {
		super(income, contadorIncome);
		this.contadorIncome = calculoValorGastar(income);
		this.localTrabalho = localTrabalho;
		this.familia = familia;
		this.individuo = individuo;

	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public int getFamilia() {
		return familia;
	}

	public void setFamilia(int familia) {
		this.familia = familia;
	}

	public int getIndividuo() {
		return individuo;
	}

	public void setIndividuo(int individuo) {
		this.individuo = individuo;
	}

	public void destinoGasto(ArrayList<ArrayList<Individuos>> familias, ArrayList<Empresas> emps, Governo gov) {

		int escolha = r.nextInt(2);
		int fam, ind;
		int gasto = (int) (10 - (10 * 0.25));
		int txGov = (int) (10 * 0.25);

		if (escolha == 0) {
			do {
				fam = r.nextInt(familias.size());
				ind = 0;
				if (familias.get(fam).size() == 2) {
					ind = r.nextInt(2);
				}

			} while (fam == this.familia);
			
			familias.get(fam).get(ind).setContadorIncome(familias.get(fam).get(ind).getContadorIncome()+ gasto);
			gov.setContadorIncome(txGov);
			this.setContadorIncome(this.getContadorIncome()-10);
		}
		
		else{
			do{
				escolha = r.nextInt(emps.size());
				
				
			}while(this.getLocalTrabalho().equals(emps.get(escolha).getNome()));
			emps.get(escolha).setContadorIncome(emps.get(escolha).getContadorIncome()+ gasto);
			gov.setContadorIncome(txGov);
			this.setContadorIncome(this.getContadorIncome()-10);
		}

	}
	
	
	public int calculoValorGastar(int income){
		if(income < 600)
		{
			return income;
		}
		
		else if(income >= 600 && income < 750)
		{
			return (int)(income*0.95);
		}
		
		else if(income >= 750 && income < 1000)
		{
			return (int)(0.85*income);
		}
		
		else if(income >= 1000 && income < 1500)
		{
			return (int)(0.7*income);
		}
		
		else if(income >= 1500 && income < 2500)
		{
			return (int)(0.6*income);
		}
		else{
		return (int)(0.5*income);
		}
	}
	

	public void print() {

		System.out.println("Salário -> " + income + "€" + " /" + " ValorGastar -> " + contadorIncome + "€" +" / Local de Trabalho -> " + localTrabalho);
	}

}
