import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Archivo {
	private int n=1;
	private String ruta;
	public Archivo(String ruta) throws IOException {
		this.ruta="../"+ruta;
		leerArchivo();
	}
	private void leerArchivo() throws IOException{
		File archivo = new File(ruta);

		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(ruta));

			String cadena;
			String[] result;
			while ((cadena = br.readLine()) != null) {
				result = cadena.split("/");
				for(int j=0;j<result.length;j++){
					n++;
					System.out.println(n+" "+result[j]);
				}
			}
			br.close();
		} else{
			System.out.println("Archivo no existe");
		}
	} 
	
	public int n() {
		return n;
	}
	
	public void llenarGrafo(Grafo g) throws IOException{
		File archivo = new File(ruta);

		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(ruta));

			String cadena;
			String[] result;
			while ((cadena = br.readLine()) != null) {
				result = cadena.split("/");
				int posI = 0;
				for(int j=0;j<result.length;j++){
					if(j==0){
						g.agregarVertice("P", result[j]);
						posI=g.n();
					}
					else{
						g.agregarVertice("A", result[j]);
						if(g.noAgrego()){
							g.agregarArista(posI , g.pos());
						}else{
							g.agregarArista(posI , g.n());
						}
					}
					System.out.println(g.n()+" "+result[j]);
				}
			}

			br.close();
		}
	}
}
