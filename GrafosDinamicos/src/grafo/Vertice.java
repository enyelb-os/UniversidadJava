package grafo;

public class Vertice<key>{
	private static int posActual=0;
	private int pos;
	private key nodo;
	
	public Vertice(key nodo){
		this.nodo=nodo;
		pos=posActual;
		posActual++;
	}
	public int pos(){
		return pos;
	}
	public key nodo(){
		return nodo;
	}
}
