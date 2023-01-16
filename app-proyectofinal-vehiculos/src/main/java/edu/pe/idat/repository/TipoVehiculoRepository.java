package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.TipoVehiculo;

@Repository
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, String> {

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantRegistrarTipoVehiculo(:clasecategoriavehiculo, :descripcioncategoriavehiculo)}", nativeQuery = true)

    void registrarTipoVehiculo(@Param("clasecategoriavehiculo") String clasecategoriavehiculo,
            @Param("descripcioncategoriavehiculo") String descripcioncategoriavehiculo);

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarTipoVehiculo (:idtipovehiculo, :clasecategoriavehiculo, :descripcioncategoriavehiculo)}", nativeQuery = true)
    void actualizarTipoVehiculo(@Param("idtipovehiculo") String idtipovehiculo,
            @Param("clasecategoriavehiculo") String clasecategoriavehiculo,
            @Param("descripcioncategoriavehiculo") String descripcioncategoriavehiculo);

}
