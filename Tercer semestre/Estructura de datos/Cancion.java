public class Cancion
{
    private String nombre;
    private int duracion;
    private String artista;
    private String album;
    private Cancion previa;
    private Cancion siguiente;

    public Cancion(String nombre, int duracion, String artista, String album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.artista = artista;
        this.album = album;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Cancion getPrevia() {
        return previa;
    }

    public void setPrevia(Cancion previa) {
        this.previa = previa;
    }

    public Cancion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cancion siguiente) {
        this.siguiente = siguiente;
    }




}
