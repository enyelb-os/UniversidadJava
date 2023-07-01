package grafo;

public class GrafoD  extends Grafo{
	public GrafoD(int numVer) {
		super(numVer);
	}

	public void agregarArista(int i, int j, double p){
		if (posExiste(i) && posExiste(j)) {
			if(!existeArista(vertices[i], vertices[j])){
				Arista a;
				a = new Arista(vertices[i], vertices[j], p);
				ady[i].add(a);
			}
		}
	}
	
	public void removerArista(Arista j){
		if (existeArista(j.origen(), j.destino())) {
			ady[j.origen().pos()].remove(j);
		}
	}
}