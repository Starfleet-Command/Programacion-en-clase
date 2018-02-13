import java.util.Scanner;
public class GCD

{
  public static void main(String[]args)
  {
    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba el primer numero con el que se va acalcular el GCD");
    int uno= lector.nextInt();

    System.out.println("Escriba el segundo numero con el que se va acalcular el GCD");
    int dos=lector.nextInt();

if(uno<dos)
{
  System.out.println("Disculpa, este calculo no se puede realizar");
}
    System.out.println("el maximo comun denominador es: "+GDC(uno,dos));
  }

  public static int  GDC(int a, int b)
  {


    if(b==0)
    return a;

    return GDC(b,a%b);
  }
}
