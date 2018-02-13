import java.io.*;
public class AbreDatos
{
  public static void main(String[] args) throws IOException;
  {
    String nombre = "datos.csv";

    BufferedReader br;
    FileReader lector2;
    String arreglo[] = new String[]


    lector2 = new FileReader(nombre);
     br = new BufferedReader(lector2);


     while ( (datosLeidos = br.readLine()) != null )
     {
       arreglo = datosLeidos.split(",");

     }

     System.out.printf("%s",arreglo[4]);
     System.out.printf("%s",arreglo[19]);
     System.out.printf("%s",arreglo[49]);


  }
}
