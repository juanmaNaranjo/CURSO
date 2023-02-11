package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.impl;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.PedidDTO;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceimpl implements PedidoService{
    @Override
    public PedidDTO createPedido(PedidDTO pedidoDTO) {
        return null;
    }

    @Override
    public PedidDTO modificarPedido(Long id) {
        if (pedidoRepository.exci){

        }else {
            throw new BadRequestException("No exite pedido");
        }
        return null;
    }
}
