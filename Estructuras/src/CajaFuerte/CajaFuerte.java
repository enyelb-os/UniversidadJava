package CajaFuerte;

public class CajaFuerte {
	private int arreglo[];

	CajaFuerte(int c1,int c2,int c3){
		arreglo=new int[3];
		arreglo[0]=c1;
		arreglo[1]=c2;
		arreglo[2]=c3;
	}
	public void AbrirCaja(int c1,int c2,int c3){
		if(arreglo[0]==c1 && arreglo[1]==c2 && arreglo[2]==c3){
			System.out.println("Caja Abierta");
		}
		else 
			System.out.println("Combinacion Incorrecta");
	}
	public void setCambiarC(int c1,int c2,int c3){
		if(arreglo[0]==c1 && arreglo[1]==c2 && arreglo[2]==c3){
			arreglo[0]=c1;//scanner
			arreglo[1]=c2;
			arreglo[2]=c3;
			System.out.println("Combinacion Cambiada");
		}
		else 
			System.out.println("Combinacion Incorrecta");
	}
}