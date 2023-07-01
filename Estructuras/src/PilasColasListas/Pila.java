package PilasColasListas;

public class Pila {	
	private final String c="------------------------------------";
	private Nodo primero;
	private int n;
	Pila(){
		primero=null;
		n=0;
	}
	public int getN(){
		return n;		
	}
	public boolean estaVacia(){
		return primero==null;	
	}
	public void insertar(char nValor){
		Nodo nuevo=new Nodo(nValor);
		nuevo.sig=primero;
		primero=nuevo;
		n++;
	}
	public char extraer(){
		char valor=primero.getValor();
		n--;
		primero=primero.sig;
		return valor;
	}
	public void imprimir(){
		Pila aux=new Pila();
		System.out.println(c);
		System.out.print("Imprimir Pila:  ");
		//System.out.println("ExtraerPila");
		while(!estaVacia()){
			char a=extraer();
			aux.insertar(a);
			System.out.print(a+" ");
		}
		//System.out.println("\nInsertarPila");
		while(!aux.estaVacia()){
			char a=aux.extraer();
			insertar(a);
			//System.out.print(a+" ");
		}
		System.out.println("\n"+c);
	}
	public void voltearPila(){
		Pila aux=new Pila();
		Pila aux2=new Pila();
		System.out.println(c);
		System.out.print("Voltear Pila:   ");
		//System.out.println("ExtraerPila");
		while(!estaVacia()){
			char a=extraer();
			aux.insertar(a);
			//System.out.print(a+" ");
		}
		//System.out.println("\nVoltearPila");
		while(!aux.estaVacia()){
			char a=aux.extraer();
			aux2.insertar(a);
			System.out.print(a+" ");
		}
		//System.out.println("\nInsertarPila");
		while(!aux2.estaVacia()){
			char a=aux2.extraer();
			insertar(a);
			//System.out.print(a+" ");
		}
		System.out.println("\n"+c);
	}
	//palindromo
	public boolean palindromo(){
		Pila aux1=new Pila();
		Pila aux2=new Pila();
		boolean b=true;
		for(int i=0;i<(getN()+aux1.getN())/2;i++){
			char a=extraer();
			aux1.insertar(a);
			aux2.insertar(a);
		}
		if((getN()+aux1.getN())%2==1){
			aux2.insertar(extraer());
		}
		for(int i=0;i<(getN()+aux1.getN());){
			char a=extraer();
			aux2.insertar(a);
			if(a!=aux1.extraer()){
			     b=false;
			}
		}
		while(!aux2.estaVacia()){
			insertar(aux2.extraer());
		}
		return b;
	}
	//parentesis 
	public boolean parentesis(){
		Pila aux1=new Pila();
		Pila aux2=new Pila();
		boolean b=true;
		for(int i=0;i<getN();){
			char a=extraer();
			aux1.insertar(a);
			if(a=='('){
				aux2.insertar(a);
			}
			else if(a==')'){
				if(!aux2.estaVacia()){
					aux2.extraer();
				}
				else{ 
					b=false;
				}
			}
		}
		if(!aux2.estaVacia()){
			b=false;
		} 
		while(!aux1.estaVacia()){
			insertar(aux1.extraer());
		}
		return b;
	}
	public void Eliminar(char n){
		Pila aux=new Pila();
		while(!estaVacia()){
			char a=extraer();
			if(a!=n){
				aux.insertar(a);
			}
		}
		while(!aux.estaVacia()){
			insertar(aux.extraer());
		}
	}
}
