package reservas.reservas.repository;

import reservas.reservas.model.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaRepository {
    private List<Reserva> reservas = new ArrayList<>();

    public void guardarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Optional<Reserva> obtenerReserva(int id) {
        return reservas.stream().filter(r -> r.getId() == id).findFirst();
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservas;
    }
}
