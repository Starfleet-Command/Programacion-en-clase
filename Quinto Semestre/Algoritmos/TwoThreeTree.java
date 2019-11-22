import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;


public class TwoThreeTree<T extends Comparable<T> > implements Iterable<T> {
// a Node has 1 (2-Node) or 2 (3-Node) values
// and 2 or 3 children.  Values and children are stored
// in ArrayLists.  If there are children, that ArrayList
// has a null element at the end, so as to make easier the
// method which adds a new child.
class Node<T extends Comparable<T> > {
List<T> vals            = new ArrayList<T>();
List<Node<T> > children = new ArrayList<Node<T> >();

boolean isLeaf()
{
    return children.size() == 0;
}
boolean is4Node()
{
    return vals.size() == 3;
}

// new Nodes always are 2-nodes (1 value).  The node may be
// a leaf, or has 2 children.
Node(T x)
{
    vals.add(x);
}

Node(T x, Node<T> left, Node<T> right)
{
    vals.add(x);
    children.add(left);
    children.add(right);
    children.add(null);                     // hack
}

public String toString()
{
    String answer = "[";
    for (int i = 0; i < vals.size(); i++)
    {
        if (i != 0)
            answer += ", ";
        if (children.size() != 0)
            answer += children.get(i).toString();
        answer += vals.get(i);
    }
    if (children.size() != 0)
        answer += children.get(children.size() - 2).toString();
    return answer + "]";
}

// used in Iterator
void getVals(List<T> iteratorList)
{
    for (int i = 0; i < vals.size(); i++)
    {
        if (children.size() != 0)
            children.get(i).getVals(iteratorList);
        iteratorList.add(vals.get(i));
    }
    if (children.size() != 0)
        children.get(children.size() - 2).getVals(iteratorList);
}

// recursively adds a new value to a subtree
boolean add(T val)
{
    if (isLeaf())
        return addToLeaf(val);
    else
        return addToInterior(val);
}

// new values are always added to a leaf.  The result may be a 4-node leaf.
boolean addToLeaf(T x)
{
    int cmp;
    // size is 1 for a 2-node, or 2 for a 3-node
    for (int i = 0; i < vals.size(); i++)
    {
        cmp = x.compareTo(vals.get(i));
        if (cmp == 0)
            return false;
        else if (cmp < 0)
        {
            vals.add(i, x);
            return true;
        }
    }
    vals.add(x);
    return true;
}

// adds a value to a subtree rooted by an interior node.  If
// the addition results in one of the children being a 4-node,
// then adjustments are made.
boolean addToInterior(T x)
{
    int cmp;
    // size is 1 for a 2-node, or 2 for a 3-node
    for (int i = 0; i <= vals.size(); i++)
    {
        if (i == vals.size())
            cmp = -1;                                           // hack because there is no vals[2]
        else
            cmp = x.compareTo(vals.get(i));
        if (cmp == 0)
            return false;
        else if (cmp < 0)
        {
            boolean retVal = children.get(i).add(x);
            if (children.get(i).is4Node())
                childIs4Node(i);
            return retVal;
        }
    }
    return false;                      // unreachable  -- just for compiler
}

// the ith child is a 4-node
void childIs4Node(int i)
{
    Node<T> the4Node = children.get(i);
    // move the middle value from the 4-node child up
    // to its parent
    if (i == 2)
        vals.add(children.get(i).vals.get(1));
    else
        vals.add(i, children.get(i).vals.get(1));
    Node<T> newChild1, newChild2;
    if (children.get(i).isLeaf())
    {
        newChild1 = new Node<T>(children.get(i).vals.get(0));
        newChild2 = new Node<T>(children.get(i).vals.get(2));
    }
    else
    {
        newChild1 = new Node<T>(children.get(i).vals.get(0),
                                children.get(i).children.get(0),
                                children.get(i).children.get(1));
        newChild2 = new Node<T>(children.get(i).vals.get(2),
                                children.get(i).children.get(2),
                                children.get(i).children.get(3));
    }
    children.remove(the4Node);
    children.add(i, newChild2);
    children.add(i, newChild1);
}
}

Node<T> root;

public TwoThreeTree()
{
    root = null;
}

// TwoThreeTree add
public boolean add(T val)
{
    if (root == null)
    {
        root = new Node<T>(val);
        return true;
    }
    else
    {
        boolean isNew = root.add(val);
        // if root is a 4-node, split it
        if (root.vals.size() == 3)
        {
            Node<T> left, right;
            if (root.isLeaf())
            {
                left  = new Node<T>(root.vals.get(0));
                right = new Node<T>(root.vals.get(2));
            }
            else
            {
                left = new Node<T>(root.vals.get(0),
                                   root.children.get(0),
                                   root.children.get(1));
                right = new Node<T>(root.vals.get(2),
                                    root.children.get(2),
                                    root.children.get(3));
            }
            root = new Node<T>(root.vals.get(1), left, right);
        }
        return isNew;
    }
}

// this method creates a list containing all of the values in
// the tree and returns that list's iterator
public Iterator<T> iterator()
{
    List<T> vals = new ArrayList<T>();
    if (root != null)
        root.getVals(vals);
    return vals.iterator();
}

public void nodeDepth()
{
}

public void nodeHeight()
{
}

public void printAscending(TwoThreeTree<T> tree)
{
    for (T i : tree)
    {
        System.out.print(i + " ");
    }
    System.out.println("");
}

public void printDescending()
{
    Iterator  itr       = iterator();
    ArrayList backwards = new ArrayList();
    while (itr.hasNext())
    {
        backwards.add(itr.next());
    }
    for (int s = backwards.size() - 1; s > 0; s--)
    {
        System.out.print(backwards.get(s) + " ");
    }
    System.out.println("");
}

public Node<T> search(T key)
{
    int     i = 0;
    Node<T> notfound;
    while (i < root.vals.size())
    {
        if (root.vals.get(i) == key)
        {
            return root.vals.get(i);
        }
        else if (root.children.get(i) == key)
        {
            return root.children.get(i);
        }
        else
            return notfound;
    }
}

// test method
public static void main(String[] args)
{
    TwoThreeTree<Integer> set       = new TwoThreeTree<Integer>();
    ArrayList<Integer>    elementos = new ArrayList<Integer>();
    int                   size      = 100000;
    Random                rng       = new Random();

    for (int s = 0; s < size; s++)
    {
        Integer rand = rng.nextInt(size * 10) + 1;
        elementos.add(rand);
        set.add(rand);
    }
    //  set.printAscending(set);
    //  set.printDescending();

    long startTime = System.nanoTime();
    for (int k = 0; k < 10; k++)
    {
        Integer randSearch = rng.nextInt(elementos.size()) + 1;
        set.search(elementos.get(randSearch));
    }
    long endTime     = System.nanoTime();
    long timeElapsed = endTime - startTime;
    System.out.println("tiempo en milisegundos : " + timeElapsed / 1000000);
}
}
