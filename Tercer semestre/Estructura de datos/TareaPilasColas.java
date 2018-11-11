/**
 *
 * @author Juan Fco
 */
 import java.util.ArrayList;
public class TareaPilasColas
{
    public static void main(String[] args)
    {

    String evalua = "{(15+6)}";
    String evalua2 = "((3x+y})";
    String evalua3 = "(15";
    String evalua4 = "[[[((15+2))]]]";

    boolean eval1 = detecta(evalua);
    System.out.println("La string 1 regresa el siguiente resultado: "+eval1);

    boolean eval2 = detecta(evalua2);
    System.out.println("La string 2 regresa el siguiente resultado: "+eval2);

    boolean eval3 = detecta(evalua3);
    System.out.println("La string 3 regresa el siguiente resultado: "+eval3);

    boolean eval4 = detecta(evalua4);
    System.out.println("La string 4 regresa el siguiente resultado: "+eval4);
    }

    public static boolean detecta(String evaluar)
    {
        Pila p = new Pila();
        ArrayList<Integer> cont = new ArrayList<>();


        boolean flag = false;
        ArrayList<Character> simAb = new ArrayList<>();
    simAb.add('{');
    simAb.add('(');
    simAb.add('[');

    ArrayList<Character> simClose = new ArrayList<>();
    simClose.add('}');
    simClose.add(')');
    simClose.add(']');

    for(int e=0; e<evaluar.length();e++)
    {
        if(simAb.contains(evaluar.charAt(e)))
        {
            p.push(evaluar.charAt(e));
            cont.add(simAb.indexOf(evaluar.charAt(e)));

        }
        char eval = evaluar.charAt(e);
        char closing = simClose.get(cont.get(cont.size()-1) );
        if(Character.valueOf(eval).equals(closing) )
        {
            p.pop();
            cont.remove(cont.size()-1);
        }
    }

    if (p.esVacia()==true)
    {
        flag=true;
    }

    return flag;
    }


}
