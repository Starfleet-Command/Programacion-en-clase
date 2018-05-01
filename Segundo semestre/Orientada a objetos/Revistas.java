public class Revistas extends ObrasLiterarias
{
    public Revistas(Autor author, String nombre, int numpag)
    {
      this.author = author;
      this.nombre = nombre;
      this.numpag = numpag;
    }

    public void getAuthor()
    {
      return author;
    }

    public void getNombre()
    {
      return nombre;
    }

    public void getNumpag()
    {
      return numpag;
    }


}
