package Cuenta;

public class Cuenta {
	private float saldo;
	Cuenta(float saldo){
		this.saldo=saldo;
	}
	public float getBalance(){
		return saldo;
	}
	public void setDepositar(float deposito){
		if(deposito>0)
			saldo=saldo+deposito;
		else
			System.out.println("El Depoaito no puede ser menor a 0");
	}
	public void setRetirar(float retiro){
		if(retiro>0 && saldo>=retiro){
			saldo=saldo-retiro;
		}
		else if(saldo<retiro)
		    System.out.println("El saldo es insuficiente");
		else 
			System.out.println("El Retiro no puede ser menor a 0");
	}
}
