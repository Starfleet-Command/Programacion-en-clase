#include <iostream>
#include <vector>
#include "D:\Boost\include\boost\graph\adjacency_list.hpp"
#include "D:/Boost/include/boost/graph/dijkstra_shortest_paths.hpp"
#include "D:/Boost/include/boost/graph/depth_first_search.hpp"
#include "D:/Boost/include/boost/graph/breadth_first_search.hpp"

using namespace boost

typedef adjacency_list<vecS, vecS, bidirectionalS> Graph;

class BoostGraph
{
public:

Graph init_graph()
{
        std::vector<int> vertices= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        Graph g(vertices.size());

        for(int k=0; k<vertices.size(); k++)
        {
                add_vertex(k+1,g);
        }

        add_edge(, ,g);
}
};

int main()
{



        return 0;
}
