public class Unicode
{
public static void main(String[] args)
{
  String str;
  int valor;

   str = "Niño 𝒫";
   valor = str.codePointAt(2);


  System.out.printf("%d",valor);
  System.out.println("");
  System.out.printf("El char es "+str.charAt(2));
  System.out.println("");
  System.out.printf("El char especial es "+str.codePointAt(5));
  System.out.println("");
  System.out.printf("el valor es %d%n",str.codePointAt(1));

}

}
