package matchband.modelo;

import java.util.List;
import java.util.Objects;

public class Musico implements Comparable<Musico> {
private int id;
private String nombreCompleto;
private String correoelectronico;
private String fechanacimiento;
private Perfil perfil;
private List<Anuncio> anuncios;


public Musico() {
	super();
	// TODO Auto-generated constructor stub
}
public Musico(int id, String nombreCompleto, String correoelectronico, String fechanacimiento, Perfil perfil,
		List<Anuncio> anuncios) {
	super();
	this.id = id;
	this.nombreCompleto = nombreCompleto;
	this.correoelectronico = correoelectronico;
	this.fechanacimiento = fechanacimiento;
	this.perfil = perfil;
	this.anuncios = anuncios;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombreCompleto() {
	return nombreCompleto;
}
public void setNombreCompleto(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}
public String getCorreoelectronico() {
	return correoelectronico;
}
public void setCorreoelectronico(String correoelectronico) {
	this.correoelectronico = correoelectronico;
}
public String getFechanacimiento() {
	return fechanacimiento;
}
public void setFechanacimiento(String fechanacimiento) {
	this.fechanacimiento = fechanacimiento;
}
public Perfil getPerfil() {
	return perfil;
}
public void setPerfil(Perfil perfil) {
	this.perfil = perfil;
}
public List<Anuncio> getAnuncios() {
	return anuncios;
}
public void setAnuncios(List<Anuncio> anuncios) {
	this.anuncios = anuncios;
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
	Musico other = (Musico) obj;
	return id == other.id;
}
@Override
public String toString() {
	return "Musico [id=" + id + ", nombreCompleto=" + nombreCompleto + ", correoelectronico=" + correoelectronico
			+ ", fechanacimiento=" + fechanacimiento + ", perfil=" + perfil + ", anuncios=" + anuncios + "]";
}

@Override
public int compareTo(Musico o) {
	
	
	return this.nombreCompleto.compareTo(o.nombreCompleto);
}




}
