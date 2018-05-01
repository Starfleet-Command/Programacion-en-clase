public abstract class Managers
{
  public boolean isManager;
  public boolean isManager(Object e )
  {

    if(e instanceof TechLead || e instanceof BusinessLead)
    {
       isManager=true;
    }
    else isManager=false;
    return isManager;
  }
}
