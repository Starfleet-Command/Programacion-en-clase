/* Juan Francisco Gortarez Ricardez A01021926
Examen Final Fundamentos de programacion
Problema 1
Profesor Luis Yepez */

import java.util.Random;
import java.util.Scanner;
public class Examen3_1
{
  public static void main(String[] args)
  {
    Random aleatorio = new Random();
    Scanner lector = new Scanner(System.in);

    int minumero,numus;

    System.out.println("Voy a pensar en un numero. Tienes 8 chances para adivinarlo");
    minumero=aleatorio.nextInt(100)+1;

    for (int k=0;k<9 ;k++ )
    {
      System.out.println("Escriba su adivinanza. Su chance actual es: "+k);
      numus=lector.nextInt();

      if (numus<minumero)
      {
        System.out.println("Mi numero es mayor al que adivinaste");
      }

      else if (numus>minumero)
       {
        System.out.println("Mi numero es menor al que adivinaste");
      }

      else if(numus==minumero)
       {
        System.out.println("Felicidades! adivinaste mi numero");
        k=7;
      }

      if (k==8)
      {
        System.out.println("Lo siento, se te acabaron tus oportunidades. El numero era: "+minumero);
      }
    }
  }
}

/* C:\Users\Juan Fco\Desktop\Programacion>java Examen3_1
Voy a pensar en un numero. Tienes 8 chances para adivinarlo
Escriba su adivinanza. Su chance actual es: 0
45
Mi numero es mayor al que adivinaste
Escriba su adivinanza. Su chance actual es: 1
60
Mi numero es mayor al que adivinaste
Escriba su adivinanza. Su chance actual es: 2
70
Mi numero es mayor al que adivinaste
Escriba su adivinanza. Su chance actual es: 3
90
Mi numero es mayor al que adivinaste
Escriba su adivinanza. Su chance actual es: 4
99
Mi numero es menor al que adivinaste
Escriba su adivinanza. Su chance actual es: 5
95
Mi numero es mayor al que adivinaste
Escriba su adivinanza. Su chance actual es: 6
97
Felicidades! adivinaste mi numero */
