import java.util.*;
public class Punto
{
  private  double x;
  private double y;

  public Punto(double x,double y)
  {
    this.x=x;
    this.y=y;
  }

  public void setX(double x)
  {
    this.x=x;
  }

  public void setY(double y)
  {
    this.y=y;
  }


  public double[] getPunto()
  {
    double[] p = new double[2];
    p[0]=this.x;
    p[1]=this.y;
    return p;
  }

  public double Distancia(Punto a)
  {
    double r=0;
    r= math.sqrt((a.x-this.x)*(a.x-this.x) + (a.y-this.y)*(a.y-this.y));
    return r;
  }
}
