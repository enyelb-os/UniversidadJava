import java.util.Scanner;


public class SistemaDatos {
	private int n=0;
	private final int N=20;
	private Materia materias[];
	
	SistemaDatos(){
		materias=new Materia[N];
	}
	public boolean getN(){
		return n<N;
	}
	public int getTam(){
		return n;
	}
	//materia
	public String getMateria(int n){
		return materias[n].getNombre()+"/"+materias[n].getID()+"/"+
		       materias[n].getCupos()+"/"+materias[n].getCantidadEstudiantes();
	}
	public String getProfesor(int n){
		return materias[n].getProfesor();
	}
	public int getCantidadDeEstudiantes(int n){
		return materias[n].getCantidadEstudiantes();
	} 
	public String getEstudiantes(int m,int n){
		return materias[m].getEstudiantes(n);
	}
	public void setMateria(String nombre,int codigo,int cupos,int cantidad_Estud){
		materias[n]=new Materia(nombre,codigo,cupos,cantidad_Estud);
		n++;
	}
	public void setEstudiantes(int n,String nombre,int ci,int materia_cursadas){
		materias[this.n-1].setEstudiante(n,nombre,ci,materia_cursadas);
	}
	public void setProfesor(String nombre,int ci,String categoria,String dedicacion){
		materias[n-1].setProfesor(nombre, ci, categoria,dedicacion);
	}
	
	public String toString(int n){
		return materias[n].toString();
	}
	//materiaMenu
 	public void addMateria(){
		Scanner a; a = new Scanner(System.in);
		materias[n]=new Materia(nombre(a),codigo(a),cupos(a),0);
		n++;
	}
 	public void mostrarMaterias(){
		for(int i=0;i<n;i++){
			System.out.println((i+1)+".)"+materias[i].getNombre());
		}
	}
	public void datosMaterias(int num,Scanner a){
		if(num>=0 && num<n){
			System.out.println("+++++"+materias[num].getNombre()+"+++++");
			String sel;
			int b=0;
			do{
				menuMaterias();
				sel=a.next();
				switch(sel){
					case "1":{
						System.out.println("Profesor");
						materias[num].addProfesor();
					}break;
					case "2":{
						materias[num].borrarProfesor();
					}break;
					case "3":{
						System.out.println("Estudiante");
						materias[num].addEstudiante();
					}break;
					case "4":{
						
						materias[num].borrarEstudiante(estudiante(a));
					}break;
					case "5":{b=5;}break;
				}
			}while(b!=5);
		}
		else
			System.out.println("La materia no existe");
	}
	public void borrarMateria(int num){
		if(n!=0){
			if(num>=0 && num<n){
				materias[num]=materias[n-1];
				materias[n-1]=null;
				n--;
			} 
		    else{
				System.out.println("La materia no existe");
			}
		}
		else{
			System.out.println("No hay materias");
		}
	}
	
	public void consultas(Scanner a){
		String sel;
		int b=0;
		do{
			menuConsultas();
			sel=a.next();
			switch(sel){
				case "1":{
					if(n>0){
						mostrarMaterias();int c=materia(a);
						System.out.println(toString(c));
						System.out.println("Profesor Asignado");
						materias[c].profesor();
						System.out.println("Lista de estudiantes");
						materias[c].listaEstudiante();
					}
					else
						System.out.print("No hay materias");
				}break;
				case "2":{
					if(n>0){
						System.out.println("");
						int c=codigo(a);
						boolean encontrado=false;
						for(int i=0;i<n;i++){
							encontrado=materias[i].mostrarProfesor(c,encontrado);
						}
						if(encontrado==false)
							System.out.println("La CI ingresada no pertenece a ningun profesor registrado.");
					}
					else
						System.out.print("No hay materias");
				}break;
				case "3":{
					if(n>0){
						System.out.println("");
						int c=codigo(a);
						boolean encontrado=false;	//Preguntar valor de encontrado= false...
						for(int i=0;i<n;i++){
							encontrado=materias[i].mostrarEstudiante(c,encontrado); 
						}
						if(encontrado==false)
							System.out.println("La CI ingresada no corresponde a ningun estudiante registrado.");
					}
					else
						System.out.print("No hay materias");
				}break;
				case "4":{b=4;}break;
			}
		}while(b!=4);
	}
	//Scanner
	private void menuMaterias(){
		System.out.println("");
		System.out.println("1.) Asignar Profesor");
		System.out.println("2.) Borrar Profesor");
		System.out.println("3.) Add Estudiante");
		System.out.println("4.) Borrar Estudiante");
		System.out.println("5.) Volver");
		System.out.println("");
	}
	private void menuConsultas(){
		System.out.println("");
		System.out.println("1.) Datos de Materia");
		System.out.println("2.) Datos de Profesor");
		System.out.println("3.) Datos de Estudiante");
		System.out.println("4.) Volver");
		System.out.println("");
	}
	private String nombre(Scanner a){
		String nombre;
		System.out.print("Nombre de la materia: ");
		nombre=a.next();
		return nombre;
	} 
	private int codigo(Scanner a){
		int codigo, b;
		do{
			b=0;
			System.out.print("ID: ");
			codigo=a.nextInt();
			for(int i=0;i<n;i++){
				if(materias[n-1].getID()==codigo){
					b=1;
					System.out.println("El codigo de la materia ya existe");
				}
			}
		}while(codigo<=0 || b==1);
		return codigo;
	}
	private int cupos(Scanner a){
		int cupos;
		do{
			System.out.print("Cupos De Materia: ");
			cupos=a.nextInt();
		}while(cupos<=0);
		return cupos;
	}
	private int estudiante(Scanner a){
		int estudiante;
		System.out.print("Ingrese la CI del estudiante a Borrar: ");
		estudiante=a.nextInt();
		return estudiante;
	}
	private int materia(Scanner a){
		int materia;int b;
		do{
			b=0;
			System.out.print("Materia a Mostrar: ");
			materia=a.nextInt();
			if(materia>n||materia<0){
				b=1;
			}
		}while(b==1);
		return materia-1;
	}
}