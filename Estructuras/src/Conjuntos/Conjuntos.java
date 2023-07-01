
public class Conjuntos {
	private Nodo primero, ultimo;
	private int n;
	Conjuntos() {
		primero= null;
		ultimo= null;
		n=0;
	}
	public boolean estaVacia(){
		return primero==null;	
	}
	public int getN(){
		return n;
	}
	public void insertar(int valor) {
		Nodo nuevo= new Nodo(valor);
		if (estaVacia()) {
			nuevo.sig= primero;
			primero= nuevo;
			ultimo= nuevo;
		}
		else {
			ultimo.sig= nuevo;
			ultimo= nuevo;
		}
		n++;
	}
	public int Buscar(int n){
		if(!estaVacia()){
			Nodo aux=primero;
			while(aux!=null){
				if(aux.getValor()==n){
					return n;
				}
				aux=aux.sig;
			}
			
		}
		return -1;
	}
	public void mostrar(){
		if(!estaVacia()){
			Nodo aux=primero;
			System.out.print("{");
			while(aux!=null){
				System.out.print(" "+aux.getValor()+" ");
				aux=aux.sig;
			}
			System.out.println("}");
		}
		else {
			System.out.println("{ }");
		}
	}
	public Conjuntos interseccion(Conjuntos otroConjunto){
		Conjuntos res=new Conjuntos();
		if(!estaVacia()){
			Nodo aux=primero;
			while(!estaVacia()&&aux!=null){
				int a=otroConjunto.Buscar(aux.getValor());
				if(a!=-1)
					res.insertar(a);
				aux=aux.sig;
			}
		}
		return res;
	}
	public Conjuntos diferencia(Conjuntos otroConjunto){
		Conjuntos res=new Conjuntos();
		if(!estaVacia()){
			Nodo aux=primero;
			while(!estaVacia()&&aux!=null){
				int a=otroConjunto.Buscar(aux.getValor());
				if(a==-1)
					res.insertar(aux.getValor());
				aux=aux.sig;
			}
		}
		return res;
	}
	
	public boolean pertenencia(int n){
		if(!estaVacia()){
			Nodo aux=primero;
			while(aux!=null){
				if(aux.getValor()==n){
					System.out.println("El valor " + n + " pertenece al conjunto señalado");
					return true;
				}
				aux=aux.sig;
			}
			
		}
		System.out.println("El valor " + n+ " no pertenece al conjunto señalado");
		return false;
	}
	
}
