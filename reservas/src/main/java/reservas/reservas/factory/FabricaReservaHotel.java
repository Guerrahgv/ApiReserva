package reservas.reservas.factory;

import reservas.reservas.model.Reserva;
import reservas.reservas.model.ReservaHotel;

public class FabricaReservaHotel extends FabricaReserva {

    @Override
    public Reserva crearReserva() {
        return new ReservaHotel();
    }
}
