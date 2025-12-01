package hilos.cajeroautomatico;

public class CuentaBancaria {
private double saldo;

public CuentaBancaria(double saldo) {
	super();
	this.saldo = saldo;
}

public double getSaldo() {
	return saldo;
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}


public synchronized void ingresar(double dineroingresa) {
	System.out.println("Ingresando: " +dineroingresa);
	this.saldo= saldo+dineroingresa;
	System.out.println("Ingresando, saldo actual: " + saldo);
}

public synchronized void retirar(double dineroretirar) throws CuentaException {
	if(this.saldo <= 0) {
		throw new CuentaException("No puedes retirar ");
	}
	else {
		System.out.println("Retirando: " + dineroretirar);
		setSaldo(saldo-dineroretirar);
		System.out.println("Retirando, saldo actual: " + saldo);
	}
}
@Override
public String toString() {
	return "CuentaBancaria [saldo=" + saldo + "]";
}


}
