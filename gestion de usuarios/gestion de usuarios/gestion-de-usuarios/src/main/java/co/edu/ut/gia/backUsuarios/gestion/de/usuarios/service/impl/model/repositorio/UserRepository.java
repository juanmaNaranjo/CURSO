package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.repositorio;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.entites.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    boolean existsByNombre(String nombre);

    List<UserEntity> findByNombre(String nombre);


}
