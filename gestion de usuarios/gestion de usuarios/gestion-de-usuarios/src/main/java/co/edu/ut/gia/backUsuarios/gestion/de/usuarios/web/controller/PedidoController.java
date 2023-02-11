package co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.controller;

import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.service.impl.PedidoService;
import co.edu.ut.gia.backUsuarios.gestion.de.usuarios.web.DTO.PedidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")

public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @PostMapping("crearpedido")
    public PedidDTO createPedido(@RequestBody PedidDTO pedidoDTO){
        return pedidoService.createPedido(pedidoDTO);
    }


    @PostMapping("modificarPedido")
    public ResponseEntity<PedidDTO> modificarPedido(@RequestParam Long id){
        return new ResponseEntity(pedidoService.modificarPedido(id), HttpStatus.ACCEPTED);
    }
}
