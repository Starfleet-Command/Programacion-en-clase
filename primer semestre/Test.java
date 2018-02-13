public class Test
{
 public static void  main(String[] args) 
 {
  double numero1, numero2, raiz, numero3;

  numero1= Double.parseDouble(args [0]);
  numero2= Double.parseDouble(args [1]);
  numero3= Double.parseDouble(args [2]);
  raiz= Math.sqrt((numero2*numero2)-4*(numero1*numero3));

  System.out.println("La primera raiz es "+((-numero2 + raiz)/(2*numero1)));
  System.out.println("La segunda raiz es "+((-numero2 - raiz)/(2*numero1)));

 
 }
 
}

