package ColaConPrioridad;

public class ColaCPMenu {
	public static void main(String[] args) {
		ColaCP nColaCP=new ColaCP();
		
		nColaCP.insertar(2,2);
		nColaCP.insertar(4,4);
		nColaCP.insertar(1,1);
		nColaCP.insertar(3,3);
		nColaCP.insertar(5,5);
		nColaCP.insertar(2,2);
		nColaCP.insertar(4,4);
		nColaCP.insertar(1,1);
		nColaCP.insertar(3,3);
		nColaCP.insertar(5,5);
		
		nColaCP.imprimir();
	}
}
