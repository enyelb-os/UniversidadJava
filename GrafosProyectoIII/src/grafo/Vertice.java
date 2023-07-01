package grafo;

public class Vertice{
	private static int posActual=0;
	private int pos;
	private String nodo;
	
	public Vertice(String nodo){
		this.nodo=nodo;
		pos=posActual;
		posActual++;
	}
	public int pos(){
		return pos;
	}
	public String nodo(){
		return nodo;
	}
}
