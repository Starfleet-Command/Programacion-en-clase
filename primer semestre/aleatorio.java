import java.util.Random;

public class aleatorio
{
  public static void main(String[] args)
  {
    Random numeroaleatorio = new Random();
    int numero;

    for(int i =1; i<=5;i++)
    {



    System.out.println("un numero aleatorio es "+numeroaleatorio.nextInt());
    numero= numeroaleatorio.nextInt(10)+1;
    System.out.println("un numero aleatorio del 1-10 es "+numero);
    System.out.println("un numero aleatorio del 0-20 es "+numeroaleatorio.nextInt(21));
    }

    double numeroDouble;
    for(int i=1; i<=50; i++)
    {
      numeroDouble= numeroaleatorio.nextDouble()*10;
      System.out.printf("%.3f ",numeroDouble);
      System.out.println();
    }
  }
}
