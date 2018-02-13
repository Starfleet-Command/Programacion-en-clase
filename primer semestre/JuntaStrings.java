public class JuntaStrings
{
  public static void main(String[] args)
  {
    String[] nombres={"Daniel", "Roa", "González"};
    String lineaCSV;

    lineaCSV = String.join(", ",nombres);

    System.out.println(lineaCSV);

    String[] separados;

    separados = lineaCSV.split(",");
    System.out.println(separados[0]);
  }
}
