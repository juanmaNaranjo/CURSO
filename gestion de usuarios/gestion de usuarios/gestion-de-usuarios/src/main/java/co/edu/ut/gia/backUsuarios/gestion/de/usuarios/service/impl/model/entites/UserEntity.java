package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private  String apellido;
    private String telefono;

    @OneToMany(targetEntity = PedidoEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkPedido",referencedColumnName = "id")

    private List<PedidoEntity> pedidoEntities;
    public UserEntity(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
}
