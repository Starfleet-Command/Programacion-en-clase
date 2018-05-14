public class TechEmployee extends Employee implements EmployeeStatus
{
  protected String name;
  protected double salario=75000;
  public TechEmployee(String name)
  {
    super(name,75000);
    this.salario=salario;
  }


@Override
  public String employeeStatus()
  {
    String part = super.toString();
    String complete = (part+""+ "Has 2 successful check ins");  //AÑADIR CHECKINS
    return complete;
  }
}
