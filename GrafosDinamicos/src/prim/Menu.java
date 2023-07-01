package prim;

import grafo.Grafo;
import grafo.Vertice;

public class Menu {
	public static void main(String[] args) {
		double ini =System.nanoTime();
		Grafo<String> g=new Grafo<String>(8);
		g.agregarVertice(new Vertice<String>("0"));
		g.agregarVertice(new Vertice<String>("1"));
		g.agregarVertice(new Vertice<String>("2"));
		g.agregarVertice(new Vertice<String>("3"));
		g.agregarVertice(new Vertice<String>("4"));
		g.agregarVertice(new Vertice<String>("5"));
		g.agregarVertice(new Vertice<String>("6"));
		g.agregarVertice(new Vertice<String>("7"));
		
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
		
		PrimPerezoso<String> p=new PrimPerezoso<String>(g);
		p.mostararARM();
		
		PrimVoraz<String> p2=new PrimVoraz<String>(g);
		p2.mostrar();
		
		double end =System.nanoTime();
		System.out.println((end-ini)/1000000000);
		
	}
}
