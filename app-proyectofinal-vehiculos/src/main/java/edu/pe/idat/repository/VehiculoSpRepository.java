package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.VehiculoSp;

@Repository
public interface VehiculoSpRepository extends JpaRepository<VehiculoSp, String> {

    @Query(value = "{call  sp_ManteListarVehiculo()}", nativeQuery = true)
    List<VehiculoSp> listarVehiculos();

}
