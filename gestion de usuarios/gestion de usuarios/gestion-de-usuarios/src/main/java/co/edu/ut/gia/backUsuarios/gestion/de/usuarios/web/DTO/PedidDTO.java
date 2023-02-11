package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidDTO {

    private Long id;
    private Date fecha;
    private String producto;
    private  String descripcion;

}

