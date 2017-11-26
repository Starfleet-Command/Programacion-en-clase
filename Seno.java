import java.util.Scanner;
public class Seno
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    double angulo,radianes,seno;

      System.out.println("Escriba el angulo para el cual quiere sacar el seno (en grados)");
      angulo= lector.nextDouble();

      radianes=Math.toRadians(angulo);

      seno = Math.sin(radianes);

      System.out.println("El seno de su angulo es: "+seno);


  }
}
