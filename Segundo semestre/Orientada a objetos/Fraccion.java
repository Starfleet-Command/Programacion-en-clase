import java.util.InputMismatchException;
import java.lang.ArithmeticException;
import java.io.*;
public class Fraccion extends CalculadoraFraccion
{
  private int den;
  private int num;
  private int gcd;
  private int numdiv,dendiv;
  public int resultado;
  private boolean test = false;

/* CONSTRUCTORES*/

public Fraccion(int num, int den)
{
  this.num=num;
  this.den=den;

  try{
    if(den<0)
    {
      this.num= -num;
      this.den = -den;
    }

    if(den<0 && num<0)
    {
      this.num= -num;
      this.den= -den;
    }


  }
  catch(ArithmeticException e)
  {
    System.out.println("No se puede realizar una division por cero");
  }
  catch(InputMismatchException e)
  {
    System.out.println("Escribio algun input de manera incorrecta");
  }




}

public Fraccion(int num)
{
  try{
  this.num= num;
  this.den = 1;

}
catch(ArithmeticException e)
{
  System.out.println("No se puede realizar una division por cero");
}
catch(InputMismatchException e)
{
  System.out.println("Escribio algun input de manera incorrecta");
}
}

public Fraccion()
{
  this.num= 0;
  this.den=1;

}

/*GETTERS*/

public int GetNumerador()
{
  return num;
}

public int GetDenominador()
{
  return den;
}

/*MODIFICADORES DE FORMATO*/

public void ToString()
{
  System.out.printf("%d/%d",num,den);
  System.out.println("");

}

public void toDouble()
{

  System.out.println(""+((double)this.num/this.den));
}

public double ToDouble()
{
  return (double)(num)/den;
}

/*OPERACIONES*/

public void add(Fraccion g)
{
  Fraccion ph = new Fraccion();

  ph.num = (g.num*this.den)+(this.num*g.den);
  ph.den *= this.den;
System.out.printf("%d/%d",ph.num,ph.den);
System.out.println("");
}

public void substract(Fraccion g)
{
  Fraccion ph = new Fraccion();

  ph.num = (this.num*g.den) - (g.num*this.den);
  ph.den *= this.den;
System.out.printf("%d/%d",ph.num,ph.den);
System.out.println("");
}

public void multiply(Fraccion g)
{
  Fraccion ph = new Fraccion();

ph.num = (g.num) * (this.num);
ph.den = (g.num)*(this.num);
System.out.printf("%d/%d",ph.num,ph.den);
System.out.println("");
}

public void divide(Fraccion g)
{
Fraccion ph = new Fraccion();
try{


ph.num = g.num*this.num;
ph.den = g.den*this.den;

}
catch(ArithmeticException e)
{
  System.out.println("Hubo un error en la operacion. Comprueba que tus datos sean correctos");
}
System.out.printf("%d/%d",ph.num,ph.den);
System.out.println("");
}

public void Equals(Object o)
{
  if(o instanceof Fraccion)
  {
    Fraccion k = (Fraccion)o;
    if((this.ToDouble()-k.ToDouble())==0)
    {
      test = true;
    }
      else test = false;
  }

  System.out.println(""+test);
}



public void toLowestTerms()
{
  gcd = super.GCD(this.num,this.den);
numdiv = this.num/gcd;
dendiv = this.den/gcd;

System.out.printf("%d/%d",numdiv,dendiv);
}







}
