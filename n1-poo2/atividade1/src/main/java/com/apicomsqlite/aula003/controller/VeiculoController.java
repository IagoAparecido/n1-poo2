package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.apicomsqlite.aula003.enity.Veiculo;
import com.apicomsqlite.aula003.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createveiculo", method = RequestMethod.POST)
    public String createveiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.createveiculo(veiculo);
    }

    @RequestMapping(value = "readveiculo", method = RequestMethod.GET)
    public List<Veiculo> readveiculo() {
        return veiculoService.readveiculo();
    }

    @RequestMapping(value = "updateveiculo/{id}", method = RequestMethod.PUT)
    public String updateveiculo(@PathVariable int id, @RequestBody Veiculo updatedVeiculo) {
        updatedVeiculo.setId(id);
        return veiculoService.updateveiculo(updatedVeiculo);
    }

    @RequestMapping(value = "deleteveiculo/{id}", method = RequestMethod.DELETE)
    public String deleteveiculo(@PathVariable int id) {
        return veiculoService.deleteveiculo(id);
    }
}
