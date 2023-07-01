package dijkstra;

import busqueda.Otopo;

import grafo.Arista;
import grafo.GrafoD;

public class DijkstraAciclico{
	private Arista[] aristas;
	private double[] dist;

	public DijkstraAciclico(GrafoD g, int s) {
		aristas = new Arista[g.tamanio()];
		dist = new double[g.tamanio()];
		for (int i = 0; i < g.tamanio(); i++) {
			dist[i] = Double.POSITIVE_INFINITY;
		}
		dist[s] = 0.0;
		Otopo otp=new Otopo(g);
		for (int i : otp.orden()) {
			relax(g,i);
		}
	}

	private void relax(GrafoD g, int v) {
		
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(g.vertice(v)).pos();
			
			if (dist[w] > dist[v] + e.p()) {
				dist[w] = dist[v] + e.p();
				aristas[w]=e;
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
