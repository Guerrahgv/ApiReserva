package reservas.reservas.service;

import org.springframework.stereotype.Service;
import reservas.reservas.dto.ClienteDTO;
import reservas.reservas.dto.ReservaDTO;
import reservas.reservas.model.Cliente;
import reservas.reservas.model.Reserva;
import reservas.reservas.model.ReservaBuilder;
import reservas.reservas.model.DescuentoSingleton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private List<Cliente> clientes = new ArrayList<>(); // Simulación de base de datos en memoria

    public Cliente agregarReserva(ClienteDTO clienteDTO, ReservaDTO reservaDTO) {
        Cliente cliente = buscarOCrearCliente(clienteDTO);

        // Crear la reserva con el Builder
        Reserva nuevaReserva = crearReserva(reservaDTO, cliente);
        cliente.agregarReserva(nuevaReserva); // Agregar la reserva al cliente

        return cliente;
    }

    private Cliente buscarOCrearCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteExistente = clientes.stream()
                .filter(c -> c.getNombre().equals(clienteDTO.getNombre())
                        && c.getApellido().equals(clienteDTO.getApellido())
                        && c.getEmail().equals(clienteDTO.getEmail())
                        && c.getTelefono().equals(clienteDTO.getTelefono()))
                .findFirst();

        if (clienteExistente.isPresent()) {
            return clienteExistente.get();
        } else {
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setNombre(clienteDTO.getNombre());
            nuevoCliente.setApellido(clienteDTO.getApellido());
            nuevoCliente.setEmail(clienteDTO.getEmail());
            nuevoCliente.setTelefono(clienteDTO.getTelefono());
            clientes.add(nuevoCliente); // Agregar cliente a la lista
            return nuevoCliente;
        }
    }

    private Reserva crearReserva(ReservaDTO reservaDTO, Cliente cliente) {
        ReservaBuilder builder = new ReservaBuilder(reservaDTO.getTipoReserva());

        // Aplicar descuento usando el Singleton
        DescuentoSingleton descuentoSingleton = DescuentoSingleton.getInstancia();
        double costoConDescuento = descuentoSingleton.aplicarDescuento(reservaDTO.getCosto());

        // Usar el builder para crear la reserva
        builder.setCliente(cliente)
                .setFecha(new Date())
                .setCosto(costoConDescuento);

        // Verificar el tipo de reserva y setear los campos correspondientes
        switch (reservaDTO.getTipoReserva().toLowerCase()) {
            case "vuelo":
                builder.setVueloNumero(reservaDTO.getVueloNumero())
                        .setAerolinea(reservaDTO.getAerolinea())
                        .setOrigen(reservaDTO.getOrigen())
                        .setDestino(reservaDTO.getDestino())
                        .setAsiento(reservaDTO.getAsiento());
                break;
            case "coche":
                builder.setModeloCoche(reservaDTO.getModeloCoche())
                        .setMatricula(reservaDTO.getMatricula())
                        .setSeguroExtra(reservaDTO.isSeguroExtra());
                break;
            case "hotel":
                builder.setDesayunoIncluido(reservaDTO.isDesayunoIncluido());
                break;
        }

        return builder.build(); // Retornar la reserva construida
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }
}
