package cola;

public class Nodo<key>{
	public Nodo<key> sig;
	private key nodo;
	Nodo(key a){
		nodo=a;
	}
	public key getNodo(){
		return nodo;
	}
}
