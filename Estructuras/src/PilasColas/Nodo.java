package PilasColas;

public class Nodo {

	private int valor;
	public Nodo sig;
	Nodo(int v) {
		valor= v;
		sig= null;
	}
	public int getValor() {
		return valor;
	}

}
