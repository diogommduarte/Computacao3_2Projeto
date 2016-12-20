import java.util.ArrayList;
import java.util.Random;
public class Governo extends AgenteEconomico{
	
	static Random r = new Random();
	
	
	
	public Governo(int contadorIncome) {
		super(contadorIncome);
		
	}

	public void destinoGasto(ArrayList<ArrayList<Individuos>> familias, ArrayList<Empresas> emps, Governo gov) {

		int escolha = r.nextInt(2);
		int fam, ind;
		int gasto = (int) (10 - (10 * 0.25));

		if (escolha == 0) {
			do {
				fam = r.nextInt(familias.size());
				ind = 0;
				if (familias.get(fam).size() == 2) {
					ind = r.nextInt(2);
				}

			} while (familias.get(fam).get(ind).getLocalTrabalho().equals("Governo"));
			
			familias.get(fam).get(ind).setContadorIncome(familias.get(fam).get(ind).getContadorIncome()+ gasto);
			this.setContadorIncome(this.getContadorIncome()-10);
		}
		
		else{
			
				emps.get(escolha).setContadorIncome(emps.get(escolha).getContadorIncome()+ gasto);
				
				this.setContadorIncome(this.getContadorIncome()-10);
		}

	}
	
}
