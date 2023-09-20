package com.crudBanco.crudBanco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudBanco.crudBanco.enity.Clientes;

@Repository
public interface ClientesRespository extends JpaRepository<Clientes, Integer> {

    public boolean existsById(int id);

    public List<Clientes> findById(int id);

    @Query("select max(s.id) from Clientes s")
    public Integer findMaxId();
}