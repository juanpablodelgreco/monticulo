
public class ColaDePrioridad {
	private MonticuloConArray m;
	
	public ColaDePrioridad() {
		m = new MonticuloConArray();
	}
	
	public void add(Integer i) {
		m.insertar(i);
	}
	
	public void delete() {
		m.remove();
	}
}
