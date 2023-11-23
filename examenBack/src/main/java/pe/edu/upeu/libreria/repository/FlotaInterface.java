package pe.edu.upeu.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.libreria.entity.FlotaEntity;

@Repository
public interface FlotaInterface extends JpaRepository<FlotaEntity, Integer> {
}
