public class PracticaSubString
{
  public static void main(String[] args)
  {
    String nombre = "Finirial Lavellan";
    //String parte = nombre.substring(2,4);
    palabras(nombre);
    //System.out.println(parte);

  }
    public static void palabras(String nom)
    {
      if(nom.length() <=1)
      {
          System.out.print(nom+" ");
      }
      else
    {
      palabras(nom.substring(0,nom.length()-1));
      System.out.print(nom+" ");
    }

    return;
  }
}
