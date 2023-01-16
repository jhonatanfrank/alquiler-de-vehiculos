package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.model.Conductor;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.model.sp.ConductorSp;
import edu.pe.idat.service.ConductorService;
import edu.pe.idat.service.TipoLicenciaService;
import edu.pe.idat.service.VehiculoService;

@Controller
@RequestMapping("/Conductor")
public class ConductorController {

	@Autowired
	private ConductorService conductorService;

	@Autowired
	private TipoLicenciaService tipolicenciaService;

	// vehiculo placa
	@Autowired
	private VehiculoService vehiculoservice;

	@GetMapping("/frmMantConductor")
	public String frmMantConductor(Model model) {
		model.addAttribute("listconductores", conductorService.listarConductores());
		model.addAttribute("listtipolicencia",
				tipolicenciaService.listarTipoLicencia());
		model.addAttribute("listvehiculo",
				vehiculoservice.listarVehiculos());
		return "Conductor/frmMantConductor";
	}

	@PostMapping("/registrarConductor")
	@ResponseBody
	public ResultadoResponse registrarConductor(@RequestBody Conductor conductor) {
		String mensaje = "Conductor registrado correctamente";
		Boolean respuesta = true;
		try {
			conductorService.registrarConductor(conductor);
		} catch (Exception e) {
			mensaje = "Conductor no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@DeleteMapping("/eliminarConductor")
	@ResponseBody
	public ResultadoResponse eliminarConductor(@RequestBody Conductor conductor) {
		String mensaje = "Conductor eliminado correctamente";
		Boolean respuesta = true;
		try {
			conductorService.eliminarConductor(conductor);
		} catch (Exception e) {
			mensaje = "Conductor no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarConductor")
	@ResponseBody
	public List<ConductorSp> listarConductor() {
		return conductorService.listarConductores();
	}

}
