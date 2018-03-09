public class Student{

private String name;
private int id;
private int units;

public Student(String name, int id)
{
  this.name=name;
  this.id =id;

}

public int AddUnits(int units)
{
  this.units = units;
  return units;
}



public String GetName()
{
  return name;
}

public int GetID()
{
 return id;
}

public int GetUnits()
{
  return units;
}



public void PrintEstudiante(Student other)
{
  System.out.println("El ID del primer estudiante es: "+this.id);
  System.out.println("Su Nombre es: "+this.name);
  System.out.println("Sus unidades añadidas son: "+this.units);
}

}
