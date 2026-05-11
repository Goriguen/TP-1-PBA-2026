
package tp;

public class Moto extends Vehiculo{

    public Moto(String id, double capacidadCargaKg) {
        super(id, capacidadCargaKg);
    }
  
    @Override
    public void desplazarse(double distanciaKm) {}

    @Override
    public String descripcionTipo() {
        return "Moto";
    }

    
    
}

