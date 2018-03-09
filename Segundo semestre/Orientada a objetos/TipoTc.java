public enum TipoTc
{
  CLASICA(29,47,7500,699),ORO(25,45,15000,959),PLATINUM(16,33,45000,1999),BLACK(9.9,16,100000,4599);

  private final double ingresos_min;
  private final double anualidad;
  private final double min;
  private final double max;

  public static final int corte =28;

  //TipoTC.corte = 30; si llamas esto desde otro método en otro programa, sobreescribes el valor que está aqui.

  private TipoTc(double min,double max, double ingresos_min, double anualidad)
  {
    this.min=min;
    this.max = max;
    this.ingresos_min = ingresos_min;
    this.anualidad = anualidad;
  }

  public double TasaInteresAnual()
  {
    double tiie = (corte*100)/360;
    double ptos = max-min;
    return (tiie + ptos);
  }

  public double TasaInteresMensual()
  {
    return (TasaInteresAnual()/360)*30;
  }
}
