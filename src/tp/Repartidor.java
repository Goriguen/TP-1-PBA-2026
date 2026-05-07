package tp;

public class Repartidor {

    private String nombre;
    private double resistencia = 100.0;
    private double pesoMaximoCarga;
    private PuntoDeDistribucion ubicacionActual;
    private Vehiculo vehiculoActual;

    public Repartidor(String nombre, double pesoMaximoCarga, PuntoDeDistribucion ubicacionActual, Vehiculo vehiculoActual) {
        this.nombre = nombre;
        this.pesoMaximoCarga = pesoMaximoCarga;
        this.ubicacionActual = ubicacionActual;
        this.vehiculoActual = vehiculoActual;
    }

    public void viajarA(PuntoDeDistribucion destino) {

    }

    public boolean puedeCargar(Paquete p) {
        boolean resultado = false;
        return resultado;
    }

    public void descansar() {
    }

    public void equiparVehiculo(Vehiculo v) {
    }

    public void desequiparVehiculo() {
    }

    @Override
    public String toString() {
        return "Repartidor{" + "nombre=" + nombre + ", resistencia=" + resistencia + ", pesoMaximoCarga=" + pesoMaximoCarga + ", ubicacionActual=" + ubicacionActual + ", vehiculoActual=" + vehiculoActual + '}';
    }


}
