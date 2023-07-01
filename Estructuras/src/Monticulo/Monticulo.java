package Monticulo;

public class Monticulo {
	private int n;
	private int monte[];
	Monticulo (int N) {
		monte = new int[N];
		n=0;
	}
	public int getN () {
		return monte.length;
	}
	public boolean esLleno(){
		return n==getN();
	}
	public boolean esVacio(){
		return n==0;
	}
	private void intercambiar(int a, int b) {
		int aux= monte[a];
		monte[a]= monte[b];
		monte[b]= aux;
	}
	private boolean menor(int a,int b){
		return monte[a]>monte[b];
	}
	private void elevar (int k) {
		while (k>0 && menor((k-1)/2,k)) {
			intercambiar (k,(k-1)/2);
			k= (k-1)/2;
		}
	}
	public void insertar (int valor) {
		if(!esLleno()){
			monte[n]= valor;
			elevar(n);
			n++;
		}
		else{
			System.out.println("  Monticulo Lleno! : "+valor);
			Monticulo aux =new Monticulo(getN());
			while(!esVacio()){
				aux.insertar(extraer());
			}
			monte=new int[getN()*2];
			while(!aux.esVacio()){
				insertar(aux.extraer());
			}
			monte[n]= valor;
			elevar(n);
			n++;
		}
	}
	public int	extraer() {
		if(!esVacio()) {
			int aux= monte[0];
			n--;
			monte[0]= monte[n];
			descender(0);
			return aux;
		}
		return -1;
	}
	private void descender(int i) {
		while(2*(i+1)<=n && (menor(i,2*(i+1)) || menor(i,2*i+1))){
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
	public void mostrar() {
		System.out.println();
		while (!esVacio()) {
			System.out.print("  "+extraer());
		}
	}
	public Monticulo mezclar(Monticulo b){
		Monticulo c = new Monticulo (getN()+b.getN());
		Monticulo d = new Monticulo (getN()+b.getN());
		while(!esVacio()){
			int v= extraer();
			d.insertar(v);
			c.insertar(v);
		}
		while(!d.esVacio()){
			insertar(d.extraer());
		}
		while(!b.esVacio()){
			int v= b.extraer();
			c.insertar(v);
			d.insertar(v);
		}
		while(!d.esVacio()){
			b.insertar(d.extraer());
		}
		return c;
	}
}
