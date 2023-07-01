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
		int ady[] = g.adyacentes(v);
		for (int i = 0; i < ady.length; i++) {
			int w = ady[i];
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
