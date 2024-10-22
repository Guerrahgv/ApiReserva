package reservas.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservas.reservas.dto.ReservaRequestDTO;
import reservas.reservas.model.Cliente;
import reservas.reservas.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/agregar")
    public Cliente agregarReserva(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return reservaService.agregarReserva(reservaRequestDTO.getCliente(), reservaRequestDTO.getReserva());
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerTodosLosClientes() {
        return reservaService.obtenerTodosLosClientes();
    }
}
