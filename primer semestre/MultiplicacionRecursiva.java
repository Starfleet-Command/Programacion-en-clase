import java.util.Scanner;
public class MultiplicacionRecursiva
{
  public static void main(String[] args)
  {
    int[] arreglo;
    int tam;

    Scanner lector = new Scanner(System.in);

    System.out.println("Dame el tamaño del arreglo");

    tam = lector.nextInt();
    arreglo = new int[tam];

    for(int i=0; i<arreglo.length;i++)
    {
      arreglo[i] = lector.nextInt();
    }

    System.out.printf("La multiplicación da %d",multiplica(arreglo,tam));

  }

  public static int multiplica(int[] arr, int[] t)
  {
    if(t<=0)
        return arr[0];
    else
      return arr[t-1]*multiplica(arr,t-1);
  }
}
