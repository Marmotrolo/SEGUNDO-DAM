package modelo;

import java.util.Objects;

public class Enfrentamiento {

	private int id;
	private String fecha;
	private String descripcionevento;
	private Videojuego videojuego;
	private String equipoganador;
	public Enfrentamiento(int id, String fecha, String descripcionevento, Videojuego videojuego, String equipoganador) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcionevento = descripcionevento;
		this.videojuego = videojuego;
		this.equipoganador = equipoganador;
	}
	
	
	public Enfrentamiento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcionevento() {
		return descripcionevento;
	}
	public void setDescripcionevento(String descripcionevento) {
		this.descripcionevento = descripcionevento;
	}
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	public String getEquipoganador() {
		return equipoganador;
	}
	public void setEquipoganador(String equipoganador) {
		this.equipoganador = equipoganador;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enfrentamiento other = (Enfrentamiento) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Enfrentamiento [id=" + id + ", fecha=" + fecha + ", descripcionevento=" + descripcionevento + ", videojuego="
				+ videojuego + ", equipoganador= "+ equipoganador  ;
	}
	
	
}
