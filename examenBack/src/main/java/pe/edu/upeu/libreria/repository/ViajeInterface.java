package pe.edu.upeu.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.libreria.entity.ViajeEntity;

@Repository
public interface ViajeInterface extends JpaRepository<ViajeEntity, Integer> {
}
