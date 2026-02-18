package acceso.guzmanesSalud.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import acceso.guzmanesSalud.models.*;
import acceso.guzmanesSalud.services.PacienteServicesImpl;

@SpringBootApplication // Esto es vital para que Spring escanee tus clases
@EntityScan("acceso.guzmanesSalud.models") 
@EnableJpaRepositories("acceso.guzmanesSalud.repositories")
public class GestionaGuzmanesSalud {

    public static void main(String[] args) {
        // 1. Iniciamos Spring y guardamos el "contexto"
        ConfigurableApplicationContext context = SpringApplication.run(GestionaGuzmanesSalud.class, args);
        
        // 2. IMPORTANTE: Pedimos el servicio a Spring (NUNCA usar 'new')
        PacienteServicesImpl pacienteservices = context.getBean(PacienteServicesImpl.class);

        // 3. Ahora ya puedes usarlo normalmente
        Paciente p1 = new Paciente("Paciente 1", "48190946N");
        pacienteservices.crearPaciente(p1);
        
        Paciente p2 = new Paciente("Paciente 2", "48123542C");
        pacienteservices.crearPaciente(p2);
        
        long idbuscar = 1;
        System.out.println("Buscando paciente: " + pacienteservices.findById(idbuscar));
        
        ConstantesVitales constante1 = new ConstantesVitales(30.2, 14, 35, LocalDateTime.now());
        pacienteservices.agregarConstantesVitales(idbuscar, constante1);
    }
}