public class Empleado
{
  public String nombre;
  public double salario;
  private String puesto = "";

  public void imprimeDatos()
  {
      System.out.println("Nombre: \t"+this.nombre);
      System.out.println("Salario: \t"+this.salario);
      System.out.println("Puesto: \t"+this.puesto);
  }

  public boolean setPuesto(String puesto)
  {
    if(puesto.equals("Estudiante") || puesto.equals("Profesor"))
    {
        this.puesto=puesto;
        return true;
    }
    else
      return false;
  }

  public String getPuesto()
  {
    return puesto;
  }

}
