public class Circulo2 implements Figuras
{
private double r;
private final double pi =3.1416;

public Circulo2(double r)
{
  this.r=r;
}
@Override
public double area()
{
  return pi*r*r;
}

@Override
public double perimetro()
{
  return (2*pi)*r;
}
}
