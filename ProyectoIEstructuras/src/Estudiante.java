
public class Estudiante extends Datos{
	private int materia_cursadas;
	Estudiante(String nombre,int ci,int materia_cursadas){
		super(nombre, ci);
		this.materia_cursadas=materia_cursadas;
	}
	public int getMateriaCursadas(){
		return materia_cursadas;
	}
	public String toString(){
		return "Nombre: "+getNombre()+" CI: "+getID()+" Materias Cursadas: "+getMateriaCursadas();
	}
}
