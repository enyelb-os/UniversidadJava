import grafo.Arista;
import grafo.Grafo;

public class Ciclo {
	private boolean marcados[];
	private boolean existeCiclo = false;

	public Ciclo(Grafo g) {
		marcados = new boolean[g.getNumV()];
		for (int i = 0; i < g.getNumV(); i++)
			if (!marcados[i])
				busqueda(g, i, i);
	}

	private void busqueda(Grafo g, int v, int u) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			int w = e.opuesto(v);
			if (!marcados[w]) {
				busqueda(g, w, v);
			} else if (w != u) {
				existeCiclo = true;
			}
		}
	}

	public boolean existeCiclo() {
		return existeCiclo;
	}
}
