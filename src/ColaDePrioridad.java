
public class ColaDePrioridad {
	private Monticulo m;
	
	public ColaDePrioridad() {
		m = new Monticulo();
	}
	
	public void add(Integer i) {
		m.insertar(i);
	}
	
	public void delete() {
		m.remove();
	}
}
