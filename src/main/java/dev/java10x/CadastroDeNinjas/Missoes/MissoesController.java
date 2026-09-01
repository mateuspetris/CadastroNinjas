package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissao(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Post -- Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoes = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + "{ID} - " + missoes.getId() + "\n" +"Nome: " + missoes.getNome());
    }

    // Put -- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<MissoesDTO> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missoes = missoesService.alterarMissao(id, missaoAtualizada);
        return ResponseEntity.ok(missoes);
    }

    // Delete -- Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar/{ID}")
    public ResponseEntity<String> deletarMissao(@PathVariable long ID){
        missoesService.deleterMissaoId(ID);
        return ResponseEntity.ok("Missão deletada com sucesso");
    }
}
