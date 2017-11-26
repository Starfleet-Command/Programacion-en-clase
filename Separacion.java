import java.util.Scanner;
public class Separacion
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    String inicial;
    String separa;


    System.out.println("Escriba la cadena que quiere que sea separada");
    inicial= lector.nextLine();

    System.out.println("Escriba el caracter por el que quieres que se separe");
    separa = lector.nextLine();
    String arreglo[] = new String[inicial.length()];

    System.out.println("%s",separa.charAt(0));

    arreglo= inicial.split(""+separa.charAt(0));

    for (int i=0;i<arreglo.length ;i++ ) {
      System.out.printf("%s %n",arreglo[i]);
    }
  }
}
