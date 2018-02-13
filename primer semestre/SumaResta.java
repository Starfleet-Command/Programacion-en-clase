public class SumaResta
{
  public static void main(String[] args)
  {
    int[] arreglo={10,-4,-7,8,-7,15,2,4,-1,5};

    System.out.println("El resultado de la operacion es "+Suma(arreglo));

}

public static int Suma(int[] arreglo2)
{
  int suma=0;
  int resta =0;
  int resultado;
    for (int i=0;i<arreglo2.length ;i++ ) {
      if(arreglo2[i]>0)
      {
        suma+= arreglo2[i];
      }
      else resta += arreglo2[i];
    }
      resultado = suma + resta;
      return resultado;
}
}
