package grafo;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Arista> ady[];
	private int numVer;
	private int cantAristas = 0;
	private double cantP = 1;

	// -----------------------------------------------------------//
	// Constructores

	@SuppressWarnings("unchecked")
	public Grafo(int numVer) {
		this.numVer = numVer;
		ady = new ArrayList[numVer];
		for (int i = 0; i < numVer; i++) {
			ady[i] = new ArrayList<Arista>();
		}
	}

	// -----------------------------------------------------------// Metodos Que
	// Retornan

	public int getNumV() {
		return numVer;
	}

	public int cantAristas() {
		return cantAristas;
	}

	public double cantPeso() {
		return cantP;
	}

	private boolean posExiste(int vOrigen) {
		return vOrigen < ady.length ? true : false;
	}

	public boolean existeArista(int i, int j) {
		if (posExiste(i) && posExiste(j)) {
			for (int k = 0; k < ady[i].size(); k++) {
				if (ady[i].get(k).opuesto(j) != -1) {
					return true;
				}
			}
		}
		return false;
	}

	public Arista[] adyacentes(int vOrigen) {
		if (posExiste(vOrigen)) {
			Arista temp[] = new Arista[ady[vOrigen].size()];
			for (int i = 0; i < ady[vOrigen].size(); i++)
				temp[i] = ady[vOrigen].get(i);
			return temp;
		}
		return null;
	}

	private int grado(int vOrigen) {
		return posExiste(vOrigen) ? ady[vOrigen].size() : null;
	}

	// -----------------------------------------------------------// Metodos
	// Publicos

	public void agregarArista(int v, int w, double p) {
		if (!existeArista(v, w)) {
			Arista a = new Arista(v, w, p);
			ady[v].add(a);
			ady[w].add(a);
			cantAristas++;
			cantP = cantP + p;
		}
	}

	public void removerArista(Arista j) {
		if (existeArista(j.origen(), j.destino())) {
			ady[j.origen()].remove(j);
			ady[j.destino()].remove(j);
			cantAristas--;
			cantP=cantP-j.p();
		}
	}

	// -----------------------------------------------------------// Metodos
	// Mostrar

	public void mostrarVGrados() {
		System.out.println("Vector De Grados");
		for (int i = 0; i < ady.length; i++) {
			System.out.println(i + " : " + grado(i));
		}
	}

	public void mostrarAdyacentes() {
		System.out.println("------------");
		System.out.println("Adyacentes");
		for (int i = 0; i < ady.length; i++) {
			System.out.print(i + " :");
			for (int j = 0; j < ady[i].size(); j++) {
				System.out.print(" " + ady[i].get(j).origen() + "-"
						+ ady[i].get(j).destino());
			}
			System.out.println();
		}
		System.out.println("------------");
	}
}
