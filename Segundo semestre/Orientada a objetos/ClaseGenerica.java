public class ClaseGenerica<T> //PUEDEN HABER MAS DE 1 T
{
public  T obj;

  public ClaseGenerica(T o)
  {
    obj=o;
  }

    public void ClassType()
    {
      System.out.println("El tipo de dato T siendo pasado es:" +obj.getClass().getSimpleName() + " y el valor es: " +obj);
    }

    //Para hacer métodos genéricos son:

    public T Metodo(T obj)
    {
      return obj;
    }
}
