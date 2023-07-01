package PilasColas;

public class Pila {
	
	private Nodo primero;
	private int n;
	Pila(){
		primero=null;
		n=0;
	}
	public int getN(){
		return n;
	}
	public void insertar(int nValor){
		Nodo nuevo=new Nodo(nValor);
		nuevo.sig=primero;
		primero=nuevo;
		n++;
	}
	public boolean estaVacia(){
		return primero==null;	
	}
	public int extraer(){
		int valor=primero.getValor();
		n--;
		primero=primero.sig;
		return valor;
	}
	public void imprimir(){
		Nodo mostrar=primero;
		if(!estaVacia()){
			while(mostrar!=null){
				System.out.print(mostrar.getValor()+" ");
				mostrar=mostrar.sig;
			}
		}
	}

}