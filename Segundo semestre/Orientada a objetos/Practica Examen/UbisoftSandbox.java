/*
Copyright (c) 2018 Your Mom. All Rights Reserved.
*/
import java.lang.InterruptedException;
public class UbisoftSandbox<T> implements Stringair
{
private T object1;
private T object2;

public UbisoftSandbox(T ob1,T ob2)
{
  object1=ob1;
  object2=ob2;
}

public void ClassType()
{
  try {
    System.out.println("La clase del primer objeto es "+ object1.getClass().getSimpleName() + " y su valor es: " +object1);
    Thread.sleep(500);
      System.out.println("La clase del segundo objeto es "+ object2.getClass().getSimpleName() + " y su valor es: " +object2);
  }
  catch(InterruptedException ex)
  {
    System.out.println("Algo salio mal");
  }

}

public String ToString()
{
  String air = "Stringair!";
return air;
}

public String nextShowing()
{
  String incorrect = "This is just not the correct class, man.";
  return incorrect;
}

}
