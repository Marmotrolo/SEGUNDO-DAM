package Controlador;

import java.util.Arrays;

import Modelo.Usuario;
import Repositorio.Usuariorepository;
import Service.Usuarioservicio;

public class Usuariomain {

	public static void main(String[] args) {
		Usuario u = new Usuario("Felipe");
		Usuarioservicio usuarioServicio= new Usuarioservicio();
		
		usuarioServicio.getRepo().addusuario(u);
		System.out.println(usuarioServicio.getRepo().readusuario(u));
	
		
		System.out.println(usuarioServicio.getRepo().toString()) ;
		usuarioServicio.deleteusuario(u);
		System.out.println(usuarioServicio.getRepo().toString());
	}
}
