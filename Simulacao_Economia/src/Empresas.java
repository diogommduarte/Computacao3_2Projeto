
public class Empresas {

	
	static protected int nextID = 1;
	protected int idEmpresa; 
	
	public Empresas()
	{
		idEmpresa = nextID;
		nextID++;
	}
	
	public void print() {

		System.out.println("Empresa " + idEmpresa);
		
	}
}
