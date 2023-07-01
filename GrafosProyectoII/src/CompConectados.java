import grafo.Arista;
import grafo.Grafo;

public class CompConectados {
	private boolean marcados[];
	private int id[];
	int idActual;

	public CompConectados(Grafo g) {
		marcados = new boolean[g.getNumV()];
		id = new int[g.getNumV()];
		idActual = 0;
		for (int i = 0; i < g.getNumV(); i++) {
			if (marcados[i] == false){
				busqueda(g, i);
				idActual++;
			}
		}
	}

	private void busqueda(Grafo g, int v) {
		marcados[v] = true;
		id[v] = idActual;
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(v);
			if (marcados[w]==false) {
				busqueda(g, w);
			}
		}
	}

	public int compConectados() {
		return idActual;
	}

	public boolean conectados(int origen, int destino) {
		return id[origen] == id[destino] ? true : false;
	}
}
