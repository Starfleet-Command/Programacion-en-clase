import java.util.Scanner;
public class DoWhileFactorial
{
  public static void main(String[]args)
  {
    int a=1;
    int numus;
    int suma=1;

    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba un numero");
    numus= lector.nextInt();

    do
    {
      suma*=a;
      a++;
      System.out.printf("%d %n",suma);

    } while (a<=numus);

  }
}
