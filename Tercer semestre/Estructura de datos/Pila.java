import java.util.Arrays;

/**
 *
 * @author Juan Fco
 */
public class Pila implements pilasycolas {
   private static final int superFinal = 0x64;
   private int tope;
   private Object[] elem;

   public Pila()
   {
      tope = superFinal;
      elem = new Object[superFinal];
   }

   @Override
   public boolean push(Object elemento)
   {
      if (tope == 0)
      {
         return false;
      }
      tope--;
      elem[tope] = elemento;
      return true;
   }

   @Override
   public boolean pop()
   {
      if (esVacia())
      {
         return false;
      }
      elem[tope] = null;
      tope++;
      return true;
   }

   @Override
   public Object top()
   {
      if (esVacia())
      {
         return null;
      }
      return elem[tope];
   }

   @Override
   public boolean vaciar()
   {
      tope = superFinal;
      elem = new Object[superFinal];
      return true;
   }

   @Override
   public boolean esVacia()
   {
      return tope == superFinal;
   }

   @Override
   public String toString()
   {
      return "Pila{" + "elem=" + Arrays.deepToString(elem) + '}';
   }
}
