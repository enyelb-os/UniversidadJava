
public class Profesor extends Datos{
	private String categoria;
	private String dedicacion;
	Profesor(String nombre,int ci,String categoria,String dedicacion){
		super(nombre,ci);
		this.categoria=categoria;
		this.dedicacion=dedicacion;
	}
	public String getCategoria(){
		return categoria;
	}
	public String getDedicacion(){
		return dedicacion;
	}
	public String toString(){
		return "Nombre: "+getNombre()+" CI: "+getID()+" Categoria: "+getCategoria()+" Dedicacion: "+getDedicacion()+"\n";
	}
}
