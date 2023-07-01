
public class NodoArbol {
	public NodoArbol izq,der;
	private int valor;
	NodoArbol(int valor){
		izq=null;
		der=null;
		this.valor=valor;
	}
	public int getValor(){
		return valor;
	}
}