public class Semaforo
{
  private int coloractual;
  private boolean estado;
  private boolean parpadeando;
  public Semaforo(int coloractual,boolean estado,boolean parpadeando)
  {
    this.coloractual=coloractual;
    this.estado=estado;
    this.parpadeando=parpadeando;

  }

  public void setColor(int coloractual)
  {
    this.coloractual=coloractual;
  }

  public void setColor(boolean estado)
  {
    this.estado=estado;
  }

  public void setParpadeando(boolean parpadeando)
  {
    this.parpadeando=parpadeando;
  }

  public int returnColor()
  {
    return this.coloractual;
  }

  public boolean returnEstado()
  {
    return this.estado;
  }

  public boolean returnParpadeo()
  {
    return this.parpadeando;
  }

  public void Prender()
  {
    if(this.estado==true)
    {
      System.out.println("El semáforo ya está prendido");
    }
    else
    {
      this.estado=true;
      System.out.println("El semaforo se prendio");
    }
  }

  public void Apagar()
  {
    if(this.estado==false)
    {
      System.out.println("El semáforo ya está apagado");
    }
    else
    {
      this.estado=false;
      System.out.println("El semaforo se apago");
    }
  }

  public void Cambia()
  {
    if(this.coloractual>=2)
    {
      this.coloractual=-1;
    }

    this.coloractual++;

    switch (this.coloractual)
    {
      case 0:
      System.out.println("El semaforo cambio de rojo a verde");
      break;
      case 1:
      System.out.println("El semaforo cambio de verde a amarillo");
      break;
      case 2:
      System.out.println("El semaforo cambio de amarillo a rojo");
      break;
    }
  }

  public void Parpadea()
  {
    if(this.parpadeando==true)
    {
      System.out.println("El semaforo ya esta parpadeando");

    }
    else
    {
      this.parpadeando=true;
      System.out.println("El semaforo se ha puesto a parpadear");
    }
  }

  public void DejaParpadea()
  {
    if(this.parpadeando==false)
    {
      System.out.println("El semaforo no esta parpadeando");

    }
    else
    {
      this.parpadeando=false;
      System.out.println("El semaforo ha dejado de parpadear");
    }
  }

    public void PrintEstado()
    {
      switch (this.coloractual)
      {
        case 0:
        System.out.println("El semáforo está en el color verde");
        break;
        case 1:
        System.out.println("El semáforo está en el color amarillo");
        break;
        case 2:
        System.out.println("El semáforo está en el color rojo");
        break;
      }
        if(this.estado==true)
        {
          System.out.println("El semáforo está prendido");
        }
        else System.out.println("El semáforo está apagado");

        if(this.parpadeando==true && (this.estado=true))
        {
          System.out.println("El semaforo esta parpadeando ");
        }
        else System.out.println("El semaforo no esta parpadeando");

    }
}
