public class Cuadrado2 implements Figuras
{
  private double x;

  public Cuadrado2(double x)
  {
    this.x=x;
  }

  public double area()
  {
    return x*x;
  }
  public double perimetro()
  {
    return 4*x;
  }
}
