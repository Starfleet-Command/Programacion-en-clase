import java.util.Scanner;
public class Armonico
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    double armonico;
    double  resultado=1;

    System.out.println("escriba el numero y le dire su armonico");
    armonico =lector.nextDouble();

    for (double i=armonico;i>1 ;i-- ) {
      resultado*=(i/(i+1));
      System.out.println("Resultado: "+resultado);
    }
  }
}
