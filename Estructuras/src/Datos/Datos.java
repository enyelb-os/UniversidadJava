package Datos;

public class Datos {
 	private String nombre,apellido;
	private int ci;
	Datos(String nombre,String apellido,int ci){
		this.nombre=nombre;
		this.apellido=apellido;
		this.ci=ci;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public String getApellido(){
		return apellido;
	}
	public void setCi(int ci){
		this.ci=ci;
	}
	public int getCi(){
		return ci;
	}
}
