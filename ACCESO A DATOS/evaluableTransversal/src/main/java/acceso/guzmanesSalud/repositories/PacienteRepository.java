package acceso.guzmanesSalud.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.guzmanesSalud.models.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findAll();
    Optional findById(Long id);

}
