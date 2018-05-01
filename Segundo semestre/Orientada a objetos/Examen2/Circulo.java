public class Circulo extends Punto{


double radio,x,y,diametro,circumferencia,area;
public Circulo(double radio,double x,double y)
{
  super(x,y);
  this.radio=radio;

}

public double getRadio()
{
  return radio;
}

public double getDiametro()
{
  diametro = 2*radio;
  return diametro ;
}

public double getCircumferencia()
{
  circumferencia = 3.1416*diametro;
  return circumferencia;
}

public double getArea()
{
  area=(3.1416*(radio*radio));
  return area;
}

public void PrintCirculo()
{
  super.printValores();
  System.out.println("el valor del radio es: "+this.radio);
}
}
