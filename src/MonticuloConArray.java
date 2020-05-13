import java.util.ArrayList;

public class MonticuloConArray {

		protected ArrayList<Integer> nodo;

		public MonticuloConArray() {
			nodo = new ArrayList<Integer>();
			nodo.add(0);
		}

		public void insertar(int nuevo) throws IllegalStateException {
			int posNuevo = nodo.size();
			nodo.add(nuevo);
			Integer aux;
			while (posNuevo > 1 && Integer.compare(nuevo, nodo.get(posNuevo / 2)) < 0) {
				aux = nuevo;
				nodo.set(posNuevo, nodo.get(posNuevo / 2));
				nodo.set((posNuevo / 2), aux);
				posNuevo /= 2;
			}

		}

		public Integer remove() {
			if (nodo.size() < 1)
				return null;
			if (nodo.size() == 2)
				return nodo.remove(1);

			Integer elim = new Integer(nodo.get(1));
			nodo.set(1, nodo.remove(nodo.size() - 1));
			int pos = 1;

			while ((pos * 2) + 1 < nodo.size()) {

			}
			return null;
		}
	}
