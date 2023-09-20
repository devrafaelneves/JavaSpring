package com.crudBanco.crudBanco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudBanco.crudBanco.enity.Camisetas;

@Repository
public interface CamisetasRespository extends JpaRepository<Camisetas, Integer> {

    public boolean existsById(int id);

    public List<Camisetas> findById(int id);

    @Query("select max(s.id) from Camisetas s")
    public Integer findMaxId();
}