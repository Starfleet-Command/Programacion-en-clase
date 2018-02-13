import java.util.Scanner;
public class Sopa
{
  public static void main(String[] args)
  {
    char[][] sopa = {{'s','e','e','d','z'},{'y','b','s','u','n'},{'t','u','l','i','p'},{'j','g','w','p','n'},{'z','s','b','e','e'}};
Scanner lector = new Scanner(System.in);

System.out.println("Escriba la palabra que quiere encontrar (Todas las palabras en la sopa tienen 4 letras o menos)");
String a= lector.nextLine();

Sopas(sopa,a);

  }

  public static void Sopas(char[][] soup, String u)
  {
    boolean existe = false;
    int veces = 0;
    for(int i=0;i<soup.length-2;i++)
    {
      for(int j=0;j<soup[0].length-2;j++)
      {
    if((soup[i][j]==u.charAt(0) && soup[i][j+1]==u.charAt(1) && soup[i][j+2]==u.charAt(2) && soup[i][j+3]==u.charAt(3)) ||( soup[i][j]==u.charAt(0) && soup[i+1][j]==u.charAt(1) && soup[i+2][j]==u.charAt(2) && soup[i+3][j]==u.charAt(3)) )
    {
      existe = true;
      veces++;
    }
  }
}


    for(int e=0;e<soup.length-2;e++)
    {
      for(int f=0;f<soup[0].length-2;f++)
      {
    if((soup[e][f]==u.charAt(3) && soup[e][f+1]==u.charAt(2) && soup[e][f+2]==u.charAt(1) && soup[e][f+3]==u.charAt(0)) ||( soup[e][f]==u.charAt(3) && soup[e+1][f]==u.charAt(2) && soup[e+2][f]==u.charAt(1) && soup[e+3][f]==u.charAt(0)) )
    {
      existe = true;
      veces++;
    }
  }
}

if(existe==true)
{
  System.out.printf("Existe la palabra en la sopa de letras %d vez(-ces) ",veces);
}
else System.out.println("No existe la palabra en la sopa de letras");
  }
}
