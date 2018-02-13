import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class PracticaExamen2
{
  public static void main(String[] args)
  {
    Random aleatorio = new Random();
    int Arreglo[] = new int[15];

     Scanner lector = new Scanner(System.in);
     int a,b,c,d,numero;

     System.out.println("Escriba el limite inferior del arreglo");
     a= lector.nextInt();

     System.out.println("Escriba el limite superior del arreglo");
     b= lector.nextInt();



     for (c=0;c<Arreglo.length;c++ )
      {
        numero= aleatorio.nextInt(b+1-a)+(a);
       Arreglo[c]=numero;
       System.out.printf("%d ",Arreglo[c]);
     }
      System.out.println("");
     Arrays.sort(Arreglo);

     System.out.printf("Su arreglo ordenado de menor a mayor es: ");

    for (d=0;d<Arreglo.length ;d++ )
    {

      System.out.printf("%d ,",Arreglo[d]);
    }




  }
}
