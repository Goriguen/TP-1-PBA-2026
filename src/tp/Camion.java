
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
    protected double consumoDeBateria(double distancia) {
        
        double consumo;
        if(tieneRemolque != false){
            consumo = distancia * 2.5;
        }else{
            consumo = distancia * 1.8;
        }
        return consumo;
    }
    
    @Override
    public String toString() {
        return "Camion{"
                + "id=" + getId()
                + ", bateriaActual=" + bateriaDisponible()
                + ", capacidadCargaKg=" + getCapacidadCargaKg()
                + ", tieneRemolque=" + this.tieneRemolque
                + '}';
    }


}
