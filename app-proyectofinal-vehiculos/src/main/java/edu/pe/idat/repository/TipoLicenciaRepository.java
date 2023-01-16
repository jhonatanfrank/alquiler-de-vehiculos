package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.TipoLicencia;

@Repository
public interface TipoLicenciaRepository extends JpaRepository<TipoLicencia, String> {

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantRegistrarTipoLicencia(:claselicencia, :categorialicencia)}", nativeQuery = true)

    void registrarTipoLicencia(@Param("claselicencia") String claselicencia,
            @Param("categorialicencia") String categorialicencia);

    @Transactional
    @Modifying
    @Query(value = "{call sp_MantActualizarTipoLicencia (:idtipolicencia, :claselicencia, :categorialicencia)}", nativeQuery = true)
    void actualizarTipoLicencia(@Param("idtipolicencia") String idtipolicencia,
            @Param("claselicencia") String claselicencia,
            @Param("categorialicencia") String categorialicencia);

}
