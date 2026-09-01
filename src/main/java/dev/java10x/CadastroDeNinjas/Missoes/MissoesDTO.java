package dev.java10x.CadastroDeNinjas.Missoes;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesDTO {
    private Long id;
    private String nome;
    private String dificuldade;
}
