import java.util.Scanner;
public class Scratch
{
  public static void main(String[] args)
  {
    String first= null;
		String second= null;
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Enter text one");
first=keyboard.next();

System.out.println("Enter text two");
second=keyboard.next();
int result= first.compareToIgnoreCase(second);
if(result==0)
System.out.println("texts are equal");
else
System.out.println("texts are not equal");
  }
}
