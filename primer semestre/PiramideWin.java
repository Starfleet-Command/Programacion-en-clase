import java.util.Scanner;
public class PiramideWin
{
  public static void main(String[] args)
  {
    int numero;
      Scanner lector = new Scanner(System.in);

      System.out.println("Hasta que numero quiere llegar?");
      numero = lector.nextInt();

      piramide(numero);

  }

  public static void piramide(int altura)
  {
    int renglones=1;
    if(altura==0)
    {
      System.out.println("0");
    }

    for(int i =altura;i>0;i-- )
    {
      for (int a=1;a<=i;a++ )
      {
        System.out.print(" ");
      }

      for (int a=1;a<=renglones ;a++ )
      {
        System.out.print(renglones+" ");
      }
      System.out.println();
      renglones++;
    }

  }
}
