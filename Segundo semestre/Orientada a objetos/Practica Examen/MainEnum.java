public class MainEnum
{
  public static void main(String[] args)
  {
  EnumPractica cancion = EnumPractica.POET;

  System.out.println(cancion.getEscala());


for(EnumPractica canciones :  EnumPractica.values())  //Todos los valores de EnumPractica que pueden ser atribuidos a canciones
{
  System.out.println(canciones);
  System.out.println(canciones.getEscala());
}

System.out.println(cancion.miFavorito("POET"));


switch(cancion)
{
  case POET:
  System.out.println("Eres muy conocedora");
  break;
  case POMPEII:
  System.out.println("Esta bien. Te lo acepto");
  break;
}

}
}
