package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
	   private int id;
	   private String name;
	   private double notaMedia;
	   private List<String> cursos;
	   private Direccion adress;
	   private List<Puntuacion> scores;
	 

	

	   public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

	   public Estudiante(int id, String name, double notaMedia, List<String> cursos, Direccion adress,
			List<Puntuacion> scores) {
		super();
		this.id = id;
		this.name = name;
		this.notaMedia = notaMedia;
		this.cursos = cursos;
		this.adress = adress;
		this.scores = scores;
	}



	   public int getId() {
		return id;
	}



	   public void setId(int id) {
		   this.id = id;
	   }



	   public String getName() {
		   return name;
	   }



	   public void setName(String name) {
		   this.name = name;
	   }



	   public double getNotaMedia() {
		   return notaMedia;
	   }



	   public void setNotaMedia(double notaMedia) {
		   this.notaMedia = notaMedia;
	   }



	   public List<String> getCursos() {
		   return cursos;
	   }



	   public void setCursos(List<String> cursos) {
		   this.cursos = cursos;
	   }



	   public Direccion getAdress() {
		   return adress;
	   }



	   public void setAdress(Direccion adress) {
		   this.adress = adress;
	   }



	   public List<Puntuacion> getScores() {
		   return scores;
	   }



	   public void setScores(List<Puntuacion> scores) {
		   this.scores = scores;
	   }



	   @Override
	   public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", notaMedia=" + notaMedia + ", cursos=" + cursos
				+ ", direccion=" + adress + ", puntuaciones=" + scores
				+ "]";
	   }

	   

	   
}
