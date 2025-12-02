package hilos.cajeroautomatico;

public class HiloIngresarDinero extends Thread {
private CuentaBancaria cuentabanco;
private double dineroingresar;


public HiloIngresarDinero(CuentaBancaria cuentabanco, double dineroingresar) {
super();
this.cuentabanco = cuentabanco;
this.dineroingresar = ((double)(Math.random()*500+1));
}

	public CuentaBancaria getCuentabanco() {
	return cuentabanco;
}



public void setCuentabanco(CuentaBancaria cuentabanco) {
	this.cuentabanco = cuentabanco;
}



public double getDineroingresar() {
	return dineroingresar;
}



public void setDineroingresar(double dineroingresar) {
	this.dineroingresar = dineroingresar;
}









	@Override
	public void run() {

		cuentabanco.ingresar(dineroingresar);
		
		super.run();
	}

}
