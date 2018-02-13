public class ArreglosTarCorregidos
{
  public static void main(String[] args)
  {


    int[] arreglo = {8,5,-14,7,9,2,20,-5,2};
    int[] arreglo2 = {6,4,3,7,8,5,-1};


      for (int i=0;i<arreglo.length ;i++ )
      {
        if (i<arreglo2.length)
        {
          System.out.printf(",%d,",arreglo2[i]);
          System.out.printf("%d",arreglo[i]);

        }
        else {
          System.out.printf("%d,",arreglo[i]);
        }

      }
        System.out.println("");
    }
  }
