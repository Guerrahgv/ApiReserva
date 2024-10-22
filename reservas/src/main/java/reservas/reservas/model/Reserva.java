package reservas.reservas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.Date;

@Data
public abstract class Reserva {
    private int id;
    private Date fecha;
    private double costo;

    @JsonBackReference // Esto evita que el cliente sea serializado dentro de las reservas, evitando recursividad infinita
    private Cliente cliente;
}
