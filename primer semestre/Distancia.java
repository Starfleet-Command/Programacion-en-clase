import java.util.Scanner;

public class Distancia
{
  public static void main(String[] args)
  {
    double x1,x2,y1,y2,resultado;
    Scanner lector = new Scanner(System.in);

    System.out.println("Inserte la coordenada x del primer punto");
    x1= lector.nextInt();

    System.out.println("Inserte la coordenada y del primer punto");
    y1= lector.nextInt();

    System.out.println("Inserte la coordenada x del segundo punto");
    x2= lector.nextInt();

    System.out.println("Inserte la coordenada y del segundo punto");
    y2= lector.nextInt();

  resultado =  distanciaa(x1,y1,x2,y2);

  System.out.println("La distancia entre ambos puntos es: "+resultado);

}

  public static double distanciaa(double a, double b, double c, double d)
  {
    double restax,restay;
    double xcuad,ycuad,todo;

    restax= c-a;
    restay= d-b;

    xcuad = Math.pow(restax,2);
    ycuad= Math.pow(restay,2);

    todo= Math.sqrt((xcuad+ycuad));

    return todo;
  }
}
