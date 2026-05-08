package tp;

public class TPMain {

    public static void main(String[] args) {
        
        Moto m1 = new Moto("SRP", 40.0);
        Camion c1 = new Camion(true,"PRP2", 340);
        System.out.println(m1.getId());
        System.out.println(m1.getBateriaActual());
        System.out.println(m1.getClass());
        System.out.println(m1.toString());
        System.out.println(c1.toString());


        
        
        
        
        
        
    }
    
}
