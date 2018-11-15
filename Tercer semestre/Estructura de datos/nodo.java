import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Juan Fco
 */
public class nodo {
private int dato;
private nodo izquierdo;
private nodo derecho;

public nodo() {
	this.dato = -1;
	this.izquierdo = null;
	this.derecho = null;
}

public nodo(int dato) {
	this.dato = dato;
	this.izquierdo = null;
	this.derecho = null;
}

public nodo(int dato, nodo izquierdo, nodo derecho) {
	this.dato = dato;
	this.izquierdo = izquierdo;
	this.derecho = derecho;
}

public int getDato() {
	return dato;
}

public void setDato(int dato) {
	this.dato = dato;
}

public nodo getIzquierdo() {
	return izquierdo;
}

public void setIzquierdo(nodo izquierdo) {
	this.izquierdo = izquierdo;
}

public nodo getDerecho() {
	return derecho;
}

public void setDerecho(nodo derecho) {
	this.derecho = derecho;
}



public static nodo insertar(nodo n,int dato)
{
	if(n==null)
	{
		return new nodo(dato);
	}
	else if(n.getDato()>dato)
	{
		n.setIzquierdo(insertar(n.getIzquierdo(),dato));
	}
	else if(n.getDato()<dato)
	{
		n.setDerecho(insertar(n.getDerecho(),dato));
	}
	else if(n.getDato()==dato)
	{
		n.setDato(dato);
	}
	return n;
}


public static nodo buscar(nodo n, int dato)
{
	if(n==null)
	{
		return null;
	}

	else if(n.getDato()>dato)
	{
		return buscar(n.getIzquierdo(),dato);
	}

	else if(n.getDato()==dato)
	{
		return n;
	}
	return buscar(n.getDerecho(),dato);
}

public static void preorden(nodo n)
{
	if(n!=null)
	{
		System.out.print(n.getDato()+ " ");
		preorden(n.getIzquierdo());
		preorden(n.getDerecho());

	}
}

public static void inorden(nodo n)
{
	if(n!=null)
	{

		inorden(n.getIzquierdo());
		System.out.print(n.getDato()+ " ");
		inorden(n.getDerecho());

	}
}

public static void postorden(nodo n)
{
	if(n!=null)
	{
		postorden(n.getIzquierdo());
		postorden(n.getDerecho());
		System.out.print(n.getDato()+ " ");

	}
}

public static void nivel(nodo n)
{
	Queue<nodo> p = new LinkedList<>();
	nodo rec = new nodo();

	if(n!=null)
	{
		if(n.getIzquierdo()!=null)
		{
			p.add(n.getIzquierdo());
		}

		if(n.getDerecho()!=null)
		{
			p.add(n.getDerecho());
		}


		while (p.isEmpty()==false)
		{
			rec= p.peek();
			System.out.print(rec.getDato()+" ");
			p.remove();


		}

		nivel(n.getIzquierdo());
		nivel(n.getDerecho());





	}


}



public static nodo borrar(int borrar, nodo raiz)
{
	if(raiz==null)
	{
		return raiz;
	}

	if(borrar<raiz.getDato())
	{
		raiz.setIzquierdo(borrar(borrar,raiz.getIzquierdo()));
	}
	else if(borrar>raiz.getDato())
	{
		raiz.setDerecho(borrar(borrar,raiz.getDerecho()));
	}
	else
	{
		if(raiz.getIzquierdo()==null)
		{
			return raiz.getDerecho();
		}
		else if (raiz.getDerecho()==null)
		{
			return raiz.getIzquierdo();
		}
		raiz.setDato(raiz.getDerecho().getIzquierdo().getDato());
		raiz.setDerecho(borrar(raiz.getDato(),raiz.getDerecho()));
	}
	return raiz;
}

}
