public class Libro
{
  private String titulo,autor;
  private int pagnum;

  public Libro(String titulo, String autor, int pagnum)
  {
    this.titulo = titulo;
    this.autor = autor;
    this.pagnum= pagnum;
  }

  public String returnLibro()
  {
    return titulo;
  }

  public String returnAutor()
  {
    return autor;
  }

  public int returnPage()
  {
    return pagnum;
  }


}
