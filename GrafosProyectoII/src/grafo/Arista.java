package grafo;

public class Arista{
	private int v;
	private int w;
	private double p;
	
	public Arista(int v,int w, double p){
		this.v = v;
		this.w = w;
		this.p = p;
	}
	public double p(){ 
		return p; 
	}
	public int origen(){ 
		return v; 
	}
	public int destino() {
		return w;
	}
	public int opuesto(int ver){
		if(ver == v)
			return w;
		else if (ver == w) 
			return v;
		else 
			return -1;
	}
	
	public void setOrigen(int o){
		v=o;
	}
	public void setDestino(int d){
		w=d;
	}
	
	public void setP(double p){ 
		this.p=p; 
	}
}
