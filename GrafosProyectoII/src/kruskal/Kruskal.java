package kruskal;

import grafo.Grafo;
import grafo.Arista;

import java.util.ArrayList;

import union_find.UnionFind;

import colaPrioridad.ColaPDinamica;
import colaPrioridad.ColaPMax;
import colaPrioridad.ColaPMin;

public class Kruskal {
	private ArrayList<Arista> ARM;
	ColaPDinamica<Arista> cola;
	
	public Kruskal(Grafo g,boolean max) {
		ARM = new ArrayList<Arista>();
		cola = max == true ? new ColaPMax<Arista>() : new ColaPMin<Arista>();
		for (int i = 0; i < g.getNumV(); i++) {
			for (Arista e : g.adyacentes(i)) {
				cola.insertar(e, e.p());
			}
		}
		UnionFind uf = new UnionFind(g.getNumV());
		while (!cola.estaVacia() && ARM.size() < g.getNumV() - 1) {
			Arista e = cola.extraer();
			int v = e.origen(), w = e.destino();
			if (!uf.conectados(v, w)) {
				uf.union(v, w);
				ARM.add(e);
			}
		}
	}
	
	public Arista[] aristas() {
		Arista a[]=new Arista[ARM.size()];
		for(int i=0;i<ARM.size();i++){
			a[i]=ARM.get(i);
		}
		return a;
	}

	public void mostrarARM() {
		System.out.println("ARM");
		int size = ARM.size();
		for (int i = 0; i < size; i++) {
			Arista a = ARM.get(i);
			System.out.println(a.origen() + "-" + a.destino() + " " + a.p());
		}
	}
}
