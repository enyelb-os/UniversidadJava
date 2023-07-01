package grafo;

public class Vertice{
	private static int posActual=0;
	private int pos;
	private int nodo;
	
	public Vertice(int nodo){
		this.nodo=nodo;
		pos=posActual;
		posActual++;
	}
	public int pos(){
		return pos;
	}
	public int nodo(){
		return nodo;
	}
}
