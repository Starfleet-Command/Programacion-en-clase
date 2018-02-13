/* Juan Francisco Gortarez Ricardez A01021926
Examen Final Fundamentos de programacion
Problema 2
Profesor Luis Yepez */

import java.util.Scanner;
public class Examen3_2
{
  public static void main(String[] args)
  {
      Scanner lector = new Scanner(System.in);

      String frase;
      int longitud, unicodear;
      int k=0;


      System.out.println("Escriba el String que quiere traducir al codigo (no mas de 50 caracteres)");
      frase= lector.nextLine();

      if (frase.length()>50)
       {
        System.out.println("Le dije que menos de 50 caracteres");
      }

      System.out.println("Defina la longitud del codigo (1-5)");
      longitud= lector.nextInt();
      lector.nextLine();

      int[] codigo = new int[longitud];
      int[] unicode = new int[frase.length()];
      int[] secreto = new int[frase.length()];

for (int i=0;i<longitud ;i++ ) {

      System.out.println("Escriba los numeros del codigo. Numero actual:  "+i);
      codigo[i]= lector.nextInt();
    }


    for (int u=0;u<unicode.length ;u++ )
    {
      unicodear= frase.charAt(u);
      unicode[u]=(int)unicodear;
    }



    //------------------------------CODIGO----------------------------
    for (int u=0;u<unicode.length ;u++ )
    {
      if (codigo.length>=unicode.length) {

      secreto[u]= codigo[u]+unicode[u];
      System.out.println("El codigo secreto es"+secreto[u]);
    }

    else
    {

      if (k>=longitud) {
        k=0;
      }

      secreto[u]= codigo[k]+unicode[u];
      System.out.printf("El codigo secreto en pos %d es %s %n ",u,secreto[u]);
      k++;


    }


    }

  }
}

/* Escriba el String que quiere traducir al codigo (no mas de 50 caracteres)
hola amigos
Defina la longitud del codigo (1-5)
5
Escriba los numeros del codigo. Numero actual:  0
4
Escriba los numeros del codigo. Numero actual:  1
2
Escriba los numeros del codigo. Numero actual:  2
1
Escriba los numeros del codigo. Numero actual:  3
5
Escriba los numeros del codigo. Numero actual:  4
6
El codigo secreto en pos 0 es 108
 El codigo secreto en pos 1 es 113
 El codigo secreto en pos 2 es 109
 El codigo secreto en pos 3 es 102
 El codigo secreto en pos 4 es 38
 El codigo secreto en pos 5 es 101
 El codigo secreto en pos 6 es 111
 El codigo secreto en pos 7 es 106
 El codigo secreto en pos 8 es 108
 El codigo secreto en pos 9 es 117
 El codigo secreto en pos 10 es 119 */
