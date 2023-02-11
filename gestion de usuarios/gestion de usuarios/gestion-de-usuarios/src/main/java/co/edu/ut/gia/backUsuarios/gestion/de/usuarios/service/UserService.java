package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.UserDTO;

import java.util.List;
import java.util.prefs.BackingStoreException;

public interface UserService {
    UserDTO createUser(UserDTO usuarioDTO) throws BackingStoreException;




    UserDTO getUser(Long id);

   List<UserDTO> getUserByNombre(String nombre);
}
