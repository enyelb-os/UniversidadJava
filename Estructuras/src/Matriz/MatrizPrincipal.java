
public class MatrizPrincipal {

	public static void main(String[] args) {
		Matriz matricita = new Matriz(3,true);
		Matriz matrizota = new Matriz(2,true);
		Matriz matrizAux = new Matriz(3,true);
		matricita.getValor(1,3);
		matricita.setValor(5,1,3);
		matricita.getValor(1,3);
		matrizAux = matricita.Suma(matrizota);
		matricita.imprimir();
		System.out.println (" ");
		matrizota.imprimir();
		System.out.println (" ");
		matrizAux.imprimir();
		
		
	}

}
