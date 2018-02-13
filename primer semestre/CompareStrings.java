public class CompareStrings
{
  public static void main(String[] args)
  {
    String uno = "Hola";
    String dos = "Adios";
    String tres = "Nos vemos";

    int comparacion;

    comparacion = uno.compareTo(dos);

    System.out.printf("Comparación 1 con 2: %d %n", comparacion);

    //Funciona con la distancia entre las letras en el alfabeto. Si las primeras letras
    // del string son iguales, se va con el siguiente. Tambien cambia si hay mayusculas o acentos

  }
}
