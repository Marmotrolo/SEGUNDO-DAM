package ejerciciorepaso2.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Conversacion {
private static int contador;
private String identificador;
private String pregunta;
private String respuesta;
private LocalDate fechaConversacion;
private int numvaloracionespositivas;
private TipoAgente tipo;
public Conversacion() {
	super();
	// TODO Auto-generated constructor stub
}
public Conversacion(String pregunta, String respuesta, TipoAgente tipo) {
	super();
	contador++;
	this.identificador= (Integer.toString(fechaConversacion.getDayOfMonth()) + contador);
	this.pregunta = pregunta;
	this.respuesta = respuesta;
	this.tipo = tipo;
}
public Conversacion(String pregunta, String respuesta, LocalDate fechaConversacion, int numvaloracionespositivas,
		TipoAgente tipo) {
	super();
	contador++;
	this.identificador= (Integer.toString(fechaConversacion.getDayOfMonth()) + contador);
	this.pregunta = pregunta;
	this.respuesta = respuesta;
	this.fechaConversacion = fechaConversacion;
	this.numvaloracionespositivas = numvaloracionespositivas;
	this.tipo = tipo;
}
public static int getContador() {
	return contador;
}
public static void setContador(int contador) {
	Conversacion.contador = contador;
}
public String getIdentificador() {
	return identificador;
}
public void setIdentificador(String identificador) {
	this.identificador = identificador;
}
public String getPregunta() {
	return pregunta;
}
public void setPregunta(String pregunta) {
	this.pregunta = pregunta;
}
public String getRespuesta() {
	return respuesta;
}
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}
public LocalDate getFechaConversacion() {
	return fechaConversacion;
}
public void setFechaConversacion(LocalDate fechaConversacion) {
	this.fechaConversacion = fechaConversacion;
}
public int getNumvaloracionespositivas() {
	return numvaloracionespositivas;
}
public void setNumvaloracionespositivas(int numvaloracionespositivas) {
	this.numvaloracionespositivas = numvaloracionespositivas;
}
public TipoAgente getTipo() {
	return tipo;
}
public void setTipo(TipoAgente tipo) {
	this.tipo = tipo;
}
@Override
public int hashCode() {
	return Objects.hash(fechaConversacion, identificador, numvaloracionespositivas, pregunta, respuesta, tipo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Conversacion other = (Conversacion) obj;
	return Objects.equals(fechaConversacion, other.fechaConversacion)
			&& Objects.equals(identificador, other.identificador)
			&& numvaloracionespositivas == other.numvaloracionespositivas && Objects.equals(pregunta, other.pregunta)
			&& Objects.equals(respuesta, other.respuesta) && tipo == other.tipo;
}




}
