package PilasColas;

public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Pila nPila=new Pila();
		nPila.insertar(3);
		nPila.insertar(4);
		nPila.insertar(5);
		nPila.insertar(6);
		nPila.insertar(7);
		nPila.extraer();
		nPila.imprimir();


	}

}
