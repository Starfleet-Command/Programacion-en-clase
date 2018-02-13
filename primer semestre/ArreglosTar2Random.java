import java.util.Scanner;
import java.util.Random;
public class ArreglosTar2Random
{
  public static void main(String[] args)
  {
    Random aleatorio = new Random();
    int[] arreglo = new int [8];
    int a,i;
    int codigo;
    Scanner lector = new Scanner(System.in);

    System.out.println("Digame un numero (1-15) y le dire en que posición del arreglo está");
    a= lector.nextInt();

    for (i=0;i<arreglo.length ;i++ )
    {
      arreglo[i]= aleatorio.nextInt(15);


    if (arreglo[i]== a)
    {
      System.out.printf("Su numero está en la posición %d.%n",i);

    }

       else if (arreglo[i]!= a)
      {
        System.out.println("Su numero no está en el arreglo");
      }
    }

}
}
