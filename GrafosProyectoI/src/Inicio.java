import java.io.IOException;


public class Inicio {
	public static void main(String[] args) throws IOException {
		double ini =System.nanoTime();
		
		Archivo archivo=new Archivo("movies.txt");
		Grafo g=new Grafo(archivo.n());
		
		archivo.llenarGrafo(g);
		//g.mostrarVertices();
		
		g.vectExcentricidad();
		g.diametro();
		
		double end =System.nanoTime();
		System.out.println((end-ini)/1000000000);
	}
	
}
