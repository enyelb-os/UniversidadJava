package prim;

import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;

import colaPrioridad.ColaPDinamica;
import colaPrioridad.ColaPMax;
import colaPrioridad.ColaPMin;

public class PrimPerezoso {
	private ColaPDinamica<Arista> cola;
	private boolean marcados[];
	private ArrayList<Arista> ARM;

	public PrimPerezoso(Grafo g,boolean max) {
		cola = max == true ? new ColaPMax<Arista>() : new ColaPMin<Arista>();
		marcados = new boolean[g.getNumV()];
		ARM = new ArrayList<Arista>();
		
		visitar(g, 0);
		
		while (!cola.estaVacia()) {
			Arista a = cola.extraer();
			int v =a.origen();
			int w =a.destino();
			if (marcados[v] && marcados[w])continue;
			ARM.add(a);
			if (!marcados[v]) {
				visitar(g, v);
			}
			if (!marcados[w]) {
				visitar(g, w);
			}
		}

	}

	private void visitar(Grafo g, int v) {
		marcados[v] = true;
		for (Arista e : g.adyacentes(v)) {
			int w= e.opuesto(v);
			if (!marcados[w]) {
				cola.insertar(e,e.p());
			}
		}
	}
	
	public Arista[] aristas() {
		Arista a[]=new Arista[ARM.size()];
		for(int i=0;i<ARM.size();i++){
			a[i]=ARM.get(i);
		}
		return a;
	}

	public void mostrarARM() {
		System.out.println("ARM");
		for (int i = 0; i < ARM.size(); i++) {
			Arista a = ARM.get(i);
			System.out.println(a.origen() + "-" + a.destino() + " " + a.p());
		}
	}
}
