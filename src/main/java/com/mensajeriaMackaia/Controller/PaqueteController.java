package com.mensajeriaMackaia.Controller;

import com.mensajeriaMackaia.Service.PaqueteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaqueteController {

    private PaqueteService paqueteService;

}
