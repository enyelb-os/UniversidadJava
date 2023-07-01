import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ArbolMenu {
	public static void main(String[] args) throws IOException {
		ArbolPerezoso arbol=new ArbolPerezoso();
		String ruta="/home/enyelb/Arbol.txt";
		BufferedReader br = new BufferedReader( new FileReader (ruta));
		String valor;
		while((valor=br.readLine())!= null){
			arbol.insertar(Integer.parseInt(valor));
		}
		br.close();
		arbol.preOrden();
	}
}
