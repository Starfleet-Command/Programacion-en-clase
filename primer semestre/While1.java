import java.util.Scanner;

public class While1
{
  public static void main(String[] args)
  {
    int contador,suma,num;

    Scanner lector= new Scanner(System.in);

    System.out.println("Escriba un numero");
    num= lector.nextInt();

    System.out.printf("Su sumatoria es %d.%n",sumatoria(num));
    System.out.printf("Su factorial es %d.%n",factorial(num));


}
    public static int sumatoria(int num)
    {
    int contador=0;
    int suma = 0;
    while(contador<=num)
    {
      suma = suma + contador;
      contador++;

    }
    return suma;
  }
    public static int factorial(int num)
    {
      int contador=1;
      int suma=1;
      while (contador<=num)
      {
        suma *= contador;
        contador++;
      }
      return suma;
    }

}
