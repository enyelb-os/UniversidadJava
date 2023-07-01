public class InicioPrueba {
	public static void main(String[] args) {
		Grafo g = new Grafo(18);
		g.agregarVertice("A", "0");
		g.agregarVertice("A", "1");
		g.agregarVertice("A", "2");
		g.agregarVertice("A", "3");
		g.agregarVertice("A", "4");
		g.agregarVertice("A", "5");
		g.agregarVertice("A", "6");
		g.agregarVertice("A", "7");
		g.agregarVertice("A", "8");
		g.agregarVertice("P", "00");
		g.agregarVertice("P", "01");
		g.agregarVertice("P", "02");
		g.agregarVertice("P", "03");
		
		
		
		g.agregarArista(9, 0);
		g.agregarArista(9, 3);
		g.agregarArista(9, 1);
		g.agregarArista(9, 2);
		g.agregarArista(10, 2);
		g.agregarArista(10, 5);
		g.agregarArista(10, 6);
		g.agregarArista(11, 4);
		g.agregarArista(12, 4);
		g.agregarArista(12, 5);
		g.agregarArista(9, 7);
		g.agregarArista(11, 8);
		g.agregarArista(12, 8);
		g.agregarArista(12, 8);
		g.agregarArista(12, 8);

		g.mostrarVertices();

		

	}

}
