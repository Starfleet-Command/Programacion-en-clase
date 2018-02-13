import java.util.Arrays;
import java.util.Scanner;
public class SumaArrays
{
  public static void main(String[] args)
  {
    int[] arreglo1 = new int[9];
    int[] arreglo2 = new int[9];
    int[] arreglo3 = new int[9];
    Scanner lector = new Scanner(System.in);

for (int c=0;c<arreglo1.length ;c++ ) {
  System.out.printf("Escriba un numero para llenar el primer arreglo. Progreso actual: %d / 9 %n",(c));
  arreglo1[c]=lector.nextInt();
}

for (int c=0;c<arreglo2.length ;c++ ) {
  System.out.printf("Escriba un numero para llenar el segundo arreglo. Progreso actual: %d / 9 %n",(c));
  arreglo2[c]=lector.nextInt();
}

for (int k=0;k<arreglo1.length ;k++ ) {
  arreglo3[k]= (arreglo1[k]+ arreglo2[k]);
System.out.printf("La suma del par numero %d es %d. %n",(k+1),arreglo3[k]);
}

Arrays.sort(arreglo3);

System.out.println("Las sumas ordenadas de menor a mayor son:");

for (int c=0;c<arreglo1.length ;c++ ) {
  System.out.printf("%d %n", arreglo3[c]);
}
Promedio(arreglo3);
  }

  public static void Promedio(int[] entrada)
  {
    int sumatoria = 0;
    int promedio;
    for (int u=0;u<entrada.length ;u++ ) {
      sumatoria+= entrada[u];
    }

    promedio=sumatoria/(entrada.length);

    System.out.println("Su promedio es: "+promedio);
  }


  }
