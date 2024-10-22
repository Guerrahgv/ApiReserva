package reservas.reservas.model;

import lombok.Data;

@Data
public class ReservaVuelo extends Reserva {
    private String vueloNumero;
    private String aerolinea;
    private String origen;
    private String destino;
    private String asiento;
}
