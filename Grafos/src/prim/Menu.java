package prim;

import grafo.Grafo;
import grafo.Vertice;

public class Menu {
	public static void main(String[] args) {
		double ini =System.nanoTime();
		Grafo g=new Grafo(8);
		g.agregarVertice(new Vertice(0));
		g.agregarVertice(new Vertice(1));
		g.agregarVertice(new Vertice(2));
		g.agregarVertice(new Vertice(3));
		g.agregarVertice(new Vertice(4));
		g.agregarVertice(new Vertice(5));
		g.agregarVertice(new Vertice(6));
		g.agregarVertice(new Vertice(7));
		
		g.agregarArista(4, 5, 35);
		g.agregarArista(4, 7, 37);
		g.agregarArista(5, 7, 28);
		g.agregarArista(0, 7, 16);
		g.agregarArista(1, 5, 32);
		g.agregarArista(0, 4, 38);
		g.agregarArista(2, 3, 17);
		g.agregarArista(1, 7, 19);
		g.agregarArista(0, 2, 26);
		g.agregarArista(1, 2, 36);
		g.agregarArista(1, 3, 29);
		g.agregarArista(2, 7, 34);
		g.agregarArista(6, 2, 40);
		g.agregarArista(3, 6, 52);
		g.agregarArista(6, 0, 58);
		g.agregarArista(6, 4, 93);
		
		PrimPerezoso p=new PrimPerezoso(g);
		p.mostararARM();
		
		PrimVoraz p2=new PrimVoraz(g);
		p2.mostrar();
		
		double end =System.nanoTime();
		System.out.println((end-ini)/1000000000);
		
	}
}
