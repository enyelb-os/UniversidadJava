package ColaConPrioridad;

public class ColaCP {
	private Nodo primero;
	private int n;
	ColaCP(){
		primero=null;
		n=0;
	}
	public boolean estaVacia(){
		return primero==null;
	}
	public int getN(){
		return n;
	}
	public Nodo extraerMin(){
		if(!estaVacia()){
			Nodo aux=primero;
			primero=primero.sig;
			n--;
			return aux;
		}
		return null;
	}
	public void insertar(int prioridad,int valor){
		Nodo nuevo=new Nodo(prioridad,valor);
		if(estaVacia()){
			primero=nuevo;
		}
		else if(nuevo.getP()>=primero.getP()){
			nuevo.sig=primero;
			primero=nuevo;
		}
		else{
			Nodo aux=primero;
			while(aux.sig!=null && aux.sig.getP()>nuevo.getP()){
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
		n++;
	}
	public void insertar1(int prioridad,int valor){
		Nodo nuevo=new Nodo(prioridad,valor);
		if(estaVacia()){
			primero=nuevo;
		}
		else if(nuevo.getP()>=primero.getP()){
			nuevo.sig=primero;
			primero=nuevo;
		}
		else{
			Nodo aux=primero;
			while(aux.sig!=null && aux.sig.getP()>nuevo.getP()){
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
		n++;
	}
	public void imprimir(){
		ColaCP aux=new ColaCP();
		System.out.println("---------");
		System.out.println("Imprimir");
		System.out.println("ExtraerCola");
		while(!estaVacia()){
			Nodo a=extraerMin();
			aux.insertar(a.getP(),a.getValor());
			System.out.print(a.getValor()+" ");
		}
		System.out.println("\nInsertarCola");
		while(!aux.estaVacia()){
			Nodo a=aux.extraerMin();
			insertar(a.getP(),a.getValor());
			System.out.print(a.getValor()+" ");
		}
		System.out.println("\n--------");
	}
}
