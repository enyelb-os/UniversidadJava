package grafo;

public class Arista{
	private Vertice v;
	private Vertice w;
	private double p;
	
	public Arista(Vertice v, Vertice w, double p){
		this.v = v;
		this.w = w;
		this.p = p;
	}
	public double p(){ 
		return p; 
	}
	public Vertice origen(){ 
		return v; 
	}
	public Vertice destino() {
		return w;
	}
	public Vertice opuesto(Vertice ver){
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
