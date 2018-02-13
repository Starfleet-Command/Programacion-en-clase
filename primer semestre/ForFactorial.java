import java.util.Scanner;
public class ForFactorial
{
  public static void main(String[]args)
  {
    int a,numus;
    int suma=1;


     Scanner lector = new Scanner(System.in);

     System.out.println("Escriba un numero");
     numus= lector.nextInt();

     for (a=1;a<=(numus);a++)
     {
       suma*=a;
       System.out.printf("%d.%n",suma);
     }

      System.out.println("El factorial de tu numero es el ultimo resultado");
  }
}
