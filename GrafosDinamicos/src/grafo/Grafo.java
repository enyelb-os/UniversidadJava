package grafo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import busqueda.BAnchura;

public class Grafo<key> {
	protected ArrayList<Arista<key>> ady[];
	protected Vertice<key>[] vertices;
	protected int numVer;
	protected int n = 0;

	// -----------------------------------------------------------//
	// Constructores

	@SuppressWarnings("unchecked")
	public Grafo(int numVer) {
		this.numVer = numVer;
		ady = new ArrayList[numVer];
		for (int i = 0; i < numVer; i++) {
			ady[i] = new ArrayList<Arista<key>>();
		}
		vertices = (Vertice<key>[]) Array.newInstance(Vertice.class, numVer);
	}

	// -----------------------------------------------------------// Metodos Que
	// Retornan

	public int tamanio() {
		return numVer;
	}

	protected boolean posExiste(int v) {
		return v >= 0 && v < ady.length ? true : false;
	}

	protected boolean existeArista(Vertice<key> v, Vertice<key> w) {
		for (int k = 0; k < ady[v.pos()].size(); k++) {
			if (ady[v.pos()].get(k).opuesto(v) == w) {
				return true;
			}
		}
		return false;
	}

	
	public Vertice<key> vertice(int i){
		if(posExiste(i)){
			return vertices[i];
		}
		return null;
	}

	public ArrayList<Arista<key>> adyacentes(int vOrigen) {
		if (posExiste(vOrigen)) {
			return ady[vOrigen];
		}
		return null;
	}

	protected int grado(int vOrigen) {
		return posExiste(vOrigen) ? ady[vOrigen].size() : null;
	}
	
	public boolean esConexo(){
		BAnchura<key> conexo=new BAnchura<key>(this,0);
		return tamanio()==conexo.getCuenta()? true: false;
	}
	
	public boolean cicloEuler() {
		if (esConexo()) {
			for (int i = 0; i < tamanio(); i++) {
				if (!(grado(i) % 2 == 0)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean caminoEuler() {
		if (this.cicloEuler())
			return true;
		else {
			if (esConexo()) {
				int cont = 0;
				for (int i = 0; i < tamanio(); i++) {
					if (!(grado(i) % 2 == 0)) {
						cont++;
						if (cont > 2)
							return false;
					}
				}
				if (cont == 2)
					return true;
			}
			return false;
		}
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

	public void agregarVertice(Vertice<key> nuevo) {
		if (n == nuevo.pos() && n < numVer) {
			vertices[n] = nuevo;
			n++;
		}
	}

	public void agregarArista(int i, int j, double p) {
		if (i!=j && posExiste(i) && posExiste(j)) {
			if(!existeArista(vertices[i], vertices[j])){
				Arista<key> a = new Arista<key>(vertices[i], vertices[j], p);
				ady[i].add(a);
				ady[j].add(a);
			}
		}
	}
	
	public void removerArista(Arista<key> j) {
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
			ArrayList<Arista<key>> adyT = adyacentes(i);
			for (int j = 0; j < adyT.size(); j++) {
				System.out.print(" " + adyT.get(j).origen().nodo()+ 
						         "-" + adyT.get(j).destino().nodo());
			}
			System.out.println();
		}
	}
}
