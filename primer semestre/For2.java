public class For2
{
public static void main(String[]args)
{
  for (int i=1; i<=5; i++)
  {
    System.out.printf("Estoy en la i=",+i);
    for (int j=1; j<=4; j++)
    {
      System.out.printf("(%d,%d) \t ",i,j);
    }
  }
}
}
