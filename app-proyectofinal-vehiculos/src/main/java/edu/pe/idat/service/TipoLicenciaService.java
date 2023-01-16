package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.TipoLicencia;
import edu.pe.idat.repository.TipoLicenciaRepository;

@Service
public class TipoLicenciaService {

	@Autowired
	private TipoLicenciaRepository tipolicenciaRepository;

	public List<TipoLicencia> listarTipoLicencia() {
		return tipolicenciaRepository.findAll();
	}

	public void registrarTipoLicencia(TipoLicencia tipolicencia) {
		if (tipolicencia.getIdtipolicencia().equals("0")) {
			tipolicenciaRepository.registrarTipoLicencia(tipolicencia.getClaselicencia(),
					tipolicencia.getCategorialicencia());
		} else {
			tipolicenciaRepository.actualizarTipoLicencia(tipolicencia.getIdtipolicencia(),
					tipolicencia.getClaselicencia(), tipolicencia.getCategorialicencia());
		}
	}

	public void eliminarTipoLicencia(TipoLicencia tipolicencia) {
		tipolicenciaRepository.deleteById(tipolicencia.getIdtipolicencia());
	}
}
