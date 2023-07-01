package Arboles;

public class ArbolMenu {
	public static void main(String[] args) {
		Arbol A=new Arbol();
		A.insertar(20);
		A.insertar(11);
		A.insertar(15);
		A.insertar(8);
		A.insertar(14);
		A.insertar(12);
		A.insertar(6);
		A.insertar(1);
		A.insertar(21);
		A.insertar(2);
		A.insertar(22);
		A.insertar(3);
		A.insertar(23);
		A.insertar(25);
		A.insertar(7);
		A.insertar(9);
		A.insertar(24);
		A.insertar(17);
		A.insertar(5);
		
		System.out.println(A.sumaHojas());
		
		A.preOrden();
		A.inOrden();
		A.posOrden();
		
	}

}