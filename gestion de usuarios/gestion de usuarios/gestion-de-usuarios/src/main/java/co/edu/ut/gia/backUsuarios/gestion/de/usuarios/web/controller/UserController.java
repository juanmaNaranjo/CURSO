package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.controller;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.UserService;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.prefs.BackingStoreException;

@RequestMapping("usercontrol")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Crear un usuario en la base de datos
     * @param usuarioDTO Contenedor de informacion de usuario
     * @return Informacion de usuario ya creado
     */

    @PostMapping("createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO usuarioDTO) throws BackingStoreException {

        return new ResponseEntity(userService.createUser(usuarioDTO), HttpStatus.CREATED);
    }
    @GetMapping("getUser")
     public ResponseEntity<UserDTO> getUser(@RequestParam("id") Long id){
        return new ResponseEntity(userService.getUser(id),HttpStatus.FOUND);
    }

    @GetMapping("getByNombre")
    public ResponseEntity<List<UserDTO>> getByNombre(@RequestParam String Nombre){
        return new ResponseEntity(userService.getUserByNombre(Nombre), HttpStatus.FOUND);
    }






}
