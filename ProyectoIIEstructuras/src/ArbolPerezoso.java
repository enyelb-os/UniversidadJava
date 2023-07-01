public class ArbolPerezoso {
	private NodoArbol raiz;
	ArbolPerezoso(){
		raiz=null;
	}
	//insertar
	public void insertar(int v){
		if(raiz==null){
			raiz=new NodoArbol(v);
		}
		else {
			raiz=insertar(raiz,v);
		}
	}
	private NodoArbol insertar(NodoArbol x,int v){
		if(x==null){
			return new NodoArbol(v);
		}
		if(v<x.getValor()){
			x.izq=insertar(x.izq,v);
		}
		else{
			x.der=insertar(x.der,v);
		} 
		x=rebalancear(x);
		return x;
	}
	//Altura
	public int altura(){
		return altura(raiz);
	}
	private int altura(NodoArbol x){
		if(x==null){
			return -1;
		}
		int izq=altura(x.izq);
		int der=altura(x.der);
		if(izq>der){
			return izq+1;
		}
		else{
			return der+1;
		}
	}
	//NumeroNodos
	public int numNodos(){
		return numNodos(raiz);
	} 
	private int numNodos(NodoArbol x){
		if(x==null)
			return 0;
		else 
			return numNodos(x.izq)+numNodos(x.der)+1;
	}
	//Imprimir
	public void preOrden(){
		System.out.println("PreOrden:\n\t┌───────────────┬───────────────┬───────────────┬───────────────┐" +
				           " \n\t|\tNodo\t│   Profundidad\t│     NumNodos\t│\tAltura\t│");
		preOrden(raiz);
		System.out.println("\t└───────────────┴───────────────┴───────────────┴───────────────┘");
	}
	private void preOrden(NodoArbol x){
		if(x!=null){
			System.out.print("\t│\t "+x.getValor());
			System.out.print("\t│\t" +profundidad(raiz,x)+" \t│\t"+(numNodos(x)-1)+"\t│\t  "+altura(x)+"\t│\n");
			preOrden(x.izq);
			preOrden(x.der);
		}
	}
	//llenar
	private ListaCP llenarLista(NodoArbol x){
		ListaCP aux=new ListaCP();
		return aux=llenarLista(x,aux);		
	}
	private ListaCP llenarLista(NodoArbol x,ListaCP aux){
		if(x!=null){
			aux.insertar(x.getValor());
			aux=llenarLista(x.izq,aux);
			aux=llenarLista(x.der,aux);
		}
		return aux;
	}
	//Balancear
	private NodoArbol rebalancear(NodoArbol x){
		if(altura(x)>3){
			if((x.izq!=null && x.der!=null)||(altura(x.izq)<altura(x.der)||altura(x.izq)>altura(x.der))){
				if((numNodos(x.izq)/2)>=numNodos(x.der) || numNodos(x.izq)<=(numNodos(x.der)/2)){
					ListaCP lista=llenarLista(x);
					lista.mostrar();
					x=lista.dividir(x);
					
				}
			}
		}
		return x;
	}
	
	private int profundidad(NodoArbol raiz,NodoArbol x){	
		if (raiz.getValor() <= x.getValor() && raiz.der != null){
				if(raiz!=x)
					return 1 + profundidad(raiz.der,x);
				return 0;
		}	
		else if (raiz.getValor() > x.getValor() && raiz.izq != null){
			if(raiz!=x)
				return 1 + profundidad(raiz.izq, x);
			return 0;
		}
		return 0;
	}	
}
