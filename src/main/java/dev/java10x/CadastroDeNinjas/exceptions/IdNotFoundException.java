package dev.java10x.CadastroDeNinjas.exceptions;

public class idException extends  RuntimeException{

    public idException() {
        super("ID não encontrado");
    }

    public idException(String message){
        super(message);
    }
}
