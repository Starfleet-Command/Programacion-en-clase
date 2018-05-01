public class Punto
{
  protected double x,y;

  public Punto(double x, double y)
  {
    this.x=x;
    this.y=y;
  }




  public void printValores()
  {
    System.out.println("El valor de x es:  "+this.x);
    System.out.println("El valor de y es: "+this.y);
  }
}
