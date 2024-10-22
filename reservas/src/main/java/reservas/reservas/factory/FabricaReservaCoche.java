package reservas.reservas.factory;

import reservas.reservas.model.Reserva;
import reservas.reservas.model.ReservaCoche;

public class FabricaReservaCoche extends FabricaReserva {

    @Override
    public Reserva crearReserva() {
        return new ReservaCoche();
    }
}
