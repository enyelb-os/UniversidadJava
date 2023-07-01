package busqueda;
import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;
import java.util.Stack;

public class BProfundidad<key>{
	boolean marcado[];
	int cuenta, vertice[], fuente;
	
	Stack<Integer> pila=new Stack<Integer>();

	BProfundidad(Grafo g, int f) {
		marcado = new boolean[g.tamanio()];
		vertice = new int[g.tamanio()];
		busqueda(g, f);
		vertice[f] = -1;
		fuente = f;
	}

	public void busqueda(Grafo g, int v) {
		ArrayList<Arista> ady = g.adyacentes(v);
		marcado[v] = true;
		cuenta++;
		for (int i = 0; i < ady.size(); i++) {
			int w = ady.get(i).destino().pos();
			while (marcado[w] == false) {
				vertice[w] = v;
				busqueda(g, w);
			}
		}
	}
	
	public void caminoA(int v){
		if(marcado[v]){
			int iniv=v;
			pila.add(v);
			while(fuente!=v){
				v=vertice[v];
				pila.add(v);
			}
			System.out.println("Camino de "+fuente+" a "+ iniv);
			while(!pila.empty()){
				System.out.print(" "+pila.pop());
			}
			System.out.println();
		}
	}
	
	public boolean esConexo(){
		return cuenta==vertice.length;
	}

	public void mostrar() {
		System.out.println("Profundidad");
		for (int i = 0; i < vertice.length; i++) {
			System.out.println(i + " : " + vertice[i]);
		}
	}
}
