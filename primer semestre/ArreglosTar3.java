/* Ejercicio 3 de la tarea del 9 de octubre
   Juan Francisco Gortarez R. // Daniel Roa // Humberto Reynoso
   Fundamentos de Programación */

public class ArreglosTar3
{
  public static void main(String[] args)
  {
    int[] arreglo ={5,-14,7,9,36,20,-5,18,7,-4};
    int a;
    int b;

    for (a=0;a<arreglo.length;a++ )
    {
      b=1;
      b++;
      if (arreglo[a]== arreglo[b])
      {
        System.out.println("El numero que se repite es " +arreglo[a]);

      }
      else
      {
        System.out.println("No se repite el numero en la posición "+a);
      }

      }
    }
    /* MacBook-Pro-de-Juan-8:Programacion juanfra$ java ArreglosTar3
No se repite el numero en la posición 0
No se repite el numero en la posición 1
El numero que se repite es 7
No se repite el numero en la posición 3
No se repite el numero en la posición 4
No se repite el numero en la posición 5
No se repite el numero en la posición 6
No se repite el numero en la posición 7
El numero que se repite es 7
No se repite el numero en la posición 9
*/
  }
