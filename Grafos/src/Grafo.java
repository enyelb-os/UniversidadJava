import java.util.ArrayList;

public class Grafo {
	private ArrayList<Integer> ady[];
	private boolean dirigido;
	private int numVer;
	private int vectExcentricidad[];
	private int radio,diametro;
	// -----------------------------------------------------------//
	// Constructores

	@SuppressWarnings("unchecked")
	Grafo(int numVer, boolean dirigido) {
		this.dirigido = dirigido;
		this.numVer=numVer;
		ady = new ArrayList[numVer];
		for (int i = 0; i < numVer; i++) {
			ady[i] = new ArrayList<Integer>();
		}
	}

	// -----------------------------------------------------------// Metodos Que
	// Retornan
	
	public int getNumV(){
		return numVer;
	}

	private boolean posExiste(int vOrigen) {
		return vOrigen < ady.length ? true : false;
	}

	private boolean aristaExiste(int vOrigen, int vDestino) {
		return ady[vOrigen].contains(vDestino);
	}

	public int[] adyacentes(int vOrigen) {
		int vect[] = null;
		if (posExiste(vOrigen)) {
			vect = new int[ady[vOrigen].size()];
			for (int i = 0; i < vect.length; i++) {
				vect[i] = ady[vOrigen].get(i);
			}
		}
		return vect;
	}

	private int grado(int vOrigen) {
		return posExiste(vOrigen) ? ady[vOrigen].size() : null;
	}

	// -----------------------------------------------------------// Metodos
	// Publicos
	
	public boolean esConexo(){
		BAnchura conexo=new BAnchura(this,0);
		return this.getNumV()==conexo.getCuenta()? true: false;
	}

	public void agregarArista(int vOrigen, int vDestino) {
		if (posExiste(vOrigen) && posExiste(vDestino)
				&& !aristaExiste(vOrigen, vDestino)) {
			ady[vOrigen].add(vDestino);
			if (!dirigido) {
				ady[vDestino].add(vOrigen);
			}
		}
	}

	public void eliminarArista(int vOrigen, int vDestino) {
		if (posExiste(vOrigen) && posExiste(vDestino)
				&& aristaExiste(vOrigen, vDestino)) {
			ady[vOrigen].remove((Integer) vDestino);
			if (!dirigido) {
				ady[vDestino].remove((Integer) vOrigen);
			}
		}
	}

	public boolean camimo(int[] vect) {
		for (int i = 0; i < vect.length - 1; i++) {
			if (!aristaExiste(vect[i], vect[i + 1])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean cicloEuler() {
		if (esConexo()) {
			for (int i = 0; i < this.numVer; i++) {
				if (!(this.grado(i) % 2 == 0)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean caminoEuler() {
		if (this.cicloEuler())
			return true;
		else {
			if (esConexo()) {
				int cont = 0;
				for (int i = 0; i < this.numVer; i++) {
					if (!(this.grado(i) % 2 == 0)) {
						cont++;
						if (cont > 2)
							return false;
					}
				}
				if (cont == 2)
					return true;
			}
			return false;
		}
	}
	
	public void vectExcentricidad(){
		System.out.println("Vector de Excentricidad");
		vectExcentricidad=new int[numVer];
		for(int i=0;i<numVer;i++){
			vectExcentricidad[i]=excentricidad(i);
			System.out.println(i+" : "+vectExcentricidad[i]);
		}
	}
	
	public int excentricidad(int i){
		BAnchura a=new BAnchura(this,i);
		return a.excentricidad();
	}

	public int radio(){
		radio=vectExcentricidad[0];
		for(int i=1;i<vectExcentricidad.length;i++){
			if(vectExcentricidad[i]<radio){
				radio=vectExcentricidad[i];
			}
		}
		System.out.println("Radio : "+radio);
		return radio;
	}
	
	public int diametro(){
		diametro=vectExcentricidad[0];
		for(int i=1;i<vectExcentricidad.length;i++){
			if(vectExcentricidad[i]>diametro){
				diametro=vectExcentricidad[i];
			}
		}
		System.out.println("Diametro : "+diametro);
		return diametro;
	}
	
	public void verticesCento(){
		System.out.println("Vertice Cento");
		for(int i=0;i<numVer;i++){
			if(radio==vectExcentricidad[i]){
				System.out.println(i);
			}
		}
	}
	// -----------------------------------------------------------// Metodos
	// Mostrar

	public void mostrarVGrados() {
		System.out.println("Vector De Grados");
		for (int i = 0; i < ady.length; i++) {
			System.out.println(i + " : " + grado(i));
		}
	}

	public void mostrarAdyacentes() {
		System.out.println("Adyacentes");
		for (int i = 0; i < ady.length; i++) {
			System.out.print(i + " :");
			int adyT[] = adyacentes(i);
			for (int j = 0; j < adyT.length; j++) {
				System.out.print(" " + adyT[j]);
			}
			System.out.println();
		}
	}
}
