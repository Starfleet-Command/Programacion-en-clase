public class Persona
{
  String persona;
  Direccion direccion;
  int dia,mes,anio;
  Fecha fecha;


public Persona(String persona, Direccion direccion, int dia, int mes, int anio)
{
  this.persona = persona;
  this.direccion = direccion;
  fecha = new Fecha(dia,mes,anio);
  this.fecha = fecha;

}

public String getPersona()
{
  return persona;
}

public Direccion getDireccion()
{
  return direccion;
}

public Fecha getFecha()
{
  return fecha;
}

public boolean esMayordeEdad(Fecha k)
{
  boolean esMayor = false;
  if((k.anio==2000 && k.mes==4 && k.dia<=3)|| (k.anio<2000))
  {
    esMayor=true;
  }
  return esMayor;
}

public String toString()
{
  String completo = ("Nombre: "+this.persona+ "\n"+"Fecha de Nac.: "+fecha.dia+ "-"+fecha.mes+"-"+fecha.anio+"\n"+"Direccion:" +direccion.calle+"\t"+direccion.numero+"\t"+direccion.cp+"\t"+direccion.ciudad);
  return completo;
}

}
