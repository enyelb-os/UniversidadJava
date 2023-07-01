package colaP;

public class ColaP<key>{
	protected Nodo<key> primero;
	protected int n;
	public ColaP(){
		primero=null;
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
	public void insertar(key n, double p){
		Nodo<key> nuevo=new Nodo<key>(n,p);
		if(estaVacia()){
			primero=nuevo;
		}
		else if(nuevo.getP()<=primero.getP()){
			nuevo.sig=primero;
			primero=nuevo;
		}
		else{
			Nodo<key> aux=primero;
			while(aux.sig!=null && aux.sig.getP()<nuevo.getP()){
				aux=aux.sig;
			}
			if(aux.sig!=null){
				nuevo.sig=aux.sig;
				aux.sig=nuevo;
			}
			else{
				aux.sig=nuevo;
			}
		}
		this.n++;
	}
	
	public Nodo<key> extraerNodo(){
		if(!estaVacia()){
			Nodo<key> aux=primero;
			primero=primero.sig;
			n--;
			return aux;
		}
		return null;
	}
	
	public void cambiarP(key i,double p){
		if(!estaVacia()){
			Nodo<key> aux=primero;
			while(aux.sig!=null){
				key a=aux.getNodo();
				if(a==i){
					aux.setP(p);
					ColaP<key> colaP=new ColaP<key>();
					while(!estaVacia()){
						Nodo<key> n=extraerNodo();
						colaP.insertar(n.getNodo(), n.getP());
					}
					while(!colaP.estaVacia()){
						Nodo<key> n=colaP.extraerNodo();
						insertar(n.getNodo(), n.getP());
					}
				}
				aux=aux.sig;
			}
		}
	}
	
	public boolean existe(key i){
		if(!estaVacia()){
			Nodo<key> aux=primero;
			while(aux.sig!=null){
				key a=aux.getNodo();
				if(a==i){
					return true;
				}
				aux=aux.sig;
			}
		}
		return false;
	}
	
	public key key(key i){
		if(!estaVacia()){
			Nodo<key> aux=primero;
			while(aux.sig!=null){
				key a=aux.getNodo();
				if(a==i){
					return a;
				}
				aux=aux.sig;
			}
		}
		return null;
	}
}
