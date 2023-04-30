package com.mensajeriaMackaia.Service;

import com.mensajeriaMackaia.Model.Empleado;
import com.mensajeriaMackaia.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService{

    private EmpleadoRepository empleadoRepository;
    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {

        this.empleadoRepository = empleadoRepository;
    }

    public Empleado crear(Empleado empleado){
        this.empleadoRepository.save(empleado);
        return empleado;
    }

    public Empleado obtenerEmpleado(Long cedula){
        return empleadoRepository.getOne(cedula);
    }

    public String actualizar (Empleado empleado){
        empleadoRepository.save(empleado);
        return "Cliente Actualizado Exitosamente";
    }

    public String eliminar(Long cedula ){
        this.empleadoRepository.deleteById(cedula);
        return "Empleado eliminado exitosamente";
    }
}