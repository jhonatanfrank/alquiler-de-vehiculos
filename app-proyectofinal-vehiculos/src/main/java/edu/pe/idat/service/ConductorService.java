package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Conductor;
import edu.pe.idat.model.sp.ConductorSp;
import edu.pe.idat.repository.ConductorRepository;
import edu.pe.idat.repository.ConductorSpRepository;

@Service
public class ConductorService {

	@Autowired
	private ConductorRepository conductorRepository;

	@Autowired
	private ConductorSpRepository conductorSpRepository;

	public List<ConductorSp> listarConductores() {
		return conductorSpRepository.listarConductores();
	}

	public void registrarConductor(Conductor conductor) {
		if (conductor.getIdconductor().equals("0")) {
			conductorRepository.registrarConductor(conductor.getDniconductor(), conductor.getNombreconductor(),
					conductor.getApellidoconductor(), conductor.getDireccionconductor(),
					conductor.getTelefonoconductor(), conductor.getSexoconductor(), conductor.getDistritoconductor(),
					conductor.getEstadoconductor(), conductor.getIdtipolicencia(), conductor.getIdvehiculo());
		} else {
			conductorRepository.actualizarConductor(conductor.getIdconductor(), conductor.getDniconductor(),
					conductor.getNombreconductor(), conductor.getApellidoconductor(), conductor.getDireccionconductor(),
					conductor.getTelefonoconductor(), conductor.getSexoconductor(), conductor.getDistritoconductor(),
					conductor.getEstadoconductor(), conductor.getIdtipolicencia(), conductor.getIdvehiculo());
		}
	}

	public void eliminarConductor(Conductor conductor) {
		conductorRepository.deleteById(conductor.getIdconductor());
	}
}
