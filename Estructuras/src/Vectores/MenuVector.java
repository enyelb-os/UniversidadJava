package Vectores;


public class MenuVector {

	public static void main(String[] args) {
		Vector2D vec1=new Vector2D(1,2);
		Vector2D vec2=new Vector2D(3,4);
		Vector2D vecS=vec1.suma(vec2);
		Vector2D vecR=vec2.resta(vec1);
		Vector2D vecN=vec1.normalizar();
		
		System.out.print("Vector2D 1: ");
		vec1.imprimir();
		System.out.print("Vector2D 2: ");
		vec2.imprimir();
		System.out.print("Suma :      ");
		vecS.imprimir();
		System.out.print("Resta :     ");
		vecR.imprimir();
		System.out.print("Normaliza2: ");
		vecN.imprimir();
		
		Vector3D vec3=new Vector3D(5,6,7);
		Vector3D vec4=new Vector3D(8,9,1);
		Vector3D vectS=vec3.suma(vec4);
		Vector3D vectR=vec4.resta(vec3);
		Vector3D vectN=vec3.normalizar();
		
		System.out.println(" ");
		System.out.print("Vector3D 1: ");
		vec3.imprimir();
		System.out.print("Vector3D 2: ");
		vec4.imprimir();
		System.out.print("Suma :      ");
		vectS.imprimir();
		System.out.print("Resta :     ");
		vectR.imprimir();
		System.out.print("Normaliza2: ");
		vectN.imprimir();
	}
}
