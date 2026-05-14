package tp;

public class Repartidor {

    private String nombre;
    private double resistencia = 100.0;
    private double pesoMaximoCarga;
    private PuntoDeDistribucion ubicacionActual;
    private Vehiculo vehiculoActual = null;

    public String getNombre() {
        return nombre;
    }

    public double getPesoMaximoCarga() {
        return pesoMaximoCarga;
    }

    public Vehiculo getVehiculoActual() {
        return vehiculoActual;
    }

    public PuntoDeDistribucion getUbicacionActual() {
        return ubicacionActual;
    }

    public double getResistencia() {
        return resistencia;
    }

    public Repartidor(String nombre, double pesoMaximoCarga, PuntoDeDistribucion ubicacionActual, Vehiculo vehiculoActual) {
        this.nombre = nombre;
        this.pesoMaximoCarga = pesoMaximoCarga;
        this.ubicacionActual = ubicacionActual;
        this.vehiculoActual = vehiculoActual;


    }

    protected void viajarA(PuntoDeDistribucion destino) {
        double distancia = ubicacionActual.distanciaA(destino);
        if (vehiculoActual != null) {
            //¿Tiene batería suficiente?
            double consumo = vehiculoActual.consumoDeBateria(distancia);
            if (vehiculoActual.bateriaDisponible() >= consumo) {
            vehiculoActual.desplazarse(distancia);
            ubicacionActual = destino;
            System.out.println(nombre + " viajando en vehículo a " + destino.getNombreNodo());
            } else {
                System.out.println("No hay batería suficiente en el vehículo para este viaje. Debe recargar.");
            }
        } else {
            double resistenciaNecesaria = distancia * 0.8;
            if (resistencia >= resistenciaNecesaria) {
                resistencia -= resistenciaNecesaria;
                ubicacionActual = destino;
                System.out.println(nombre + " viajó a pie a " + destino.getNombreNodo());
            } else {
                System.out.println("Necesita descansar para completar el viaje. Faltan " +
                    String.format("%.2f", resistenciaNecesaria - resistencia) + " puntos de resistencia.");
            }
            //if(resistencia), explicación del método:
            //necesito una lógica que averigüe si lo que va a recorrer
            //excede la resistencia que tiene el personaje, es decir
            //si el viaje consume 30 de resistencia y se está en 20
            //que no permita hacer el viaje, indique cuanta resistencia falta,
            // e imprima por pantalla: necesita descansar.
            // descansar ofrece +30 pts de resistencia.
        }
    }

    protected boolean puedeCargar(Paquete p) {
        double peso = p.getPeso();

        // validación 1:peso inválido
        if (peso <= 0) {
            System.out.println("El peso no es un número válido.");
            return false;
        }
        // validación 2: a pie o con vehículo
        if (vehiculoActual == null) {
            if (peso > pesoMaximoCarga || resistencia <= 20.0) {
                System.out.println("No puede cargar a pie.");
                return false;
            }
        } else {
            if (peso > vehiculoActual.getCapacidadCargaKg()) {
                System.out.println("Excede capacidad del vehículo.");
                return false;
            }
        }
        System.out.println("Puede cargar el paquete.");
        return true;
    }

    protected void descansar() {
        double resultado = resistencia + 30;
        if (resultado >= 100)
        //si el descanso +30 pts + resistencia actual es mayyor
        //que resistencia maxima, entonces el max es 100
        {
            resistencia = 100.0;
        }
        else{
            resistencia += 30.0;
        }
            
    }

    protected void equiparVehiculo(Vehiculo v) {
        //implementar una lógica que permita elegir un vehiculo pre-cargado
        //posiblemente de un array de vehiculos
        this.vehiculoActual = v;
        System.out.println(nombre + " equipó un " + v.descripcionTipo());
    }

    protected void desequiparVehiculo() {
        //de la misma forma que el método anterior, una lógica que permita
        //desequipar el vehiculo actual
        //pero sería necesario entonces que el vehículo sea devuelto, ¿no?
        //¿tendría que tener un booleano que dice: vehíchulo disponible/ocupado?
        //sería útil hacerlo así
        if (vehiculoActual != null) {
            System.out.println(nombre + " desequipó el " + vehiculoActual.descripcionTipo());
            this.vehiculoActual = null;
        } else {
            System.out.println(nombre + " no tiene vehículo equipado.");
        }
    }

    @Override
    public String toString() {
        return "Repartidor{" + "nombre=" + nombre + ", resistencia=" + resistencia + ", pesoMaximoCarga=" + pesoMaximoCarga + ", ubicacionActual=" + ubicacionActual + ", vehiculoActual=" + vehiculoActual + '}';
    }

    protected void desplazarse() {
        
    }


}
