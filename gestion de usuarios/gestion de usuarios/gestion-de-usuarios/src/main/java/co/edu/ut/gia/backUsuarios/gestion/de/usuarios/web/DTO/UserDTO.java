package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nombre;
    private  String apellido;
    private String telefono;
    private List<PedidDTO> pedidoDTO;
}
