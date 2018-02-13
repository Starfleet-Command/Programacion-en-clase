import java.util.Scanner;

public class Infinito2
{
  public static void main(String[] args)
  {
    int contador;
    int numus;
    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba un numero menor a 100");
    numus= lector.nextInt();

    contador=100;

    while(contador>=numus)
    {
      System.out.printf("Conteo Regresivo: %d%n", contador);

      contador --;
    }
  }
}
