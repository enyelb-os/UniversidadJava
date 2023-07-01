import java.util.Stack;


public class Otopo {
	private boolean marados[];
	private Stack<Integer> pila=new Stack<Integer>();
	Otopo(Grafo g){
		marados=new boolean[g.getNumV()];
		for(int i=0;i<g.getNumV();i++){
			if(marados[i]==false){
				bProf(g, i);
			}
		}
	}
	private void bProf(Grafo g,int v){
		marados[v]=true;
		int vect[]=g.adyacentes(v);
		for(int i=0;i<vect.length;i++){
			int w=vect[i];
			if(marados[w]==false){
				bProf(g, w);
			}
		}
		pila.add(v);
	}
	public void mostrar(){
		System.out.println();
		for(int i=pila.size();i>0;i--){
			System.out.println(" "+pila.pop());
		}
	}
}
