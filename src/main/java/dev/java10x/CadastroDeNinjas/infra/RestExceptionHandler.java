package dev.java10x.CadastroDeNinjas.infra;

import dev.java10x.CadastroDeNinjas.exceptions.IdNotFoundException;
import dev.java10x.CadastroDeNinjas.exceptions.MissoesNotFoundException;
import dev.java10x.CadastroDeNinjas.exceptions.NinjaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    private ResponseEntity<RestErrorMessage> idNotFound(IdNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(NinjaNotFoundException.class)
    private ResponseEntity<RestErrorMessage> ninjaNotFound(NinjaNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((threatResponse));
    }

    @ExceptionHandler(MissoesNotFoundException.class)
    private ResponseEntity<RestErrorMessage> missoesNotFound(MissoesNotFoundException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

}
