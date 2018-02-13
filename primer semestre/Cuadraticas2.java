/* Juan Francisco Gortarez
Input: ax^2 ± bx ± c
Output: Raices reales de esa funcion cuadratica
*/

import java.util.Scanner;

public class Cuadraticas2
{
  public static void main(String[] args)
{
		Double vara;
		Double varb;
    Double varc;


		Scanner lector = new Scanner(System.in);

    System.out.println("Escriba la variable a");
		vara = lector.nextDouble();

		System.out.println("Escriba la variable b");
		varb= lector.nextDouble();

    System.out.println("Escriba la variable c");
		varc= lector.nextDouble();



		imprime(vara,varb,varc);




	}

		public static void imprime(Double vara, Double varb, Double varc)
		{
      Double raizpos;
      Double raizneg;

      raizpos= ((-varb + Math.sqrt((varb*varb)-(4*vara*varc)))/(2*vara));
      raizneg= ((-varb - Math.sqrt((varb*varb)-(4*vara*varc)))/(2*vara));

      if (raizpos>=0 || raizneg>=0)
      {

			System.out.printf("La variable a es %f. la variable b es %f. La variable c es %f.%n", vara,varb,varc);
      System.out.println("La primera raiz es " + raizpos);
      System.out.println("La segunda raiz es " + raizneg);
    }

      else if (raizpos<0 || raizneg<0) {
      System.out.printf("La variable a es %f. la variable b es %f. La variable c es %f.%n", vara,varb,varc);
      System.out.println("Esta ecuación contiene soluciones imaginarias inoperables");
      }


		}
  }
