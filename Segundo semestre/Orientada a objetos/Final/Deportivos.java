public class Deportivos extends Vehiculos  implements Alquiler
{
  private String marca, matricula;
  private int id, kilometros, gasolina, anio,puertas,asientos,capacidad,diasRenta;
  private boolean turbo;

   public Deportivos(String marca, String matricula, int id, int kilometros, int gasolina, int anio, int puertas,int asientos, boolean turbo,int capacidad,int diasRenta)
   {
     super(marca,matricula,id,kilometros,gasolina,anio,capacidad,diasRenta);
     this.puertas=puertas;
     this.asientos=asientos;
     this.turbo=turbo;
   }




   public double Alquiler(int dia, int capacidad,int gasolina)
   {
     int baseCost = 2500;
    baseCost= Disminuye(baseCost,(2018-getAnio()));
    if(baseCost<1500)
    {
      baseCost=1500;
    }
    double aniade=((100-gasolina)*capacidad);
    double aniade2 = 0.1*aniade;
    double aniade3= 20*aniade2;
    double costoFinal = (baseCost*dia)+aniade3;
    return costoFinal;
   }


}
