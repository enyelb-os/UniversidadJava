package busqueda;

import java.util.ArrayList;

import grafo.Arista;
import grafo.Grafo;

public class CompConectados<key> {
	private boolean marcados[];
	private int id[];
	int idActual;

	public CompConectados(Grafo g) {
		marcados = new boolean[g.tamanio()];
		id = new int[g.tamanio()];
		idActual = 0;
		for (int i = 0; i < g.tamanio(); i++) {
			if (marcados[i] == false){
				busqueda(g, i);
				idActual++;
			}
		}
	}

	private void busqueda(Grafo g, int v) {
		marcados[v] = true;
		id[v] = idActual;
		ArrayList<Arista> ady = g.adyacentes(v);
		for (int i = 0; i < ady.size(); i++) {
			int w = ady.get(i).destino().pos();
			if (marcados[w]==false) {
				busqueda(g, w);
			}
		}
	}

	public int numCompConectados() {
		System.out.println("Numero de Conectados " + idActual);
		return idActual;
	}

	public boolean conectados(int origen, int destino) {
		System.out.println(id[origen] == id[destino] ? true : false);
		return id[origen] == id[destino] ? true : false;
	}
}
