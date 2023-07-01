package colaP;

public class Nodo<key>{
	public Nodo<key> sig;
	private key arista;
	private double prioridad;
	Nodo(key a,double p){
		arista=a;
		prioridad=p;
	}
	public double getP(){
		return prioridad;
	}
	public void setP(double p){
		prioridad=p;
	}
	public key getNodo(){
		return arista;
	}
}
