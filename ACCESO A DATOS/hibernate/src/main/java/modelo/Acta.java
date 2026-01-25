package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="acta")
public class Acta {
@OneToOne(cascade= CascadeType.ALL)
@JoinColumn(name="idReunion")
private Reunion reunion;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int idActa; 

private String contenido;

public Acta(Reunion reunion,  String contenido) {
	super();
	this.reunion = reunion;
	this.contenido = contenido;
}


public Acta() {
	super();
}


public Reunion getReunion() {
	return reunion;
}

public void setReunion(Reunion reunion) {
	this.reunion = reunion;
}

public int getIdActa() {
	return idActa;
}

public void setIdActa(int idActa) {
	this.idActa = idActa;
}

public String getContenido() {
	return contenido;
}

public void setContenido(String contenido) {
	this.contenido = contenido;
}

@Override
public String toString() {
	return "Acta [reunion=" + reunion + ", idActa=" + idActa + ", contenido=" + contenido + "]";
}



}
