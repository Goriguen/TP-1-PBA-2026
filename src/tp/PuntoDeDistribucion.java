
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
        double distancia=0.0;
        return distancia;
    }

    @Override
    public String toString() {
        return "PuntoDeDistribucion{" + "nombre=" + nombre + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", conectado=" + conectado + ", visitado=" + visitado + '}';
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
    
    
}
