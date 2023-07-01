package cola;

public class Cola<key>{
	protected Nodo<key> primero,ultimo;
	protected int n;
	public Cola(){
		primero=null;
		ultimo=null;
		n=0;
	}
	public boolean estaVacia(){
		return primero==null;
	}
	public int getN(){
		return n;
	}
	public key extraer(){
		if(!estaVacia()){
			Nodo<key> aux=primero;
			primero=primero.sig;
			n--;
			return aux.getNodo();
		}
		return null;
	}
	public void insertar(key n){
		Nodo<key> nuevo= new Nodo<key>(n);
		if (primero == null) {
			nuevo.sig= primero;
			primero= nuevo;
			ultimo= nuevo;
		}
		else {
			ultimo.sig= nuevo;
			ultimo= nuevo;
		}
		this.n++;
	}
	
//	public boolean existe(key i) {
//		if (!estaVacia()) {
//			Nodo<key> aux = primero;
//			while (aux.sig != null) {
//				key a = aux.getNodo();
//				if (a == i) {
//					return true;
//				}
//				aux = aux.sig;
//			}
//		}
//		return false;
//	}
//
//	public key key(key i) {
//		if (!estaVacia()) {
//			Nodo<key> aux = primero;
//			while (aux.sig != null) {
//				key a = aux.getNodo();
//				if (a == i) {
//					return a;
//				}
//				aux = aux.sig;
//			}
//		}
//		return null;
//	}
}