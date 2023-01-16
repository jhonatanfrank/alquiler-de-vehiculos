package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipovehiculo")
public class TipoVehiculo {

    @Id
    private String idtipovehiculo;

    @Column(name = "clasecategoriavehiculo")
    private String clasecategoriavehiculo;

    @Column(name = "descripcioncategoriavehiculo")
    private String descripcioncategoriavehiculo;

}
