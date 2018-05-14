public class Motos extends Vehiculos implements Alquiler
{
  private String marca, matricula;
   private int id, kilometros, gasolina, anio,capacidad,diasRenta;
  public Motos(String marca, String matricula, int id, int kilometros, int gasolina, int anio,int capacidad,int diasRenta)
  {
    super(marca,matricula,id,kilometros,gasolina,anio,capacidad,diasRenta);
  }



  public double Alquiler(int dia, int capacidad,int gasolina)
  {
    int baseCost = 800;
    double aniade=((100-gasolina)*capacidad);
    double aniade2 = 0.1*aniade;
    double aniade3= 20*aniade2;
    double costoFinal = (baseCost*dia)+aniade3;
   return costoFinal;
  }


}
