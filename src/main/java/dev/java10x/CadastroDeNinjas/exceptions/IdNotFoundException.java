package dev.java10x.CadastroDeNinjas.exceptions;

public class IdNotFoundException extends  RuntimeException{

    public IdNotFoundException() {
        super("ID não encontrado");
    }

    public IdNotFoundException(String message){
        super(message);
    }
}
