import java.util.Scanner;
public class PracticaRecursiva
{
  public static void main(String[] args)
  {
    int a;
    Scanner lector = new Scanner(System.in);

    System.out.println("Digame el numero al que quiere sumar");
    a = lector.nextInt();

    System.out.format("Suma: %d",Sumaa(a));
    System.out.println("");
  }

    public static int Sumaa(int a)
    {
      if(a==1)
        return 1;
      else if(a<0)
        return 0;

      else
      return a+Sumaa(a-1);
    }
}
