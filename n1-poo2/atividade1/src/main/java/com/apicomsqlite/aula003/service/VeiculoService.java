package com.apicomsqlite.aula003.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Veiculo;
import com.apicomsqlite.aula003.repository.VeiculoRespository;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired(required = false)
    private VeiculoRespository veiculoRepository;

    @Transactional
    public String createveiculo(Veiculo veiculo) {
        try {
            if (!veiculoRepository.existsById(veiculo.getId())) {
                veiculo.setId(null == veiculoRepository.findMaxId() ? 1 : veiculoRepository.findMaxId() + 1);
                veiculoRepository.save(veiculo);
                return "veiculo cadastrado com sucesso.";
            } else {
                return "veiculo já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Veiculo> readveiculo() {
        return veiculoRepository.findAll();
    }

    @Transactional
    public String updateveiculo(Veiculo veiculo) {
        if (veiculoRepository.existsById(veiculo.getId())) {
            try {
                Optional<Veiculo> veiculos = veiculoRepository.findById(veiculo.getId());
                if (veiculos.isPresent()) {
                    Veiculo veiculoToBeUpdate = veiculos.get();
                    veiculoToBeUpdate.setNome(veiculo.getNome());
                    veiculoToBeUpdate.setTipo(veiculo.getTipo());
                    veiculoToBeUpdate.setCor(veiculo.getCor());
                    veiculoToBeUpdate.setFabricante(veiculo.getFabricante());
                    veiculoRepository.save(veiculoToBeUpdate);
                    return "veiculo atualizado.";
                } else {
                    return "veiculo não encontrado no banco.";
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "veiculo não existe no banco.";
        }
    }

    @Transactional
    public String deleteveiculo(int id) {
        try {
            if (veiculoRepository.existsById(id)) {
                veiculoRepository.deleteById(id);
                return "veiculo deletado com sucesso.";
            } else {
                return "veiculo não existe no banco de dados.";
            }
        } catch (Exception e) {
            throw e;
        }
    }
}