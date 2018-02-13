import java.util.Scanner;

public class Condiciones3
{

	public static void main(String[] args)
	{
		String zip;
		char codigo;


		Scanner lector = new Scanner(System.in);


		System.out.println("Escriba un zip code y le diremos de que región es");
		zip = lector.nextLine();
		codigo = zip.charAt(0);

		switch( codigo )
		{
			case '2': case '3': case '0':
			System.out.println("Este codigo postal es del este");
			break;
			case '5': case '4' : case '6':
			System.out.println("Este codigo postal es del centro");
			break;
			case '7':
			System.out.println("Este codigo postal es del sur");
			break;
			case '8': case '9':
			System.out.println("Este codigo postal es del oeste");
				break;
			default:
				System.out.println("Esa opcion no existe");

			}
		}
}
