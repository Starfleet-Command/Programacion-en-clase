public class average
{
  public static void main(String[] args)
  {

    int[] a = {1,2,3,4,5};
  System.out.printf("promedio es: %d",average(a));
  }

public static int promedio(int[] k)
{
    for(int e=0; e<k.length;e++)
    {
        int i =+ k[e];
    }

    int r = i/(k.length+1);

    return r;
}
}
