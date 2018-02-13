import java.util.Scanner;

public class FactorialFor
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    int usuario;
    int factorial = 1;

    System.out.println("Escriba el numero del cual quiere obtener el factorial");
    usuario = lector.nextInt();

    for (int i=1;i<=usuario;i++ ) {
      factorial *= i;

    }

    System.out.printf("El numero factorial es %d",factorial);
  }
}
