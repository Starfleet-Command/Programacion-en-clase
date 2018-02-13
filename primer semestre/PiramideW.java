/*
Piramide con while
Juan Francisco Gortarez Ricardez//Humberto Reynoso G.//Daniel Roa//
Fundamentos de Programación
*/

import java.util.Scanner;

public class PiramideW
{
  public static void main(String[] args)
  {
    Scanner lectura = new Scanner(System.in);

    int a = 1, contador = 0, p=0, n;

    System.out.println("Ingresa un numero");
    n=lectura.nextInt();

    while(contador<=n-1) //controla el largo de cada linea
    {
      contador++;
      System.out.printf("%d%n", contador);

      for ( p=1; p<=contador; p++)
      {
      System.out.printf("%d",p);
      }
    }
    p -= 2;

    for (int g=p;g>=1 ;g-- )
    {
      System.out.println("");

    for (p=1;p<=g ;p++ ) {

      System.out.printf("%d",p);


    }
    }
    System.out.println("");
  }
  /* MacBook-Pro-de-Juan-8:Programacion juanfra$ java PiramideW
Ingresa un numero
5
1
12
123
1234
12345
12345
1234
123
12
1
*/
}
