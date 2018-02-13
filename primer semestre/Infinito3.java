import java.util.Scanner;

public class Infinito3
{
  public static void main(String[] args)
  {
    int contador;
    int numus;
    int sumamax;
    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba un numero menor a 100");
    numus= lector.nextInt();

    contador=0;
    sumamax = 0;

    while(contador<=numus)
    {
      sumamax = sumamax + contador;
      contador++;
    }
      System.out.printf("Sumatoria: %d%n", sumamax);

    }
    public static int Sumatoria(int numero) //Aqui puede haber en lugar de sumatoria cualquier nombre
{
    int contador=0;
    int suma= 0;
    while (contador<= numero)
    {
      suma = suma + contador;
      contador++;
    }
    return suma;
  }

  }
