import java.util.ArrayList;
import java.util.Random;

public class Familias {
	static protected int nextID = 1;
	protected int idFamilias; 
	protected int numFamilias;
	static protected int probabilidade;
	static protected Random r = new Random();
	
	public Familias(int numFamilias)
	{
		idFamilias = nextID;
		nextID++;
		
		ArrayList <Individuos> [] familias = new ArrayList [numFamilias];
		
		for(int i = 0; i < numFamilias; i++)
		{
			probabilidade = r.nextInt(101);
			
			if(probabilidade <= 70)
			{
				familias[i] 	
			}
			
			else
			{
				familias[i]
			}
		}
		
	}
	
	
	
	public void print() {

		System.out.println("Empresa " + idFamilias);
		
	}
	
}
