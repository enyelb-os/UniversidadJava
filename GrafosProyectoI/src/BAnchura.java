import java.util.LinkedList;
import java.util.Queue;

public class BAnchura {
	boolean marcados[];
	int longitudA[];

	BAnchura(Grafo g, int f) {
		marcados = new boolean[g.n()+1];
		longitudA = new int[g.n()+1];
		
		for (int i = 0; i < longitudA.length; i++) {
			longitudA[i] = Integer.MAX_VALUE;
		}
		
		longitudA[f] = g.nodo(f).getId().equals("P") ? -1 : 0;
		bAnchura(g, f);
	}

	private void bAnchura(Grafo g, int s) {
		Queue<Integer> cola = new LinkedList<Integer>();
		marcados[s] = true;
		cola.add(s);
		while (!cola.isEmpty()) {
			int v = cola.remove();
			for (Nodo e : g.ady(v)) {
				int w = e.pos();
				if (marcados[w] == false) {
					marcados[w] = true;
					if (e.getId().equals("A")) {
						longitudA[w] = longitudA[v] + 1;
					} else {
						longitudA[w] = longitudA[v];
					}
					cola.add(w);
				}
			}
		}
	}

	public int excentricidad() {
		int exc = -1;
		for (int i = 0; i < longitudA.length; i++) {
			if (exc < longitudA[i] && longitudA[i] != Integer.MAX_VALUE) {
				exc = longitudA[i];
			}
		}
		return exc;
	}

	public int distancia() {
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < longitudA.length; i++) {
			if (dis > longitudA[i] && longitudA[i] != 0) {
				dis = longitudA[i];
			}
		}
		System.out.println(dis);
		return dis;
	}
}
