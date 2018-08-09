public class Lampara
{
  private String color;
  private int potencia;
  private int niveles;
  private boolean prendido;
  public Lampara(String color,int potencia, int niveles,boolean prendido)
  {
    this.color=color;
    this.potencia=potencia;
    this.niveles=niveles;
    this.prendido=prendido;
  }

  public void setColor(String color)
  {
    this.color=color;
  }

  public void setPotencia(int potencia)
  {
    this.potencia=potencia;
  }

  public void setNiveles(int niveles)
  {
    this.niveles=niveles;
  }

  public void setPrendido(boolean prendido)
  {
    this.prendido=prendido;
  }


  public int returnPotencia()
  {
    return this.potencia;
  }

  public int returnNiveles()
  {
    return this.niveles;
  }

  public String returnColor()
  {
    return this.color;
  }

  public boolean returnPrendido()
  {
    return this.prendido;
  }

  public void intensidad(int set)
  {
     if(set>this.niveles)
     {
       System.out.println("Lo sentimos,la lampara no llega a ese nivel");

     }
      else
      {
        System.out.printf("Intensidad de la lampara puesta a %d",set);
        System.out.println("");
      }
  }

  public void prender()
  {
    if(this.prendido==true)
    {
      System.out.println("La lámpara ya esta prendida");
    }
    else
    {
      System.out.println("La lampara se prendió");
      this.prendido=true;
    }

  }

  public void apagar()
  {
    if(this.prendido==false)
    {
      System.out.println("La lampara ya está apagada");
    }
    else
    {
      System.out.println("La lámpara se ha apagado");
      this.prendido=false;
    }

  }
}
