public enum TipoTarjeta
{
  CLASICA(29,47,7500,699),ORO(25,45,15000,959),PLATINUM(16,33,45000,1999),BLACK(9.9,16,100000,4599);

  TipoTarjeta(int min,int max, float ingreso, float anualidad)
  {
    this.min=min;
    this.max = max;
    this.ingreso = ingreso;
    this.anualidad = anualidad;
  }

  private float Min()
  {
    return min;
  }

  private float Max()
  {
    return max;
  }

  private float Ingreso()
  {
    return ingreso;
  }

  private float Anualidad()
  {
    return anualidad;
  }



public String Interes(TipoTarjeta tipo)
{

  float tiie,tim,tia,porc;

  tiie=((28*100)/360);
  porc = max-min;
  tia = tiie+porc;
  tim = (tia/360)*30;

String interes = new String ("Su interes mensual es %f , y su interes anual es %f ",tim,tia);
    return interes;
}

}
