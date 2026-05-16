
package tp;

public class Moto extends Vehiculo{

    public Moto(String id, double capacidadCargaKg) {
        super(id, capacidadCargaKg);
    }
  
    @Override
    public void desplazarse(double distanciaKm) {
        double consumo = consumoDeBateria(distanciaKm);
        double bateriaActualizada = bateriaDisponible() - consumo;
        setBateriaActual(bateriaActualizada);
        System.out.println("Vehiculo: Moto. Desplazado " + String.format("%.2f" ,distanciaKm) + " km. Batería restante: "
                + String.format("%.2f%%", bateriaDisponible()));
    }

    //este método funciona porque lo hereda del padre (Vehiculo)
    //quien al ser una clase abstracta, define la firma pero no el cuerpo
    //al estar obligada la clase hija a usarla y darle el cuerpo
    //asignamos y sobreescribimos al método para que devuelva
    //el tipo de Vehiculo de la clase
    @Override
    public String descripcionTipo() {
        return "Una Moto";
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    protected double consumoDeBateria(double distancia) {
        double consumo = distancia * 0.5;
        return consumo;
    }

    
    
}

