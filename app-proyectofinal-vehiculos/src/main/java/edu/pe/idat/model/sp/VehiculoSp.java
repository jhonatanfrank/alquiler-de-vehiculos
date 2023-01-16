package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehiculoSp {
    @Id
    private String idvehiculo;

    private String placavehiculo;

    private String partidaregistralvehiculo;

    private String idtipovehiculo;

    private String clasecategoriavehiculo;
}
