import java.util.Arrays;
import java.util.Scanner;
public class Comparacion
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    int total,diferencia;
    int primer=0;

    System.out.println("Escriba el numero total de terminos del vector");
    total=lector.nextInt();

    int arreglo[] = new int[total];

    for (int k=0;k<total ;k++ ) {
      System.out.println("Escriba el siguiente termino (termino: "+(k+1));
      arreglo[k]=lector.nextInt();

      if(k==0)
      {
        primer=arreglo[k];
      }
    }
      Arrays.sort(arreglo);

      System.out.printf("La diferencia entre el termino mayor y el menor es %d",(arreglo[total-1]- arreglo[0]));
      diferencia = arreglo[total-1]- arreglo[0];

      System.out.printf("El valor de la multiplicacion de la diferencia por el primer numero es %d",(diferencia*primer));

  }
}
