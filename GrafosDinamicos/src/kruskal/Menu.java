package kruskal;

import grafo.Grafo;
import grafo.Vertice;

public class Menu {
	public static void main(String[] args) {
		double ini =System.nanoTime();
		
		Grafo<Integer> g=new Grafo<Integer>(18);
		g.agregarVertice(new Vertice<Integer>(0));
		g.agregarVertice(new Vertice<Integer>(1));
		g.agregarVertice(new Vertice<Integer>(2));
		g.agregarVertice(new Vertice<Integer>(3));
		g.agregarVertice(new Vertice<Integer>(4));
		g.agregarVertice(new Vertice<Integer>(5));
		g.agregarVertice(new Vertice<Integer>(6));
		g.agregarVertice(new Vertice<Integer>(7));
		g.agregarVertice(new Vertice<Integer>(8));
		g.agregarVertice(new Vertice<Integer>(9));
		g.agregarVertice(new Vertice<Integer>(10));
		g.agregarVertice(new Vertice<Integer>(11));
		g.agregarVertice(new Vertice<Integer>(12));
		g.agregarVertice(new Vertice<Integer>(13));
		g.agregarVertice(new Vertice<Integer>(14));
		g.agregarVertice(new Vertice<Integer>(15));
		g.agregarVertice(new Vertice<Integer>(16));
		g.agregarVertice(new Vertice<Integer>(17));
		
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
		Kruskal<Integer> k=new Kruskal<Integer>(g);
		k.mostararARM();
		
		
		double end =System.nanoTime();
		System.out.println(end-ini);
	}
}
