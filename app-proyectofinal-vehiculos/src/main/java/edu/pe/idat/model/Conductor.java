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
@Table(name = "conductor")
public class Conductor {

	@Id
	private String idconductor;

	@Column(name = "dniconductor")
	private String dniconductor;

	@Column(name = "nombreconductor")
	private String nombreconductor;

	@Column(name = "apellidoconductor")
	private String apellidoconductor;

	@Column(name = "direccionconductor")
	private String direccionconductor;

	@Column(name = "telefonoconductor")
	private String telefonoconductor;

	@Column(name = "sexoconductor")
	private String sexoconductor;

	@Column(name = "distritoconductor")
	private String distritoconductor;

	@Column(name = "estadoconductor")
	private Integer estadoconductor;

	@Column(name = "idtipolicencia")
	private String idtipolicencia;

	@Column(name = "idvehiculo")
	private String idvehiculo;
}
