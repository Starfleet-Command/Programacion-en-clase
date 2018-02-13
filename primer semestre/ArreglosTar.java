/*  Ejercicio 1 de la tarea del 9 de octubre
   Juan Francisco Gortarez R. // Daniel Roa // Humberto Reynoso
   Fundamentos de Programación */

public class ArreglosTar
{
  public static void main(String[] args)
  {


    int[] arreglo = {8,5,-14,7,9,2,20,-5,2};
    int total = 0;
    int[] arreglo2 = {6,4,3,7,8,5,-1};
    int total2= 0;

    for(int a: arreglo)
    {
      for (int b: arreglo2)
      {
        total=a;
        total2=b;
        System.out.printf("{%d,",a);
        System.out.printf("%d}",b);
      }



    }
  }
}
/* MacBook-Pro-de-Juan-8:Programacion juanfra$ java ArreglosTar
{8,6}{8,4}{8,3}{8,7}{8,8}{8,5}{8,-1}{5,6}{5,4}{5,3}{5,7}{5,8}{5,5}{5,-1}{-14,6}{-14,4}
{-14,3}{-14,7}{-14,8}{-14,5}{-14,-1}{7,6}{7,4}{7,3}{7,7}{7,8}{7,5}{7,-1}{9,6}{9,4}{9,3}
{9,7}{9,8}{9,5}{9,-1}{2,6}{2,4}{2,3}{2,7}{2,8}{2,5}{2,-1}{20,6}{20,4}{20,3}{20,7}{20,8}
{20,5}{20,-1}{-5,6}{-5,4}{-5,3}{-5,7}{-5,8}{-5,5}{-5,-1}{2,6}{2,4}{2,3}{2,7}{2,8}{2,5}{2,-1}

En este ejercicio no sabía si era copiar uno dentro de otro para que se hiciera uno masivo, o
copiar uno en el otro de manera que se hicieran todas las combinaciones posibles. Hice la segunda
opción. */
