import java.util.Random;
import java.io.*;

public class ArchivoRandom
{
  public static void main(String[] args) throws IOException
  {
    int limite;
    Random aleatorio = new Random();



    File archivador;
     archivador = new File("Datos.dat");
     archivador.createNewFile();


     FileWriter escritor = new FileWriter(archivador);
     PrintWriter pw = new PrintWriter(escritor);

    for (int k=0;k<200 ;k++ ) {
      limite = aleatorio.nextInt(1000);
      if(limite%15 !=0)
      {
        pw.println(limite);
      }
    }
  }
}
