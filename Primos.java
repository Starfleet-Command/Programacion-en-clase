import java.util.Scanner;
import java.util.Arrays;

public class Primos
{
  public static void main(String[] args)
  {
    int numerous;
    Boolean comprobacion;

    Scanner lector = new Scanner(System.in);

    System.out.println("Diga el numero que quiera comprobar (Mayor a 2. Se asume que 1 y 2 son primos)");
    numerous = lector.nextInt();

     primos(numerous);



  }

    public static void primos(int num)
    {
      Boolean comprob=false;
      int residuo=0;
      int arreglo[]= new int[num-2];


      for (int k=2;k<num ;k++ )
      {
        residuo=num%k;
        arreglo[k-2]=residuo;
        System.out.printf("%d",residuo);
      }

      Arrays.sort(arreglo);


        if (arreglo[0]!=0)
        {
          comprob= true;
        }

        else if(arreglo[0]==0)
         {
           comprob= false;
         }


        if(comprob == false)
        {
          System.out.println("El numero no es primo");
        }

        if (comprob == true)
        {
          System.out.println("El numero es primo");
        }




    }
}
