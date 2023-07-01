package Arboles;

public class ArbolAVL {
	private NodoAVL raiz;
	ArbolAVL(){
		raiz=null;
	}
	
	private int altura (NodoAVL x){
		if (x==null)
			return -1;
		return x.getAltura();
	}
	
	public void insertar(int v){
		raiz=insertar(v,raiz);
	}
	private NodoAVL insertar(int v,NodoAVL x){
		if(x==null)
			x=new NodoAVL(v);
		else{
			if(v<x.getValor()){
				x.izq=insertar(v,x.izq);
				if(altura(x.izq) - altura(x.der) == 2){
					if(v<x.izq.getValor())
						x=rotarDer(x);
					else
						x=rotarIzqDer(x);
				}
			}
			else if(v>x.getValor()){
				x.der = insertar(v,x.der);
				if(altura(x.der) - altura(x.izq)==2){
					if(v>x.der.getValor())
						x=rotarIzq(x);
					else
						x=rotarDerIzq(x);
				}
			}
		}
		x.setAltura(Math.max(altura(x.izq), altura(x.der))+1);
		return x;
	}
	
	//-------------------------------------------------//
	public void eliminar(int v){
		raiz=eliminar(v,raiz);
	}
	
	private NodoAVL eliminar(int v,NodoAVL x){
		if(x.getValor()==v){
			if(x.der==null){
				return x.izq;
			}
			if(x.izq==null){
				return x.der;
			}
			else{
				NodoAVL t=x;
				x=menorValor(t.der);
				x.der=eliminarMin(x.der);
				x.izq=t.izq;
			}
		}
		else{
			if(v<x.getValor()){
				x.izq=eliminar(v,x.izq);
				if(altura(x.der) - altura(x.izq) == 2){
					if(altura(x.der.izq)<altura(x.der.der)){
						x=rotarIzq(x);
					}
					else
						x=rotarDerIzq(x);
				}
			}
			else if(v>x.getValor()){
				x.der = eliminar(v,x.der);
				if(altura(x.izq) - altura(x.der)==2 ){
					if(altura(x.izq.der)<altura(x.izq.izq))
						x=rotarDer(x);
					else
						x=rotarIzqDer(x);
				}
			}
		}
		x.setAltura(Math.max(altura(x.izq), altura(x.der))+1);
		return x;
	}
	
	private NodoAVL eliminarMin(NodoAVL x){
		if(x.izq==null){
			return x.der;
		}
		x.izq=eliminarMin(x.izq);
		return x;
	}
	
	private NodoAVL menorValor(NodoAVL x){
		if(x.izq!=null){
			x=menorValor(x.izq);
		}
		return x;
	}
	//-------------------------------------------------//
	
	private NodoAVL rotarDer(NodoAVL pivote){
		NodoAVL nPivote=pivote.izq;
		pivote.izq=nPivote.der;
		nPivote.der=pivote;
		pivote.setAltura(Math.max(altura(pivote.izq),altura(pivote.der))+1);
		nPivote.setAltura(Math.max(altura(nPivote.izq),pivote.getAltura())+1);
		return nPivote;
	}
	private NodoAVL rotarIzq(NodoAVL pivote){
		NodoAVL nPivote=pivote.der;
		pivote.der=nPivote.izq;
		nPivote.izq=pivote;
		pivote.setAltura(Math.max(altura(pivote.der),altura(pivote.izq))+1);
		nPivote.setAltura(Math.max(altura(nPivote.der),pivote.getAltura())+1);
		return nPivote;
	}
	private NodoAVL rotarDerIzq(NodoAVL pivote){
		pivote.der=rotarDer(pivote.der);
		return rotarIzq(pivote);
	}
	private NodoAVL rotarIzqDer(NodoAVL pivote){
		pivote.izq=rotarIzq(pivote.izq);
		return rotarDer(pivote);
	}
	
	
	public void posOrden(){
		System.out.println("PosOrden: ");
		posOrden(raiz);
		System.out.println("");
	}
	private void posOrden(NodoAVL x){
		if(x!=null){
			posOrden(x.izq);
			posOrden(x.der);
			System.out.println(" "+x.getValor()+" "+x.getAltura());
		}
	}
}
