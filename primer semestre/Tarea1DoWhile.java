/*
Sumar a 50 con dowhile
Juan Francisco Gortarez Ricardez//Humberto Reynoso G.//Daniel Roa//
Fundamentos de Programación
*/

public class Tarea1DoWhile
{
  public static void main(String[]args)
  {
    int a;
    a=1;
    int c=0;

    do {

      c += a;
      a++;

    } while (a<=50);

    System.out.printf("la suma de los primeros 50 numeros es %d",+c);
    System.out.println();
  }
  /*
  la suma de los primeros 50 numeros es 1275
MacBook-Pro-de-Juan-8:Programacion juanfra$

  */
}
