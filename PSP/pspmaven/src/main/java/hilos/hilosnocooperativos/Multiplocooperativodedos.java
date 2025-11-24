package hilos.hilosnocooperativos;

public class Multiplocooperativodedos extends Thread{
private MultiplosCooperativos multiplocooperativo= new MultiplosCooperativos();

@Override
public void run() {
	// TODO Auto-generated method stub
	multiplocooperativo.multiplicar(2);
}




}
