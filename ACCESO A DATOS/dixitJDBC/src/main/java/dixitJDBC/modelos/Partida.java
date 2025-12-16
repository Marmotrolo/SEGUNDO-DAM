package dixitJDBC.modelos;

import java.sql.Date;
import java.time.LocalDate;

public class Partida {
private int id;
private int torneo_id;
private Jugador narrador_id;
private Date fecha;
private Resultado resultado;
public Partida(int torneo_id, Jugador narrador_id, Date fecha, Resultado resultado) {
	super();
	this.id = id;
	this.torneo_id = torneo_id;
	this.narrador_id = narrador_id;
	this.fecha = fecha;
	this.resultado = resultado;
}


public Partida() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTorneo_id() {
	return torneo_id;
}
public void setTorneo_id(int torneo_id) {
	this.torneo_id = torneo_id;
}
public Jugador getNarrador_id() {
	return narrador_id;
}
public void setNarrador_id(Jugador narrador_id) {
	this.narrador_id = narrador_id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public Resultado getResultado() {
	return resultado;
}
public void setResultado(Resultado resultado) {
	this.resultado = resultado;
}
@Override
public String toString() {
	return "Partida [id=" + id + ", torneo_id=" + torneo_id + ", narrador_id=" + narrador_id + ", fecha=" + fecha
			+ ", resultado=" + resultado + "]";
}



}
