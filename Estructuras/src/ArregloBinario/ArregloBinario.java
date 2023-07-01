package ArregloBinario;
import java.util.Random;


public class ArregloBinario {
	private int arreglo[];
	private int tam;
	ArregloBinario(int tam){
		arreglo=new int[tam];
		Random gen=new Random();
		for(int i=0;i<tam;i++){
			arreglo[i]=gen.nextInt(2);
		}
		this.tam=tam;
	}
	public int getValor(int i){
		return arreglo[i];
	}
	public void setValor(int i,int valor){
		if((i>=0 && i<tam)&&(valor==1||valor==0)){
			arreglo[i]=valor;
		}
	}
	public void imprimir(){
		for(int i=0;i<tam;i++){
			System.out.print(arreglo[i]+" ");
		}
		System.out.println(" ");
		for(int i=0;i<tam;i++){
			if(arreglo[i]==1)
				System.out.print("T ");
			else if(arreglo[i]==0)
				System.out.print("F ");
		}
		System.out.println(" ");
	}
}