public class MainLetras
{
  public static void main(String[] args)
  {
    A a = new A();
    Herencia[] elements = {new A(), new B(), new Herencia(), new D()};
    for(int i=0; i<elements.length;i++)
    {
      System.out.println(a);
      elements[i].method1();
      System.out.println("");
      elements[i].method2();
      System.out.println("");

    }
  }
}
