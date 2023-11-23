package pe.edu.upeu.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.libreria.entity.ConductorEntity;

@Repository
public interface ConductorInterface extends JpaRepository<ConductorEntity, Integer> {
}
