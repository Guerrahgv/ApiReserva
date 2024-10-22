package reservas.reservas.dto;

import lombok.Data;

@Data
public class ReservaDTO {
    private String tipoReserva; // "vuelo", "hotel", "coche"
    private double costo;

    // Campos específicos para reservas de vuelo
    private String vueloNumero;
    private String aerolinea;
    private String origen;
    private String destino;
    private String asiento;

    // Campos específicos para reservas de coche
    private String modeloCoche;
    private String matricula;
    private boolean seguroExtra;

    // Campos específicos para reservas de hotel
    private String nombreHotel;
    private int numNoches;
    private String ubicacion;
    private boolean desayunoIncluido;
}
