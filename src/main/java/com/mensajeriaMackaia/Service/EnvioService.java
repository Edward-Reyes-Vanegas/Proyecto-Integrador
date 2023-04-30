package com.mensajeriaMackaia.Service;

import com.mensajeriaMackaia.Dto.EnvioDto;
import com.mensajeriaMackaia.Exceptions.DataNotFoundException;
import com.mensajeriaMackaia.Exceptions.InvalidDataException;
import com.mensajeriaMackaia.Model.*;
import com.mensajeriaMackaia.Repository.ClienteRepository;
import com.mensajeriaMackaia.Repository.EmpleadoRepository;
import com.mensajeriaMackaia.Repository.EnvioRepository;
import com.mensajeriaMackaia.Repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    private EnvioRepository envioRepository;
    private ClienteRepository clienteRepository;
    private EmpleadoRepository empleadoRepository;
    private PaqueteRepository paqueteRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository, ClienteRepository clienteRepository, EmpleadoRepository empleadoRepository,PaqueteRepository paqueteRepository) {
        this.envioRepository = envioRepository;
        this.clienteRepository = clienteRepository;
        this.paqueteRepository = paqueteRepository;
        this.empleadoRepository=empleadoRepository;
    }

    public EnvioDto crearEnvio(EnvioDto envioDto){

        Long cedulaCliente=envioDto.getCedulaCliente();
        String ciudadOrigen=envioDto.getCiudadOrigen();
        String ciudadDestino=envioDto.getCiudadDestino();
        String direccionDestino=envioDto.getDireccionDestino();
        String nombreDestinatario=envioDto.getNombreDestinatario();
        String celularDestinatario=envioDto.getCelularDestinatario();
        Double valorDeclarado=envioDto.getValorDeclarado();
        Integer peso=envioDto.getPeso();

        // Validar que todos los campos obligatorios estén presentes
        if (cedulaCliente == null || ciudadOrigen == null || ciudadDestino == null || direccionDestino == null || nombreDestinatario == null || celularDestinatario == null || valorDeclarado == null || peso== null) {
            throw new InvalidDataException("Todos los campos son obligatorios.");
        }

        // Verificar que el cliente exista en la base de datos
        Optional<Cliente> cliente = clienteRepository.findById(cedulaCliente);
        Optional<Empleado> empleado=empleadoRepository.findById(12345678L);
        if (cliente.isEmpty()) {
            throw new DataNotFoundException("El cliente con cedula " + cedulaCliente + " debe de estar registrado para poder enviar un paquete.");
        }

        // Calcular el tipo de paquete
        String tipoPaquete = null;
        Long valor = 0L;
        Integer id=null;
        if (peso < 2) {
            tipoPaquete = "LIVIANO";
            valor=30000L;
        } else if (peso >= 2 && peso < 5) {
            tipoPaquete = "MEDIANO";
            valor=40000L;
        } else {
            tipoPaquete = "GRANDE";
            valor=50000L;
        }

        // Crear el paquete
        Paquete paquete = new Paquete(id,tipoPaquete, peso, valorDeclarado);
        paqueteRepository.save(paquete);

        // Crear el envío
        LocalTime hora= LocalTime.now();
        String horaEntrega =hora.toString();
        String numeroGuia = GeneradorGuia.generar();
        Envio envio = new Envio(numeroGuia,cliente.get(),empleado.get(), paquete, ciudadOrigen, ciudadDestino,direccionDestino, nombreDestinatario, celularDestinatario, horaEntrega, "RECIBIDO",valor);
        envioRepository.save(envio);
        envioDto.setNumeroGuia(envio.getNumeroGuia());
        envioDto.setEstadoEnvio(envio.getEstadoEnvio());
        return envioDto;
    }

    public EnvioDto EnvioPorGuia(EnvioDto envioDto){

        String numeroGuia=envioDto.getNumeroGuia();
        if (numeroGuia == null ) {
            throw new InvalidDataException("El numero de guia es obligatorio.");
        }

        // Verificar que el cliente exista en la base de datos
        Optional<Envio> envio = envioRepository.findById(numeroGuia);

        if (envio.isEmpty()) {
            throw new DataNotFoundException("La guia numero " + numeroGuia + " debe estar errada.");
        }

        EnvioDto envioDto1 = new EnvioDto(envio.get().getNumeroGuia(), envio.get().getCliente().getCedula(), envio.get().getEmpleado().getCedula(), envio.get().getCiudadOrigen(),
                envio.get().getCiudadDestino(), envio.get().getDireccionDestino(), envio.get().getNombreDestinatario(), envio.get().getCelularDestinatario(),
                envio.get().getPaquete().getValorDeclarado(), envio.get().getPaquete().getPeso(), envio.get().getEstadoEnvio(), envio.get().getValorEnvio());
        return envioDto1;

    }

    public EnvioDto actualizar(EnvioDto envioDto) {

        String numeroGuia= envioDto.getNumeroGuia();
        String estadoEnvio=envioDto.getEstadoEnvio();
        Long cedulaEmpleado=envioDto.getCedulaEmpleado();

        // Validar que todos los campos obligatorios estén presentes
        if (numeroGuia == null || estadoEnvio == null || cedulaEmpleado == null) {
            throw new InvalidDataException("Todos los campos son obligatorios.");
        }

        // Verificar que el cliente exista en la base de datos
        Optional<Envio> envio = envioRepository.findById(numeroGuia);
        Optional<Empleado> empleado = empleadoRepository.findById(cedulaEmpleado);
        if (envio.isEmpty() || empleado.isEmpty()) {
            throw new DataNotFoundException("El empleado con cedula " + cedulaEmpleado + " no existe  o el numero de guia "+numeroGuia+" no existe ");
        }

        // Calcular el tipo de paquete
        Empleado empleado1 = empleado.get();
        if (empleado1.getTipoEmpleado().equals("CONDUCTOR")) {
            throw new InvalidDataException("No tiene los permisos para actualizar la informacion");
        }

        Envio envio1=envio.get();

        if ((envio1.getEstadoEnvio().equals("RECIBIDO")) && (estadoEnvio.equals("RECIBIDO"))) {
            estadoEnvio="EN RUTA";
            envio1.setEstadoEnvio(estadoEnvio);
        }else if ((envio1.getEstadoEnvio().equals("EN RUTA")) && (estadoEnvio.equals("EN RUTA"))) {
            estadoEnvio = "ENTREGADO";
            envio1.setEstadoEnvio(estadoEnvio);
        } else {
            throw new InvalidDataException("El cambio de estado no cumple con las validaciones");
        }

        // Crear el envío
        Cliente cliente=envio1.getCliente();
        envioDto.setCedulaCliente(cliente.getCedula());
        envioDto.setCiudadOrigen(envio1.getCiudadOrigen());
        envioDto.setCiudadDestino(envio1.getCiudadDestino());
        envioDto.setDireccionDestino(envio1.getDireccionDestino());
        envioDto.setNombreDestinatario(envio1.getNombreDestinatario());
        envioDto.setCelularDestinatario(envio1.getCelularDestinatario());
        envioDto.setValorDeclarado(envio1.getPaquete().getValorDeclarado());
        envioDto.setPeso(envio1.getPaquete().getPeso());
        envioDto.setValorEnvio(envio1.getValorEnvio());
        envioRepository.save(envio1);
        return envioDto;
    }

    public List<EnvioDto> enviosPorEstado(EnvioDto envioDto) {

        Long cedulaEmpleado = envioDto.getCedulaEmpleado();
        String estadoEnvio = envioDto.getEstadoEnvio();


        // Validar que todos los campos obligatorios estén presentes
        if (estadoEnvio == null || cedulaEmpleado == null) {
            throw new InvalidDataException("Todos los campos son obligatorios.");
        }

        // Verificar que el empleado exista en la base de datos
        Optional<Empleado> empleado = empleadoRepository.findById(cedulaEmpleado);
        if (empleado.isEmpty()) {
            throw new DataNotFoundException("El empleado con cedula " + cedulaEmpleado + " no existe ");
        }

        List<Envio> envios = this.envioRepository.findShippingAll(estadoEnvio);
        List<EnvioDto> enviosDto = new ArrayList<>();

        for (Envio envio : envios) {

            EnvioDto envioDto1 = new EnvioDto(envio.getNumeroGuia(), envio.getCliente().getCedula(), envio.getEmpleado().getCedula(), envio.getCiudadOrigen(),
                    envio.getCiudadDestino(), envio.getDireccionDestino(), envio.getNombreDestinatario(), envio.getCelularDestinatario(),
                    envio.getPaquete().getValorDeclarado(), envio.getPaquete().getPeso(), envio.getEstadoEnvio(), envio.getValorEnvio());

            enviosDto.add(envioDto1);
        }
        return enviosDto;
    }
}