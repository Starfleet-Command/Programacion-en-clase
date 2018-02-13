public class Time
{

private int hora;
private int minuto;
private int segundo;

public Time()
{
  this(0,0,0);
}

public Time(int hora)
{
  this(hora,0,0);
}

public Time(int hora, int minuto)
{
  this(hora,minuto,0);
}

public Time(int hora,int minuto, int segundo)
{
  if(hora>24 || hora<0)
  {
    this.hora =0;
  }
  if(minuto>60 || minuto<0)
  {
    this.minuto=0;
  }

  if(segundo<0 || segundo>60)
  {
    this.segundo=0;
  }
  this.hora=hora;
  this.minuto=minuto;
  this.segundo = segundo;
}

public Time(Time tiempo)
{
  this(tiempo.hora,tiempo.minuto,tiempo.segundo);
}

public void printTime()
{

  if(hora<10)
  System.out.println("0"+hora + ":");
  else
  System.out.println(hora+":");

  if(minuto<10)
  System.out.println("0"+minuto + ":");
  else
  System.out.println(hora+":");

  if(segundo<10)
  System.out.println("0"+segundo + "horas");
  else
  System.out.println(segundo+"hora");
}
}
