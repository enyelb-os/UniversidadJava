package PilasColasListas;


public class Listas {
		private Nodo pri, ult;
		//private int n;
		Listas() {
			pri= null;
			ult= null;
			//n= 0;
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
		}
		public void eliminar(int valor) {
			if(!estaVacia()){
				if(pri.getValor()==valor){
					pri=pri.sig;
				}
				else{
					Nodo aux=pri;
					while(aux.sig!=null){
						if(aux.sig.getValor()==valor){
							break;
						}
						else{
							aux=aux.sig;
						}
					}
					aux.sig=aux.sig.sig;
					if(aux.sig==null){
						ult=aux;
					}
				}
			}
		}
		public void mostrar(){
			if(!estaVacia()){
				Nodo aux=pri;
				while(aux!=null){
					System.out.println(aux.getValor());
					aux=aux.sig;
				}
			}
		}
		public boolean existe(int n){
			if(!estaVacia()){
				Nodo aux=pri;
				while(aux!=null){
					if(aux.getValor()==n){
						return true;
					}
					aux=aux.sig;
				}
				
			}
			return false;
		}
		public int Buscar(int n){
			if(!estaVacia()){
				Nodo aux=pri;
				while(aux!=null){
					if(aux.getValor()==n){
						return n;
					}
					aux=aux.sig;
				}
				
			}
			return (Integer) null;
		}
}