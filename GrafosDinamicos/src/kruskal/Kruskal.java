package kruskal;

import grafo.Grafo;
import grafo.Arista;

import java.util.ArrayList;

import union_find.UnionFind;

import colaP.CPmin;

public class Kruskal<key> {
	private ArrayList<Arista<key>> ARM;

	public Kruskal(Grafo<key> g) {
		ARM = new ArrayList<Arista<key>>();
		CPmin<Arista<key>> cola = new CPmin<Arista<key>>();
		for (int i = 0; i < g.tamanio(); i++) {
			for (Arista<key> e : g.adyacentes(i)) {
				cola.insertar(e, e.p());
			}
		}
		UnionFind uf = new UnionFind(g.tamanio());
		while (!cola.estaVacia() && ARM.size() < g.tamanio() - 1) {
			Arista<key> e = cola.extraer();
			int v = e.origen().pos(), w = e.destino().pos();
			if (!uf.conectados(v, w)) {
				uf.union(v, w);
				ARM.add(e);
			}
		}
	}

	public void mostararARM() {
		System.out.println("ARM");
		int size = ARM.size();
		for (int i = 0; i < size; i++) {
			Arista<key> a = ARM.get(i);
			System.out.println(a.origen().nodo() + "-" + a.destino().nodo() + " " + a.p());
		}
	}
}
