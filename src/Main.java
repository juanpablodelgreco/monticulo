
public class Main {
	public static void main(String[] args) {
		Monticulo mA = new Monticulo();
		mA.insertar(5);
		mA.insertar(7);
		mA.insertar(15);
		mA.insertar(14);
		mA.insertar(9);
		mA.insertar(18);
		mA.insertar(20);
		System.out.println(mA);
		mA.remove();
		System.out.println(mA);
	}

}
