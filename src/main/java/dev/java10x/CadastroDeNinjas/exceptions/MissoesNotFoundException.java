package dev.java10x.CadastroDeNinjas.exceptions;

public class MissoesNotFoundException extends RuntimeException {

    public MissoesNotFoundException(){
        super("Missão não encontrada!");
    }

    public MissoesNotFoundException(String message) {
        super(message);
    }
}
