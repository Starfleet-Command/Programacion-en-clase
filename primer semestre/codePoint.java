public class codePoint
{
  public static void main(String[] args)
  {
    String strung;
    int valor;
    String compara = args[0];
    String nuevo;

    strung=  "Blessed are they who stand before the corrupt and the wicked and do not falter. \n Blessed are the peacekeepers, the champions of the just. \n Blessed are the righteous, the lights in the shadow. \n In their blood the Maker's will is written." ;

System.out.println(strung);
if (strung.contains("Blessed") && strung.contains(compara.toLowerCase() ) )
  System.out.println("Walk in the Maker's path");
else
  System.out.println("I denounce you in the name of Andraste");

nuevo = strung.replace("peacekeepers", "Dalish");
System.out.println(nuevo);

//Existe un tipo de datos llamados string.buffer que son mutables.
  }
}
