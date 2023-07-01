public class Nodo{
	private String id;
	private String nombre;
	private static int posActual=0;
	private int pos;
	Nodo(String id,String nombre){
		this.id=id;
		this.nombre=nombre;
		pos=posActual;
		posActual++;
	}
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setId(String id) {
		this.id=id;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public int pos(){
		return pos;
	}
}