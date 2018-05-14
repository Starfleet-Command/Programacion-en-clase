public abstract class Vehiculos implements Alquiler
{
  protected String marca,matricula;
  protected int id,kilometros,gasolina,anio,capacidad,diasRenta;
  public Vehiculos( String marca, String matricula, int id, int kilometros, int gasolina, int anio,int capacidad,int diasRenta)
  {
    this.marca=marca;
    this.matricula=matricula;
    this.id=id;
    this.kilometros=kilometros;
    this.gasolina=gasolina;
    this.anio=anio;
    this.capacidad=capacidad;
    this.diasRenta=diasRenta;

  }

  public int Disminuye(int baseCost,int diferencia)
  {
     baseCost=baseCost-(100*diferencia);
     return baseCost;
  }

  public int getAnio()
  {
    return anio;
  }

  public int getCapacidad()
  {
    return capacidad;
  }

  public int getGasolina()
  {
    return gasolina;
  }

  public int getDias()
  {
    return diasRenta;
  }

  public int getID()
  {
    return id;
  }

  public int getCost()
  {
    if(this.getClass().getSimpleName()=="Motos")
    {
      return 800;
    }

    else if (this.getClass().getSimpleName()=="Furgonetas")
    {
      return 2000;
    }
    else return 2500;
  }

  public double Alquiler(int dia,int capacidad,int gasolina)
  {
    if(this.getClass().getSimpleName()=="Motos")
    {
      int baseCost = 800;
      double aniade=((100-gasolina)*capacidad);
      double aniade2 = 0.1*aniade;
      double aniade3= 20*aniade2;
      double costoFinal = (baseCost*dia)+aniade3;
     return costoFinal;
    }

    else if (this.getClass().getSimpleName()=="Furgonetas")
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

    else {

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

}
