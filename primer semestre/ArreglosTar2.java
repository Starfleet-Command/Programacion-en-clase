/* Ejercicio 2 de la tarea del 9 de octubre
   Juan Francisco Gortarez R. // Daniel Roa // Humberto Reynoso
   Fundamentos de Programación */

import java.util.Scanner;
public class ArreglosTar2
{
  public static void main(String[] args)
  {

    int[] arreglo = {6,7,4,5,180,-10,271,1,0};
    int a,i;
    int codigo;
    Scanner lector = new Scanner(System.in);

    System.out.println("Digame un numero y le dire en que posición del arreglo está");
    a= lector.nextInt();

    for (i=0;i<arreglo.length ;i++ )
    {


    if (arreglo[i]== a)
    {
      System.out.printf("Su numero está en la posición %d.%n",i);

    }

       else if (arreglo[i]!= a)
      {
        System.out.println("Su numero no está en el arreglo");
      }
    }

}
}
/* Digame un numero y le dire en que posición del arreglo está
1
Su numero está en la posición 7.
MacBook-Pro-de-Juan-8:Programacion juanfra$
*/
