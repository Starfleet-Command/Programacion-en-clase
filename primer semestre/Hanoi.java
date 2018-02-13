import java.util.Scanner;
public class Hanoi
{
  public static void main(String[] args)
  {
      int n;

      Scanner lector = new Scanner(System.in);

      System.out.println("Escriba el numero de discos en la torre");
      n= lector.nextInt();
      movimientos(n,true);

    }

      public static void movimientos(int k, Boolean izq)
      {
        if(k==0) return;
      movimientos(k-1,!izq);
      if(izq==true)
      {
        System.out.printf("%d a la izquierda %n",k);
      }
      else
      {
        System.out.printf("%d a la derecha %n",k);
      }
      movimientos(k-1,!izq);



      }







}
