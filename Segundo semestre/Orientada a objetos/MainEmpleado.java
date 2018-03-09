public class MainEmpleado
{
  public static void main(String[] args)
  {
    Empleado emp1 = new Empleado("Juan","Gortarez","Ricardez","1000");
    Empleado emp2 = new Empleado("Jose","Lope","De Vega","4500");
    emp1.Sueldo(15000);
    emp1.Compara(emp2);
  }
}
