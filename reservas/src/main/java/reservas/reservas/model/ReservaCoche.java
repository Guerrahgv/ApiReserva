package reservas.reservas.model;

import lombok.Data;

@Data
public class ReservaCoche extends Reserva {
    private String modeloCoche;
    private String matricula;
    private boolean seguroExtra;
}
