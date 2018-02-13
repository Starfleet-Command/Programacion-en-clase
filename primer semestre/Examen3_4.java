/* Juan Francisco Gortarez Ricardez A01021926
Examen Final Fundamentos de programacion
Problema 3
Profesor Luis Yepez */
import java.util.Scanner;
public class Examen3_4
{
  public static void main(String[] args)
  {
      String cadena,resultados;
      int limite;
      Scanner lector = new Scanner(System.in);

      System.out.println("Escriba una cadena de no mas de 50 caracteres");
      cadena = lector.nextLine();


      String[] arreglo2 = new String[cadena.length()];
      String[] resultado = new String[cadena.length()];



        arreglo2= cadena.split("-");

      char[] charArray = cadena.toCharArray();


    resultados=  Recursiva(arreglo2,charArray,cadena.length());


    System.out.printf("%s",resultados);



}

    public static String Recursiva(String[] arreglo2,char[] charArray, int longitud )
    {


      if(longitud==1)
      {
        return "";
      }

String hola = arreglo2[arreglo2.length-1];


return hola + Recursiva(arreglo2,charArray,longitud-1);

}
}

/* C:\Users\Juan Fco\Desktop\Programacion>java Examen3_4
Escriba una cadena de no mas de 50 caracteres
hola mundo
hola mundohola mundohola mundohola mundohola mundohola mundohola mundohola mundohola mundo */
