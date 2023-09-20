package com.crudBanco.crudBanco.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.crudBanco.crudBanco.enity.Clientes;
import com.crudBanco.crudBanco.service.ClientesService;

@RestController
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @RequestMapping(value = "info-clientes", method = RequestMethod.GET)
    public String info2() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createclientes", method = RequestMethod.POST)
    public String createclientes(@RequestBody Clientes clientes) {
        return clientesService.createclientes(clientes);
    }

    @RequestMapping(value = "readclientess", method = RequestMethod.GET)
    public List<Clientes> readclientes() {
        return clientesService.readclientes();
    }

    @RequestMapping(value = "updateclientes", method = RequestMethod.PUT)
    public String updateclientes(@RequestBody Clientes clientes) {
        return clientesService.updateclientes(clientes);
    }

    @RequestMapping(value = "deleteclientes", method = RequestMethod.DELETE)
    public String deleteclientes(@RequestBody Clientes clientes) {
        return clientesService.deleteclientes(clientes);
    }
}
