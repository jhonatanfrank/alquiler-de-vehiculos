package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.ConductorSp;

@Repository
public interface ConductorSpRepository extends JpaRepository<ConductorSp, String> {
	@Query(value = "{call sp_MantListarConductor()}", nativeQuery = true)
	List<ConductorSp> listarConductores();
}
