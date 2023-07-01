package Datos;

public class Menu {
	public static void main(String[] args) {
		Monticulo monte=new Monticulo(10);
		monte.insertar("Angel", "Martinez", 27000000);
		monte.insertar("David", "Calvo", 35000000);
		monte.insertar("Rocio", "Hernandez", 27114400);
		monte.insertar("Andrea", "Vera", 22600908);
		monte.insertar("Jose", "Boscan", 25439050);
		monte.insertar("Josibel", "Torcato", 25296390);
		monte.insertar("Victor", "Urdaneta", 25719081);
		monte.insertar("Merlin", "Rosales", 24382390);
		monte.insertar("Luis", "Garces", 25191477);
		monte.insertar("Enyelberth", "Gonzalez", 26200431);
		monte.mostrar();
	}
}
