import java.util.Scanner;
public class Cadena
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    String inicial;
    String separa;
    int contador=0;


    System.out.println("Escriba la cadena que quiere que sea analizada");
    inicial= lector.nextLine();

    char[] arreglo = inicial.toCharArray();

    for (int i=0;i<inicial.length() ;i++ ) {
      if (inicial.codePointAt(i)==32)
      {
        contador++;
      }
    }

    System.out.printf("Su cadena tiene %d espacios vacíos",contador);
  }
}
