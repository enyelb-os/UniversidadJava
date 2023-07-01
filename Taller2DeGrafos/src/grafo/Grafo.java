package grafo;

import java.util.ArrayList;


public class Grafo {
	protected ArrayList<Arista> ady[];
	protected Vertice[] vertices;
	protected int numVer;
	protected int n = 0;

	// -----------------------------------------------------------//
	// Constructores

	@SuppressWarnings("unchecked")
	public Grafo(int numVer) {
		this.numVer = numVer;
		ady = new ArrayList[numVer];
		for (int i = 0; i < numVer; i++) {
			ady[i] = new ArrayList<Arista>();
		}
		vertices = new Vertice[numVer];
	}

	// -----------------------------------------------------------// Metodos Que
	// Retornan

	public int tamanio() {
		return numVer;
	}

	protected boolean posExiste(int v) {
		return v >= 0 && v < ady.length ? true : false;
	}

	protected boolean existeArista(Vertice v, Vertice w) {
		for (int k = 0; k < ady[v.pos()].size(); k++) {
			if (ady[v.pos()].get(k).opuesto(v) == w) {
				return true;
			}
		}
		return false;
	}

	
	public Vertice vertice(int i){
		if(posExiste(i)){
			return vertices[i];
		}
		return null;
	}

	public ArrayList<Arista> adyacentes(int vOrigen) {
		if (posExiste(vOrigen)) {
			return ady[vOrigen];
		}
		return null;
	}

	protected int grado(int vOrigen) {
		return posExiste(vOrigen) ? ady[vOrigen].size() : null;
	}
	
	public boolean camimo(int[] vect) {
		if(posExiste(vect[0]))
			for (int i = 0; i < vect.length - 1; i++)
				if(posExiste(vect[i+1]))
					if (!existeArista(vertices[vect[i]], vertices[vect[i+1]]))
						return false;
		return true;
	}

	// -----------------------------------------------------------// Metodos
	// Publicos

	public void agregarVertice(Vertice nuevo) {
		if (n == nuevo.pos() && n < numVer){
			vertices[n] = nuevo;
			n++;
		}
	}

	public void agregarArista(int i, int j, double p) {
		if (i!=j && posExiste(i) && posExiste(j)) {
			if(!existeArista(vertices[i], vertices[j])){
				Arista a=new Arista(vertices[i], vertices[j], p);
				ady[i].add(a);
				ady[j].add(a);
			}
		}
	}
	
	public void removerArista(Arista j) {
		if (existeArista(j.origen(), j.destino())) {
			ady[j.origen().pos()].remove(j);
			ady[j.destino().pos()].remove(j);
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
		System.out.println("Adyacentes");
		for (int i = 0; i < ady.length; i++) {
			System.out.print(i + " :");
			ArrayList<Arista> adyT = adyacentes(i);
			for (int j = 0; j < adyT.size(); j++) {
				System.out.print(" " + adyT.get(j).origen().nodo()+ 
						         "-" + adyT.get(j).destino().nodo());
			}
			System.out.println();
		}
	}
}
