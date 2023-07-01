public class Datos {
	protected String nombre;
	protected int id;
	Datos(String nombre,int id){
		this.nombre=nombre;
		this.id=id;
	}
	public String getNombre(){
		return nombre;
	}
	public int getID(){
		return id;
	}
}