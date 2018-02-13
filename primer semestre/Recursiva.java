public class Recursiva
{
  public static void main(String[] args)
  {
    int n=15;


  System.out.format("Suma: %d",suma(n));
  System.out.println("");
  System.out.format("Multiplicación: %d",factorial(n));
  System.out.println("");
  }

  public static int sumatoriaRecursiva(int n)
  {
    if(n==1)
      return 1;
    else if(n<0)
      return 0;

    else
    return n+sumatoriaRecursiva(n-1);
  }

  public static long factorial(long n)
  {

    if(n<=1)
      return 1;

      else
        return n*factorial(n-1);
  }

  public static int suma(int n)
  {
    int suma=0;
    for(int cont=1;cont <=n;cont++)
    {
      suma +=cont;
    }
    return suma;
  }
}
