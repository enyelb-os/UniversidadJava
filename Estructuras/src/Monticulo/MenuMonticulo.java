package Monticulo;

public class MenuMonticulo {

	public static void main(String[] args) {
		Monticulo a= new Monticulo(10);
		Monticulo b= new Monticulo(10);
		Monticulo c= new Monticulo(a.getN()+b.getN());
		
		a.insertar(27);
		a.insertar(35);
		a.insertar(23);
		a.insertar(22);
		a.insertar(4);
		a.insertar(45);
		a.insertar(21);
		a.insertar(5);
		a.insertar(42);
		a.insertar(14);
		
		b.insertar(8);
		b.insertar(60);
		b.insertar(33);
		b.insertar(26);
		b.insertar(1);
		b.insertar(40);
		b.insertar(12);
		b.insertar(7);
		b.insertar(2);
		b.insertar(3);
		
		c= a.mezclar(b);
		
		a.mostrar();
		b.mostrar();
		c.mostrar();
		System.out.println("    "+c.getN());
	}
}