import java.util.Random;


class Matriz {

	private int arreglo[];
	private int tamanio;
	private boolean verdadero;
	
	Matriz (int tam, boolean ini){ 
		if (ini == true){
			arreglo = new int[(tam * (tam + 1)) / 2];
			Random gen = new Random();
				
				for (int i=0;i<(tam * (tam + 1)) / 2;i++){
					arreglo[i] = gen.nextInt(10);
				}
		}
		else{
			arreglo = new int[(tam * (tam + 1)) / 2];
		}	
		tamanio = tam;
		verdadero = ini;
	}
	
	public int getValor(int i, int j){
		int valor1;
		
		if (i <= tamanio && j <= tamanio){
			if (i >= j){
				valor1 =arreglo[((i * (i +1) / 2) + j)];
				return valor1;
			}
			else{
				return valor1 = 0;
				
			}
		}else{
			System.out.println("El valor ingresado es mayor al tamanio de la matriz.");
			return 0;
		}
	}
	
	public void setValor(int valor, int i,int j){
		if (i <= tamanio && j <= tamanio){
			if (i >= j){
				arreglo[((i * (i +1) / 2) + j)] = valor;
			}
		}
		
	}
	
	public void imprimir (){
		int posicion;
		
		for (int i= 0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
				if (i >= j){
					posicion =arreglo[((i * (i +1) / 2) + j)];
					System.out.print(" " + posicion);
				}
				else{
					System.out.print(" 0");
				}
			}
			System.out.println(" ");
		}
	}
	

	
	public Matriz Suma (Matriz otraMatriz){
		Matriz resultado = new Matriz(tamanio,verdadero);
		Matriz falsa = new Matriz(0,false);
		
		if (tamanio == otraMatriz.tamanio){
			for (int i= 0; i < tamanio; i++){
				for (int j=0; j < tamanio; j++){
					resultado.setValor((arreglo[((i * (i +1) / 2) + j)]+otraMatriz.getValor(i,j)), i, j);
				}
			}
			return resultado;
		}
		else{
			System.out.println ("Las matrices ingresadas no tienen el mismo tamanio.");
			return falsa;
		}
	}
}
