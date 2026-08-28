package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }


    // Adicionar um Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso : " + novoNinja.getNome() + "(ID):" + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninja = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninja);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarPorId(id);
        return ResponseEntity.ok("Ninja encontrado: " + ninja.getNome());
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);
        return ResponseEntity.ok(ninja);
    }

    // Deletar Ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return ResponseEntity.ok("Ninja deletado com sucesso");
    }
}
