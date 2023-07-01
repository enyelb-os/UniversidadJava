

import grafo.GrafoD;
import grafo.Vertice;

public class Menu {
	public static void main(String[] args) {
		
		GrafoD g = new GrafoD(5);
		g.agregarVertice(new Vertice(0));
		g.agregarVertice(new Vertice(1));
		g.agregarVertice(new Vertice(2));
		g.agregarVertice(new Vertice(3));
		g.agregarVertice(new Vertice(4));
	
		g.agregarArista(0,1,10);
		g.agregarArista(0,3,5);
		g.agregarArista(1,2,1);
		g.agregarArista(1,3,2);
		g.agregarArista(3,4,2);
		g.agregarArista(3,1,3);
		g.agregarArista(3,2,9);
		g.agregarArista(2,4,4);
		g.agregarArista(4,2,6);
		g.agregarArista(4,0,7);

		Dijkstra<Integer> d=new Dijkstra<Integer>(g,2);
		d.mostrar();
		d.todosCaminos(g,2);
		
	}
}
