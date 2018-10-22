public class EjerciciosRecursiva
{
  public static void main(String[] args)
  {
    int[] arreglo = {1,2,3,4,5};
    int[] temparray = new int[arreglo.length];
    char[] arreglos= new char[3];
    String lleva = "123";
    for(int o=0;o<3;o++)
    {
      arreglos[o]=lleva.charAt(o);
    }
    int result=Factorial(3);
    int result2=Exponencial(2,4);
    int[] result3= Replace(arreglo,arreglo.length,temparray);
    System.out.println("El factorial de 3 es "+result);
    System.out.println("2 a la 4ta potencia es "+result2);
    System.out.println("El arreglo queda de la forma: ");
    for(int p=0;p<result3.length;p++)
    {
      System.out.println(""+result3[p]);
    }
    System.out.println("las combinaciones de {1,2,3} con k=2 son ");
    Longitud(arreglos,2);
  }


  public static int Factorial(int a)
  {
    if(a<=1)
    {
      return 1;
    }

    return (a*Factorial(a-1));
  }

  public static int Exponencial(int num,int reps)
  {
    if(reps<=1)
    {
      return num;
    }
    reps--;
    return num* Exponencial(num,reps);
  }

  public static int[] Replace(int[] arreglo,int cantidad, int[] temparray)
  {

    cantidad--;
    if(cantidad==0)
    {
      int temp=1;
      for(int k=0;k<arreglo.length;k++)
      {
        temp*=arreglo[k];
        temparray[cantidad]=temp;
}
      return temparray;
    }

    int temp2=1;
    for(int r=arreglo.length-1;r>0;r--)
    {
      if(r!=cantidad)
      {
        temp2*=arreglo[r];
      }

      temparray[cantidad]=temp2;
   }



    return Replace(arreglo,cantidad,temparray);
  }
// Inspiración para la solución fue obtenida de la universidad de Princeton en (https://introcs.cs.princeton.edu/java/23recursion/PermutationsK.java.html)
  public static void Longitud(char[] a, int k) {
        Combinar(a, a.length, k);
    }

    private static void Combinar(char[] a, int n, int k) {
        if (k == 0) {
            for (int i = n; i < a.length; i++)
                System.out.print(a[i]);
            System.out.println("");
            return;
        }

        for (int i = 0; i < n; i++) {
            Cambia(a, i, n-1);
            Combinar(a, n-1, k-1);
            Cambia(a, i, n-1);
        }
    }


    public static void Cambia(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
