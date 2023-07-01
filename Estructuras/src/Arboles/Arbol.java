package Arboles;

public class Arbol {
	private Nodo raiz;
	Arbol(){
		raiz=null;
	}
	public void insertar(int v){
		if(raiz==null){
			raiz=new Nodo(v);
		}else{
			insertar(raiz,v);
		}
	}
	private Nodo insertar(Nodo x,int v){
		if(x==null){
			return new Nodo(v);
		}
		if(v<x.getValor()){
			x.izq=insertar(x.izq,v);
		}
		else{
			x.der=insertar(x.der,v);
		} 
		return x;
	}
	private Nodo eliminarMin(Nodo x){
		if(x.izq==null){
			return x.der;
		}
		x.izq=eliminarMin(x.izq);
		return x;
	}
	private Nodo menorValor(Nodo x){
		if(x.izq!=null){
			x=menorValor(x.izq);
		}
		return x;
	}
	public void eliminar(int v){
		raiz=eliminar(raiz,v);
	}
	private Nodo eliminar(Nodo x,int v){
		if(x==null){
			return null;
		}
		if(v<x.getValor()){
			x.izq=eliminar(x.izq,v);
		}
		else if(v>x.getValor()){
			x.der=eliminar(x.der,v);
		}
		else{
			if(x.der==null){
				return x.izq;
			}
			if(x.izq==null){
				return x.der;
			}else{
				Nodo t=x;
				x=menorValor(t.der);
				x.der=eliminarMin(x.der);
				x.izq=t.izq;
			}
		}
		return x;
	}
	public void preOrden(){
		System.out.print("PreOrden: ");
		preOrden(raiz);
		System.out.println("");
	}
	private void preOrden(Nodo x){
		if(x!=null){
			System.out.print(" "+x.getValor());
			preOrden(x.izq);
			preOrden(x.der);
		}
	}
	public void inOrden(){
		System.out.print("InOrden: ");
		inOrden(raiz);
		System.out.println("");
	}
	private void inOrden(Nodo x){
		if(x!=null){
			inOrden(x.izq);
			System.out.print(" "+x.getValor());
			inOrden(x.der);
		}
	}
	public void posOrden(){
		System.out.print("PosOrden: ");
		posOrden(raiz);
		System.out.println("");
	}
	private void posOrden(Nodo x){
		if(x!=null){
			posOrden(x.izq);
			posOrden(x.der);
			System.out.print(" "+x.getValor());
		}
	}
	public int sumaHojas(){
		return sumaHojas(raiz);
	}
	public int sumaHojas(Nodo x){
		int suma=0;
		if(x!=null){
			if(x.der==null && x.izq==null){
				return x.getValor();
			}else 
				suma=sumaHojas(x.izq)+ sumaHojas(x.der);
		}
		return suma;
	}
}