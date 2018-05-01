public class MainPunto
{
  public static void main(String[] args)
  {

    Circulo circle = new Circulo(4.0,12.0,13.0);

    System.out.println("Radio: "+circle.getRadio());
    System.out.println("Diametro: "+circle.getDiametro());
    System.out.println("Circumferencia: "+circle.getCircumferencia());
    System.out.println("Area: "+circle.getArea());

    circle.PrintCirculo();



  }
}
