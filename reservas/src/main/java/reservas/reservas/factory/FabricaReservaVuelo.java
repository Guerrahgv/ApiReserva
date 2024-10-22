package reservas.reservas.factory;

import reservas.reservas.model.Reserva;
import reservas.reservas.model.ReservaVuelo;

public class FabricaReservaVuelo extends FabricaReserva {

    @Override
    public Reserva crearReserva() {
        return new ReservaVuelo();
    }
}
