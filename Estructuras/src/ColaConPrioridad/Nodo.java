package ColaConPrioridad;

public class Nodo {
	private int prioridad;
	private int valor;
	public Nodo sig;
	Nodo(int prioridad,int valor){
		this.prioridad=prioridad;
		this.valor=valor;
		sig=null;
	}
	public int getP(){
		return prioridad;
	}
	public int getValor(){
		return valor;
	}
}
