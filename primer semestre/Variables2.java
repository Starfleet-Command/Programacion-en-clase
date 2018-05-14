public class Variables2
{
	public static void main (String[] args)
	{
		char inicialNombre, inicialApellido;
		char codigoControl;

		inicialNombre = 'J';
		inicialApellido= 'G';

		codigoControl = '\n';

		String texto = "mi nombre es ";

		System.out.println ("Hola "+ inicialNombre);
		System.out.println ("Codigo:  "+ codigoControl);
		System.out.println ("\"Hola de \t nuevo \r "+ inicialApellido);
		System.out.println("\\");
		System.out.println("Los caracteres de texto son "+texto.length());
		System.out.println("El caracter en 5 es "+texto.charAt(5));

		// Int, long son para numeros enteros
		// double, float son para numeros con decimales
		//char, String son para texto, pero char es solo para una letra



	}
}
