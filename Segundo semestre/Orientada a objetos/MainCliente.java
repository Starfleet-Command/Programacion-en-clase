public class MainCliente
{
  public static void main(String[] args)
  {
    Persona cliente1 = new Persona();

    Persona cliente2 = new Persona("Marcela");

    Persona cliente3 = new Persona("Gabriela", "Rodriguez",30,"Sra");

    cliente1.SetNombre("Rodrigo");
    cliente1.SetApellido("Garcia");
    cliente1.SetAlias("Sr");
    cliente1.SetEdad(32);

    cliente1.printPersona();
    cliente2.printPersona();
    cliente3.printPersona();

  }
}
