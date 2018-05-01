public class Direccion{

String calle,numero,cp,ciudad;
public Direccion(String calle, String numero, String cp, String ciudad)
{
  this.calle=calle;
  this.numero=numero;
  this.cp= cp;
  this.ciudad = ciudad;
}

public String getCalle()
{
  return calle;
}

public String getNumero()
{
  return numero;
}

public String getCp()
{
  return cp;
}

public String getCiudad()
{
  return ciudad;
}
}
