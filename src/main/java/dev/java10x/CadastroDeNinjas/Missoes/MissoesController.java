package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Get -- Mandar uma requisao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }

    // Post -- Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    // Put -- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // Delete -- Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}
