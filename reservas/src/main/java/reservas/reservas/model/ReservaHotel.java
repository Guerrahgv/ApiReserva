package reservas.reservas.model;

import lombok.Data;

@Data
public class ReservaHotel extends Reserva {
    private String nombreHotel;
    private int numNoches;
    private String ubicacion;
    private boolean desayunoIncluido;
}
