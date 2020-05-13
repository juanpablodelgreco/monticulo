import java.util.ArrayList;

public class Monticulo {

		protected ArrayList<Integer> nodo;

		public Monticulo() {
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
			Integer nodoSubido = nodo.get(nodo.size() - 1);
			nodo.set(1, nodoSubido);
			nodo.remove(nodo.size() - 1);
			System.out.println(nodoSubido);
			int pos = 1;
			Integer aux;
			Integer menor;
			int huboCambio = 1;
			while ((pos * 2) < (nodo.size() - 1) && huboCambio == 1){
				if (nodo.get(pos * 2).compareTo(nodo.get((pos * 2) + 1)) < 0) {
					menor = pos * 2;
				} else menor = (pos * 2) + 1;
				
				if (nodo.get(pos).compareTo(nodo.get(menor)) > 0) {
					aux = nodo.get(pos);
					nodo.set(pos, nodo.get(menor));
					nodo.set(menor, aux);
					pos = menor;
					huboCambio = 1;
				}else huboCambio = 0;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "MonticuloConArray [nodo=" + nodo + "]";
		}
		
		
	}
