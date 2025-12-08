package matchband.modelo;

import java.util.List;
import java.util.Objects;

public class Perfil {
private int id;
private List<String> instrumentos;
private int experiencia;
private Genero genero;
private String biografia;
private boolean busca_banda;
public Perfil(int id, List<String> instrumentos, int experiencia, Genero genero, String biografia,
		boolean busca_banda) {
	super();
	this.id = id;
	this.instrumentos = instrumentos;
	this.experiencia = experiencia;
	this.genero = genero;
	this.biografia = biografia;
	this.busca_banda = busca_banda;
}
public Perfil() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<String> getInstrumentos() {
	return instrumentos;
}
public void setInstrumentos(List<String> instrumentos) {
	this.instrumentos = instrumentos;
}
public int getExperiencia() {
	return experiencia;
}
public void setExperiencia(int experiencia) {
	this.experiencia = experiencia;
}
public Genero getGenero() {
	return genero;
}
public void setGenero(Genero genero) {
	this.genero = genero;
}
public String getBiografia() {
	return biografia;
}
public void setBiografia(String biografia) {
	this.biografia = biografia;
}
public boolean isBusca_banda() {
	return busca_banda;
}
public void setBusca_banda(boolean busca_banda) {
	this.busca_banda = busca_banda;
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
	Perfil other = (Perfil) obj;
	return id == other.id;
}
@Override
public String toString() {
	return "Perfil [id=" + id + ", instrumentos=" + instrumentos + ", experiencia=" + experiencia + ", genero=" + genero
			+ ", biografia=" + biografia + ", busca_banda=" + busca_banda + "]";
}



}
