

import java.lang.Math;
import java.util.Scanner;

public class CalculadoraMetodos
{
  public static void main(String[] args)
  {
    Scanner nou = new Scanner(System.in);


    System.out.println("Welcome to the Non-Linear Calculator");
    System.out.println("How many terms does your function have? (a term is an expression of the form ax^b)");
    int input1= nou.nextInt();
    int[][] matriz = new int[2][input1];
    for (int k=0;k<input1 ;k++ )
    {
      System.out.println("Write the value of x in term "+(k+1));
      matriz[0][k]=nou.nextInt();
      System.out.println("Write the exponent of x in term "+(k+1));
      matriz[1][k]=nou.nextInt();
    }

    System.out.println("Select your method:");
    System.out.println("1. Bisection");
    System.out.println("2. False Position");
    System.out.println("3. Newton Raphson");
    int userselect= nou.nextInt();

    System.out.println("Select your tolerance( in decimal form)");
    int tolerance = nou.nextInt();
    switch (userselect)
    {
      case 1:
System.out.println("Write the first x");
int x0=nou.nextInt();
System.out.println("Write the second x");
int x1=nou.nextInt();
System.out.println("Write the maximum iterations of this method");
int iterations = nou.nextInt();
int e=0;

      break;
      case 2:

      break;
      case 3:

      break;
    }

  }
}
