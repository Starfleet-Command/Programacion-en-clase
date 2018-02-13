class sistemaRH
{
  public static void main(String[] args)
  {
    Empleado emp1 = new Empleado();
    emp1.nombre = "luis";
    emp1.salario = 240.2;
    emp1.setPuesto("Profesor");

    Empleado emp2 = new Empleado();
    emp2.nombre = "Jose";
    emp2.salario = 548.3;
    emp2.setPuesto("Estudiante");

    emp1.imprimeDatos();
    emp2.imprimeDatos();

if(!emp2.setPuesto("Estudiante"))
{
  System.out.println("Error de asignación");
}

System.out.println("El puesto del empleado 1 es"+emp1.getPuesto());

Empleado[] empleados = new Empleado[10];
empleados[0] = new Empleado();
empleados[0].nombre = "Anglada";

for(int i=0;i<1;i++)
{
  empleados[i].imprimeDatos();
}
  }
}
