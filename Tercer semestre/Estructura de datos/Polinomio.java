/**
 *
 * @author Juan Fco
 */
public class Polinomio {
    private int expon;
  private int coef;
  private Polinomio sig;

    public Polinomio(int expon, int coef) {
        this.expon = expon;
        this.coef = coef;
    }

    public int getExpon() {
        return expon;
    }

    public void setExpon(int expon) {
        this.expon = expon;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public Polinomio getSig() {
        return sig;
    }

    public void setSig(Polinomio sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Exponente=" + expon + ", Coeficiente=" + coef + ", Tiene siguiente=" +(sig == null ? "No" : "Si");
    }


}
