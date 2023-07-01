package prim;

import grafo.Arista;
import grafo.Grafo;
import colaP.CPmin;

public class PrimVoraz {
	private CPmin<Integer> cola;
	private boolean marcados[];
	private Arista[] aristas;
	private double dist[];

	public PrimVoraz(Grafo g) {
		aristas =new Arista[g.tamanio()];
		marcados = new boolean[g.tamanio()];
		dist = new double[g.tamanio()];
		for (int i = 0; i < g.tamanio(); i++){
			dist[i] = Double.POSITIVE_INFINITY;
		}
		cola = new CPmin<Integer>();
		dist[0] = 0.0;
		cola.insertar(0, 0.0);
		while (!cola.estaVacia()) {
			visitar(g, cola.extraer());
		}
	}

	private void visitar(Grafo g, int v) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(g.vertice(v)).pos();
			if (!marcados[w]) {
				if (e.p() < dist[w]) {
					aristas[w]= e;
					dist[w] = e.p();
					if (cola.existe(w))
						cola.cambiarP(w, dist[w]);
					else
						cola.insertar(w, dist[w]);
				}
			}
		}
	}

	public void mostrar() {
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				System.out.println(i+" "+aristas[i].origen().nodo() + "-"
						+ aristas[i].destino().nodo() + "  " + dist[i]);
			else
				System.out.println(i);
		}
	}
}
