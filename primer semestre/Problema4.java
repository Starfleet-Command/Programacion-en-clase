import java.util.Scanner;
	public class Problema4
		{
			public static void main (String[] args)

			{
				int[] primes = new int[81];
				int x = 0, conteo = 0;

				for(int j=2; j<420; j++)
					{
						for(int k=1; k<=j; k++)
						{
							if (j%k==0)
							{
								conteo++;
							}
						}
								if(conteo<3)
								{
									primes[x]=j; x++;
								}

								conteo=0;




					}

					for(int l=0; l<=80; l++)
					{
						if (l%11!=1)
						{



						System.out.printf("%d\t", primes[l]);
					}
					}

					System.out.println();

					System.out.println();








			}
		}
