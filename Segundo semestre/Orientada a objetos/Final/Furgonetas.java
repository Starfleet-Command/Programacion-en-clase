public class Furgonetas extends Vehiculos  implements Alquiler
{
  private String marca, matricula;
  private int id, kilometros, gasolina, anio,carga,capacidad,diasRenta;
  private double altura;
  public Furgonetas(String marca, String matricula, int id, int kilometros, int gasolina, int anio,int carga, double altura,int capacidad,int diasRenta)
  {
    super(marca,matricula,id,kilometros,gasolina,anio,capacidad,diasRenta);
    this.carga=carga;
    this.altura=altura;
  }



  public double Alquiler(int dia, int capacidad,int gasolina)
  {
    int baseCost = 2000;
    baseCost= Disminuye(baseCost,2018-getAnio());
    if(baseCost<1000)
    {
      baseCost=1000;
    }
    double aniade=((100-gasolina)*capacidad);
    double aniade2 = 0.1*aniade;
    double aniade3= 20*aniade2;
    double costoFinal = (baseCost*dia)+aniade3;
   return costoFinal;
  }


}
