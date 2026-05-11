
package tp;

public abstract class Vehiculo {
    
    private String id;
    private double capacidadCargaKg;
    private static final double BATERIA_MAXIMA = 100;
    private double bateriaActual;
    
    public Vehiculo(String id, double capacidadCargaKg) {
        this.id = id;
        this.capacidadCargaKg = capacidadCargaKg;
        this.bateriaActual = BATERIA_MAXIMA;
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

    private double getBateriaActual() {
        return bateriaActual;
    }

    public void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public void setBateriaActual(double bateriaActual) {
        this.bateriaActual = bateriaActual;
    }
    
    
    public void cargarBateria (double cantidad){
        double carga;
        //casos borde a evaluar:
        //1)¿Qué pasa si la bateria actual es 0?
        //2)¿Qué pasa si cantidad <= 0?
        if (cantidad <= 0){
            System.out.println("ERROR, debe retornar un valor positivo válido y mayor a cero.");
            return;
        }
        //3)¿Qué pasa si cantidad > 0?
        //4)¿Qué pasa si cantidad >= 0? ==> No aplica. La condición 1 y 2 evalúa si es = 0
        //5¿Qué pasa si cantidad > BATERIA_MAXIMA? ==> Se cumple en la condición 3
        
        if(cantidad > 0 && cantidad > BATERIA_MAXIMA){
            carga = BATERIA_MAXIMA - bateriaActual;
            setBateriaActual(carga);
        }else{
            carga = bateriaActual + cantidad;
            setBateriaActual(carga);
        }

        
    }
    
    protected double bateriaDisponible(){
        double bateriaRestante = (getBateriaActual() * 100.0) / BATERIA_MAXIMA ;
        return bateriaRestante;
    }
    
    public abstract void desplazarse(double distanciaKm);
    public abstract String descripcionTipo();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                "id=" + getId() +
                ", bateriaActual=" + bateriaDisponible() +
                ", capacidadCargaKg=" + getCapacidadCargaKg() + '}';
    }
}
