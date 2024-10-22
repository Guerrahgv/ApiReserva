package reservas.reservas.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
