
package tp;

public abstract class Vehiculo {
    
    protected String id;

    protected double capacidadCargaKg;
    protected static final double BATERIA_MAXIMA = 100;
    protected double bateriaActual = BATERIA_MAXIMA;
    
    public Vehiculo(String id, double capacidadCargaKg) {
        this.id = id;
        this.capacidadCargaKg = capacidadCargaKg;
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
        return "Vehiculo{" + "id=" + id + ", bateriaActual=" + bateriaActual + ", capacidadCargaKg=" + capacidadCargaKg + '}';
    }
}
