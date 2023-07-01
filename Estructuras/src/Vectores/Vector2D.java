package Vectores;

public class Vector2D {
	protected float x;
	protected float y;
	
	Vector2D(float x,float y){
		this.x=x;
		this.y=y;
	}
	public float getValorX(){
		return x;
	}
	public float getValorY(){
		return y;
	}
	public float longitud(){
		float res;
		float a=getValorX();
		float b=getValorY();
		res=(float) Math.sqrt((Math.pow(a,2))+(Math.pow(b,2)));
		return res;
	}
	public Vector2D suma(Vector2D otroVector){
		float a=otroVector.getValorX()+x;
		float b=otroVector.getValorY()+y;
		Vector2D res=new Vector2D(a,b);
		return res;
	}
	public Vector2D resta(Vector2D otroVector){
		float a=otroVector.getValorX()-x;
		float b=otroVector.getValorY()-y;
		Vector2D res=new Vector2D(a,b);
		return res;
	}
	public Vector2D normalizar(){
		float a=getValorX()/longitud();
		float b=getValorY()/longitud();
		Vector2D res=new Vector2D(a,b);
		return res;
	}
	public void imprimir(){
		System.out.print(x+" ");
		System.out.println(y+" ");
	}
}
