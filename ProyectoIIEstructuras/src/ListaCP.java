
public class ListaCP {
	private NodoLista primero,mitad;
	private int n;
	ListaCP(){
		primero=null;
		mitad=null;
		n=0;
	}
	public boolean estaVacia(){
		return primero==null;
	}
	public int getN(){
		return n;
	}
	public void insertar(int valor){
		NodoLista nuevo=new NodoLista(valor);
		if(estaVacia())
			primero=nuevo;
		else if(nuevo.getValor()<=primero.getValor()){
			nuevo.sig=primero;
			primero=nuevo;
		}
		else{
			NodoLista aux=primero;
			while(aux.sig!=null && aux.sig.getValor()<nuevo.getValor())
				aux=aux.sig;
			if(aux.sig!=null){
				nuevo.sig=aux.sig;
				aux.sig=nuevo;
			}
			else
				aux.sig=nuevo;
		}
		//Mitad
		mitad=primero;
		for(int i=0;i<(n/2);i++)
			mitad=mitad.sig;
		n++;
	}
	private int mitad(){
		int valor=mitad.getValor();
		mitad=mitad.sig;
		return valor;
	} 
	private int extraerIzq(){
		int valor=primero.getValor();
		n--;
		primero=primero.sig;
		return valor;
	}
	private int extraerDer(){
		int valor=mitad.getValor();
		n--;
		mitad=mitad.sig;
		return valor;
	}
	public NodoArbol dividir(NodoArbol x){
		if(!estaVacia()){
			int a=mitad();
			x=new NodoArbol(a);
			ListaCP aux1=new ListaCP();
			ListaCP aux2=new ListaCP();
			int n=getN();
			for(int i=0;i<((n%2==0) ? (n/2)-1:(n/2));i++){
				if(n>2){
					aux1.insertar(extraerIzq());
				}
			}
			while(mitad!=null){
				aux2.insertar(extraerDer());
			}
			x.izq=aux1.dividir(x.izq);
			x.der=aux2.dividir(x.der);
		}
		return x;
	}
	// X
	public void mostrar(){
		if(!estaVacia()){
			NodoLista aux=primero;
			while(aux!=null){
				System.out.print(aux.getValor()+" ");
				aux=aux.sig;
			}
			System.out.println("");
		}
	}
}
