/* Juan Francisco Gortarez Ricardez A01021926
Examen Final Fundamentos de programacion
Problema 3
Profesor Luis Yepez */

import java.util.Scanner;
public class Examen3_3
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

      String[] arreglo2 = new String[cadena.length()];
      String[] resultado = new String[cadena.length()];
      String[] resultados = new String[]



      //char[] charArray = cadena.toCharArray();

      arreglo2[]= cadena.split("-");

for (int u=0;u<cadena.length() ;u++ ) {
    resultados[u]=  Recursiva(cadena,arreglo2,arreglo2.length);

}
     System.out.println("El string al reves es");

     for (int u=0;u<resultados.length ; u++)
     {
        System.out.printf("%s",resultados[u]);
     }


}

    public static String Recursiva(String cadena,String[] arreglo,int longitud )
    {
      char[] charArray = arreglo.toCharArray();


      if(cadena.length()==0)
      {
        return charArray[0];
      }



return Recursiva(cadena,arreglo,cadena.length()-1);

}
}
