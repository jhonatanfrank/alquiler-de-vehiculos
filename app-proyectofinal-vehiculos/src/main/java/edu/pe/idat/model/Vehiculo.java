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
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    private String idvehiculo;

    @Column(name = "placavehiculo")
    private String placavehiculo;

    @Column(name = "partidaregistralvehiculo")
    private String partidaregistralvehiculo;

    @Column(name = "idtipovehiculo")
    private String idtipovehiculo;

}
