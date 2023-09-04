package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

import com.apicomsqlite.aula003.enity.Veiculo;

// @Repository
public interface VeiculoRespository extends JpaRepository<Veiculo, Integer> {

    public boolean existsById(int id);

    public List<Veiculo> findByNome(String nome);

    @Query("select max(s.id) from Veiculo s")
    public Integer findMaxId();
}