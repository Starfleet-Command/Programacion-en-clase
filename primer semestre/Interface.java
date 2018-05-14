public class Interface implements Test
{
// Lista de métodos abstractos que dictan ciertos requerimientos para un objeto. Aplica un estandar de como se va a a relacionar con objetos externos
//Varios tipos de interface: Comparable (único método CompareTo), Iterable (), List (add,remove,clear,equals, toma a un objeto como un almacenamiento de tipo Array)
protected String bok;
public descripcion(String bok)
{
  this.bok = bok;
}

abstract String bokeh();
abstract int compareTo();





}

public interface Test
{
  public String bok = "unscharfte";
  public int compareTo();
  public String bokeh();
}
