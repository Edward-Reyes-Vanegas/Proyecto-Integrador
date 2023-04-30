package com.mensajeriaMackaia.Controller;

import com.mensajeriaMackaia.Dto.EnvioDto;
import com.mensajeriaMackaia.Service.EnvioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Envio", description = "Controller Envio")
public class EnvioController {

    private EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @ApiOperation(value = "Generar envio", notes = "Se recibe por el body un un objeto de tipo envioDTO y" +
            "se registra en la base de datos si cumple todas las validaciones.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/envio")
    public ResponseEntity<?> crearEnvio(@RequestBody EnvioDto envioDto) {

        this.envioService.crearEnvio(envioDto);
        String mensaje="Numero De Guia: "+envioDto.getNumeroGuia() + "  Estado del Envio: "+envioDto.getEstadoEnvio();
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/envio")
    public EnvioDto envioPorGuia(@RequestBody EnvioDto envioDto) {

        return envioService.EnvioPorGuia(envioDto);

    }

    @GetMapping("/envios")
    public List<EnvioDto> enviosPorEstado(@RequestBody EnvioDto envioDto) {

        return envioService.enviosPorEstado(envioDto);

    }


    @PutMapping("/envio")
    public ResponseEntity<?> actualizar(@RequestBody EnvioDto envioDto) {

        this.envioService.actualizar(envioDto);
        String mensaje="Numero De Guia: "+envioDto.getNumeroGuia() + "  Estado del Envio: "+envioDto.getEstadoEnvio();
        return ResponseEntity.ok(mensaje);
        //prueba
    }


}