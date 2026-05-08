
package tp;

public abstract class Vehiculo {
    
    private String id;
    private double capacidadCargaKg;
    private static final double BATERIA_MAXIMA = 100;
    private double bateriaActual = BATERIA_MAXIMA;
    
    public Vehiculo(String id, double capacidadCargaKg) {
        this.id = id;
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public String getId() {
        return id;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public static double getBATERIA_MAXIMA() {
        return BATERIA_MAXIMA;
    }

    public double getBateriaActual() {
        return bateriaActual;
    }
    
    
    protected void cargarBateria (double cantidad){}
    
    protected double bateriaDisponible(){
        double bateriaRestante=0.0;
        return bateriaRestante;
    }
    
    public abstract void desplazarse(double distanciaKm);
    public abstract String descripcionTipo();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                "id=" + getId() +
                ", bateriaActual=" + getBateriaActual() +
                ", capacidadCargaKg=" + getCapacidadCargaKg() + '}';
    }
}
