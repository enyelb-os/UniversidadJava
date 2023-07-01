package grafo;

public class Arista<key>{
	private Vertice<key> v;
	private Vertice<key> w;
	private double p;
	
	public Arista(Vertice<key> v, Vertice<key> w, double p){
		this.v = v;
		this.w = w;
		this.p = p;
	}
	public double p(){ 
		return p; 
	}
	public Vertice<key> origen(){ 
		return v; 
	}
	public Vertice<key> destino() {
		return w;
	}
	public Vertice<key> opuesto(Vertice<key> ver){
		if(ver == v)
			return w;
		else if (ver == w) 
			return v;
		else 
			throw new RuntimeException("No Existe Vertice");
	}
	
//	public void setOrigen(key o){
//		v=o;
//	}
//	public void setDestino(key d){
//		w=d;
//	}
}
