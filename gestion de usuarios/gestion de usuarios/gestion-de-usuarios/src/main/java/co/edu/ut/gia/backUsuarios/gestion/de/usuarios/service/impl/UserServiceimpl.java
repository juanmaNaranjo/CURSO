package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.impl;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.entites.PedidoEntity;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.entites.UserEntity;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.model.repositorio.UserRepository;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.UserService;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.PedidDTO;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.UserDTO;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

@Service
public class UserServiceimpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Mapea un objeto de tipo userDTO o UserEntity y guarda la informacion en la base de datos
     * @param usuarioDTO
     * @return userDTO con la informacion del usuario
     */
    @Override
    public UserDTO createUser(UserDTO usuarioDTO) throws BackingStoreException {
        // UserEntity userEntity = new UserEntity(usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getTelefono());
        if (!usuarioDTO.equals(null)) {
            UserEntity userEntity = modelMapper.map(usuarioDTO, UserEntity.class);
            List< PedidoEntity> pedidoEntities =new ArrayList<>();

            usuarioDTO.getPedidoDTO().forEach(pedidoDTO -> {
                pedidoEntities.add(modelMapper.map(pedidoDTO, PedidoEntity.class));
            });
            userEntity.setPedidoEntities((pedidoEntities));
            UserEntity userEntityResponse = userRepository.save(userEntity);

            UserDTO userDTOResponse = modelMapper.map(userEntityResponse ,UserDTO.class);
            List<PedidDTO> pedidoDTO = new ArrayList<>();
            userEntityResponse.getPedidoEntities().forEach(pedidoEntity -> {
                pedidoDTO.add(modelMapper.map(pedidoEntity , PedidDTO.class));

            });

            userDTOResponse.setPedidoDTO(pedidoDTO);



            return userDTOResponse;
        } else {
            throw new BackingStoreException("usuario nulo");
        }
    }


    @Override
    public UserDTO getUser(Long id) {
        if (userRepository.existsById(id)) {
                UserEntity usuarioEntity = userRepository.findById(id).get();
                return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
            } else {
                throw new UserNotFoundException("EL usuario no encontrado en la base de datos");
            }
        }

    @Override
    public List<UserDTO> getUserByNombre(String nombre) {
        if (userRepository.existsByNombre(nombre)){
            List<UserEntity> userEntities =userRepository.findByNombre(nombre);
            List<UserDTO>  userDTOS = new ArrayList<>();
            userEntities.forEach(userEntity -> {
                UserDTO userDTO = modelMapper.map(userEntity,UserDTO.class);
                userDTOS.add(userDTO);
            });
            return userDTOS;
        }
        else {
            throw new UserNotFoundException("EL usuario no se encontro cpor el nombre");
        }
    }
}
