
import java.util.Scanner;
public class FinalDiscretas
{

  public static void main(String[] args)
  {
     Scanner lector = new Scanner(System.in);

     String strung;
     int contador,a,b,c,d,k,z,error;

     contador=0;
     error=0;
     a = 0;
     b = 0;
     c = 0;
     d = 0;

     System.out.println("Escriba la ecuación booleana");
     strung = lector.nextLine();

    if (strung.contains("p")) {
      b=1;
      contador++;

      if (strung.contains("q")) {
        c=1;
        contador++;

        if (strung.contains("r")) {
          d=1;
          contador++;
        }
        else error++;
      }
        else error++;
    }
        else error++;

if (error==3) {
  System.out.println("Lo sentimos, su ecuación no es válida");
}
//----------------------------*Inicialización Tabla*----------------------------

      System.out.printf("P \t Q \t R\t| %s",strung);
      String[][] todo = new String[contador][((int)Math.pow(2,contador))];
      for (k=0;k<contador;k++ ) {

        if (b==1) {
          todo[0][k]= "t";
          todo[0][k+1] = "f";

          if (c==1) {
            if (k%2 !=0) {
              System.out.printf("%s",todo[0][k]+"\t t") ;
                System.out.printf("%s",todo[0][k+1]+"\t t");
            }
              else if (k%2 == 0) {

              }

          }
        }




      }




  }

}
