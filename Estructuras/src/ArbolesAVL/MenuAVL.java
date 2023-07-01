package Arboles;

public class MenuAVL {
	public static void main(String[] args) {
		ArbolAVL arbol=new ArbolAVL();
		
		arbol.insertar(3);
		arbol.insertar(2);
		arbol.insertar(1);
		arbol.insertar(4);
		arbol.insertar(5);
		arbol.insertar(6);
		arbol.insertar(8);
		arbol.insertar(7);
		
		arbol.posOrden();
		arbol.eliminar(5);
		arbol.posOrden();
		
	}
}
