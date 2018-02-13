import java.util.Scanner;

public class Condiciones
{
	public static void main(String[] args)
	{
		int temperatura;
		String salida;
		Scanner lectura = new Scanner(System.in);

		System.out.println("Escribe la temperatura del auto en numeros enteros");

		temperatura = lectura.nextInt();

		if (temperatura>=110  || temperatura< -10)
		{
		System.out.println("Alerta: Explosion inminente; Uso continuo del sistema no recomendado");
		System.out.println("Revise el nivel de aceite y su temperatura");
	}
	else
	{
		System.out.println("Todo dentro de parametros aceptables. Continue");
	}
lectura.nextLine();
	System.out.println("Escribe s para salir");
	salida = lectura.nextLine();
	if(salida.equals("S")|| salida.equals("s")) // Puedes aplicar equals.IgnoreCase para no hacer esto doble
	{
	System.out.println("Hasta la vista,baby");
	}

	}
}
