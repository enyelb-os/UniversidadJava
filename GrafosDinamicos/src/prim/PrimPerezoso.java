package prim;

import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;

import colaP.CPmin;

public class PrimPerezoso<key> {
	private CPmin<Arista<key>> cola;
	private ArrayList<Arista<key>> ARM;
	private boolean marcados[];

	public PrimPerezoso(Grafo<key> g) {
		cola = new CPmin<Arista<key>>();
		marcados = new boolean[g.tamanio()];
		ARM = new ArrayList<Arista<key>>();
		visitar(g, 0);
		while (!cola.estaVacia()) {
			Arista<key> a = cola.extraer();
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

	private void visitar(Grafo<key> g, int v) {
		marcados[v] = true;
		for (Arista<key> e : g.adyacentes(v)) {
			if (!marcados[e.opuesto(g.vertice(v)).pos()]) {
				cola.insertar(e, e.p());
			}
		}
	}

	public void mostararARM() {
		System.out.println("ARM");
		for (int i = 0; i < ARM.size(); i++) {
			Arista<key> a = ARM.get(i);
			System.out.println(a.origen().nodo() + "-" + a.destino().nodo()
					+ " " + a.p());
		}
	}
}
