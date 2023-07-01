package Cuenta;


public class MenuCuenta {
	public static void main(String[] args) {
		Cuenta en=new Cuenta(464);
		System.out.println("Balance "+en.getBalance());
		en.setDepositar(1000);
		System.out.println("Balance "+en.getBalance());
		en.setRetirar(464);
		System.out.println("Balance "+en.getBalance());
		en.setDepositar(-1);
		System.out.println("Balance "+en.getBalance());
		en.setRetirar(-100);
		System.out.println("Balance "+en.getBalance());
		en.setRetirar(1000);
		System.out.println("Balance "+en.getBalance());
	}

}
