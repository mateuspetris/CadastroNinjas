package dev.java10x.CadastroDeNinjas.exceptions;

public class NinjaNotFoundException extends RuntimeException {
  public NinjaNotFoundException(String message) {
    super(message);
  }
}
