
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean estaConectado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getNombreNodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "PuntoDeDistribucion{" + "nombre=" + nombre + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", conectado=" + conectado + ", visitado=" + visitado + '}';
    }
    
    
}
