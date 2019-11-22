import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;




class Elemento
{
int peso;
int beneficio;
int ratio;

Elemento(int peso, int beneficio)
{
    this.peso      = peso;
    this.beneficio = beneficio;
    this.ratio     = beneficio / peso;
}
}






public class Mochila
{
public void llenaMochila(ArrayList<Elemento> elementos, int maxPeso, int elms)
{
    int     pesoTemp = 0;
    int     count    = 0;
    int[][] mochila  = new int[elms][maxPeso];
    int     maxVal   = 0;

    for (int s = 0; s < maxPeso; s++)
    {
        mochila[0][s] = 0;

        if (s < elms)
        {
            mochila[s][0] = 0;
        }
    }


    //Funcion objetivo

    for (int i = 1; i <= elms - 1; i++)
    {
        for (int j = 1; j <= maxPeso - 1; j++)
        {
            if (j - elementos.get(i).peso < 0)
            {
                mochila[i][j] = mochila[i - 1][j];
            }
            else
            {
                mochila[i][j] = Math.max(mochila[i - 1][j], mochila[i - 1][j - elementos.get(i).peso] + elementos.get(i).beneficio);
            }
            maxVal = mochila[i][j];
        }
    }

    // System.out.println("La mochila tiene los elementos con los siguientes pesos: ");

    /*  for (int x = 0; x < mochila.length; x++)
       {
          for (int y = 0; y < mochila[x].length; y++)
          {
              System.out.printf("%d", mochila[x][y]);
          }
          System.out.println("");
       }
     */
    System.out.println("El mayor beneficio es: " + maxVal);
}

public static void main(String[] args)
{
    Mochila             mochi = new Mochila();
    Random              rng = new Random();
    Scanner             lector = new Scanner(System.in);
    int                 maxPeso, elms, pesoT, benT, elsize;
    ArrayList<Elemento> elementos = new ArrayList<>();


    System.out.println("Escriba el peso máximo de la mochila");
    maxPeso = lector.nextInt();

    lector.nextLine();

    System.out.println("Escriba el numero máximo de elementos");
    elms = lector.nextInt();


    lector.nextLine();
    System.out.println("Escriba el numero de elementos a generar");
    elsize = lector.nextInt();

    for (int k = 0; k < elsize; k++)
    {
        pesoT = rng.nextInt(10) + 1;
        benT  = rng.nextInt(40) + 1;
        Elemento newEle = new Elemento(pesoT, benT);
        elementos.add(newEle);
    }

    /*
       Elemento e1 = new Elemento(3, 6);
       Elemento e2 = new Elemento(3, 6);
       Elemento e3 = new Elemento(5, 12);
       elementos.add(e1);
       elementos.add(e2);
       elementos.add(e3);
       maxPeso = 6;
       elms    = 3;
     */
    mochi.llenaMochila(elementos, maxPeso, elms);
}
}
