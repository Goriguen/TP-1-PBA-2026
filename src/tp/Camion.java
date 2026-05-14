
package tp;

public class Camion extends Vehiculo{
    
    private boolean tieneRemolque;

    public Camion(boolean tieneRemolque, String id,  double capacidadCargaKg) {
        super(id, capacidadCargaKg);
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public void desplazarse(double distanciaKm) {
        double consumo = consumoDeBateria(distanciaKm);
        double bateriaActualizada = bateriaDisponible() - consumo;
        setBateriaActual(bateriaActualizada);
        System.out.println("Camión: desplazado " + distanciaKm + " km. Batería restante: "
                + String.format("%.2f%%", bateriaDisponible()));
    }

    //este método funciona porque lo hereda del padre (Vehiculo)
    //quien al ser una clase abstracta, define la firma pero no el cuerpo
    //al estar obligada la clase hija a usarla y darle el cuerpo
    //asignamos y sobreescribimos al método para que devuelva
    //el tipo de Vehiculo de la clase
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
