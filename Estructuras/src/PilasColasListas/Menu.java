package PilasColasListas;

public class Menu {

	public static void main(String[] args) {		
		Pila nPila=new Pila();
		Cola nCola=new Cola();
		String cadena;
		cadena="Enyelberth";
		for(int i=0;i<cadena.length();i++){
			nPila.insertar(cadena.charAt(i));
			nCola.insertar(cadena.charAt(i));
		}
		
		System.out.println("o=o=o=o=o=o=o=o=o=o=o=o=o=o=o  Pilas");
		
		nPila.imprimir();
		nPila.voltearPila();
		System.out.println("Palindromo "+nPila.palindromo());
		System.out.println("Parentesis "+nPila.parentesis());
		nPila.Eliminar('e');
		nPila.imprimir();
		
		System.out.println("o=o=o=o=o=o=o=o=o=o=o=o=o=o=o  Colas");
		
		nCola.imprimir();
		nCola.voltearCola();
		System.out.println("Palindromo "+nCola.palindromo());
		System.out.println("Parentesis "+nCola.parentesis());
		nCola.Eliminar('e');
		nCola.imprimir();
	}
}
