package reservas.reservas.model;

public class DescuentoSingleton {
    private static DescuentoSingleton instancia;
    private double descuento;

    private DescuentoSingleton() {
        this.descuento = 0.1; // Descuento inicial del 10%
    }

    public static DescuentoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new DescuentoSingleton();
        }
        return instancia;
    }

    public double aplicarDescuento(double costo) {
        return costo - (costo * descuento);
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
