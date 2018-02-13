import java.util.Scanner;

public class Rueda2
{
public static void main(String[] args) {

  Double Grosor;
  Double Diametro;

  Scanner lector = new Scanner(System.in);

  System.out.println("Escriba el grosor");
  Grosor = lector.nextDouble();

  System.out.println("Escriba el diametro");
  Diametro = lector.nextDouble();



  if (Diametro> 1.4 && Grosor<0.4 )
  {
    System.out.println("La rueda es para un vehículo grande");
    System.out.println("El grosor para esta rueda es inferior al recomendado");

  }
  else if (Diametro=< 1.4 && Diametro>0.8 && Grosor<0.25)
  {
    System.out.println("La rueda es para un vehiculo mediano");
    System.out.println("El grosor para esta rueda es inferior al recomendado");

  else if (Diametro> 1.4 && Grosor>=0.4)
  {
    System.out.println("La rueda es para un vehículo grande");
  }
  else if (Diametro =<1.4 && Diametro>0.8 && Grosor>= 0.25)
  {
    System.out.println("La rueda es para un vehiculo mediano");
  }
  else if (Diametro=< 0.8)
  {
    System.out.println("La rueda es para un vehiculo pequeño");
  }


}
}
}
