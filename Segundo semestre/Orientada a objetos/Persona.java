public class Persona
{

private String nombre;
private String apellido;
private String alias;
private int edad;


//COnstructor genérico
public Persona()
{
  nombre = "Genérico";
}

//Constructor 2
public Persona(String nombre)
{
  this.nombre = nombre;
  this.apellido = "default";
  this.alias = "default";
}
// Constructor 3 (Complejo)
public Persona(String nombre, String apellido, int edad, String alias)
{
  this.nombre = nombre;
  this.apellido = apellido;
  this.edad = edad;
  this.alias = alias;
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
