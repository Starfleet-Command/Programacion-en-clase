import java.io.*;
public class EscribirArchivo
{
  public static void main(String[] args) throws IOException
  {
    File archivo;
    String nombrearchivo = "ejemplo60.txt";

    archivo = new File("ejemplo60.txt");
E
    archivo.createNewFile();

    FileWriter escritor = new FileWriter(archivo,true);

    // NO HACER ESTO : escritor.write("Ejemplo de archivo. \n Salto de linea. %nOtra Linea");

    PrintWriter pw = new PrintWriter(escritor);
    pw.printf("Ejemplo de archivo con formato. %nNumero %d",1218);
    escritor.close();
  }
}
