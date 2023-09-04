package com.apicomsqlite.aula003.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Jogo;
import com.apicomsqlite.aula003.repository.JogoRespository;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired(required = false)
    private JogoRespository jogoRepository;

    @Transactional
    public String createjogo(Jogo jogo) {
        try {
            if (!jogoRepository.existsById(jogo.getId())) {
                jogo.setId(null == jogoRepository.findMaxId() ? 1 : jogoRepository.findMaxId() + 1);
                jogoRepository.save(jogo);
                return "jogo cadastrado com sucesso.";
            } else {
                return "jogo já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Jogo> readjogo() {
        return jogoRepository.findAll();
    }

    @Transactional
    public String updatejogo(Jogo jogo) {
        if (jogoRepository.existsById(jogo.getId())) {
            try {
                Optional<Jogo> jogos = jogoRepository.findById(jogo.getId());
                if (jogos.isPresent()) {
                    Jogo jogoToBeUpdate = jogos.get();
                    jogoToBeUpdate.setNome(jogo.getNome());
                    jogoToBeUpdate.setCategoria(jogo.getCategoria());
                    jogoToBeUpdate.setClassificacao(jogo.getClassificacao());
                    jogoToBeUpdate.setLancamento(jogo.getLancamento());
                    jogoRepository.save(jogoToBeUpdate);
                    return "jogo atualizado.";
                } else {
                    return "jogo não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "jogo não existe no banco.";
        }
    }

    @Transactional
    public String deletejogo(int id) {
        try {
            if (jogoRepository.existsById(id)) {
                jogoRepository.deleteById(id);
                return "jogo deletado com sucesso.";
            } else {
                return "jogo não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}