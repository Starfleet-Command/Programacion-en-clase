public class Accountant extends BusinessEmployee implements EmployeeStatus
{
  protected String accountant;
  protected double bonusbudget=0;
  protected TechLead supporting = null;

  public Accountant(String name)
  {
    this.name=name;
    this.bonusbudget=bonusbudget;

    this.supporting=supporting;
  }

  public TechLead getTeamSupported()
  {
    return this.supporting;
  }

  public void SupportTeam(TechLead lead)
  {
    this.supporting=lead;
    this.bonusbudget= (lead.reportes.size()*2)+(lead.reportes.size()*0.1);
    super.bonusbudget=this.bonusbudget;
  }

  public boolean approveBonus(double bonus )
  {
    if(this.supporting!=null)
    {
    if (bonus<bonusbudget)
    {
        return true;
    }
  }
   return false;
  }

  @Override
  public String employeeStatus()
  {
    String part1 = super.employeeStatus();
    String part2 = supporting.getName();
    String complete = (part1 + "" +part2);
    return complete;
  }


}
