import java.util.Scanner;

public class While2
{
public static void main(String[] args)
{
  double lado;
  String respuesta;
  Scanner reader = new Scanner(System.in);

  respuesta="si";
do {
  System.out.println("Dame la longitud del lado del cuadrado");
  lado=reader.nextDouble();
  reader.nextLine();

  System.out.printf("El area es %.2f.%n", lado*lado);

  System.out.println("Quieres hacerlo de nuevo? (si) (no)");
  respuesta=reader.nextLine().toLowerCase();

} while (!respuesta.equalsIgnoreCase("no"));

  System.out.println("Gracias");
}
}
