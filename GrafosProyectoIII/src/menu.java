

import java.io.IOException;

import ford_fulkerson.FordFulkerson;
import grafo.GrafoF;
import grafo.Vertice;

public class menu {
	public static void main(String[] args) throws IOException {
//		GrafoF g=new GrafoF(4+2);
//		g.agregarVertice(new Vertice(0));
//		g.agregarVertice(new Vertice(1));
//		g.agregarVertice(new Vertice(2));
//		g.agregarVertice(new Vertice(3));
//		g.agregarVertice(new Vertice(4));
//		g.agregarVertice(new Vertice(5));
//		
//		g.agregarArista(0, 1, 16);
//		g.agregarArista(0, 2, 13);
//		g.agregarArista(1, 4, 12);
//		g.agregarArista(2, 3, 14);
//		g.agregarArista(3, 4, 7 );
//		g.agregarArista(3, 5, 4 );
//		g.agregarArista(4, 2, 9 );
//		g.agregarArista(4, 5, 20);
		
		Archivo a=new Archivo("estudiantes.txt");
		GrafoF g=new GrafoF(a.num()+2);
		int aristas[][]=a.aristas();
		g.agregarVertice(new Vertice("S"));
		for(int i=0;i<a.num();i++){
			g.agregarVertice(new Vertice(""+i));
		}
		g.agregarVertice(new Vertice("T"));
		for(int i=0;i<aristas.length;i++){
			g.agregarArista(0,aristas[i][0]+1,a.capacidad());
			g.agregarArista(aristas[i][0]+1,aristas[i][1]+1,a.capacidad());
			g.agregarArista(aristas[i][1]+1,a.num()+1,a.capacidad());
		}
		FordFulkerson red=new FordFulkerson(g, 0, a.num()+1);
		g.mostrarAdyacentes();
		if(g.adyacentes(0).size()<=red.flujo())
			System.out.println("Flujo:"+red.flujo()+"\nLa demanda sí puede ser satisfecha");
		else
			System.out.println("Flujo:"+red.flujo()+"\nLa demanda no puede ser satisfecha");
	}

}
