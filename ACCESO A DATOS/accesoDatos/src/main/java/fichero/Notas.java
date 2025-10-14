package fichero;

public class Notas {
private double nota;

public Notas(double nota) {
	super();
	this.nota = nota;
}



public double getNota() {
	return nota;
}

public void setNota(double nota) {
	this.nota = nota;
}

@Override
public String toString() {
	return "Notas [nota=" + nota + "]";
}


}
