package reservas.reservas.model;

import java.util.Date;

public class ReservaBuilder {
    private Reserva reserva;

    public ReservaBuilder(String tipo) {
        switch (tipo.toLowerCase()) {
            case "vuelo":
                this.reserva = new ReservaVuelo();
                break;
            case "hotel":
                this.reserva = new ReservaHotel();
                break;
            case "coche":
                this.reserva = new ReservaCoche();
                break;
            default:
                throw new IllegalArgumentException("Tipo de reserva no soportado.");
        }
    }

    public ReservaBuilder setCliente(Cliente cliente) {
        reserva.setCliente(cliente);
        return this;
    }

    public ReservaBuilder setFecha(Date fecha) {
        reserva.setFecha(fecha);
        return this;
    }

    public ReservaBuilder setCosto(double costo) {
        reserva.setCosto(costo);
        return this;
    }

    // Métodos para campos específicos de vuelo
    public ReservaBuilder setVueloNumero(String vueloNumero) {
        if (reserva instanceof ReservaVuelo) {
            ((ReservaVuelo) reserva).setVueloNumero(vueloNumero);
        }
        return this;
    }

    public ReservaBuilder setAerolinea(String aerolinea) {
        if (reserva instanceof ReservaVuelo) {
            ((ReservaVuelo) reserva).setAerolinea(aerolinea);
        }
        return this;
    }

    public ReservaBuilder setOrigen(String origen) {
        if (reserva instanceof ReservaVuelo) {
            ((ReservaVuelo) reserva).setOrigen(origen);
        }
        return this;
    }

    public ReservaBuilder setDestino(String destino) {
        if (reserva instanceof ReservaVuelo) {
            ((ReservaVuelo) reserva).setDestino(destino);
        }
        return this;
    }

    public ReservaBuilder setAsiento(String asiento) {
        if (reserva instanceof ReservaVuelo) {
            ((ReservaVuelo) reserva).setAsiento(asiento);
        }
        return this;
    }

    // Métodos para campos específicos de coche
    public ReservaBuilder setModeloCoche(String modeloCoche) {
        if (reserva instanceof ReservaCoche) {
            ((ReservaCoche) reserva).setModeloCoche(modeloCoche);
        }
        return this;
    }

    public ReservaBuilder setMatricula(String matricula) {
        if (reserva instanceof ReservaCoche) {
            ((ReservaCoche) reserva).setMatricula(matricula);
        }
        return this;
    }

    public ReservaBuilder setSeguroExtra(boolean seguroExtra) {
        if (reserva instanceof ReservaCoche) {
            ((ReservaCoche) reserva).setSeguroExtra(seguroExtra);
        }
        return this;
    }

    // Métodos para campos específicos de hotel
    public ReservaBuilder setDesayunoIncluido(boolean desayunoIncluido) {
        if (reserva instanceof ReservaHotel) {
            ((ReservaHotel) reserva).setDesayunoIncluido(desayunoIncluido);
        }
        return this;
    }

    public Reserva build() {
        return this.reserva;
    }
}
