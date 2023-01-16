package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Vehiculo;
import edu.pe.idat.model.sp.VehiculoSp;
import edu.pe.idat.repository.VehiculoRepository;
import edu.pe.idat.repository.VehiculoSpRepository;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private VehiculoSpRepository vehiculoSpRepository;

    public List<VehiculoSp> listarVehiculos() {
        return vehiculoSpRepository.listarVehiculos();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo.getIdvehiculo().equals("0")) {
            vehiculoRepository.registrarVehiculo(vehiculo.getPlacavehiculo(),
                    vehiculo.getPartidaregistralvehiculo(),
                    vehiculo.getIdtipovehiculo());
        } else {
            vehiculoRepository.actualizarVehiculo(vehiculo.getIdvehiculo(),
                    vehiculo.getPlacavehiculo(),
                    vehiculo.getPartidaregistralvehiculo(),
                    vehiculo.getIdtipovehiculo());
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.deleteById(vehiculo.getIdvehiculo());
    }

}
