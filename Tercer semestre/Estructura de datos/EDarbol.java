/**
 *
 * @author Juan Fco
 */
public class EDarbol {
public static void main(String[] args)
{
    nodo raiz = new nodo(10);

    nodo.insertar(raiz, 5);
    nodo.insertar(raiz, 40);
    nodo.insertar(raiz, 1);
    nodo.insertar(raiz, 7);
    nodo.insertar(raiz, 50);

    System.out.println("Preorden:");
    nodo.preorden(raiz);
    System.out.println("");
    System.out.println("Inorden:");
    nodo.inorden(raiz);
    System.out.println("");
    System.out.println("Postorden");
    nodo.postorden(raiz);
    System.out.println("");
    System.out.println("Nivel");
    nodo.nivel(raiz);
    System.out.println("");
    System.out.println("Borrando '50'(Inorden)");
    nodo.borrar(50, raiz);
    nodo.inorden(raiz);
}
}
