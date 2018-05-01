import java.util.ArrayList;
public class TechLead extends TechEmployee implements CheckIn
{
  protected String name;
  protected int headCount=4;
  SoftwareEngineer dummy = new SoftwareEngineer("Dummy");
  ArrayList<SoftwareEngineer> reportes = new ArrayList<SoftwareEngineer>();

  public TechLead(String name)
  {
    super(name);
    this.salario=super.salario*1.3;
    this.headCount=4;
  }

  

  public boolean hasHeadCount()
  {
    if(reportes.size()<headCount) return true;
    else return false;

  }

  public boolean addReport(SoftwareEngineer e)
  {
  if ( hasHeadCount() ==true)
  {
    reportes.add(e);
    return true;
  }

  else return false;
  }

  public boolean approveCheckIn(SoftwareEngineer e)
  {
    if(reportes.contains(e) && e.hasAccess==true)
    {
      e.checkIns=e.getSuccessfulCheckIns()+1;
      return true;

    }

     return false;
  }

  public String getTeamStatus()
  {
    String managerial = super.employeeStatus();
    String bridge = "And is managing: \n";
    String finales="";
    for(int k=0;k<reportes.size();k++)
    {

    finales =  (finales + "\n"+  reportes.get(k).employeeStatus());
    }
    String completa = (managerial+""+bridge+""+""+finales);
    return completa;
  }

}
