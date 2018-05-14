public class BusinessEmployee extends Employee implements employeeStatus
{
  public double bonusBudget=0;
  public BusinessEmployee(String name)
  {
    super(name,50000);
    this.bonusbudget=bonusBudget;
  }

  public double getBonusBudget()
  {
    return this.bonusbudget;
  }

@Override
  public String employeeStatus()
  {
    String part = super.toString();
    String part2 = ("with a budget of"+this.bonusbudget);
    String complete = (part + "" + part2);
    return complete;
  }
}
