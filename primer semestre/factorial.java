import java.util.Scanner;

public class factorial
{
  public static void main(String[] args)
  {
    int contador;
    int numus;
    int sumamax;
    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba un numero menor a 100");
    numus= lector.nextInt();


      System.out.printf("Factorial: %d%n", factorial(numus));

  }
    public static int factorial(int num)  //Se puede hacer de dos maneras: desde main o desde método. este es desde metodo
    {
    int contador=1;
    int fact= 1;
    while (contador<= num)
    {
      fact *= contador;
      contador++;
    }
    return fact;
    }

  }
