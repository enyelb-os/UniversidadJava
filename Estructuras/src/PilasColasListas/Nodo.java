package PilasColasListas;

public class Nodo {
	private char valor;
	public Nodo sig;	
	Nodo(char v){
		valor=v;
		sig=null;
	}
	public char getValor(){
		return valor;
	} 	
}
