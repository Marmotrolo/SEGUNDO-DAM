package acceso.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;

public interface VacunaRepository extends JpaRepository<Vacuna, Long> {

}
