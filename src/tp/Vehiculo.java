
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

    protected String getId() {
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

    protected void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    protected void setBateriaActual(double bateriaActual) {
        if (bateriaActual < 0) {
            this.bateriaActual = 0;
        }else if (bateriaActual > BATERIA_MAXIMA) {
        this.bateriaActual = BATERIA_MAXIMA;
        } else {
            this.bateriaActual = bateriaActual;
        }
    }
    
    
    protected void cargarBateria (double cantidad){
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
    
    protected abstract void desplazarse(double distanciaKm);
    protected abstract String descripcionTipo();
    protected abstract double consumoDeBateria(double distancia);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                "id=" + getId() +
                ", bateriaActual=" + bateriaDisponible() +
                ", capacidadCargaKg=" + getCapacidadCargaKg() + '}';
    }
}
