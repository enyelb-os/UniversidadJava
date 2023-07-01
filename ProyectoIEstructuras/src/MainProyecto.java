import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
	

public class MainProyecto {
	static String ruta="/home/enyelb/Materias.txt";
	public static void main(String[] args) throws IOException {
		SistemaDatos lista= new SistemaDatos();
		leerArchivo(lista);
		
		Scanner a; a = new Scanner(System.in);
		String sel;
		int b=0;
		do{
			menu();
			sel=a.next();
			switch(sel){
				case "1":{
					if(lista.getN())
						lista.addMateria();
					else System.out.println("Ha excedido el limite de materias");
				}break;
				case "2":{
					lista.mostrarMaterias();
					lista.datosMaterias(materia(a),a);
				}break;
				case "3":{
					lista.mostrarMaterias();
					lista.borrarMateria(materia(a));
				}break;
				case "4":{
					lista.consultas(a);
				}break;
				case "5":{
					crearArchivo(lista);
				}break;
				case "6":{
					b=6;
				}break;
			}	
		}while(b!=6);
		a.close();
	}
	public static void leerArchivo(SistemaDatos n) throws IOException{
		BufferedReader br = new BufferedReader( new FileReader (ruta));
		String cadena;int k=0; String[] result;
		while((cadena=br.readLine())!= null){
				//materia
				result = cadena.split("/");
				n.setMateria(result[0],Integer.parseInt(result[1]),
							           Integer.parseInt(result[2]),
							           Integer.parseInt(result[3]));
				//profesor
				cadena=br.readLine();
				result = cadena.split("/");
				n.setProfesor(result[0],Integer.parseInt(result[1]),
						                result[2],result[3]);
				//estudiante
				for(int i=0;i<n.getCantidadDeEstudiantes(k);i++){
					cadena=br.readLine();
					result = cadena.split("/");
					n.setEstudiantes(i,result[0],Integer.parseInt(result[1]),
												 Integer.parseInt(result[2]));
				}
				cadena=br.readLine();
				k++;
		}
		br.close();
	}
	public static void crearArchivo(SistemaDatos n) throws IOException{
		FileWriter fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(ruta);
        pw = new PrintWriter(fichero);
        for(int i=0;i<n.getTam();i++){
        	pw.println(n.getMateria(i));
        	pw.println(n.getProfesor(i));
        	for(int j=0;j<n.getCantidadDeEstudiantes(i);j++){
        		pw.println(n.getEstudiantes(i,j));
        	}
        	pw.println("--------------------------------------------");
        }
        pw.close();
	}
	
	//Scanner
	private static void menu(){
		System.out.println("");
		System.out.println("1.) Crear Materia");
		System.out.println("2.) Config Materia");
		System.out.println("3.) Borrar Materia");
		System.out.println("4.) Consultas");
		System.out.println("5.) Guardar Cambios");
		System.out.println("6.) Salir");
		System.out.println("");
	}
	private static int materia(Scanner a){
		int materia;
		System.out.print("Materia a Configurar: ");
		materia=a.nextInt();
		return materia-1;
	}
}