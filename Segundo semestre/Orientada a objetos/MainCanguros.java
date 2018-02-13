import java.util.Scanner;
public class MainCanguros
{
  public static void main(String[] args)
  {
    int d1,v1,d2,v2;

    Scanner lector = new Scanner(System.in);

    String resultados;
    String[] lineVector;
    System.out.println("Escriba los cuatro valores, de forma (d1,v1,d2,v2):");
    resultados = lector.nextLine();
    lineVector=resultados.split(",");
    d1= Integer.parseInt(lineVector[0]);
    v1 = Integer.parseInt(lineVector[1]);
    d2= Integer.parseInt(lineVector[2]);
    v2 = Integer.parseInt(lineVector[3]);

    Canguros canguro1 = new Canguros(d1,v1);
    Canguros canguro2 = new Canguros(d2,v2);

    canguro1.PrintCanguros(canguro2);
  }
}
