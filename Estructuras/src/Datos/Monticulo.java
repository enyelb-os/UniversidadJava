package Datos;

public class Monticulo{
	private int n;
	private Datos mont[];
	Monticulo(int v){
		mont=new Datos[v];
		n=0;
	}
	public int getN(){
		return mont.length;
	}
	public boolean esLLeno(){
		return n==getN();
	}
	public boolean esVacio(){
		return n==0;
	}
	private void intercambiar(int a,int b){
		Datos aux;
		aux=mont[a];
		mont[a]=mont[b];
		mont[b]=aux;
	}
	private boolean menor(int a,int b){
		return mont[a].getCi() > mont[b].getCi();
	}
	private void elevar(int k){
		while(k>0 && menor((k-1)/2,k)){
			intercambiar(k,(k-1)/2);
			k=(k-1)/2;
		}
	}
	public void insertar(String nombre,String apellido,int ci){
		if(!esLLeno()){
			mont[n]=new Datos(nombre,apellido,ci);
			elevar(n);
			n++;
		}
		else{
			System.out.println("Monticulo lleno!");
		}
	}
	private void descender(int i){
		while(2*(i+1)<n && (menor(i,2*(i+1)) || menor(i,2*i+1))){
			if(menor(2*(i+1),2*i+1)){
				intercambiar(i,2*i+1);
				i=2*i+1;
			}
			else{
				intercambiar(i,2*(i+1));
				i=2*(i+1);
			}
		}
	}
	public Datos extraer(){
		if(!esVacio()){
			Datos aux=mont[0];
			n--;
			mont[0]=mont[n];
			mont[n]=null;
			descender(0);
			return aux;
		}
		return null;
	}
	public void mostrar(){
		Monticulo a=new Monticulo(getN());
		while(!esVacio()){
			Datos aux=extraer();
			a.insertar(aux.getNombre(),aux.getApellido(),aux.getCi());
			System.out.print(" "+aux.getNombre());
			System.out.print(" "+aux.getApellido());
			System.out.println(" "+aux.getCi());
		}
		while(!a.esVacio()){
			Datos aux=a.extraer();
			insertar(aux.getNombre(),aux.getApellido(),aux.getCi());
		}
	}
}
