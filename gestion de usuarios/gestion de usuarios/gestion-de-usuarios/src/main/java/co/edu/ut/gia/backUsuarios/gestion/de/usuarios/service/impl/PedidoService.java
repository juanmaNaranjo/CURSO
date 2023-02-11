package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.impl;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.PedidDTO;

public interface PedidoService {
    PedidDTO createPedido(PedidDTO pedidoDTO);

    PedidDTO modificarPedido(Long id);
}
