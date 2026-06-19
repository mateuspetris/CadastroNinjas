package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota.";
    }


    // Adicionar um Ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninjas";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninjas Por ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Alterar ninja por ID";
    }
    // Deletar Ninjas (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado por ID";
    }
}
