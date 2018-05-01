import java.io.*;
import java.util.InputMismatchException;

public class DivisionEntreCeroConExc{

    public static int cociente(int numerador, int denominador) throws ArithmethicException,InputMismatchException{

        int resultado = numerador/denominador;
        return resultado;
    }

    public static void main(String[] args){
        cociente(1, 10);
        System.out.println("hola");
    }
}
