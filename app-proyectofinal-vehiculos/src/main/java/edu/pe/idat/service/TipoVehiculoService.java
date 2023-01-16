package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.TipoVehiculo;
import edu.pe.idat.repository.TipoVehiculoRepository;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipovehiculorepository;

    public List<TipoVehiculo> listarTipoVehiculo() {
        return tipovehiculorepository.findAll();
    }

    public void registrarTipoVehiculo(TipoVehiculo tipovehiculo) {
        if (tipovehiculo.getIdtipovehiculo().equals("0")) {
            tipovehiculorepository.registrarTipoVehiculo(tipovehiculo.getClasecategoriavehiculo(),
                    tipovehiculo.getDescripcioncategoriavehiculo());
        } else {
            tipovehiculorepository.actualizarTipoVehiculo(tipovehiculo.getIdtipovehiculo(),
                    tipovehiculo.getClasecategoriavehiculo(), tipovehiculo.getDescripcioncategoriavehiculo());
        }
    }

    public void eliminarTipoVehiculo(TipoVehiculo tipovehiculo) {
        tipovehiculorepository.deleteById(tipovehiculo.getIdtipovehiculo());
    }
}
