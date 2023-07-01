package busqueda;
import grafo.Arista;
import grafo.Grafo;

import java.util.ArrayList;
import java.util.Stack;


public class Otopo{
	private boolean marados[];
	private Stack<Integer> pila=new Stack<Integer>();
	public Otopo(Grafo g){
		marados=new boolean[g.tamanio()];
		for(int i=0;i<g.tamanio();i++){
			if(marados[i]==false){
				bProf(g, i);
			}
		}
	}
	private void bProf(Grafo g,int v){
		marados[v]=true;
		ArrayList<Arista> aristas=g.adyacentes(v);
		for(int i=0;i<aristas.size();i++){
			int w=aristas.get(i).destino().pos();
			if(marados[w]==false){
				bProf(g, w);
			}
		}
		pila.add(v);
	}
	
	public Stack<Integer> orden(){
		return pila;
	}
	public void mostrar(){
		System.out.println();
		for(int i=pila.size();i>0;i--){
			System.out.println(" "+pila.pop());
		}
	}
}
