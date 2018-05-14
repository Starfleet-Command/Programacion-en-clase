public class Employee extends Managers implements EmployeeStatus
{
  protected String name;
  protected double baseSalary;
  private int id=1;

  public Employee(String name, double baseSalary)
  {
    this.name=name;
    this.baseSalary=baseSalary;
    this.id=id;

    id++;
  }

  public double getBaseSalary()
  {
    return baseSalary;
  }

  public String getName()
  {
    return name;
  }

  public int GetEmployeeID()
  {
    return id;
  }

/* public Employee getManager()
  {

  }

  */

  @Override
  public String toString()
  {
    String combi = (this.id + "" + this.name);
    return combi;
  }




  public boolean equals(Employee other)
{
  if(this.id==other.id)
  {
    return true;
  }
  else return false;
}

public boolean isManager(Object e)
{
  boolean isManager;
  isManager=  super.isManager(e);
  return isManager;
}

@Override
public String employeeStatus()
{
  return 0;
}

}
