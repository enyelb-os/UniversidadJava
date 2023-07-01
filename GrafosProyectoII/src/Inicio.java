import java.io.IOException;

import grafo.Grafo;

public class Inicio {
	public static void main(String[] args) throws IOException {
		
		Archivo archivo=new Archivo("Reino.txt");
		
		Grafo reino = new Grafo(archivo.tam());
		int costosC[] =archivo.costosC();
		int costosD[] =archivo.costosD();
		int vertices[]=archivo.vertices();
		
		llenarGrafo(reino, vertices, costosD);
		
		reino.mostrarAdyacentes();
		Trabajos trabajo = new Trabajos(reino, costosC);
		trabajo.costo();
		reino.mostrarAdyacentes();
	}
	
	public static void llenarGrafo(Grafo reino,int vertices[],int costosD[]){
		for (int i = 0; i < reino.getNumV(); i++) {
			for (int j = 0; j < reino.getNumV(); j++) {
				if (i != j && vertices[(i * reino.getNumV()) + j]==1){
					reino.agregarArista(i, j,costosD[(i * reino.getNumV()) + j]);
				}
			}
		}
	}
	
}
