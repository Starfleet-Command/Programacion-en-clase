import java.util.Arrays;
public class SubArreglos
{
  public static void main(String[] args)
  {
    int[] arreglo = {4,5,-2,-7};
    Calculo(arreglo);
  }

   public static void Calculo(int[] array)
  {
    int[] arreglodob = new int[array.length];
    int suma;

    for(int k=0; k<array.length-1;k++)
    {
      for(int i=k+1; i<array.length-1; i++)
      {
        for(int u=k;u<k-1;u++)
        {
          suma += array[u];
        if(suma<0)
      arreglodob = Arrays.copyOfRange(array, k, i);
    }
  }
  }
    Suma(arreglodob);
  }

  public static void Suma(int[] array2)
  {
    System.out.println("Los arreglos que dan suma negativa son:");
    for(int u=0; u<array2.length;u++)
    {
      System.out.println(""+array2[u]);
    }
  }

}
