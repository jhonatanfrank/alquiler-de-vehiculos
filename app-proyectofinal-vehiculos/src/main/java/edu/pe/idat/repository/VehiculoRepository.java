package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantRegistrarVehiculo(:placavehiculo, :partidaregistralvehiculo, :idtipovehiculo)}", nativeQuery = true)

    void registrarVehiculo(@Param("placavehiculo") String placavehiculo,
            @Param("partidaregistralvehiculo") String partidaregistralvehiculo,
            @Param("idtipovehiculo") String idtipovehiculo);

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarVehiculo (:idvehiculo, :placavehiculo, :partidaregistralvehiculo, :idtipovehiculo)}", nativeQuery = true)
    void actualizarVehiculo(@Param("idvehiculo") String idvehiculo,
            @Param("placavehiculo") String placavehiculo,
            @Param("partidaregistralvehiculo") String partidaregistralvehiculo,
            @Param("idtipovehiculo") String idtipovehiculo);

}
