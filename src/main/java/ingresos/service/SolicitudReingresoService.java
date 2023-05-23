package ingresos.service;

import ingresos.models.SolicitudReingreso;
import ingresos.repository.ISolicitudReingresoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SolicitudReingresoService {

    @Autowired
    ISolicitudReingresoRepository solicitudReingresoRepository;

    public List<SolicitudReingreso> getAllSolicitudesReingreso() {
        return solicitudReingresoRepository.findAll();
    }

    public SolicitudReingreso getSolicitudReingresoById(int id) {
        Optional<SolicitudReingreso> solicitudReingreso = solicitudReingresoRepository.findById(id);
        if (solicitudReingreso.isPresent()) {
            return solicitudReingreso.get();
        } else {
            throw new NoSuchElementException("Solicitud de Reingreso no encontrada");
        }
    }

    public SolicitudReingreso createSolicitudReingreso(SolicitudReingreso solicitudReingreso) {
        return solicitudReingresoRepository.save(solicitudReingreso);
    }

    public SolicitudReingreso updateSolicitudReingreso(int id, SolicitudReingreso solicitudReingresoData) {
        Optional<SolicitudReingreso> solicitudReingreso = solicitudReingresoRepository.findById(id);
        if (solicitudReingreso.isPresent()) {
            SolicitudReingreso updatedSolicitudReingreso = solicitudReingreso.get();

            BeanUtils.copyProperties(solicitudReingresoData, updatedSolicitudReingreso, "idSolicitudReingreso");

            return solicitudReingresoRepository.save(updatedSolicitudReingreso);
        } else {
            throw new NoSuchElementException("Solicitud de Reingreso no encontrada");
        }
    }

    public void deleteSolicitudReingreso(int id) {
        solicitudReingresoRepository.deleteById(id);
    }
}
