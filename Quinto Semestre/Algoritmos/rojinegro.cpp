#include <iostream>

using namespace std;

/* Init Struct */
template <class T>
struct node
{
        node<T> * parent;
        enum colour {RED, BLACK};
}
/*----------------Metodos de ayuda----------------- */
struct node * abuelo(struct node *n)
{
        if ((n != NULL) && (n->parent != NULL))
        {
                return n->parent->parent;
        }
        else return NULL;
}

struct node * tio(struct node *n)
{

        struct node *g;

        g = abuelo(n);

        if (g == NULL)
        {
                return NULL;
        }

        else if (n->parent == g->left)
        {
                return g->right;
        }
        else return g->left;
}

/*-----Casos de Inserción------- */
void insert_case1(struct node *n)
{
        if (n->parent == NULL) // Root node
        {
                n->colour = BLACK;
        }
        else
                insert_case2(n);
}

void case2(struct node *n)
{

        if (n->parent->colour == BLACK)
        {
                return;
        }
        else
        {
                insert_case3(n);
        }
}

void insert_case3(struct node *n)
{

        struct node *u, *g;
        u =  tio(n);
        g = abuelo(n);

        if ((u != NULL) && (u->colour == RED)) {
                n->parent->colour = BLACK;
                u->colour = BLACK;
                g->colour = RED;
                insert_case1(g);
        }

        else
        {
                insert_case4(n);
        }
}

void insert_case4(struct node *n)
{
        struct node *g = abuelo(n);

        if ((n == n->parent->right)
            && (n->parent == g->left))
        {
                rotate_left(n->parent);

                n = n->left;
        }

        else if ((n == n->parent->left) && (n->parent == g->right))
        {

                rotate_right(n->parent);
                n = n->right;
        }

        insert_case5(n);
}
