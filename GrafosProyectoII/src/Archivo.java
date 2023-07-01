import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Archivo {
	private String ruta = "../";
	private int[] cC;
	private int[] cD;
	private int[] g;
	private int tam=0;
	
	public Archivo(String ruta) throws IOException {
		this.ruta = this.ruta + ruta;
		leerArchivo();
	}

	private void leerArchivo() throws IOException {
		File archivo = new File(ruta);

		if (archivo.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(ruta));

			Hashtable<String, Integer> valores = new Hashtable<String, Integer>();

			for (int i = 65; i < 91; i++) {
				valores.put(String.valueOf((char) i), i - 65);
				valores.put(String.valueOf((char) (i + 32)), i - 65 + 26);
			}

			String cadena;
			String result[];
			char[] grafo = null;
			char[] costoC = null;
			char[] costoD = null;

			if ((cadena = br.readLine()) != null) {
				result = cadena.split(",");
				String tCadena = "";
				for (int i = 0; i < result.length; i++) {
					tam=result[i].length();
					tCadena = new String(tCadena + result[i]);
				}
				grafo = tCadena.toCharArray();
			}
			if ((cadena = br.readLine()) != null) {
				result = cadena.split(",");
				String tCadena = "";
				for (int i = 0; i < result.length; i++) {
					tCadena = new String(tCadena + result[i]);
				}
				costoC = tCadena.toCharArray();
			}
			if ((cadena = br.readLine()) != null) {
				result = cadena.split(",");
				String tCadena = "";
				for (int i = 0; i < result.length; i++) {
					tCadena = new String(tCadena + result[i]);
				}
				costoD = tCadena.toCharArray();
			}

			g=new int[tam*tam];
			cC=new int[tam*tam];
			cD=new int[tam*tam];
			
			for (int i = 0; i < g.length; i++)
				if (grafo[i] == '1')
					g[i] = 1;
				else
					g[i] = 0;

			for (int i = 0; i < cC.length; i++)
				cC[i] = valores.get(String.valueOf(costoC[i]));

			for (int i = 0; i < cD.length; i++)
				cD[i] = valores.get(String.valueOf(costoD[i]));

			br.close();
		}
	}

	public int[] vertices(){
		return g;
	}
	
	public int[] costosD(){
		return cD;
	}
	
	public int[] costosC(){
		return cC;
	}
	
	public int tam(){
		return tam;
	}
}
