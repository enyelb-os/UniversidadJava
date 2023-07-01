package grafo;

public class GrafoD<key>  extends Grafo<key>{
	public GrafoD(int numVer) {
		super(numVer);
	}

	public void agregarArista(int i, int j, double p) {
		if (posExiste(i) && posExiste(j)) {
			if(!existeArista(vertices[i], vertices[j])){
				Arista<key> a;
				a = new Arista<key>(vertices[i], vertices[j], p);
				ady[i].add(a);
			}
		}
	}
}