public class Variables
{
	public static void main (String[] args)
	{
		int numero1;
		double numero2, numero3=0;
		double pi = 3.14;
		final double velocidadDeLaLuz = 299792458.0;

		numero3++;
		++numero3;
		numero1= (int)pi;
		numero2=(numero1+numero3)/2 ;
		numero2= numero2+numero1; //esto es lo  mismo que numero2 += numero1

		System.out.println(numero1);
		System.out.println(numero2);
		System.out.println(Math.sqrt(numero2++));

	}
}