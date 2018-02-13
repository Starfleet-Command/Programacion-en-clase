import java.util.Scanner;

public class Paso
{
  public static void main(String[] args)
{
		int vara;
		int varb;
    int varc;


		Scanner lector = new Scanner(System.in);

    System.out.println("Escriba la variable a");
		vara = lector.nextInt();

		System.out.println("Escriba la variable b");
		varb= lector.nextInt();

    System.out.println("Escriba la variable c");
		varc= lector.nextInt();

		imprime(vara,varb,varc);



	}

		public static void imprime(int vara, int varb, int varc)
		{
      raiz= Math.sqrt((varb*varb)-4*(vara*varc));

			System.out.printf("La variable a es %d. la variable b es %d. La variable c es %d.%n", vara,varb,varc);
      System.out.printf("La primera raiz es " + (-varb + raiz)/(2*vara));
      System.out.printf("La segunda raiz es "+ (-varb - raiz)/(2*vara));
		}
}
