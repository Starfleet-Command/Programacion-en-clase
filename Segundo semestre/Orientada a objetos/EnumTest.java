public class EnumTest{
Day day;

public EnumTest(Day day)
{
  this.day = day;
}
public void print()
{
  switch(day)
  {
    case LUNES: System.out.println("Que dia mas horrible");
    break;
    case VIERNES: System.out.println("Thank god it's Friday");
    break;
    case SABADO: System.out.println("El segundo mejor dia de la semana");
    break;
    case DOMINGO: System.out.println("Que lindo es estar en fin de semana");
    break;
    default: System.out.println("Este dia esta meh");
  }
}
}
