public class SubArreglos2
{
  public static void main(String[] args)
  {
    int suma=0;
    int contador =0;
    for(int k=0;k<arreglo.length-1;k++)
    {
      for(int i=k;i<arreglo.length;i++)
      {
        suma+= arreglo[i];
        if(suma>0)
        {
          contador++;
        }
      }
    }

    System.out.println("En el arreglo, hay esta cantidad de sub-arreglos positivos: "+contador);

  }
}
