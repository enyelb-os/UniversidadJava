package colaPrioridad;


public class ColaPMin<key> extends ColaPDinamica<key>{
	
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
}
