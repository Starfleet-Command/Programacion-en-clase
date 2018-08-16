public class CalculosEmpleado
{
  String nombre,numeroEmp;
  double salariobase,retenciones;

public CalculosEmpleado(Empleado t)
{
  this.nombre=t.nombre;
  this.numeroEmp=t.numeroEmp;
  this.salariobase=t.salariobase;
  this.retenciones=Retenciones(this.salariobase);
}
  public double Retenciones(double salarioBase)
  {
    double reten=0;
    if(salarioBase<6000)
    {
      reten=(salarioBase*0.07);
    }
    else reten=(salarioBase*0.09);

    reten+=(salarioBase*0.05);
    System.out.println(""+reten);
    return reten;
  }

  public void PrintNomina()
  {
    double neto= this.salariobase-this.retenciones;
    System.out.printf("El trabajador %s con numero %s  tiene un salario de %f despues de $ %f pesos de deducciones  ",this.nombre,this.numeroEmp,neto,this.retenciones);
  }
}
