package com.mensajeriaMackaia.Controller;

import com.mensajeriaMackaia.Model.Cliente;
import com.mensajeriaMackaia.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private ClienteService Clienteservice;

    @Autowired
    public ClienteController(ClienteService Clienteservice) {

        this.Clienteservice=Clienteservice;
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        Cliente cliente1 = Clienteservice.crear(cliente);
        return ResponseEntity.ok(cliente1);
    }

    @GetMapping("/cliente/{cedula}")
    public Cliente obtenerCliente(@PathVariable("cedula") Long  cedula){
        return Clienteservice.obtenerCliente(cedula);
    }
    @PutMapping("/cliente")
    public ResponseEntity<String> actualizar(@RequestBody Cliente cliente) {
        this.Clienteservice.actualizar(cliente);
        return ResponseEntity.ok().body("Cliente Actualizado Exitosamente");
    }

    @DeleteMapping("/cliente/{cedula}")
    public ResponseEntity<String> eliminar(@PathVariable("cedula") Long  cedula){
        this.Clienteservice.eliminar(cedula);
        return ResponseEntity.ok().body("Cliente eliminado exitosamente");
    }
}