package concierto;



import java.util.ArrayList;
import java.util.List;

public class GestionaConcierto {

	public static void main(String[] args) {
		Concierto concierto= new Concierto();
		
		List<Thread> terminales= new ArrayList<>();
		for (int i = 0; i < 5; i++) {
            String nombrePersonalizado = "Terminal-" + i;
            
			Terminal terminal = new Terminal(nombrePersonalizado, concierto);
            
			Thread t = new Thread(terminal, nombrePersonalizado); 
			terminales.add(t);
		}
		for (Thread thread : terminales) {
			
			thread.start();
		
	
	}
		
	for (Thread thread : terminales) {
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
		System.out.println(concierto.getNumeroentradas());

	
}
}