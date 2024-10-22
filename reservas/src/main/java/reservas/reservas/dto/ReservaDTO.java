package reservas.reservas.dto;

import lombok.Data;

@Data
public class ReservaDTO {
    private String tipoReserva; // "vuelo", "hotel", "coche"
    private double costo;


    private String vueloNumero;
    private String aerolinea;
    private String origen;
    private String destino;
    private String asiento;


    private String modeloCoche;
    private String matricula;
    private boolean seguroExtra;


    private String nombreHotel;
    private int numNoches;
    private String ubicacion;
    private boolean desayunoIncluido;
}
