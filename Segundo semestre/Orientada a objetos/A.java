public class A extends B
{


  public void method2()
  {
    System.out.println("Este es el metodo dos de A");
    method1();
    super.method2();
  }

  public void method1()
  {
    System.out.println("Este es el metodo 1 de A");
  }
}
