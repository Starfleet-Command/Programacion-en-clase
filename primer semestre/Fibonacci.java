import java.util.Scanner;
public class Fibonacci
{
  public static void main(String[] args)
  {
    int numusuario,regreso;
      Scanner lector = new Scanner(System.in);

      System.out.println("Escriba el numero que quiera saber de la secuencia de fibonacci");
      numusuario= lector.nextInt();

      regreso = fibonacci(numusuario);

      System.out.println("La secuencia en ese numero vale : "+regreso);

  }
    public static int fibonacci(int num)
    {
      if(num<=1)
      {
        return 1;
      }


      else return (fibonacci(num-1)+fibonacci(num-2));
    }
}
