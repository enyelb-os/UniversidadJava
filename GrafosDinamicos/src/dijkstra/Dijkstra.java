package dijkstra;

import java.lang.reflect.Array;
import java.util.ArrayList;

import colaP.CPmin;
import grafo.Arista;
import grafo.GrafoD;
import grafo.Vertice;

public class Dijkstra<key> {
	private Arista<key>[] aristas;
	private double[] dist;
	private CPmin<Integer> cola;

	@SuppressWarnings("unchecked")
	public Dijkstra(GrafoD<key> g, int s) {
		aristas = (Arista<key>[]) Array.newInstance(Arista.class,g.tamanio());
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

	private void relax(GrafoD<key> g, int v) {
		
		for (Arista<key> e : g.adyacentes(v)) {
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
	
	public ArrayList<key> lista(){
		ArrayList<key> lista=new ArrayList<>();
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				lista.add(aristas[i].destino().nodo());
		}
		return lista;
	}
	
	public ArrayList<Vertice<key>> listaVertice(){
		ArrayList<Vertice<key>> lista=new ArrayList<>();
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				lista.add(aristas[i].destino());
		}
		return lista;
	}
	
	public ArrayList<Arista<key>> listaArista(){
		ArrayList<Arista<key>> lista=new ArrayList<>();
		for (int i = 0; i < aristas.length; i++) {
			if (aristas[i] != null)
				lista.add(aristas[i]);
		}
		return lista;
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
