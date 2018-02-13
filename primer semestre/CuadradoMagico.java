/*
Daniel Roa, Juan Francisco Gortarez, Humberto Reynoso
A01021960
Cuadrado Mágico
*/
import java.util.Scanner;
import java.util.Random;

public class CuadradoMagico
{
  public static void main(String[] args)
  {
    Scanner lectura = new Scanner(System.in);
    Random aleatorio = new Random();

    int var;

    System.out.println("Inserta un numero impar ");
    var = lectura.nextInt();

    int hil = var-1;
    int colum = var/2;

    int[][] matriz = new int[var][var];
    matriz[hil][colum] = 1;

    for (int renglones = 0; renglones<matriz.length; renglones++)
    {
      for (int columnas = 0; columnas<matriz[0].length; columnas++)
      {

        matriz[hil][colum]= aleatorio.nextInt(7) ;

        for(int e=0; e<matriz.length-1; e++)
    {
        for(int i=0; i<matriz.length-1; i++)
        {

      if (matriz[e][i]+matriz[e][i+1] == matriz[e][i]+matriz[e+1][i])
      {
        System.out.printf("%d\t",matriz[hil][colum]);
      }
      else {
        matriz[hil][colum]= aleatorio.nextInt(7) ;
      }
      }
    }
      System.out.println("");
    }

  }
}
