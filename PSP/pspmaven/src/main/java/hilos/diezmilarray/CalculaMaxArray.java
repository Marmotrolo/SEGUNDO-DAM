package hilos.diezmilarray;

import java.util.Arrays;

public class CalculaMaxArray implements Runnable {
private int[] tabla;
private int inicio;
private int fin;
private int valormaximo;

public CalculaMaxArray(int[] tabla, int inicio, int fin, int valormaximo) {
	super();
	this.tabla = tabla;
	this.inicio = inicio;
	this.fin = fin;
	this.valormaximo = valormaximo;
}

public int[] getTabla() {
	return tabla;
}

public void setTabla(int[] tabla) {
	this.tabla = tabla;
}

public int getInicio() {
	return inicio;
}

public void setInicio(int inicio) {
	this.inicio = inicio;
}

public int getFin() {
	return fin;
}

public void setFin(int fin) {
	this.fin = fin;
}

public int getValormaximo() {
	return valormaximo;
}

public void setValormaximo(int valormaximo) {
	this.valormaximo = valormaximo;
}

@Override
public String toString() {
	return "CalculaMaxArray [tabla=" + Arrays.toString(tabla) + ", inicio=" + inicio + ", fin=" + fin + ", valormaximo="
			+ valormaximo + "]";
}
public int calculamaxtramo() {
	int numeromax=tabla[inicio];
	for (int i = inicio; i < fin; i++) {
		if(numeromax<i)
	}
}

@Override
public void run() {

	
	
}


}
