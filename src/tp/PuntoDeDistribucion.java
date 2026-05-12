
package tp;

public class PuntoDeDistribucion implements Conectable {
    
    private String nombre;
    private double coordenadaX, coordenadaY;
    private boolean conectado = false;
    private boolean visitado = false;

    public PuntoDeDistribucion(String nombre, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    protected double distanciaA(PuntoDeDistribucion otro){
        
        //obtenemos el valor actual de las coordenadas
        //y medimos la distancia entre ambas (restamos)
        double difX = otro.coordenadaX - this.coordenadaX;
        double difY = otro.coordenadaY - this.coordenadaY;
        
        //elevamos al cuadrado cada una
        //sumamos
        //y sacamos la raíz
        double distancia = Math.sqrt(Math.pow(difX, 2) +
                           Math.pow(difY, 2));
        
        //devolvemos la distancia euclidiana
        return distancia;
    }



    @Override
    public boolean conectarALaRed() {
        if(visitado == true){
            conectado = true;
            System.out.println("Conectado");
            return true;
        }else{
            System.out.println("No pudo ser conectado");
            return false;
        }
    }

    @Override
    public boolean estaConectado() {
        if(conectado == false){
            System.out.println("No se encuentra conectado a esta red aún.");
            return false;
        }else{
            System.out.println("Conectado a esta red.");
            return true;
        }
    }

    @Override
    public String getNombreNodo() {
        String nombreNodo = "El nombre del nodo es: " + this.nombre + ".";
        return nombreNodo;
    }

    @Override
    public String toString() {
        return "PuntoDeDistribucion{" + "nombre=" + nombre + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", conectado=" + conectado + ", visitado=" + visitado + '}';
    }
    
    
}
