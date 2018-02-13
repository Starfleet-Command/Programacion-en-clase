import java.util.Random;

public class ArregloAleatorios
{
  public static void main(String[] args)
  {
    int[] arreglo = new int[100];
    Random aleatorio = new Random();

    for(int i=0; i<arreglo.length;i++)
    {
      arreglo[i]= aleatorio.nextInt(100)+1;
    }

    for(int i=0; i<arreglo.length; i++)
    {
      System.out.printf("%d, ",arreglo[i]);
    }
  }
}
