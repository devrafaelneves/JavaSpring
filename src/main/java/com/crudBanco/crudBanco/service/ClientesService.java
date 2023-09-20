package com.crudBanco.crudBanco.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudBanco.crudBanco.enity.Clientes;
import com.crudBanco.crudBanco.repository.ClientesRespository;
import jakarta.transaction.Transactional;

@Service
public class ClientesService { 

    @Autowired(required = false)
    private ClientesRespository clientesRespository;

    @Transactional
    public String createclientes(Clientes cliente) {
        try {
            if (!clientesRespository.existsById(cliente.getNumero())) {
                cliente.setId(null == clientesRespository.findMaxId() ? 0 : clientesRespository.findMaxId() + 1);
                clientesRespository.save(cliente);
                return "cliente cadastrada com sucesso.";
            } else {
                return "cliente já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Clientes> readclientes() {
        return clientesRespository.findAll();
    }

    @Transactional
    public String updateclientes(Clientes cliente) {
        if (clientesRespository.existsById(cliente.getNumero())) {
            try {
                List<Clientes> clientes = clientesRespository.findById(cliente.getNumero());
                clientes.stream().forEach(s -> {
                    Clientes clientesToBeUpdate = clientesRespository.findById(s.getId()).get(0);
                    clientesToBeUpdate.setNome(cliente.getNome());
                    clientesToBeUpdate.setNumero(cliente.getNumero());
                    clientesRespository.save(clientesToBeUpdate);
                });
                return "cliente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cliente não existe no banco.";
        }
    }

    @Transactional
    public String deleteclientes(Clientes cliente) {
        if (clientesRespository.existsById(cliente.getNumero())) {
            try {
                List<Clientes> clientes = clientesRespository.findById(cliente.getNumero());
                clientes.stream().forEach(s -> {
                    clientesRespository.delete(s);
                });
                return "cliente deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "cliente n\u00E3o existe no banco.";
        }
    }
}