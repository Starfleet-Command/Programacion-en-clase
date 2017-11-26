import java.util.Scanner;
public class CharArray
{
  public static void main(String[] args)
  {
      String cadena;
      int limite;
      Scanner lector = new Scanner(System.in);

      System.out.println("Escriba una cadena de no mas de 50 caracteres");
      cadena = lector.nextLine();

      System.out.println("Cuantos caracteres de atras para delante quiere mostrar?");
      limite = lector.nextInt();

      if(limite>cadena.length())
      {
        limite = cadena.length();
      }

      System.out.println("se van a usar esta cantidad de caracteres: "+limite);

      char[] charArray = cadena.toCharArray();

      for (int i=cadena.length()-limite;i<cadena.length() ;i++) {

        System.out.print(charArray[i]);

      }


  }
}
