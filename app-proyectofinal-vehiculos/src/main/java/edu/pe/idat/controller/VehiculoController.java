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

import edu.pe.idat.model.Vehiculo;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.model.sp.VehiculoSp;
import edu.pe.idat.service.TipoVehiculoService;
import edu.pe.idat.service.VehiculoService;

@Controller
@RequestMapping("/Vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private TipoVehiculoService tipovehiculoService;

    @GetMapping("/frmMantVehiculo")
    public String frmMantVehiculo(Model model) {
        model.addAttribute("listvehiculos", vehiculoService.listarVehiculos());
        model.addAttribute("listtipovehiculos", tipovehiculoService.listarTipoVehiculo());
        return "Vehiculo/frmMantVehiculo";
    }

    @PostMapping("/registrarVehiculo")
    @ResponseBody
    public ResultadoResponse registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        String mensaje = "Vehiculo registrado correctamente";
        Boolean respuesta = true;
        try {

            vehiculoService.registrarVehiculo(vehiculo);

        } catch (Exception e) {
            mensaje = "Vehiculo no registrado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarVehiculo")
    @ResponseBody
    public ResultadoResponse eliminarVehiculo(@RequestBody Vehiculo vehiculo) {
        String mensaje = "Vehiculo eliminado correctamente";
        Boolean respuesta = true;
        try {

            vehiculoService.eliminarVehiculo(vehiculo);

        } catch (Exception e) {
            mensaje = "Vehiculo no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarVehiculo")
    @ResponseBody
    public List<VehiculoSp> listarVehiculos() {
        return vehiculoService.listarVehiculos();
    }

}
