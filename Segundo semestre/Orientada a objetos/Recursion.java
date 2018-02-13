public class Recursion
{
  public static void main(String[] args)
  {
    //Cuando un metodo se llama a si mismo

    System.out.println("El factorial de 5 es: "+factorial(5));

  }

  public static long factorial(int n)
  {
    if(n==1)
    return 1;

  return factorial(n)*factorial(n-1);
  }
}
