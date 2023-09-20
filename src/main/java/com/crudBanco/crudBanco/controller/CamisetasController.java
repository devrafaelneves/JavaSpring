package com.crudBanco.crudBanco.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.crudBanco.crudBanco.enity.Camisetas;
import com.crudBanco.crudBanco.service.CamisetasService;

@RestController
public class CamisetasController {

    @Autowired
    private CamisetasService camisetasService;

    @RequestMapping(value = "info-camisetas", method = RequestMethod.GET)
    public String info1() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createcamisetas", method = RequestMethod.POST)
    public String createcamisetas(@RequestBody Camisetas camisetas) {
        return camisetasService.createcamisetas(camisetas);
    }

    @RequestMapping(value = "readcamisetas", method = RequestMethod.GET)
    public List<Camisetas> readcamisetas() {
        return camisetasService.readcamisetas();
    }

    @RequestMapping(value = "updatecamisetas", method = RequestMethod.PUT)
    public String updatecamisetas(@RequestBody Camisetas camisetas) {
        return camisetasService.updatecamisetas(camisetas);
    }

    @RequestMapping(value = "deletecamisetas", method = RequestMethod.DELETE)
    public String deletecamisetas(@RequestBody Camisetas camisetas) {
        return camisetasService.deletecamisetas(camisetas);
    }
}
