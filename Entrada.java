import java.util.Scanner; //Se necesita para las herramientas para leer el teclado

public class Entrada
{
	public static void main (String[] args)
	{
		String nombre;

		Scanner stdIn = new Scanner(System.in); //Se neecesita para leer el teclado

		nombre= stdIn.nextLine();

		System.out.println ("Hola "+nombre);

	}
}
