package reservas.reservas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @JsonManagedReference // Esta referencia se manejará y no causará recursividad
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
}
