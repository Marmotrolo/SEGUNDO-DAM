package boletin1;

public class Calculasuma {
	
	
	public static void main(String[] args) {
		String tipo= args[0];
		 int numero= Integer.parseInt(args[1]);
		 Calculasuma calcula= new Calculasuma();
		 System.out.println(calcula.calculasuma( tipo,numero));
	}
	
	
	
	public int calculasuma( String tipo,int numero) {
		
		int suma=0;
		
		for( int i=0; i<=numero; i++) {
			if(tipo.equals("par") && i%2==0) {
			suma= suma+i;	
			}
			
			else if(tipo.equals("impar") && i%2!=0) {
				suma= suma+i;
			}
		}
		return suma;
		
		
	}
}
