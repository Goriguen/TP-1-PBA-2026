
package tp;

public class Camion extends Vehiculo{
    
    private boolean tieneRemolque;

    public Camion(boolean tieneRemolque, String id,  double capacidadCargaKg) {
        super(id, capacidadCargaKg);
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public void desplazarse(double distanciaKm) {}

    @Override
    public String descripcionTipo() {
        return "Camion";
    }

    @Override
    public String toString() {
        return "Camion{"
                + "id=" + getId()
                + ", bateriaActual=" + getBateriaActual()
                + ", capacidadCargaKg=" + getCapacidadCargaKg()
                + ", tieneRemolque=" + this.tieneRemolque
                + '}';
    }


}
