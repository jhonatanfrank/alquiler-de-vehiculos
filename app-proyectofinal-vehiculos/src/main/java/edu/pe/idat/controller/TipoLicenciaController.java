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

import edu.pe.idat.model.TipoLicencia;

import edu.pe.idat.model.response.ResultadoResponse;

import edu.pe.idat.service.TipoLicenciaService;

@Controller
@RequestMapping("/TipoLicencia")
public class TipoLicenciaController {

    @Autowired
    private TipoLicenciaService tipolicenciaService;

    @GetMapping("/frmMantTipoLicencia")
    public String frmMantTipoLicencia(Model model) {
        model.addAttribute("listtipolicencias", tipolicenciaService.listarTipoLicencia());
        return "TipoLicencia/frmMantTipoLicencia";
    }

    @PostMapping("/registrarTipoLicencia")
    @ResponseBody
    public ResultadoResponse registrarTipoLicencia(@RequestBody TipoLicencia tipolicencia) {
        String mensaje = "Tipo de Licencia registrado correctamente";
        Boolean respuesta = true;
        try {

            tipolicenciaService.registrarTipoLicencia(tipolicencia);

        } catch (Exception e) {
            mensaje = "Tipo de Licencia no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarTipoLicencia")
    @ResponseBody
    public ResultadoResponse eliminarTipoLicencia(@RequestBody TipoLicencia tipolicencia) {
        String mensaje = "Tipo de Licencia eliminado correctamente";
        Boolean respuesta = true;
        try {

            tipolicenciaService.eliminarTipoLicencia(tipolicencia);

        } catch (Exception e) {
            mensaje = "Tipo de Licencia no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarTipoLicencia")
    @ResponseBody
    public List<TipoLicencia> listarTiposLicencias() {
        return tipolicenciaService.listarTipoLicencia();
    }
}
