package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

import com.apicomsqlite.aula003.enity.Jogo;

// @Repository
public interface JogoRespository extends JpaRepository<Jogo, Integer> {

    public boolean existsById(int id);

    public List<Jogo> findByNome(String nome);

    @Query("select max(s.id) from Jogo s")
    public Integer findMaxId();
}