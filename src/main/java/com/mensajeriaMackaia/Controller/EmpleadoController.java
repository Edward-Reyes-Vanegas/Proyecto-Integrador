package com.mensajeriaMackaia.Controller;

import com.mensajeriaMackaia.Model.Empleado;
import com.mensajeriaMackaia.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> crear(@RequestBody Empleado empleado){
        Empleado empleado1 = empleadoService.crear(empleado);
        return ResponseEntity.ok(empleado1);
    }

    @GetMapping("/empleado/{cedula}")
    public Empleado obtenerEmpleado(@PathVariable("cedula") Long  cedula){
        return empleadoService.obtenerEmpleado(cedula);
    }

    @PutMapping("/empleado")
    public ResponseEntity<String> actualizar(@RequestBody Empleado empleado) {
        this.empleadoService.actualizar(empleado);
        return ResponseEntity.ok().body("Empleado Actualizado Exitosamente");
    }

    @DeleteMapping("/empleado/{cedula}")
    public ResponseEntity<String> eliminar(@PathVariable("cedula") Long  cedula){
        this.empleadoService.eliminar(cedula);
        return ResponseEntity.ok().body("Empleado eliminado exitosamente");
    }
}