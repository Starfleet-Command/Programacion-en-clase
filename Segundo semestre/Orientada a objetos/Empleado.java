public class Empleado
{
  private String nombre, app,apm,nume;
  private float sueldo =10000;

  public Empleado(String nombre, String app, String apm, String nume)
  {
    this.nombre =nombre;
    this.app =app;
    this.apm=apm;

    if ((Integer.parseInt(nume)>1) && (Integer.parseInt(nume)<1000000))
    {
      this.nume = nume;
    }
    else nume="1";


}
    public float Sueldo(float sueldo)
    {
      this.sueldo=sueldo;
      return sueldo;
    }


    public String getNombre()
    {
      return nombre;
    }

    public String getApp()
    {
      return app;
    }

    public String getApm()
    {
      return apm;
    }

    public String getNume()
    {
      return nume;
    }

    public float getSueldo()
    {
      return sueldo;
    }
    public void Compara(Empleado other)
    {
      if(this.sueldo> other.sueldo)
      {
        System.out.println("El primer empleado es el que tiene el mayor salario");
      }
      else if(other.sueldo> this.sueldo)
      {
        System.out.println("El segundo empleado es el que tiene el mayor salario");

      }
    }



}
