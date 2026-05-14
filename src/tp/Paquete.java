
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

    protected void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public void setId(String id) {
        if(id == null) return;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paquete{" + "id=" + id +
                ", descripcion=" + descripcion +
                ", peso=" + peso + ", urgente=" +
                urgente + '}';
    }

    @Override
    protected Object clone() {

        Paquete copia = new Paquete(this.id, this.descripcion, this.peso, this.urgente);
        return copia;
    }

    @Override
    public int compareTo(Paquete o) {

        //Paquetes urgentes van primero
        if(this.urgente && !o.urgente) {
            return -1;
        }
        if(!this.urgente && o.urgente) {
            return 1;
        }

        //Si ambos son urgentes, el de menor peso va primero
        if(this.peso < o.peso) {
            return -1;
        }
        if(this.peso > o.peso) {
            return 1;
        }

        //Si tienen el mismo peso, ordena por orden alfabético
        int resultado = this.id.compareTo(o.id);
        return resultado;
    }

    
    
    
    }


