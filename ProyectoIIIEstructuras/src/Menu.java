import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class Menu {
	static String ruta="../Impresora.txt";
	public static void main(String[] args) throws IOException {
		Impresora trabajos=new Impresora(30);
		trabajos.insertar("Enyel", 11, 1, 10,true);
		leerArchivo(trabajos);
		trabajos.mostrarConsola();
		VentanaScroll v1=new VentanaScroll(trabajos);
		v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//--------------------------------------------//
	public static void leerArchivo(Impresora n) throws IOException{
		File archivo=new File(ruta);
		BufferedReader br = null;
		if(archivo.exists()){
			br= new BufferedReader( new FileReader (ruta));
		}
		else{
			BufferedWriter bw= new BufferedWriter( new FileWriter (ruta));
			br= new BufferedReader( new FileReader (ruta));
			bw.close();
		}
		String cadena; String[] result;
		while((cadena=br.readLine())!=null){
				result = cadena.split("/");
				int a=Integer.parseInt(result[1]);
				int b=Integer.parseInt(result[2]);
				int c=Integer.parseInt(result[3]);
				boolean d=Integer.parseInt(result[4])==1 ? true:false;
				n.insertar(result[0],a,b,c,d);
		}
		br.close();
	}
}

