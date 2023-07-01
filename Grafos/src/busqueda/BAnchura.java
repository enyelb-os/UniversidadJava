package busqueda;
import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BAnchura {
	boolean marcados[];
	int verticeA[];
	int fuente;
	int longitudA[];
	int cuenta=1;

	public BAnchura(Grafo g, int f) {
		marcados = new boolean[g.tamanio()];
		verticeA = new int[g.tamanio()];
		longitudA = new int[g.tamanio()];
		for (int i = 0; i < longitudA.length; i++) {
			longitudA[i] = Integer.MAX_VALUE;
		}
		longitudA[f] = 0;
		bAnchura(g, f);
		fuente = f;
		verticeA[f]=-1;
	}

	private void bAnchura(Grafo g, int s) {
		Queue<Integer> cola = new LinkedList<Integer>();
		marcados[s] = true;
		cola.add(s);
		while (!cola.isEmpty()) {
			int v = cola.remove();
			ArrayList<Arista> ady = g.adyacentes(v);
			for (int i = 0; i < ady.size(); i++) {
				int w=ady.get(i).destino().pos();
				if (marcados[w] == false) {
					marcados[w] = true;
					verticeA[w] = v;
					longitudA[w] = longitudA[v] + 1;
					cola.add(w);
					cuenta++;
				}
			}
		}
	}
	public int getCuenta(){
		return cuenta;
	}
	public int[] VerticesA() {
		System.out.println("VerticeA");
		for (int i = 0; i < verticeA.length; i++) {
			System.out.println(i + " : " + verticeA[i]);
		}
		return verticeA;
	}

	public int[] LongitudA() {
		System.out.println("LongitudA");
		for (int i = 0; i < longitudA.length; i++) {
			System.out.println(i + " : " + longitudA[i]);
		}
		return longitudA;
	}
	
	public int excentricidad() {
		int exc=-1;
		for(int i=0;i<longitudA.length;i++){
			if(exc<longitudA[i]){
				exc=longitudA[i];
			}
		}
		return exc;
	}
	
	public int distancia() {
		int dis=Integer.MAX_VALUE;
		for(int i=0;i<longitudA.length;i++){
			if(dis>longitudA[i] && longitudA[i]!=0
					){
				dis=longitudA[i];
			}
		}
		System.out.println(dis);
		return dis;
	}
}
