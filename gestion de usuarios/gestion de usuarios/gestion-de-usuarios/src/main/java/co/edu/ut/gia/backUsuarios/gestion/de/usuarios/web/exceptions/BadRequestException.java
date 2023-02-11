package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Throwable {

    public BadRequestException(String message) {
        super(message);
    }
}
