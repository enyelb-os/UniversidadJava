public class InicioTaller {

	public static void main(String[] args) {
		Grafo grafito1 = new Grafo(6, false);
		grafito1.agregarArista(0, 1);
		grafito1.agregarArista(0, 3);
		grafito1.agregarArista(1, 4);
		grafito1.agregarArista(2, 3);
		grafito1.agregarArista(2, 4);
		grafito1.agregarArista(3, 4);
		grafito1.agregarArista(3, 5);
		grafito1.agregarArista(4, 5);

		System.out.println("GRAFO 1...");
		System.out.println("Ciclo Euleriano?..." + grafito1.cicloEuler());
		System.out.println("Camino Euleriano?..." + grafito1.caminoEuler());

		Grafo grafito2 = new Grafo(8, false);
		grafito2.agregarArista(0, 1);
		grafito2.agregarArista(0, 2);
		grafito2.agregarArista(0, 3);
		grafito2.agregarArista(1, 2);
		grafito2.agregarArista(1, 4);
		grafito2.agregarArista(1, 5);
		grafito2.agregarArista(2, 3);
		grafito2.agregarArista(2, 4);
		grafito2.agregarArista(3, 4);
		grafito2.agregarArista(4, 5);
		grafito2.agregarArista(5, 6);
		grafito2.agregarArista(5, 7);
		grafito2.agregarArista(6, 7);

		System.out.println("GRAFO 2...");
		System.out.println("Ciclo Euleriano?..." + grafito2.cicloEuler());
		System.out.println("Camino Euleriano?..." + grafito2.caminoEuler());

		Grafo grafito3 = new Grafo(6, false);
		grafito3.agregarArista(0, 1);
		grafito3.agregarArista(0, 3);
		grafito3.agregarArista(1, 2);
		grafito3.agregarArista(1, 4);
		grafito3.agregarArista(2, 3);
		grafito3.agregarArista(3, 4);
		grafito3.agregarArista(3, 5);
		grafito3.agregarArista(4, 5);

		System.out.println("GRAFO 3...");
		System.out.println("Ciclo Euleriano?..." + grafito3.cicloEuler());
		System.out.println("Camino Euleriano?..." + grafito3.caminoEuler());
	}

}
