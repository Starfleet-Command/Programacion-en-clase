public class MainPract
{
  public static void main(String[] args)
  {
    PractHerencia2 pract = new PractHerencia2();
    PractHerencia2[] elements = {new PractHerencia(), new PractHerencia1(), new PractHerencia2()};
    for(int i=0; i<elements.length;i++)
    {
      System.out.println(pract);
      elements[i].Song();
      System.out.println("");
      elements[i].Song2();
      System.out.println("");

    }
  }
}
