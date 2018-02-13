import java.util.Scanner;

public class PracticaExamen
{

public static void main(String[] args)
{
  int contador,numusuario,suma;
  Scanner lector= new Scanner(System.in);

  System.out.println("Escriba un numero menor o igual a 100");
  numusuario=lector.nextInt();

  System.out.printf("El factorial de ese número es %d.%n",Factorial(numusuario));

}

  public static int Factorial(int num)
  {
    int contador=1;
    int fact=1;

    while (contador<=num)
    {
      fact *= contador;
      contador++;

    }
    return fact;

  }

}
