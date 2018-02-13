/*
Piramide con for
Juan Francisco Gortarez Ricardez//Humberto Reynoso G.//Daniel Roa//
Fundamentos de Programación
*/

import java.util.Scanner;

public class Piramide
{
public static void main(String[] args)
  {
  Scanner lectura = new Scanner(System.in);
  int numus,p=1;

  System.out.println("Hasta que valor quieres llegar?");
  numus = lectura.nextInt();

  for (int contador=1;contador<=numus ;contador++ )
  {
    System.out.println("");

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
/*
Hasta que valor quieres llegar?
5

1
12
123
1234
12345
1234
123
12
1
 */
}
