package com.crudBanco.crudBanco.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudBanco.crudBanco.enity.Camisetas;
import com.crudBanco.crudBanco.repository.CamisetasRespository;
import jakarta.transaction.Transactional;

@Service
public class CamisetasService {

    @Autowired(required = false)
    private CamisetasRespository camisetasRespository;

    @Transactional
    public String createcamisetas(Camisetas camiseta) {
        try {
            if (!camisetasRespository.existsById(camiseta.getNumero())) {
                camiseta.setId(null == camisetasRespository.findMaxId() ? 0 : camisetasRespository.findMaxId() + 1);
                camisetasRespository.save(camiseta);
                return "camiseta cadastrada com sucesso.";
            } else {
                return "camiseta já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Camisetas> readcamisetas() {
        return camisetasRespository.findAll();
    }

    @Transactional
    public String updatecamisetas(Camisetas camiseta) {
        if (camisetasRespository.existsById(camiseta.getNumero())) {
            try {
                List<Camisetas> camisetas = camisetasRespository.findById(camiseta.getNumero());
                camisetas.stream().forEach(s -> {
                    Camisetas camisetasToBeUpdate = camisetasRespository.findById(s.getId()).get(0);
                    camisetasToBeUpdate.setEstilo(camiseta.getEstilo());
                    camisetasToBeUpdate.setNumero(camiseta.getNumero());
                    camisetasRespository.save(camisetasToBeUpdate);
                });
                return "camiseta atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "camiseta não existe no banco.";
        }
    }

    @Transactional
    public String deletecamisetas(Camisetas camiseta) {
        if (camisetasRespository.existsById(camiseta.getNumero())) {
            try {
                List<Camisetas> camisetas = camisetasRespository.findById(camiseta.getNumero());
                camisetas.stream().forEach(s -> {
                    camisetasRespository.delete(s);
                });
                return "camiseta deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "camiseta n\u00E3o existe no banco.";
        }
    }
}