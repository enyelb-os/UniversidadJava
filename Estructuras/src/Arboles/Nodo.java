package Arboles;

public class Nodo {
	private int valor;
	public Nodo izq,der;	
	Nodo(int v){
		valor=v;
		izq=null;
		der=null;
	}
	public int getValor(){
		return valor;
	} 	
}