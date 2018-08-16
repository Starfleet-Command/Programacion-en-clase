public class Empleado
{
  String nombre; String numeroEmp;
   double salariobase;
   int prima;
   double incentivoProductividad; double incentivoAsistencia;


  public Empleado(String nombre, String numeroEmp, double salariobase, int prima, double incentivoProductividad, double incentivoAsistencia)
  {
    this.nombre=nombre;
    this.numeroEmp=numeroEmp;
    this.salariobase=salariobase;
    this.prima=prima;
    this.incentivoProductividad=incentivoProductividad;
    this.incentivoAsistencia=incentivoAsistencia;

  }



public void printNomina(Empleado a)
{
  CalculosEmpleado dummy = new CalculosEmpleado(a);
  dummy.PrintNomina();
}

}
