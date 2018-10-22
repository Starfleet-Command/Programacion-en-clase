public class Calculos
{

public Calculos()
{

}
public double Biseccion(double x0, double x1, double tolerance, int[][] formula,int iteraciones)
{

double fx0=Values(x0,formula);
double fx1=Values(x1,formula);
double midpoint,recursion;
int contador=0;
midpoint = (x0+x1)/2;
recursion =Values(midpoint,formula);

while (Math.abs(recursion)>tolerance || contador<iteraciones ) {
contador++;

if((fx0*fx1)<0)
{
 midpoint = (x0+x1)/2;
 recursion =Values(midpoint,formula);
  if(x0<x1)
  {
    if(recursion>0 && recursion<fx1)
    {
      x1=midpoint;
      fx1=recursion;
    }

    else if(recursion<0 && recursion<fx0)
    {
      x0=midpoint;
      fx0=recursion;
    }
  }
    else
    {

      if(recursion<0 && recursion>fx1)
      {
        x1=midpoint;
        fx1=recursion;
      }

      else if(recursion>0 && recursion<fx0)
      {
        x0=midpoint;
        fx0=recursion;
      }

    }
}
else
{
  System.out.println("You cannot do this method with the values provided. An interval cannot be formed. Values: "+fx0+ " "+fx1);
  break;
}
}

return midpoint;
}

public double FalsePos(double x0, double x1, double tolerance, int[][] formula,int iteraciones)
{
  double fx0=Values(x0,formula);
  double fx1=Values(x1,formula);
  double midpoint,recursion;
int contador=0;

if(x0<x1)
{
midpoint=  x1+((fx1*(x0-x1) )/(fx1-fx0));
}
else
{
midpoint=  x0+((fx0*(x1-x0) )/(fx0-fx1));
}
recursion =Values(midpoint,formula);
  while (Math.abs(recursion)>tolerance  || contador<iteraciones) {
    contador++;

  if((fx0*fx1)<0)
  {

    if(x0<x1)
    {
    midpoint=  x1+((fx1*(x0-x1) )/(fx1-fx0));
    }
    else
    {
    midpoint=  x0+((fx0*(x1-x0) )/(fx0-fx1));
    }

   recursion =Values(midpoint,formula);
    if(x0<x1)
    {
      if(recursion>0 && recursion<fx1)
      {
        x1=midpoint;
        fx1=recursion;
      }

      else if(recursion<0 && recursion<fx0)
      {
        x0=midpoint;
        fx0=recursion;
      }
    }
      else
      {

        if(recursion<0 && recursion>fx1)
        {
          x1=midpoint;
          fx1=recursion;
        }

        else if(recursion>0 && recursion<fx0)
        {
          x0=midpoint;
          fx0=recursion;
        }

      }
  }
  else
  {
    System.out.println("You cannot do this method with the values provided. An interval cannot be formed. Values: "+fx0+ " "+fx1);
    break;
  }
  }

  return midpoint;
}

public double Newton(double x0, double tolerance, int[][] formula, int iteraciones)
{
  int cont=0;
  double fx0=Values(x0,formula);
  double x1 = x0*.99;
  double fx1 = Values(x1, formula);

  double fdx0 = ((fx0-fx1)/(x0-x1));
  double x2 = x0 - (fx0/fdx0);
  double fx2= Values(x2,formula);
  
  while(Math.abs(fx2)<tolerance || cont<iteraciones )
{

   fx0=Values(x0,formula);
   x1 = x0*.99;
   fx1 = Values(x1, formula);

   fdx0 = ((fx0-fx1)/(x0-x1));
   x2 = x0 - (fx0/fdx0);
   fx2= Values(x2,formula);

   x0=x1;
   fx0=fx1;
   x1=x2;
   fx1=fx2;

  cont++;

}
  return x2;

}

public double Values(double x, int[][] formula)
{
  double result=0;
  for (int r=0;r<formula[0].length ;r++ )
  {
    result += Math.pow((formula[0][r]*x),formula[1][r]);
  }
  return result;
}

}
