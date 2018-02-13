/* Juan Francisco Gortarez Ricardez A01021926
Examen Final Fundamentos de programacion
Problema 4
Profesor Luis Yepez */

import java.util.Scanner;
import java.io.*;

public class Examen3_5
{
  public static void main(String[] args) throws IOException
  {
    int primerp,segundop,exfin,proyfin;

    double porcparc,porcexamen,porcproy;

    porcparc= 0.275;
    porcexamen= 0.30;
    porcproy=0.15;

    Scanner lector = new Scanner(System.in);

    System.out.println("Escriba su calificacion de primer parcial");
    primerp=lector.nextInt();

    System.out.println("Escriba su calificacion de segundo parcial");
    segundop=lector.nextInt();

    System.out.println("Escriba su calificacion de examen final");
    exfin=lector.nextInt();

    System.out.println("Escriba su calificacion de proyecto final");
    proyfin=lector.nextInt();

    File archivador;
     archivador = new File("Resultados.csv");
     archivador.createNewFile();


     FileWriter escritor = new FileWriter(archivador);
     PrintWriter pw = new PrintWriter(escritor);


     pw.printf("%d \t %f \t %f  %n",primerp,porcparc*100,primerp*porcparc);
     pw.printf("%d \t %f \t %f %n",segundop,porcparc*100,segundop*porcparc);
     pw.printf("%d \t %f \t %f %n",exfin,porcexamen*100,exfin*porcexamen);
     pw.printf("%d \t %f \t %f %n",proyfin,porcproy*100,proyfin*porcproy);
     pw.printf("Total: \t \t %f",((primerp*porcparc)+(segundop*porcparc)+(exfin*porcexamen)+(proyfin*porcproy)));


         escritor.close();

  }
}

/* C:\Users\Juan Fco\Desktop\Programacion>java Examen3_5
Escriba su calificacion de primer parcial
80
Escriba su calificacion de segundo parcial
43
Escriba su calificacion de examen final
65
Escriba su calificacion de proyecto final
43

80 	 27.500000 	 22.000000
43 	 27.500000 	 11.825000
65 	 30.000000 	 19.500000
43 	 15.000000 	 6.450000
Total: 	 	 59.775000   (Esto esta en el documento) */
