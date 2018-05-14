import java.util.*;
import java.lang.ArithmeticException;
public class PracticaExcepciones
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
int intento=0;
try
{
    System.out.println("Escriba un numero mayor a 0");
     intento = lector.nextInt();
    if(intento<0)
    {
      throw new InputMismatchException();
    }
}
catch(InputMismatchException ex)
{
  System.out.println("Le dije que escribiera un numero mayor a 0,retrasado");
}

try
{
  System.out.println("Escriba otro número por el cual quiere dividir al primero");
  int intento2 = lector.nextInt();
  int resultado = (intento/intento2);
  System.out.println("El resultado es "+resultado);
}
catch(ArithmeticException el)
{
  System.out.println("Division entre 0? En serio?");
}
catch(InputMismatchException ex)
{
  System.out.println("Le dije que escribiera un numero mayor a 0,retrasado");
}

  }
}
