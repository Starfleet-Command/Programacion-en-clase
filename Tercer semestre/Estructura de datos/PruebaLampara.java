public class PruebaLampara
{

public static void main(String[] args)
{
  Lampara lamp = new Lampara("gris",80,3,false);
  System.out.printf("%s",lamp.returnPrendido());
  lamp.prender();
  lamp.apagar();
  lamp.prender();
  lamp.intensidad(2);
  lamp.intensidad(4);
}
}
