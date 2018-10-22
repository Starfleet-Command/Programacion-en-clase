import java.lang.ArithmeticException;
import java.util.Scanner;
public class GaussSolve
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);

System.out.println("Write the height of the matrix");
int hei = lector.nextInt();

System.out.println("Write the length of the matrix");
int len = lector.nextInt();
lector.nextLine();
double[][] toSolve = new double[hei][len];

for (int s=0;s<hei ;s++ ) {
  for (int v=0;v<len ;v++ ) {
    System.out.println("Write the number for the array at position: "+s + " , " +v);
    toSolve[s][v]=Double.parseDouble(lector.nextLine());
  }
}


      double[][] solved = GaussOperation(toSolve);
      for(int e=0;e<solved.length;e++)
      {
        System.out.println("");
        for(int u=0;u<solved[0].length;u++)
        {

      System.out.printf("%.6s  \t",solved[e][u]);
        }
      }

  }

  public static double[][] GaussOperation(double[][] matriz)
  {
    int cont=-1;

    for(int i=0;i<matriz.length;i++)
  {
    cont++;


double temp2= matriz[i][cont];
if(i!=matriz.length-1)
{
double multiplier= (matriz[i+1][cont]/temp2);
    for(int r=0; r<matriz[0].length; r++ )  //PONER LOS OTROS VALORES DE LAS COLUMNAS IGUALES A 0. (Excepto el resultado)
    {
      for(int z=i+1;z<matriz.length;z++)
      {
        matriz[z][r]=(matriz[z][r]-(matriz[i][r]* multiplier));
      }

      }
}
for(int x=0;x<matriz[0].length;x++) //PONER LOS DIAGONALES IGUALES A 1.
{
  matriz[i][x]=(matriz[i][x]/temp2);
}
  }


    return matriz;
  }

  }
