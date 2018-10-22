public class Jugador
{
 private int dedos;
 private String nombre;
 private Jugador siguiente;
 private Jugador previo;

 public Jugador(int dedos,String nombre)
 {
     this.dedos= dedos;
     this.nombre=nombre;
 }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDedos() {
        return dedos;
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }

    public void setDedos(int dedos) {
        this.dedos = dedos;
    }

    public Jugador getPrevio() {
        return previo;
    }

    public void setPrevio(Jugador previo) {
        this.previo = previo;
    }

    @Override
    public String toString() {
        return "Dedos levantados=" + dedos ;
    }




}
