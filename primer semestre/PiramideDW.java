import java.util.Scanner;

public class PiramideDW
{
  public static void main(String[] args)
  {
    Scanner lectura = new Scanner(System.in);
    int a=1, contador=1, n;


    System.out.println("Hasta que numero quieres llegar?");
    n=lectura.nextInt();

    System.out.println("1");

    do{
    do {
      a++;
      System.out.printf("%d", a);
    } while (a<=contador);

      System.out.println("");
      contador++;
      a=1;
    }while(contador<=n-1);

    do{
      do{
        System.out.printf("%d",a);
        a++;
      }while(a<=contador);

      System.out.println();
      contador--;
      a=1;
    }while(contador>0);


  }
}
