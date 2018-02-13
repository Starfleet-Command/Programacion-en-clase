import java.util.Scanner;
public class FibonacciCondicion
{
  public static void main(String[] args)
  {
    int numusuario,regreso,regreso2;
      Scanner lector = new Scanner(System.in);

      System.out.println("Escriba el numero que quiera saber si esta en la secuencia de fibonacci");
      numusuario= lector.nextInt();

      regreso = fibonacci(numusuario);
      regreso2= fibonacci2(numusuario);

      if(regreso== regreso2)
      {
        System.out.println("Este numero esta en la secuencia de fibonacci");
      }
      else System.out.println("Este numero no esta en la secuencia");


      System.out.println("La secuencia en ese numero vale : "+regreso);

  }
    public static int fibonacci(int num)
    {
      if( num == 0)
      {
        return 0;
      }

      else if(num ==1 || num == 2)
      {
        return 1;
      }


      else return (fibonacci(num-1)+fibonacci(num-2));
    }

    public static int fibonacci2(int num2)
    {
      int condicional=0;
      for (int i=0;i<num2 ;i++ )
       {
         condicional = fibonacci(i);
      }
      return condicional;
    }
}
