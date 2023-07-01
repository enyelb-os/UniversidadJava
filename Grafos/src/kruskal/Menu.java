package kruskal;

import grafo.Grafo;
import grafo.Vertice;

public class Menu {
	public static void main(String[] args) {
		double ini =System.nanoTime();
		
		Grafo g=new Grafo(18);
		g.agregarVertice(new Vertice(0));
		g.agregarVertice(new Vertice(1));
		g.agregarVertice(new Vertice(2));
		g.agregarVertice(new Vertice(3));
		g.agregarVertice(new Vertice(4));
		g.agregarVertice(new Vertice(5));
		g.agregarVertice(new Vertice(6));
		g.agregarVertice(new Vertice(7));
		g.agregarVertice(new Vertice(8));
		g.agregarVertice(new Vertice(9));
		g.agregarVertice(new Vertice(10));
		g.agregarVertice(new Vertice(11));
		g.agregarVertice(new Vertice(12));
		g.agregarVertice(new Vertice(13));
		g.agregarVertice(new Vertice(14));
		g.agregarVertice(new Vertice(15));
		g.agregarVertice(new Vertice(16));
		g.agregarVertice(new Vertice(17));
		
		g.agregarArista(1, 2,2);
		g.agregarArista(1, 8,1);
		g.agregarArista(2, 3,2);
		g.agregarArista(3, 4,1);
		g.agregarArista(4, 5,1);
		g.agregarArista(4, 11,2);
		g.agregarArista(5, 6,1);
		g.agregarArista(5, 9,1);
		g.agregarArista(6, 7,1);
		g.agregarArista(7, 8,1);
		g.agregarArista(7, 10,1);
		g.agregarArista(8, 15,2);
		g.agregarArista(9, 10,2);
		g.agregarArista(9, 12,1);
		g.agregarArista(10, 14,1);
		g.agregarArista(11, 0,1);
		g.agregarArista(11, 12,1);
		g.agregarArista(12, 13,1);
		g.agregarArista(13, 14,1);
		g.agregarArista(14, 15,1);
		g.agregarArista(15, 16,1);
		g.agregarArista(16, 17,2);
		g.agregarArista(17, 0,2);
		
		g.mostrarAdyacentes();
		Kruskal k=new Kruskal(g);
		k.mostararARM();
		
		
		double end =System.nanoTime();
		System.out.println(end-ini);
	}
}
