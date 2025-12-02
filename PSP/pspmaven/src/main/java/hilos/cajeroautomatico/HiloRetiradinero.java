package hilos.cajeroautomatico;

public class HiloRetiradinero extends Thread {
	private CuentaBancaria cuentabanco;
	private double dineroingresar;
	
	

	public HiloRetiradinero(CuentaBancaria cuentabanco, double dineroingresar) {
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

		try {
			cuentabanco.retirar(dineroingresar);
		} catch (CuentaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
	
	
	
	
}
