import java.util.Scanner;

public class Materia extends Datos{
	private int cupos;
	private int cantidad_estud;
	private Estudiante ins[];
	private Profesor asignado=new Profesor("NoAsignado",0,"NoAsignado","NoAsignado");
	
	Materia(String nombre,int id, int cupos,int cantidad_estud){
		super(nombre,id);
		this.cupos=cupos;
		this.cantidad_estud=cantidad_estud;
		ins=new Estudiante[cupos+cantidad_estud];
	}
	public int getCupos(){
		return cupos;
	}
	public String getProfesor(){
		return asignado.getNombre()+"/"+asignado.getID()+"/"+
			   asignado.getCategoria()+"/"+asignado.getDedicacion();
	}
	public int getCantidadEstudiantes(){
		return cantidad_estud;
	}
	
	public String toString(){
		return "\nNombre: "+getNombre()+" Codigo: "+getID()+" Cupos: "+getCupos()+" Cantidad de Estudiantes: "+getCantidadEstudiantes();
	}
	public void listaEstudiante(){
		for(int i=0;i<cantidad_estud;i++){
			System.out.println(ins[i].toString());
		}
	} 
	public void profesor(){
		System.out.print(asignado.toString());
	}
	//estudianteYprofesor
	public String getEstudiantes(int n){
		return ins[n].getNombre()+"/"+ins[n].getID()+"/"+ins[n].getMateriaCursadas();
	}
	public void setEstudiante(int n,String nombre,int ci,int materia_cursadas){
		ins[n]=new Estudiante(nombre,ci,materia_cursadas);
	}
	public void setProfesor(String nombre,int ci,String categoria,String dedicacion){
		asignado=new Profesor(nombre, ci, categoria,dedicacion);
	}
	//estudianteYprofesor
	public void addEstudiante(){
		Scanner a; a = new Scanner(System.in);
		if(cupos!=0){
				ins[cantidad_estud]=new Estudiante(nombre(a),ci(a),cursadas(a));
				cantidad_estud++;
				cupos--;
		}
		else{
			System.out.println("No hay cupos disponibles en la materia");
		}
	}
	public void borrarEstudiante(int num){
		boolean encontrado= false;
		if(num>=0){
			for(int i=0;i<cantidad_estud;i++){
				if(ins[i].getID()==num){
					ins[i]=ins[cantidad_estud-1];
					ins[cantidad_estud-1]=null;
					cantidad_estud--;
					cupos++;
					encontrado=true;
				}
			}
			if (encontrado==false)
				System.out.println("No se pudo encontrar el estudiante");
		}
		else
			System.out.println("Estudiante no existe");
	}	
	public void addProfesor(){
		Scanner a; a = new Scanner(System.in);
		if(asignado.getNombre()=="NoAsignado"){
				asignado=new Profesor(nombre(a),ci(a),categoria(a),dedicacion(a));
		}
		else{
			System.out.println("El Profesor ya esta asignado a la materia");
		}
	}
	public void borrarProfesor(){
		if(asignado.getNombre()=="NoAsignado"){
			System.out.println("No hay Profesor Asignado");
		}
		else{
			asignado=new Profesor("NoAsignado",0,"NoAsignado","NoAsignado");
			System.out.println("El profesor ha sido borrado");
		}
	}
	
	public boolean mostrarProfesor(int num,boolean encontrado){
		if(asignado.getID()==num){
			System.out.println("Profesor de "+getNombre());
			System.out.println(asignado.toString());
			encontrado=true;
		}
		return encontrado;
	} 
	public boolean mostrarEstudiante(int num, boolean encontrado){
		for(int i=0;i<cantidad_estud;i++){
			if(ins[i].getID()==num){
				System.out.println("Estudiante de "+getNombre());
				System.out.println(ins[i].toString());
				encontrado=true;
			}
		}
		return encontrado;
	}
	//Scanner
	private String nombre(Scanner a){
		String nombre;
		System.out.print("Nombre: ");
		nombre=a.next();
		return nombre;
	}
	private int ci(Scanner a){
		int codigo, b;
		do{
			b=0;
			System.out.print("CI: ");
			codigo=a.nextInt();
			for(int i=0;i<cantidad_estud;i++){
				if(ins[i].getID()==codigo){
					b=1;
					System.out.println("La CI se encuentra asignada a otro estudiante");
				}
			}
		}while(codigo<=0 || b==1);
		return codigo;
	}
	private int cursadas(Scanner a){
		int aprobadas;
		do{
			System.out.print("Cantidad de materias aprobadas: ");
			aprobadas=a.nextInt();
		}while(aprobadas<0);
		return aprobadas;
	}
	private String categoria(Scanner a){
		String categoria;
		System.out.print("La categoria del profesor es: ");
		categoria=a.next();
		return categoria;
	}
	private String dedicacion(Scanner a){
		String dedicacion;
		System.out.print("Tiene una dedicacion: ");
		dedicacion=a.next();
		return dedicacion;
	}
} 