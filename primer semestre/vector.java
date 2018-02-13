import java.io.*;
import java.util.Scanner;
public class vector
{
  public static void main(String[] args) throws IOException
  {
  BufferedReader br;
  FileReader lector2;
  String nombre,datosLeidos;
  int valores;
  double resultado;
  Scanner lector = new Scanner(System.in);

  System.out.println("Escriba el nombre del archivo donde están sus valores (CaseSensitive)");
  nombre = lector.nextLine();

  lector2 = new FileReader(nombre);
   br = new BufferedReader(lector2);

   System.out.println("Escriba el numero de valores");
   valores = lector.nextInt();

   String arreglo[] = new String[valores];


   while ( (datosLeidos = br.readLine()) != null)
   {
     arreglo = datosLeidos.split(",");
   }

  resultado = calculo(arreglo);

  System.out.println("El resultado de la operacion con esos valores es: "+resultado);

  }

  public static double calculo(String[] entrada)
  {
    double valores=0;
    if (entrada[0]== null)
    {
      return 0;
    }

    for (int k=0;k<(entrada.length-2) ;k++ )
    {
      valores = ((Integer.parseInt(entrada[k])+Integer.parseInt(entrada[k+1]))/Integer.parseInt(entrada[k+2]));
    }
    return valores;
  }
}
