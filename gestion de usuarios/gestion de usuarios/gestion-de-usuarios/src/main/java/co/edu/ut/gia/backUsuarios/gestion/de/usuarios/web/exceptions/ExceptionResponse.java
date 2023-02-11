package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String detalles;
    private String httpCodeMessage;


}
