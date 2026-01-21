package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int idPersona; 
private String dni;

private String nombreapellido;
private int edad;
private String email;
private Date fechanacimiento;
private String telefono;

@ManyToMany
Set<Reunion>reuniones ;


public Persona(String dni, String nombreapellido, int edad, String email, Date fechanacimiento, String telefono) {
	super();
	this.dni = dni;
	this.nombreapellido = nombreapellido;
	this.edad = edad;
	this.email = email;
	this.fechanacimiento = fechanacimiento;
	this.telefono = telefono;
	this.reuniones= new HashSet<Reunion>();
}

public Persona() {
	super();
}

public void addReunion(Reunion r) {
	this.reuniones.add(r);
	if(!r.getPersonas().contains(r))
	{
		r.getPersonas().add(this);
	}
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public Set<Reunion> getReuniones() {
	return reuniones;
}

public String getNombreapellido() {
	return nombreapellido;
}

public void setNombreapellido(String nombreapellido) {
	this.nombreapellido = nombreapellido;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getFechanacimiento() {
	return fechanacimiento;
}

public void setFechanacimiento(Date fechanacimiento) {
	this.fechanacimiento = fechanacimiento;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public void setReuniones(Set<Reunion> reuniones) {
	this.reuniones = reuniones;
}


}
