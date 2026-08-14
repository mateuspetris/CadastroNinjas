package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();
    }

    // Post -- Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    // Put -- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // Delete -- Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar")
    public void deletarMissao(@PathVariable long id){
        missoesService.deleterMissaoId(id);
    }
}
