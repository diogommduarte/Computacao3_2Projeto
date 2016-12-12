import java.util.ArrayList;
import java.util.Collection;

public class Individuos extends AgenteEconomico {

	protected String localTrabalho;
	protected int numFamilias;
	
	public Individuos(int income, String localTrabalho) {
		
		
		
		ArrayList<ArrayList<Individuos>> familias = new ArrayList<ArrayList<Individuos>>(numFamilias);

		for (int i = 0; i < numFamilias; i++) {
			
			probabilidade = r.nextInt(101);
			
			Individuos ind1 = new Individuos(income, localTrabalho);
			Individuos ind2 = new Individuos(income, localTrabalho);
			
			
			if(probabilidade <= 70)//2individuos 70%
			{
				familias.addAll((Collection<? extends ArrayList<Individuos>>) ind1);
				familias.addAll((Collection<? extends ArrayList<Individuos>>) ind2);
			}
			else//1individuo 30%
			{
				familias.addAll((Collection<? extends ArrayList<Individuos>>) ind1);
			}
			
			
		}

	}
	
	
	
	public int gastos() {
		return 0;
	}

	
	
}
