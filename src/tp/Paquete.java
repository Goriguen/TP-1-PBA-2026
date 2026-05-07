
package tp;

public class Paquete implements Comparable<Paquete>, Cloneable {
    
    private String id, descripcion;
    private double peso;
    private boolean urgente;

    
    
    public Paquete(String id, String descripcion, double peso, boolean urgente) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.urgente = urgente;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    @Override
    public String toString() {
        return "Paquete{" + "id=" + id + ", descripcion=" + descripcion + ", peso=" + peso + ", urgente=" + urgente + '}';
    }

    @Override
    protected Object clone() {
        return 0; 
    }

    @Override
    public int compareTo(Paquete o) {
        return 0;
    }

    
    
    
    }


