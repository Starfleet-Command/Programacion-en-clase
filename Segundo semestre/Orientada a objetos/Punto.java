public class Punto
{
  private int x;
  private int y;



  public Punto(int x, int y)
  {
    this.x =x;
    this.y =y;
  }

  public int Getx()
  {
    return x;
  }

  public int Gety()
  {
    return y;
  }

  public void distancia(Punto other)
  {
    double sumax = ((other.x-this.x)*(other.x-this.x));
    double sumay = ((other.y-this.y)*(other.y-this.y));
    double sumafin = Math.sqrt(sumax+sumay);
    if(sumafin<0)
    {
      sumafin = -sumafin;
    }

    System.out.println("La distancia entre ambos puntos es: "+sumafin);
  }
}
