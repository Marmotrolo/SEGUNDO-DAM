package hilos.hilosnocooperativos;

public class MultiplosCooperativos {





public void multiplicar(int numero) {
	
	for (int i = 0; i < 10; i++) {
		System.out.println(i*numero);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}
