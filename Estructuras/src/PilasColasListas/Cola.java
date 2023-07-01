package PilasColasListas;

public class Cola {
	private final String c="------------------------------------";
	private Nodo pri, ult;
	private int n;
	Cola(){
		pri= null;
		ult= null;
	}
	public int getN(){
		return n;		
	}
	public boolean estaVacia(){
		return pri==null;	
	}
	public void insertar(char valor) {
		Nodo nuevo= new Nodo(valor);
		if (pri == null) {
			nuevo.sig= pri;
			pri= nuevo;
			ult= nuevo;
		}
		else {
			ult.sig= nuevo;
			ult= nuevo;
		}
		n++;
	}
	public char extraer() {	
		char valor= pri.getValor();
		pri=pri.sig;
		n--;
		return valor;
	}
	public void imprimir(){
		Cola aux=new Cola();
		System.out.println(c);
		System.out.print("Imprimir Cola:  ");
		//System.out.println("ExtraerCola");
		while(!estaVacia()){
			char a=extraer();
			aux.insertar(a);
			System.out.print(a+" ");
		}
		//System.out.println("\nInsertarCola");
		while(!aux.estaVacia()){
			char a=aux.extraer();
			insertar(a);
			//System.out.print(a+" ");
		}
		System.out.println("\n"+c);
	}
	public void voltearCola(){
		Cola aux=new Cola();
		int n=getN();
		System.out.println(c);
		System.out.print("Voltear Cola:   ");
		//System.out.println("ExtraerCola");
		for(int i=0;i<(getN());i++){
			if(i<n-1){
				insertar(extraer());
			}
			else{
				aux.insertar(extraer());
				i=-1;
				n--;
			}
			//System.out.print(a+" ");
		}
		//System.out.println("\nInsertarCola");
		while(!aux.estaVacia()){
			char a=aux.extraer();
			insertar(a);
			System.out.print(a+" ");
		}
		System.out.println("\n"+c);
	}
	//palindromo
	public boolean palindromo(){
		Cola aux1=new Cola();
		Cola aux2=new Cola();
		boolean b=true;
		for(int i=0;i<(getN()+aux1.getN())/2;i++){
			char a=extraer();
			aux1.insertar(a);
			aux2.insertar(a);
		}
		aux1.voltearCola();
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
		Cola aux1=new Cola();
		Cola aux2=new Cola();
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
		while(!aux1.estaVacia()){
			insertar(aux1.extraer());
		}
		return b;
	}
	//eliminar sin alterar
	public void Eliminar(char n){
		Cola aux=new Cola();
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