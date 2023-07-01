package grafo;

public class AristaFlujo{
	private Vertice v;
	private Vertice w;
	private double capacidad;
	private double flujo;
	
	public AristaFlujo(Vertice v, Vertice w, double c){
		this.v = v;
		this.w = w;
		this.capacidad = c;
	}
	public double capacidad(){ 
		return capacidad; 
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
	public double capacidadResidual(int v){
		if(v==this.v.pos())
			return flujo;
		else if(v==this.w.pos())
			return (capacidad-flujo);
		return flujo;
	}
	
	public void aumentarFlujo(int v , double b) {
		if(v==this.v.pos())
			flujo-=b;
		else if(v==this.w.pos())
			flujo+=b;
	}
}
