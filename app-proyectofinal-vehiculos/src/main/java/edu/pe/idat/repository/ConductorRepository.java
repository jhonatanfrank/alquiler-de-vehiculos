package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, String> {

        @Transactional
        @Modifying
        @Query(value = " {call sp_MantRegistrarConductor(:dniconductor, :nombreconductor,:apellidoconductor,:direccionconductor,:telefonoconductor,:sexoconductor,:distritoconductor,:estadoconductor,:idtipolicencia,:idvehiculo)} ", nativeQuery = true)
        void registrarConductor(
                        @Param("dniconductor") String dniconductor,
                        @Param("nombreconductor") String nombreconductor,
                        @Param("apellidoconductor") String apellidoconductor,
                        @Param("direccionconductor") String direccionconductor,
                        @Param("telefonoconductor") String telefonoconductor,
                        @Param("sexoconductor") String sexoconductor,
                        @Param("distritoconductor") String distritoconductor,
                        @Param("estadoconductor") Integer estadoconductor,
                        @Param("idtipolicencia") String idtipolicencia,
                        @Param("idvehiculo") String idvehiculo);

        @Transactional
        @Modifying
        @Query(value = " {call sp_MantActualizarConductor(:idconductor,:dniconductor, :nombreconductor,:apellidoconductor,:direccionconductor,:telefonoconductor,:sexoconductor,:distritoconductor,:estadoconductor,:idtipolicencia,:idvehiculo)} ", nativeQuery = true)
        void actualizarConductor(
                        @Param("idconductor") String idconductor,
                        @Param("dniconductor") String dniconductor,
                        @Param("nombreconductor") String nombreconductor,
                        @Param("apellidoconductor") String apellidoconductor,
                        @Param("direccionconductor") String direccionconductor,
                        @Param("telefonoconductor") String telefonoconductor,
                        @Param("sexoconductor") String sexoconductor,
                        @Param("distritoconductor") String distritoconductor,
                        @Param("estadoconductor") Integer estadoconductor,
                        @Param("idtipolicencia") String idtipolicencia,
                        @Param("idvehiculo") String idvehiculo);
}
