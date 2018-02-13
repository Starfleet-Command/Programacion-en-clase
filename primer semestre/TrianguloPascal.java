import java.util.Scanner;
public class TrianguloPascal
{
  public static void main(String[] args)
  {
    int columna,renglon;
    Scanner lector = new Scanner(System.in);

    System.out.println("Digame que renglon quiere obtener");
    renglon= lector.nextInt();

    System.out.println("Digame que columna quiere obtener");
    columna= lector.nextInt();

System.out.printf("%d",pascal(renglon,columna));

  }

  public static int pascal(int r, int c)
  {
    if(r==0 || c==0 || r==c ) return 1;
    else if(r==(c-1))
    {
      return r;
    }
    else
  {
      return pascal(r-1,c-1)+pascal(r-1,c);
  }
  }
}
