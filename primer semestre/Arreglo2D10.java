import java.util.Random;

public class Arreglos2D10
{
  public static void main(String[] args)
  {
    int[][] matriz = new int[5][2];
    matriz[0][0] = 7;
    matriz[0][1] = 8;
    matriz[1][0] = 2;
    matriz[1][1] = 4;
    matriz[2][0] = 8;
    matriz[2][1] = 3;
    matriz[3][0] = 7;
    matriz[3][1] = 8;
    matriz[4][0] = 2;
    matriz[4][1] = 4;
    matriz[5][0] = 8;
    matriz[][1] = 3;

    for (int renglones =0; renglones <matriz.length; renglones++)
    {
      for(int columnas =0; columnas<matriz[0].length; columnas++)
      {
        System.out.printf("(%d,%d)=%d\t",renglones,columnas,matriz[renglones][columnas]);
      }
      System.out.println("");
    }
  }
}
