public class tareaPolinomio
{
public static void main(String[] args)
{
    Polinomio p1 = new Polinomio(2, 5);
    Polinomio p2 = new Polinomio(2, 3);
    Polinomio p3 = new Polinomio(3, 5);
    Polinomio p4 = new Polinomio(4, 2);

    p2.setSig(p3);
    p2.getSig().setSig(p4);

    Polinomio res = SumaPoli(p1, p2);
    printPolinomio(res);
}

public static Polinomio SumaPoli(Polinomio P, Polinomio Q)
{
    Polinomio R = null;

    if (Q == null)
    {
        return P;
    }
    else if (P == null)
    {
        return Q;
    }

    if (P.getExpon() < Q.getExpon())
    {
        R = P;

        R.setSig(SumaPoli(P.getSig(), Q));
    }

    else if (P.getExpon() > Q.getExpon())
    {
        R = Q;
        R.setSig(SumaPoli(P, Q.getSig()));
    }

    else if (P.getExpon() == Q.getExpon())
    {
        R = P;
        R.setCoef(P.getCoef() + Q.getCoef());
        R.setSig(SumaPoli(P.getSig(), Q.getSig()));
    }

    return R;
}

private static void printPolinomio(Polinomio per1)
{
    System.out.println("El resultado de la suma da:");
    System.out.println(per1.toString());

    while (per1.getSig() != null)
    {
        per1 = per1.getSig();
        System.out.println(per1);
    }
}
}
