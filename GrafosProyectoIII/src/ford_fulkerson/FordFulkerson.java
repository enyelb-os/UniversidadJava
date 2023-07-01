package ford_fulkerson;

import grafo.AristaFlujo;
import grafo.GrafoF;

import cola.Cola;

public class FordFulkerson {
	Cola<Integer> cola;
	boolean marcados[];
	private AristaFlujo arista[];
	private double flujo;
	public FordFulkerson(GrafoF g,int s,int t) {
		while(existeCamino(g, s, t) ){
			double cmin = Integer.MAX_VALUE;
			for(int v = t; v != s; v = arista[v].opuesto(g.vertice(v)).pos()){
				cmin = cmin < arista[v].capacidadResidual(v) ? cmin : arista[v].capacidadResidual(v);
			}
			for (int v = t; v != s; v = arista[v].opuesto(g.vertice(v)).pos()){
				arista[v].aumentarFlujo(v, cmin);
			}
			flujo += cmin;
		}
	}

	public boolean existeCamino(GrafoF g, int s, int t){
		cola=new Cola<Integer>();
		marcados=new boolean [g.tamanio()];
		arista=new AristaFlujo[g.tamanio()];
		cola.insertar(s);
		marcados[s]=true;
		while(!cola.estaVacia()){
			int v=cola.extraer();
			for (AristaFlujo a : g.adyacentes(v)) {
				int w=a.opuesto(g.vertice(v)).pos();
				if(marcados[w]==false && a.capacidadResidual(w)>0){
					arista[w]=a;
					marcados[w]=true;
					cola.insertar(w);
				}
			}
		}
		return marcados[t];
	}

	public double flujo(){
		return flujo;
	}
}
