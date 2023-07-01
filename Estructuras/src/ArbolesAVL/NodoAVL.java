package Arboles;

public class NodoAVL {
	public NodoAVL izq,der;
	private int valor, altura; 
	NodoAVL(int v){
		this.valor=v;
		izq=null;
		der=null;
		altura=0;
	}
	public int getValor(){
		return valor;
	}
	public int getAltura(){
		return altura;
	}
	public void setAltura(int a){
		altura=a;
	}
}
