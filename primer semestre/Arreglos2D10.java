import java.util.Random;

public class Arreglos2D10
{
  public static void main(String[] args)
  {

    Random aleatorio = new Random();
    int numero;


    int[][] matriz = new int[10][10];



    for (int renglones =0; renglones <matriz.length; renglones++)
    {
      for(int columnas =0; columnas<matriz[0].length; columnas++)
      {

        matriz[renglones][columnas]= aleatorio.nextInt(100) +1;

        System.out.printf("%d\t",matriz[renglones][columnas]);
      }
      System.out.println("");
    }

    for(int e=0; e<matriz.length-1; e++)
{
    System.out.println("La suma de los pares del renglón es ");
    for(int i=0; i<matriz.length-1; i++)
    {
      System.out.printf("%d\t",matriz[e][i]+matriz[e][i+1]);
    }
}

  }
}
