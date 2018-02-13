public class proposito

{

public static void main(String[] args)

{
int[][] matriz  = {{2,2,2,2,2,2},{4,4,4,4,4,4}};


System.out.println(" "+suma(matriz,matriz.length-1,matriz[0].length-1, 0));
}

public static int suma(int[][] a, int b, int c, int sumatoria)
{
  sumatoria += a[b][c];

if(c==0 && b>0)
{
c=a[0].length-1;
return suma(a,b-1,c,sumatoria);
}

else if(c>0)
  return suma(a,b,c-1,sumatoria);

else if(b==0 && c==0)
  sumatoria+=0;

  return sumatoria;


// C:\Users\Juan Fco\Desktop\Programacion\Segundo semestre\Orientada a objetos>java proposito
// 36
}

}
