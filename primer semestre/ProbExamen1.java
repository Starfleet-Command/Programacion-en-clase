import java.util.Scanner;
public class ProbExamen1
{
  public static void main(String[] args)
  {


    Double a,d;
    Double c=0.00;
    Double i=1.00;

    Scanner lector = new Scanner(System.in);

    System.out.println("Digame un numero para calcular su armónico");
    a= lector.nextDouble();

    do {
      for (i=1.00;i<a ;i++ ) {
        c += (1/i);
        i++;
      }


    } while (i<a);

    System.out.printf("%f",c);
    System.out.println("");

  }
}
