package concierto;

import java.util.Random;

public class Concierto {
private int numeroentradas;

public Concierto() {
	super();
	this.numeroentradas = 50;
}


public int getNumeroentradas() {
	return numeroentradas;
}




public void setNumeroentradas(int numeroentradas) {
	this.numeroentradas = numeroentradas;
}

public synchronized void vendeentradas(int entradaavender) {
	if(numeroentradas>=entradaavender ) {
	numeroentradas= numeroentradas-entradaavender;
	System.out.println("Terminal "+ Thread.currentThread().getName()+ " ha vendido"+ entradaavender+ "entradas \n Numero entradas restantes: " + numeroentradas );
	}
	else {
		System.out.println("ERROR: NUMERO DE ENTRADAS NEGATIVO: " + numeroentradas);
	}
	
}


@Override
public String toString() {
	return "Concierto [numeroentradas=" + numeroentradas + "]";
}


}
