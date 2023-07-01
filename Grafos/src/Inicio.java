public class Inicio {
	public static void main(String[] args) {
		System.out.println("-------------Grafo 1-------------");
		
		Grafo grafito = new Grafo(7, false);
		
		grafito.agregarArista(0, 1);
		grafito.agregarArista(0, 2);
		grafito.agregarArista(1, 2);
		grafito.agregarArista(1, 3);
		grafito.agregarArista(1, 5);
		grafito.agregarArista(2, 4);
		grafito.agregarArista(2, 3);
		grafito.agregarArista(3, 4);
		grafito.agregarArista(4, 5);
		grafito.agregarArista(4, 6);
		grafito.agregarArista(5, 6);

		grafito.mostrarAdyacentes();
		grafito.mostrarVGrados();

		// int vect[] = { 0, 1, 4, 6, 5 };
		// System.out.println(grafito.camimo(vect));

		BProfundidad p = new BProfundidad(grafito, 2);
		p.mostrar();
		p.caminoA(4);
		
		System.out.println("-------------Grafo 2-------------");
		
		Grafo grafito2 = new Grafo(9, false);
		
		grafito2.agregarArista(0, 1);
		grafito2.agregarArista(0, 2);
		grafito2.agregarArista(0, 3);
		grafito2.agregarArista(1, 2);
		grafito2.agregarArista(1, 6);
		grafito2.agregarArista(1, 5);
		grafito2.agregarArista(2, 4);
		grafito2.agregarArista(3, 4);
		grafito2.agregarArista(4, 5);
		grafito2.agregarArista(4, 8);
		grafito2.agregarArista(5, 6);
		grafito2.agregarArista(5, 8);
		grafito2.agregarArista(5, 7);
		grafito2.agregarArista(7, 8);

		grafito2.mostrarAdyacentes();

		BAnchura a = new BAnchura(grafito2, 0);
		a.VerticesA();
		a.LongitudA();
		a.excentricidad();
		a.distancia();

		grafito2.vectExcentricidad();
		grafito2.diametro();
		grafito2.radio();
		grafito2.verticesCento();
		CompConectados c = new CompConectados(grafito2);
		c.conectados(8, 5);
		c.numCompConectados();
		
		System.out.println("-------------Grafo 3-------------");
		
		Grafo grafito3 = new Grafo(13, true);
		grafito3.agregarArista(0, 6);
		grafito3.agregarArista(0, 5);
		grafito3.agregarArista(0, 1);
		grafito3.agregarArista(2, 3);
		grafito3.agregarArista(2, 0);
		grafito3.agregarArista(3, 5);
		grafito3.agregarArista(5, 4);
		grafito3.agregarArista(6, 4);
		grafito3.agregarArista(6, 9);
		grafito3.agregarArista(7, 6);
		grafito3.agregarArista(8, 7);
		grafito3.agregarArista(9, 11);
		grafito3.agregarArista(9, 10);
		grafito3.agregarArista(9, 12);
		grafito3.agregarArista(11, 12);

		grafito3.mostrarAdyacentes();

		Otopo o = new Otopo(grafito3);
		o.mostrar();
	}
}
