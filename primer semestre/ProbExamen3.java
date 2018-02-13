import java.util.Scanner;
public class ProbExamen3
{
  public static void main(String[] args)
  {

    int a;
    int var1;
    Scanner lector = new Scanner(System.in);

    System.out.println("Digame el largo de la matriz");
    var1= lector.nextInt();

    int[] matriz = new int[var1];
    int[] matriz2 = new int[var1];

    for (a=0;a<var1 ;a++ ) {
      System.out.println("Digame los valores de la matriz");
      matriz[a]= lector.nextInt();

    }

    for (a=0;a<var1;a++ ) {
      matriz2[a]= (matriz[a]+matriz[a+1]);
    }

}
public static int sumaRecursiva(int[] matriz2, int var1)
{

  if(var1<=0)
    return 0;
  else
  {


    return matriz2[var1];
}
}
}
