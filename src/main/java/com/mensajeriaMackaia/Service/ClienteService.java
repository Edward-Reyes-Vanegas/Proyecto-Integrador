package com.mensajeriaMackaia.Service;

import com.mensajeriaMackaia.Exceptions.InvalidDataException;
import com.mensajeriaMackaia.Model.Cliente;
import com.mensajeriaMackaia.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crear(Cliente cliente){
        if(cliente.getCedula()==null||cliente.getNombre()==null ||cliente.getApellidos()==null ||cliente.getCelular()==null ||cliente.getCorreoElectronico()==null ||cliente.getDireccion()==null ||cliente.getCiudad()==null){
            throw new InvalidDataException(("Algun dato esta vacio"));
        }
        this.clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente obtenerCliente(Long cedula){
        return clienteRepository.getOne(cedula);
    }

    public String actualizar (Cliente cliente){
        clienteRepository.save(cliente);
        return "Cliente Actualizado Exitosamente";
    }

    public String eliminar(Long cedula ){
        this.clienteRepository.deleteById(cedula);
        return "Cliente eliminado exitosamente";
    }
}