package dijkstra;

import colaP.CPmin;
import grafo.Arista;
import grafo.GrafoD;

public class Dijkstra<key> {
	private Arista[] aristas;
	private double[] dist;
	private CPmin<Integer> cola;

	public Dijkstra(GrafoD g, int s) {
		aristas = new Arista[g.tamanio()];
		dist = new double[g.tamanio()];
		cola = new CPmin<Integer>();
		for (int i = 0; i < g.tamanio(); i++) {
			dist[i] = Double.POSITIVE_INFINITY;
		}
		dist[s] = 0.0;
		cola.insertar(s, 0.0);
		while (!cola.estaVacia()){
			relax(g,cola.extraer());
		}
	}

	private void relax(GrafoD g, int v) {
		
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(g.vertice(v)).pos();
			
			if (dist[w] > dist[v] + e.p()) {
				dist[w] = dist[v] + e.p();
				aristas[w]=e;
				if (cola.existe(w))
					cola.cambiarP(w, dist[w]);
				else
					cola.insertar(w, dist[w]);
			}
		}
	}
	
	public void mostrar() {
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				System.out.println(i+" "+aristas[i].origen().nodo() + "->"
						            + aristas[i].destino().nodo() + " "
						            + aristas[i].p()+ " " + dist[i]);
			else
				System.out.println(i);
		}
	}
}
