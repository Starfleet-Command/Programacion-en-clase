public class Canguros
{
  private int distancia;
  private int velocidad;

public Canguros(int distancia, int velocidad)
  {
      this.distancia = distancia;
      this.velocidad = velocidad;
  }

  public int GetDistancia()
  {
  return distancia;
  }

  public int GetVelocidad()
  {
    return velocidad;
  }

  public void PrintCanguros(Canguros other)
  {
    int result1= 0;
    int result2=0;
    Boolean result = false;

if((this.distancia == other.distancia) && (this.velocidad== other.velocidad))
result = true;

    for(int k=0; k<(this.velocidad*other.velocidad);k++)
    {
       result1 = this.distancia+(this.velocidad*k);
       result2 =  other.distancia+(other.velocidad*k);

       if(result1==result2)
       {
         result=true;
       }


    }

    if(((this.distancia>other.distancia)&&(this.velocidad>other.velocidad)) || ((this.distancia<other.distancia)&&(this.velocidad<other.velocidad)) )
    result =false;


    if(result==true)
    System.out.println("SI");
    else
    System.out.println("NO");

  }
}
