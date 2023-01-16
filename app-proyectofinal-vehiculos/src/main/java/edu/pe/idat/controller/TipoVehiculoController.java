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

import edu.pe.idat.model.TipoVehiculo;

import edu.pe.idat.model.response.ResultadoResponse;

import edu.pe.idat.service.TipoVehiculoService;

@Controller
@RequestMapping("/TipoVehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipovehiculoService;

    @GetMapping("/frmMantTipoVehiculo")
    public String frmMantTipoVehiculo(Model model) {
        model.addAttribute("listtipovehiculos", tipovehiculoService.listarTipoVehiculo());
        return "TipoVehiculo/frmMantTipoVehiculo";
    }

    @PostMapping("/registrarTipoVehiculo")
    @ResponseBody
    public ResultadoResponse registrarTipoVehiculo(@RequestBody TipoVehiculo tipovehiculo) {
        String mensaje = "Tipo de Vehiculo registrado correctamente";
        Boolean respuesta = true;
        try {

            tipovehiculoService.registrarTipoVehiculo(tipovehiculo);

        } catch (Exception e) {
            mensaje = "Tipo de Vehiculo no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarTipoVehiculo")
    @ResponseBody
    public ResultadoResponse eliminarTipoVehiculo(@RequestBody TipoVehiculo tipovehiculo) {
        String mensaje = "Tipo de Vehiculo eliminado correctamente";
        Boolean respuesta = true;
        try {

            tipovehiculoService.eliminarTipoVehiculo(tipovehiculo);

        } catch (Exception e) {
            mensaje = "Tipo de Vehiculo no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarTipoVehiculo")
    @ResponseBody
    public List<TipoVehiculo> listarTiposVehiculos() {
        return tipovehiculoService.listarTipoVehiculo();
    }
}
