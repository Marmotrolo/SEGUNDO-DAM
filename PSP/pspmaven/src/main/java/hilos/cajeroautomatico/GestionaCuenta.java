package hilos.cajeroautomatico;

public class GestionaCuenta {
double aleatorio;

public static void main(String[] args) {
	
GestionaCuenta f= new GestionaCuenta();
	CuentaBancaria cuenta1= new CuentaBancaria(200);
	
	HiloIngresarDinero hiloingresa1= new HiloIngresarDinero(cuenta1, f.aleatorio);
	HiloIngresarDinero hiloingresa2= new HiloIngresarDinero(cuenta1, f.aleatorio);
	HiloRetiradinero hiloretira1= new HiloRetiradinero(cuenta1, f.aleatorio);
	HiloRetiradinero hiloretira2= new HiloRetiradinero(cuenta1, f.aleatorio);
	

	hiloingresa1.start();
	hiloretira1.start();

	hiloingresa2.start();
	hiloretira2.start();

	try {
		hiloingresa1.join();
		hiloretira1.join();
		hiloingresa2.join();
		hiloretira2.join();


	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
