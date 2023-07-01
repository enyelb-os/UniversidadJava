package prim;

import grafo.Arista;
import grafo.Grafo;
import colaPrioridad.ColaPDinamica;
import colaPrioridad.ColaPMax;
import colaPrioridad.ColaPMin;

public class PrimVoraz {
	private ColaPDinamica<Integer> cola;
	private boolean marcados[];
	private Arista[] aristas;
	private double dist[];

	public PrimVoraz(Grafo g,boolean max) {
		aristas = new Arista[g.getNumV()];
		marcados = new boolean[g.getNumV()];
		dist = new double[g.getNumV()];
		for (int i = 0; i < g.getNumV(); i++){
			dist[i] = max == true ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
		}
		cola = max == true ? new ColaPMax<Integer>() : new ColaPMin<Integer>();
		dist[0] = 0.0;
		cola.insertar(0, 0.0);
		while (!cola.estaVacia()) {
			if(max == true)
				visitarMax(g, cola.extraer());
			else
				visitarMin(g, cola.extraer());
		}
	}

	private void visitarMin(Grafo g, int v) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(v);
			if (!marcados[w]) {
				if (e.p() < dist[w]) {
					aristas[w] = e;
					dist[w] = e.p();
					if (cola.existe(w))
						cola.cambiarPrioridad(w, dist[w]);
					else
						cola.insertar(w, dist[w]);
				}
			}
		}
	}
	
	private void visitarMax(Grafo g, int v) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(v);
			if (!marcados[w]) {
				if (e.p() > dist[w]) {
					aristas[w] = e;
					dist[w] = e.p();
					if (cola.existe(w))
						cola.cambiarPrioridad(w, dist[w]);
					else
						cola.insertar(w, dist[w]);
				}
			}
		}
	}
	
	public Arista[] aristas() {
		return aristas;
	}

	public void mostrar() {
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				System.out.println(i+" "+aristas[i].origen() + "-"
						+ aristas[i].destino() + "  " + dist[i]);
			else
				System.out.println(i);
		}
	}
}
