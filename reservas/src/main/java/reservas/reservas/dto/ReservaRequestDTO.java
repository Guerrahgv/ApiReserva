package reservas.reservas.dto;

import lombok.Data;

@Data
public class ReservaRequestDTO {
    private ClienteDTO cliente;
    private ReservaDTO reserva;
}
