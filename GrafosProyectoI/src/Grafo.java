import java.util.ArrayList;

public class Grafo {
	private ArrayList<Nodo> ady[];
	private Nodo[] vertices;
	private int nV;
	private int n = -1;
	private boolean noAgrego=false;
	private int posExisteV=0;

	private int vectExcentricidad[];
	private int radio, diametro;


	@SuppressWarnings("unchecked")
	Grafo(int nV) {
		ady = new ArrayList[nV];
		for(int i=0;i<nV;i++){
			ady[i]= new ArrayList<Nodo>();
		}
		vertices = new Nodo[nV];
		this.nV = nV;
	}
	
	private boolean posExiste(int i){
		return (i>=0)&&(i<=n);
	}

	private boolean existeVertice(String nombre) {
		for (int i = 0; i <=n; i++) {
			if (nombre.equals(vertices[i].getNombre())) {
				posExisteV=i;
				noAgrego=true;
				return true;
			}
		}
		return false;
	}

	public void agregarVertice(String id, String nombre) {
		if (n < nV && !existeVertice(nombre)) {
			n++;
			vertices[n] = new Nodo(id, nombre);
		}
	}

	private boolean existeArista(int v, int w) {
		if (ady[v].contains(vertices[w])) {
			return true;
		}
		return false;
	}

	public void agregarArista(int v, int w) {
		if (!existeArista(v, w)) {
			ady[v].add(vertices[w]);
			ady[w].add(vertices[v]);
		}
	}
	
	public Nodo nodo(int i){
		if(posExiste(i)){
			return vertices[i];
		}
		return null;
	}
	
	public ArrayList<Nodo> ady(int v){
		if(posExiste(v)){
			return ady[v];
		}
		return null;
	} 

	public int pos(String nombre) {
		for (int i = 0; i <=n; i++) {
			if (nombre == vertices[i].getNombre()) {
				return i;
			}
		}
		return -1;
	}
	public int n(){
		return n;
	}
	
	public boolean noAgrego(){
		if(noAgrego==true){
			noAgrego=false;
			return true;
		}
		return noAgrego;
	}
	
	public int pos(){
		return posExisteV;
	}

	public void vectExcentricidad() {
		// System.out.println("Vector de Excentricidad");
		vectExcentricidad = new int[1+n];
		for (int i = 0; i <=n; i++) {
			vectExcentricidad[i] = excentricidad(i);
			System.out.println(i + " : " + vectExcentricidad[i]);
		}
	}

	public int excentricidad(int i) {
		BAnchura a = new BAnchura(this, i);
		return a.excentricidad();
	}

	public int radio() {
		radio = Integer.MAX_VALUE;
		for (int i = 1; i < vectExcentricidad.length; i++) {
			if (vectExcentricidad[i] < radio && vectExcentricidad[i] != 0) {
				radio = vectExcentricidad[i];
			}
		}
		System.out.println("Radio : " + radio);
		return radio;
	}

	public int diametro() {
		diametro = vectExcentricidad[0];
		for (int i = 1; i < vectExcentricidad.length; i++) {
			if (vectExcentricidad[i] > diametro) {
				diametro = vectExcentricidad[i];
			}
		}
		System.out.println("Diametro : " + diametro);
		return diametro;
	}

	public void verticesCento() {
		System.out.println("Vertice Cento");
		for (int i = 0; i < ady.length; i++) {
			if (radio == vectExcentricidad[i]) {
				System.out.println(i);
			}
		}
	}

	// ------------------------------------------------------//

	public void mostrarVertices() {
		for (int i = 0; i <=n; i++) {
			System.out.print(vertices[i].getNombre()+" : ");
			for (int j = 0; j < ady[i].size(); j++) {
				System.out.print(" "+ady[i].get(j).getNombre());
			}
			System.out.println("");
		}
	}
}
