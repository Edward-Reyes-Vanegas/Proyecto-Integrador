package com.mensajeriaMackaia;

import com.mensajeriaMackaia.Dto.EnvioDto;
import com.mensajeriaMackaia.Exceptions.DataNotFoundException;
import com.mensajeriaMackaia.Model.Cliente;
import com.mensajeriaMackaia.Model.Empleado;
import com.mensajeriaMackaia.Model.Envio;
import com.mensajeriaMackaia.Model.Paquete;
import com.mensajeriaMackaia.Repository.ClienteRepository;
import com.mensajeriaMackaia.Repository.EmpleadoRepository;
import com.mensajeriaMackaia.Repository.EnvioRepository;
import com.mensajeriaMackaia.Repository.PaqueteRepository;
import com.mensajeriaMackaia.Service.EnvioService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnvioServiceTest {

    EnvioRepository envioRepository;
    ClienteRepository clienteRepository;
    EmpleadoRepository empleadoRepository;
    PaqueteRepository paqueteRepository;
    EnvioService envioService;

    @Before()
    public void SetUp() {

        this.envioRepository = mock(EnvioRepository.class);
        this.clienteRepository = mock(ClienteRepository.class);
        this.empleadoRepository = mock(EmpleadoRepository.class);
        this.paqueteRepository=mock(PaqueteRepository.class);
        this.envioService = new EnvioService(envioRepository, clienteRepository, empleadoRepository, paqueteRepository);

    }

    @Test(expected = DataNotFoundException.class)
    public void pruebaClienteNoEncontado() {

        Long cedulaCliente = 1234567L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        Integer peso = 2;
        Cliente cliente = new Cliente(123456L, "Edward", "Reyes Vanegas", "3126786543", "e.reyes@gmail.com", "Calle 10 # 20 - 30", "Bogota");
        Empleado empleado = new Empleado(123456789L, "Juan", "Pérez", "321654987", "juanperez@email.com", "Calle 123", "Bogotá", "2 años", "O+", "COORDINADOR");
        EnvioDto envioDto = new EnvioDto("EDL0Z6F8H7", cedulaCliente, 123456789L, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, "RECIBIDO", 40000L);
        this.envioService.crearEnvio(envioDto);
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());
        Paquete paquete = new Paquete(1, "LIVIANO", 2, 19000.0);
        LocalTime hora = LocalTime.now();
        String horaEntrega = hora.toString();
        Envio envio = new Envio("EDL0Z6F8H7", cliente, empleado, paquete, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, horaEntrega, "ETREGADO", 40000l);
        assertTrue(envio.getCliente()==null);
    }
    @Test(expected = DataNotFoundException.class)
    public void guiaNoEncontrada(){
        String numeroGuia= "EDL0Z6F8H7";
        Long cedulaCliente = 1234567L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        Integer peso = 2;
        EnvioDto envioDto = new EnvioDto(numeroGuia, cedulaCliente, 123456789L, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, "RECIBIDO", 40000L);
        this.envioService.EnvioPorGuia(numeroGuia);
        when(envioRepository.findById(any())).thenReturn(Optional.empty());
        assertTrue(this.envioRepository==null);
    }
    @Test(expected = DataNotFoundException.class)
    public void empleadoNoEncontrado(){
        String numeroGuia= "EDL0Z6F8H7";
        Long cedulaCliente = 1234567L;
        Long cedulaEmpleado=123456789L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        Integer peso = 2;
        EnvioDto envioDto = new EnvioDto(numeroGuia, cedulaCliente, cedulaEmpleado, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, "RECIBIDO", 40000L);
        this.envioService.actualizar(envioDto);
        when(envioRepository.findById(any())).thenReturn(Optional.empty());
        when(empleadoRepository.findById(any())).thenReturn(Optional.empty());
        assertTrue(this.envioRepository==null);
        assertTrue(this.empleadoRepository==null);
    }
    @Test(expected = DataNotFoundException.class)
    public void empleadoConductor(){

        String numeroGuia= "EDL0Z6F8H7";
        Long cedulaCliente = 1234567L;
        Long cedulaEmpleado=123456789L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        String estadoEnvio="ENTREGADO";
        Integer peso = 2;
        Empleado empleado = new Empleado(123456789L, "Juan", "Pérez", "321654987", "juanperez@email.com", "Calle 123", "Bogotá", "2 años", "O+", "CONDUCTOR");
        Cliente cliente = new Cliente(123456L, "Edward", "Reyes Vanegas", "3126786543", "e.reyes@gmail.com", "Calle 10 # 20 - 30", "Bogota");
        Paquete paquete = new Paquete(1, "LIVIANO", 2, 19000.0);
        LocalTime hora = LocalTime.now();
        String horaEntrega = hora.toString();
        Envio envio = new Envio("EDL0Z6F8H7", cliente, empleado, paquete, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, horaEntrega, estadoEnvio, 40000l);
        EnvioDto envioDto = new EnvioDto(numeroGuia, cedulaCliente, cedulaEmpleado, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, "RECIBIDO", 40000L);
        this.envioService.actualizar(envioDto);
        when(envioRepository.findById(any())).thenReturn(Optional.of(envio));
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(empleado));
        assertTrue(envio.getEmpleado().getTipoEmpleado().equals("CONDUCTOR"));
    }

    @Test(expected = DataNotFoundException.class)
    public void estadoEnvio(){

        String numeroGuia= "EDL0Z6F8H7";
        Long cedulaCliente = 1234567L;
        Long cedulaEmpleado=123456789L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        String estadoEnvio="ENTREGADO";
        Integer peso = 2;
        Empleado empleado = new Empleado(123456789L, "Juan", "Pérez", "321654987", "juanperez@email.com", "Calle 123", "Bogotá", "2 años", "O+", "REPARTIDOR");
        Cliente cliente = new Cliente(123456L, "Edward", "Reyes Vanegas", "3126786543", "e.reyes@gmail.com", "Calle 10 # 20 - 30", "Bogota");
        Paquete paquete = new Paquete(1, "LIVIANO", 2, 19000.0);
        LocalTime hora = LocalTime.now();
        String horaEntrega = hora.toString();
        Envio envio = new Envio("EDL0Z6F8H7", cliente, empleado, paquete, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, horaEntrega, estadoEnvio, 40000l);
        EnvioDto envioDto = new EnvioDto(numeroGuia, cedulaCliente, cedulaEmpleado, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, estadoEnvio, 40000L);
        this.envioService.actualizar(envioDto);
        when(envioRepository.findById(any())).thenReturn(Optional.of(envio));
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(empleado));
        assertTrue(envio.getEstadoEnvio().equals("RECIBIDO"));
    }
    @Test(expected = DataNotFoundException.class)
    public void obtenerEstadoEnvio(){

        String numeroGuia= "EDL0Z6F8H7";
        Long cedulaCliente = 1234567L;
        Long cedulaEmpleado=123456789L;
        String ciudadOrigen = "Bogota";
        String ciudadDestino = "Barranquilla";
        String direccionDestino = "calle 25 30-30";
        String nombreDestinatario = "polo Balencia";
        String celularDestinatario = "3103255601";
        Double valorDeclarado = 19000.0;
        String estadoEnvio="ENTREGADO";
        Integer peso = 2;

        EnvioDto envioDto = new EnvioDto(numeroGuia, cedulaCliente, cedulaEmpleado, ciudadOrigen, ciudadDestino, direccionDestino, nombreDestinatario, celularDestinatario, valorDeclarado, peso, estadoEnvio, 40000L);
        Empleado empleado = new Empleado(123456789L, "Juan", "Pérez", "321654987", "juanperez@email.com", "Calle 123", "Bogotá", "2 años", "O+", "REPARTIDOR");
        this.envioService.actualizar(envioDto);
        List <Envio> envios=envioRepository.findShippingAll(any());

        List<EnvioDto> enviosDto = new ArrayList<>();

        for (Envio envio : envios) {

            EnvioDto envioDto1 = new EnvioDto(envio.getNumeroGuia(), envio.getCliente().getCedula(), envio.getEmpleado().getCedula(), envio.getCiudadOrigen(),
                    envio.getCiudadDestino(), envio.getDireccionDestino(), envio.getNombreDestinatario(), envio.getCelularDestinatario(),
                    envio.getPaquete().getValorDeclarado(), envio.getPaquete().getPeso(), envio.getEstadoEnvio(), envio.getValorEnvio());

            enviosDto.add(envioDto1);
        }
        when(envioRepository.findShippingAll(any())).thenReturn(envios);
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(empleado));
        assertTrue(enviosDto.isEmpty());



    }
}
