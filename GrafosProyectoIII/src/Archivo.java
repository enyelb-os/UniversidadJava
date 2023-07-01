
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	private int[][] aristas;
	private int capacidad;
	private int numVer;
	
	public Archivo(String ruta) throws IOException {
		ruta = "../" + ruta;
		File archivo = new File(ruta);

		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(ruta));

			String cadena;
			String result[];
			
			int k=0;
			while((cadena = br.readLine()) != null) {
				if(k==0)
					capacidad=Integer.parseInt(cadena);
				else if(k==1){
					result = cadena.split(" ");
					numVer =Integer.parseInt(result[0]);
					int n=Integer.parseInt(result[1]);
					aristas=new int[n][2];
				}else if(k<aristas.length+2){
					result = cadena.split(" ");
					aristas[k-2][0]=Integer.parseInt(result[0]);
					aristas[k-2][1]=Integer.parseInt(result[1]);
				}else{
					break;
				}
				k++;
			}

			br.close();
		}
	}

	public int[][] aristas(){
		return aristas;
	}

	public int capacidad() {
		return capacidad;
	}

	public int num() {
		return numVer;
	}
}
