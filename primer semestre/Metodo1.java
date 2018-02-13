/*
Uso de metodos
Por Juan Francisco Gortarez
*/
import java.util.Scanner;

public class Metodo1
{
  public static void main(String[] args)
{
		String nombre = "Juan";
		int edad;

		Scanner lector = new Scanner(System.in);

 System.out.println("Dame tu nombre");
		nombre = lector.nextLine();

		System.out.println("Dame tu edad");
		edad= lector.nextInt();

		imprime(nombre,edad);



	}

		public static void imprime(String nom, int edad)
		{
			System.out.printf("Hola %s. tu edad es %d.%n", nom,edad);
		}
}
