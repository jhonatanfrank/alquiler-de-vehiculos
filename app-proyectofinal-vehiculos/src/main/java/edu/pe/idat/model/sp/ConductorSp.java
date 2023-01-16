package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ConductorSp {

	@Id
	private String idconductor;

	private String dniconductor;

	private String nombreconductor;

	private String apellidoconductor;

	private String direccionconductor;

	private String telefonoconductor;

	private String sexoconductor;

	private String distritoconductor;

	private Integer estadoconductor;

	private String idtipolicencia;

	private String claselicencia;

	private String idvehiculo;

	private String placavehiculo;

}
