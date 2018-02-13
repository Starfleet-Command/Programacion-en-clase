public class Persona
{

private String nombre;
private String apellido;
private String alias;
private int edad;

public Persona()
{
  
}

public Persona(String nombre)
{

}

public void SetNombre(String nombre)
{
  this.nombre = nombre;

}

public void SetApellido(String apellido)
{
  this.apellido = apellido;
}

public void SetEdad(int edad)
{
  this.edad = edad;
}

public void SetAlias(String alias)
{
  this.alias=alias;
}

public String getNombre()
{
  return nombre;
}

public String getApellido()
{
  return apellido;
}

public int getEdad()
{
  return edad;
}

public String getAlias()
{
  return alias;
}

public void printPersona()
{
    System.out.println("Persona: "+alias+". "+nombre + " " +apellido);
    System.out.println("Edad:" +edad);
}

}
