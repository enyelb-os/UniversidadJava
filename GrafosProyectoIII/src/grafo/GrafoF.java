package grafo;

import java.util.ArrayList;

public class GrafoF{
	protected ArrayList<AristaFlujo> ady[];
	protected Vertice[] vertices;
	protected int numVer;
	protected int n = 0;

	// -----------------------------------------------------------//
	// Constructores

	@SuppressWarnings("unchecked")
	public GrafoF(int numVer) {
		this.numVer = numVer;
		ady = new ArrayList[numVer];
		for (int i = 0; i < numVer; i++) {
			ady[i] = new ArrayList<AristaFlujo>();
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

	public ArrayList<AristaFlujo> adyacentes(int vOrigen) {
		if (posExiste(vOrigen)) {
			return ady[vOrigen];
		}
		return null;
	}

	protected int grado(int vOrigen) {
		return posExiste(vOrigen) ? ady[vOrigen].size() : null;
	}
	
	// -----------------------------------------------------------// Metodos
	// Publicos

	public void agregarVertice(Vertice nuevo) {
		if (n == nuevo.pos() && n < numVer){
			vertices[n] = nuevo;
			n++;
		}
	}

	public void agregarArista(int i, int j, double c) {
		if (i!=j && posExiste(i) && posExiste(j)) {
			if(!existeArista(vertices[i], vertices[j])){
				AristaFlujo a=new AristaFlujo(vertices[i], vertices[j], c);
				ady[i].add(a);
			}
		}
	}
	
	public void removerArista(AristaFlujo j) {
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
			ArrayList<AristaFlujo> adyT = adyacentes(i);
			for (int j = 0; j < adyT.size(); j++) {
				System.out.print(" " + adyT.get(j).origen().nodo()+ 
						         "-" + adyT.get(j).destino().nodo()+
						         "("+adyT.get(j).capacidad()+
						         "-"+adyT.get(j).capacidadResidual(j)+")");
			}
			System.out.println();
		}
	}
}
