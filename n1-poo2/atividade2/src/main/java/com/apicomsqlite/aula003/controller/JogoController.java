package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.apicomsqlite.aula003.enity.Jogo;
import com.apicomsqlite.aula003.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createjogo", method = RequestMethod.POST)
    public String createjogo(@RequestBody Jogo jogo) {
        return jogoService.createjogo(jogo);
    }

    @RequestMapping(value = "readjogo", method = RequestMethod.GET)
    public List<Jogo> readjogo() {
        return jogoService.readjogo();
    }

    @RequestMapping(value = "updatejogo/{id}", method = RequestMethod.PUT)
    public String updateaniamal(@PathVariable int id, @RequestBody Jogo updatedjogo) {
        updatedjogo.setId(id);
        return jogoService.updatejogo(updatedjogo);
    }

    @RequestMapping(value = "deletejogo/{id}", method = RequestMethod.DELETE)
    public String deletejogo(@PathVariable int id) {
        return jogoService.deletejogo(id);
    }
}
