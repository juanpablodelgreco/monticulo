
public class Monticulo {
	
	protected int[] nodo;
	protected int tamanio;
	
	private static final int RAIZ = 1;

	public Monticulo(int tamanioMaximo) {
		this.tamanio = 0;
		this.nodo = new int[tamanioMaximo + 1];
	}

	public void insertar(int nuevo) throws IllegalStateException {
		if (this.monticuloLleno()) {
			System.out.println("Monticulo lleno");
		} else {
			this.nodo[++this.tamanio] = nuevo;
			while (!this.compareTo(this.padre(this.tamanio))) {
				this.intercambiar(this.tamanio, this.padre(this.tamanio));
				this.tamanio = this.padre(this.tamanio);
			}
			for (int i = this.tamanio / 2; i >= 1; i--) {
				this.hundir(i);
			}
		}
	}
	
	public int eliminar() throws IllegalStateException {
		if (this.estaVacio()) {
			System.out.println("Monticulo vacio");
			return -1;
		}else {
		int nodo = this.nodo[RAIZ];
		this.nodo[RAIZ] = this.nodo[this.tamanio--];
		this.hundir(RAIZ);
		return nodo;
		}
	}

	private void hundir(int i) {
		if (!this.esHoja(i)) {
			if (!this.tieneHijoUnico(i)) {
				if (!this.comparacion(this.hijoIzquierdo(i), i) || !this.comparacion(this.hijoDerecho(i), i)) {
					if (!this.comparacion(this.hijoIzquierdo(i), this.hijoDerecho(i))) {
						this.intercambiar(i, this.hijoIzquierdo(i));
						this.hundir(this.hijoIzquierdo(i));
					} else {
						this.intercambiar(this.hijoDerecho(i), i);
						this.hundir(this.hijoDerecho(i));
					}
				}
			} else {
				if (!this.comparacion(this.hijoIzquierdo(i), i)) {
					this.intercambiar(i, this.hijoIzquierdo(i));
					this.hundir(this.hijoIzquierdo(i));
				}
			}
		}
	}

	protected void intercambiar(int i, int j) {
		int tmp = this.nodo[i];
		this.nodo[i] = this.nodo[j];
		this.nodo[j] = tmp;
	}

	private int padre(int i) {
		return i / 2;
	}

	protected boolean comparacion(int hijo, int padre) {
		return this.nodo[hijo] >= this.nodo[padre];
	}

	private int hijoIzquierdo(int i) {
		return 2 * i;
	}

	private int hijoDerecho(int i) {
		return 2 * i + 1;
	}

	private boolean tieneHijoIzquierdo(int i) {
		return this.hijoIzquierdo(i) <= this.tamanio;
	}

	private boolean tieneHijoDerecho(int i) {
		return this.hijoDerecho(i) <= this.tamanio;
	}

	private boolean tieneHijoUnico(int i) {
		return this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
	}

	public boolean esHoja(int i) {
		return !this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
	}
	
	private boolean monticuloLleno() {
		return this.tamanio == this.nodo.length - 1;
	}
	
	public boolean estaVacio() {
		return tamanio == 0;
	}
	
	public boolean compareTo(int tam) {
		return this.tamanio >= tam;
	}
	
	public void mostrar() {
		for (int i = 1; i <= this.tamanio / 2; i++) {
			System.out.print("Padre: " + this.nodo[i]);
			if (this.tieneHijoIzquierdo(i)) {
				System.out.print(" HijoIzquierdo: " + this.nodo[2 * i]);
			}
			if (this.tieneHijoDerecho(i)) {
				System.out.print(" HijoDerecho: " + this.nodo[2 * i + 1]);
			}
			System.out.println();
		}
	}

}
