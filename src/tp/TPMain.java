package tp;

public class TPMain {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.ejecutar();
        
        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = new Moto("RAM-CABA01", 35);
        vehiculos[1] = new Camion(true, "RAA-ABA02", 35);
        
        // POLIMORFISMO:
        // Aunque cada elemento de vehiculos[] se referencia como tipo Vehiculo,
        // el tipo REAL del objeto (Moto o Camion) se determina en tiempo de ejecución.
        // Cuando Java ejecuta v.descripcionTipo(), invoca la versión sobrescrita de la subclase,
        // no la de Vehiculo. y es lo que permite que cada vehículo imprima su tipo correcto.
        for(Vehiculo v : vehiculos){
            System.out.println("El tipo de vehículo es: " + v.descripcionTipo() + "\n");
        }
        
        Moto m1 = new Moto("SRP1", 40.0);
        Camion c1 = new Camion(false,"SRP2", 500.0);
        //Repartidor r1 = new Repartidor("Sam", 140, "NoroesteWC", v1);
        System.out.println(m1.getId());
        System.out.println(m1.bateriaDisponible());
        System.out.println(m1.getClass());
        System.out.println(m1.toString());
        System.out.println(c1.toString());
        
        System.out.println("Vamos a cargar bateria");
        System.out.println("La bateria actual es: " + m1.bateriaDisponible());
        m1.setBateriaActual(70.0);
        System.out.println("Si le resto 30 queda en: " + m1.bateriaDisponible());
        System.out.println("\nProcedo a cargar bateria.\n");
        System.out.println("CARGANDO BATERÍA");
        m1.cargarBateria(27);
        System.out.printf("La cantidad de bateria actual es: \n%.2f%%\n\n" , m1.bateriaDisponible());
        
        System.out.printf("El consumo de bateria de un camión es %.2f%%\n\n" , c1.consumoDeBateria(43));
        System.out.printf("El consumo de bateria de una moto es es %.2f%%\n\n" , m1.consumoDeBateria(30));
        




        
        
        
        
        
        
    }
    
}
