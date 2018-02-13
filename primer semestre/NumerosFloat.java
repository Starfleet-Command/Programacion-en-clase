import java.util.Scanner;

public class NumerosFloat
{

	public static void main(String[] args)
	{
		Float num1;
		Float num2;
		Float num3;

		Scanner lector = new Scanner(System.in);


		System.out.println("Escriba el primer numero");
		num1 = lector.nextFloat();

		System.out.println("Escriba el segundo numero");
		num2 = lector.nextFloat();

		System.out.println("Escriba el tercer número");
		num3= lector.nextFloat();

		imprime(num1,num2,num3);




	}

		public static void imprime(Float num1, Float num2, Float num3)
		{


		if (num1<num2 && num2<num3 || num1<num3 && num3<num2 )
		{
			System.out.printf("El numero menor es %f. %n",num1);
		}
		else if (num2<num1 && num1<num3 || num2<num3 && num3<num1)
		{
			System.out.printf("El numero menor es %f. %n", num3);
		}
		else if (num3<num2 && num2<num1 || num3<num1 && num1<num2)
		{
			System.out.printf("El numero menor es %f. %n", num3);
		}

}
}
