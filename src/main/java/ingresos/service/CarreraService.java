package ingresos.service;

import ingresos.models.Carrera;
import ingresos.repository.ICarreraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    ICarreraRepository carreraRepository;

    public List<Carrera> getAllCarreras(){
        return carreraRepository.findAll();
    }

    public Carrera getCarreraById(int id){
        Optional<Carrera> carrera = carreraRepository.findById(id);
        if (carrera.isPresent()){
            return carrera.get();
        }else{
            throw new NoSuchElementException("Carrera no encontrada");
        }
    }

    public Carrera createCarrera(Carrera carrera){
        return carreraRepository.save(carrera);
    }

    public Carrera updateCarrera(int id, Carrera carreraData){
        Optional<Carrera> carrera = carreraRepository.findById(id);
        if(carrera.isPresent()){
            Carrera updateCarrera = carrera.get();

            BeanUtils.copyProperties(carreraData, updateCarrera, "idCarrera");

            return carreraRepository.save(updateCarrera);
        }else{
            throw new NoSuchElementException("Carrera no encontrada");
        }
    }

    public void deleteCarrera(int id){
        carreraRepository.deleteById(id);
    }
}
