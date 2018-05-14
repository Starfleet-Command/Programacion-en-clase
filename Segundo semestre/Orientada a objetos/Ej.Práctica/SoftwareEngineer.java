public class SoftwareEngineer extends TechEmployee
{
  protected String name;
  protected boolean hasAccess=false;
  public  int checkIns=0;
  protected double salario;
 TechLead dummy= new TechLead("Dummy");

  public SoftwareEngineer(String name)
{
  super(name);
  this.hasAccess = hasAccess;
  this.checkIns=checkIns;
  this.salario=super.salario;
}


public boolean GetCodeAccess()
{
  return hasAccess;
}

public void setCodeAccess(boolean access)
{
  if(access==true)
  {
    this.hasAccess=true;
  }
  else this.hasAccess=false;
}

public int getSuccessfulCheckIns()
{
  return checkIns;
}

 public boolean checkInCode()
{
  boolean confirma = dummy.approveCheckIn(this);
  if(confirma==false)
  {
    this.hasAccess=false;
    return false;
  }
  else return true;
}


}
