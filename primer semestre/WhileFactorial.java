import java.util.Scanner;
public class WhileFactorial
{
  public static void main(String[]args)
  {
    int a=1;
    int numus;
    int suma=1;

    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba un numero");
    numus= lector.nextInt();

    while(a<=numus)
    {
      suma*=a;
      a++;

      System.out.printf("%d.%n",suma);
    }

    System.out.println("El factorial de tu numero es el último resultado");
  }
}
