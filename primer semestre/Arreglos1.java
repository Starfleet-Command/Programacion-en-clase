public class Arreglos1
{
  public static void main(String[]args)
  {
    double numeros[];

    int[] arreglo = {3,5,8};
    int[] arreglo2 = new int[5];
    double suma = 0;

    //System.out.println(arreglo[0]);

    for(int indice =0;indice<arreglo.length; indice++)
    {
      System.out.println(arreglo[indice]);

    }

    System.out.println("Tamaño: "+arreglo.length);

    arreglo2[0] = 95;
    arreglo2[0] = 80;
    arreglo2[0] = 70;
    arreglo2[0] = 100;
    arreglo2[0] = 65;

    for(int i=0; i<arreglo2.length; i++)
    {
      suma += (double)arreglo2[i];
    }

    System.out.printf("El promedio es %.2f", suma/(double)arreglo2.length);

    System.out.println();

  }
}
