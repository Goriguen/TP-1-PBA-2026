package tp;

public class TPMain {

    public static void main(String[] args) {
        
        Moto m1 = new Moto("SRP1", 40.0);
        Camion c1 = new Camion(false,"SRP2", 500.0);
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




        
        
        
        
        
        
    }
    
}
