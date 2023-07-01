package prim;

import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;

import colaP.CPmin;

public class PrimPerezoso {
	private CPmin<Arista> cola;
	private ArrayList<Arista> ARM;
	private boolean marcados[];

	public PrimPerezoso(Grafo g) {
		cola = new CPmin<Arista>();
		marcados = new boolean[g.tamanio()];
		ARM = new ArrayList<Arista>();
		visitar(g, 0);
		while (!cola.estaVacia()) {
			Arista a = cola.extraer();
			int v = a.origen().pos();
			int w = a.destino().pos();
			if (!marcados[v] || !marcados[w]) {
				ARM.add(a);
				if (!marcados[v]) {
					visitar(g, v);
				}
				if (!marcados[w]) {
					visitar(g, w);
				}
			}
		}

	}

	private void visitar(Grafo g, int v) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			if (!marcados[e.opuesto(g.vertice(v)).pos()]) {
				cola.insertar(e, e.p());
			}
		}
	}

	public void mostararARM() {
		System.out.println("ARM");
		for (int i = 0; i < ARM.size(); i++) {
			Arista a = ARM.get(i);
			System.out.println(a.origen().nodo() + "-" + a.destino().nodo()
					+ " " + a.p());
		}
	}
}
