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
@Table(name = "tipolicencia")
public class TipoLicencia {

	@Id
	private String idtipolicencia;

	@Column(name = "claselicencia")
	private String claselicencia;

	@Column(name = "categorialicencia")
	private String categorialicencia;
}
