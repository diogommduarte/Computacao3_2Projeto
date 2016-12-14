import java.util.ArrayList;
import java.util.Collection;

public class Individuos extends AgenteEconomico {

	protected String localTrabalho;
	
	
	public Individuos(int income, String localTrabalho) {
		super(income);
		this.localTrabalho=localTrabalho;
		
	}
	
	
	public String getLocalTrabalho() {
		return localTrabalho;
	}


	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}


	public int gastos() {
		return 0;
	}
	
}
