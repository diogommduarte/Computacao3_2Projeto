import java.util.ArrayList;
import java.util.Random;
public class Empresas extends AgenteEconomico{
	
	protected String nome;
	protected int numTrabalhadores;
	protected int totalSalarios;
	public int getTotalSalarios() {
		return totalSalarios;
	}



	

	static Random r = new Random();
	
	
	public Empresas(int income, int contadorIncome, String nome, int numTrabalhadores) {
		super(income, contadorIncome);
		this.nome=nome;
		this.numTrabalhadores = numTrabalhadores;
		this.totalSalarios = 0;
	}
	
	

	public int getNumTrabalhadores() {
		return numTrabalhadores;
	}
	
	public void setTotalSalarios(int totalSalarios) {
		this.totalSalarios = totalSalarios;
	}



	public void setNumTrabalhadores(int numTrabalhadores) {
		this.numTrabalhadores = numTrabalhadores;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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

			} while (familias.get(fam).get(ind).getLocalTrabalho().equals(this.nome));
			
			familias.get(fam).get(ind).setContadorIncome(familias.get(fam).get(ind).getContadorIncome()+ gasto);
			gov.setContadorIncome(txGov);
			if(this.getContadorIncome()<10){
				familias.get(fam).get(ind).setContadorIncome(familias.get(fam).get(ind).getContadorIncome()+this.getContadorIncome());
				gov.setContadorIncome((int)(this.getContadorIncome()*0.25));
				this.setContadorIncome(this.getContadorIncome()-this.getContadorIncome());
			}
			this.setContadorIncome(this.getContadorIncome()-10);
		}
		
		else{
			do{
				escolha = r.nextInt(emps.size());
			}while(this.getNome().equals(emps.get(escolha).getNome()));
			emps.get(escolha).setContadorIncome(emps.get(escolha).getContadorIncome()+ gasto);
			gov.setContadorIncome(txGov);
			if(this.getContadorIncome()<10){
				emps.get(escolha).setContadorIncome(emps.get(escolha).getContadorIncome()+ this.getContadorIncome());
				gov.setContadorIncome((int)(this.getContadorIncome()*0.25));
				this.setContadorIncome(this.getContadorIncome()-this.getContadorIncome());
			}
			this.setContadorIncome(this.getContadorIncome()-10);
		}

	}
	
	public void pagarSalarios(){
	this.contadorIncome-=this.totalSalarios;	
	}
	
	public void print() {

		System.out.println(getNome() + ": NumFuncionarios -> " + numTrabalhadores);
	}



		
	
}
