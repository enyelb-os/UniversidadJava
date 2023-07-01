package PilasColas;

public class Cola {
	private Nodo pri, ult;
	private int n;
	Cola() {
		pri= null;
		ult= null;
		n= 0;
	}
	public int getN(){
		return n;
	}
	public void insertar(int valor) {
		Nodo nuevo= new Nodo(valor);
		if (pri == null) {
			nuevo.sig= pri;
			pri= nuevo;
			ult= nuevo;
		}
		else {
			ult.sig= nuevo;
			ult= nuevo;
		}
	}
	public int extraer() {
		if(pri == null)
			return -1;
		else {
			int valor= pri.getValor();
			pri= pri.sig;
			return valor;
		}
	}
}