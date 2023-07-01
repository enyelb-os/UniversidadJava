
public class MenuConjuntos {
	public static void main(String[] args) {
		Conjuntos a=new Conjuntos();
		Conjuntos b=new Conjuntos();
		Conjuntos j=new Conjuntos();
		Conjuntos t=new Conjuntos();
		int n= 5; //Este es el valor que utiliza Pertenencia para buscar en el conjunto...
		System.out.println("Conjunto A...");
		a.insertar(1);
		a.insertar(2);
		a.insertar(3);
		a.mostrar();
		System.out.println("Conjunto B...");
		b.insertar(1);
		b.insertar(2);
		b.insertar(4);
		b.insertar(5);
		b.mostrar();
		System.out.println("Conjunto C...");
		a.mostrar();
		System.out.println("Conjunto D...");
		j.insertar(4);
		j.insertar(5);
		j.mostrar();
		System.out.println("La interseccion entre A y B es...");
		Conjuntos c=a.interseccion(b);
		c.mostrar();
		System.out.println("La interseccion entre C y D es...");
		Conjuntos m=a.interseccion(j);
		m.mostrar();
		System.out.println("DIFERENCIA DE CONJUNTOS");
		System.out.println("Conjunto A...");
		a.mostrar();
		t.insertar(1);
		t.insertar(2);
		t.insertar(4);
		System.out.println("Conjunto B...");
		t.mostrar();
		System.out.println("La Diferencia entre A y B es...");
		Conjuntos k=a.diferencia(t);
		k.mostrar();
		System.out.println("Conjunto C...");
		a.mostrar();
		System.out.println("Conjunto D...");
		j.mostrar();
		System.out.println("La Diferencia entre C y D es...");
		Conjuntos d=a.diferencia(j);
		d.mostrar();
		System.out.println(b.pertenencia(n));
	}
}