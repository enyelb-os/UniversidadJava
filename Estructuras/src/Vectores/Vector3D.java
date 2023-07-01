package Vectores;


public class Vector3D extends Vector2D{
	private float z;
	Vector3D(float x,float y,float z){
		super(x,y);
		this.z=z;
	}
	public float getValorZ(){
		return z;
	}
	public float longitud(){
		float res;
		float a=getValorX();
		float b=getValorY();
		float c=getValorZ();
		res=(float) Math.sqrt((Math.pow(a, 2))+(Math.pow(b, 2))+(Math.pow(c, 2)));
		return res;
	}
	public Vector3D suma(Vector3D otroVector){
		float a=otroVector.getValorX()+x;
		float b=otroVector.getValorY()+y;
        float c=otroVector.getValorZ()+z;
		Vector3D res=new Vector3D(a,b,c);
		return res;
	}
	public Vector3D resta(Vector3D otroVector){
		float a=otroVector.getValorX()-x;
		float b=otroVector.getValorY()-y;
		float c=otroVector.getValorZ()-z;
		Vector3D res=new Vector3D(a,b,c);
		return res;
	}
	public Vector3D normalizar(){
		float a=getValorX()/longitud();
		float b=getValorY()/longitud();
		float c=getValorZ()/longitud();
		Vector3D res=new Vector3D(a,b,c);
		return res;
	}
	public void imprimir(){
		System.out.print(x+" ");
		System.out.print(y+" ");
		System.out.println(z+" ");
	}
}
