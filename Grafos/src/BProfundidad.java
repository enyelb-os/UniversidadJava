import java.util.Stack;

public class BProfundidad{
	boolean marcado[];
	int cuenta, vertice[], fuente;
	
	Stack<Integer> pila=new Stack<Integer>();

	BProfundidad(Grafo G, int f) {
		marcado = new boolean[G.getNumV()];
		vertice = new int[G.getNumV()];
		busqueda(G, f);
		vertice[f] = -1;
		fuente = f;
	}

	public void busqueda(Grafo G, int v) {
		int vector[] = G.adyacentes(v);
		marcado[v] = true;
		cuenta++;
		for (int j = 0; j < vector.length; j++) {
			int w = vector[j];
			while (marcado[w] == false) {
				vertice[w] = v;
				busqueda(G, w);
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
