# Chapter 28 Graphs and Applications

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1038

<details>
<summary>Page text</summary>

```text
GRAPHS AND
APPLICATIONS
Objectives
■ To model real-world problems using graphs and explain the Seven 
Bridges of Königsberg problem (§28.1).
■ To describe the graph terminologies: vertices, edges, simple graphs, 
weighted/unweighted graphs, and directed/undirected graphs (§28.2).
■ To represent vertices and edges using lists, edge arrays, edge objects, 
adjacency matrices, and adjacency lists (§28.3).
■ To model graphs using the Graph interface, the AbstractGraph
class, and the UnweightedGraph class (§28.4).
■ To display graphs visually (§28.5).
■ To represent the traversal of a graph using the AbstractGraph.Tree
class (§28.6).
■ To design and implement depth-first search (§28.7).
■ To solve the connected-circle problem using depth-first search (§28.8).
■ To design and implement breadth-first search (§28.9).
■ To solve the nine-tail problem using breadth-first search (§28.10).
CHAPTER
28
```

</details>


## PDF page 1039

<details>
<summary>Page text</summary>

```text
1016 Chapter 28  Graphs and Applications
28.1 Introduction
Many real-world problems can be solved using graph algorithms.
Graphs are useful in modeling and solving real-world problems. For example, the problem 
to find the least number of flights between two cities can be modeled using a graph, where 
the vertices represent cities and the edges represent the flights between two adjacent cities, 
as shown in Figure 28.1. The problem of finding the minimal number of connecting flights 
between two cities is reduced to finding a shortest path between two vertices in a graph.
Key
Pointproblem
FIGURE 28.1 A graph can be used to model the flights between the cities.
Seattle (0)
San Francisco (1)
Los Angeles (2)
Dallas (10)
Houston (11)
Atlanta (8)
New York (7)
Boston (6)
Chicago (5)
Denver (3)
Kansas City (4)
Miami (9)
FIGURE 28.2 Seven bridges connected islands and land.
A
C
B
D
(b) Graph model (a) Seven bridges sketch
D
A
B
Island 2
Island 1
C
The study of graph problems is known as graph theory. Graph theory was founded by 
Leonhard Euler in 1736, when he introduced graph terminology to solve the famous Seven
Bridges of Königsberg problem. The city of Königsberg, Prussia (now Kaliningrad, Russia), 
was divided by the Pregel River. There were two islands on the river. The city and islands 
were connected by seven bridges, as shown in Figure 28.2a. The question is, can one take a 
walk, cross each bridge exactly once, and return to the starting point? Euler proved that it is 
not possible.
graph theory
Seven Bridges of Königsberg
To establish a proof, Euler first abstracted the Königsberg city map by eliminating all 
streets, producing the sketch shown in Figure 28.2a. Next, he replaced each land mass with
```

</details>


## PDF page 1040

<details>
<summary>Page text</summary>

```text
28.2 Basic Graph Terminologies  1017
a dot, called a vertex or a node, and each bridge with a line, called an edge, as shown in 
Figure 28.2b. This structure with vertices and edges is called a graph.
Looking at the graph, we ask whether there is a path starting from any vertex, traversing 
all edges exactly once, and returning to the starting vertex. Euler proved that for such a path 
to exist, each vertex must have an even number of edges. Therefore, the Seven Bridges of 
Königsberg problem has no solution.
Graph problems are often solved using algorithms. Graph algorithms have many appli-
cations in various areas, such as in computer science, mathematics, biology, engineering, 
economics, genetics, and social sciences. This chapter presents the algorithms for depth-first 
search and breadth-first search, and their applications. The next chapter presents the algo-
rithms for finding a minimum spanning tree and shortest paths in weighted graphs, and their 
applications.
28.2 Basic Graph Terminologies
A graph consists of vertices, and edges that connect the vertices.
This chapter does not assume that you have any prior knowledge of graph theory or discrete 
mathematics. We use plain and simple terms to define graphs.
What is a graph? A graph is a mathematical structure that represents relationships among 
entities in the real world. For example, the graph in Figure 28.1 represents the flights among 
cities, and the graph in Figure 28.2b represents the bridges among land masses.
A graph consists of a nonempty set of vertices (also known as nodes or points), and a set of 
edges that connect the vertices. For convenience, we define a graph as G = (V, E), where V 
represents a set of vertices and E represents a set of edges. For example, V and E for the graph 
in Figure 28.1 are as follows:
V = {"Seattle", "San Francisco", "Los Angeles",
"Denver", "Kansas City", "Chicago", "Boston", "New York",
"Atlanta", "Miami", "Dallas", "Houston"};
E = {{"Seattle", "San Francisco"},{"Seattle", "Chicago"},
     {"Seattle", "Denver"}, {"San Francisco", "Denver"},
       ...
    };
A graph may be directed or undirected. In a directed graph, each edge has a direction, which 
indicates that you can move from one vertex to the other through the edge. You can model 
parent/child relationships using a directed graph, where an edge from vertex A to B indicates 
that A is a parent of B. Figure 28.3a shows a directed graph.
Key
Point
what is a graph?
define a graph
directed vs. undirected graphs
FIGURE 28.3 Graphs may appear in many forms.
(a) A directed graph
Peter (0)
Cindy (3)
Wendy (4)
Jane (1)
Mark (2)
(b) A complete graph 
A
B
C
E
D
(c) A subgraph of the graph in (b)
A
B
C
E
D
In an undirected graph, you can move in both directions between vertices. The graph in 
Figure 28.1 is undirected.
```

</details>


## PDF page 1041

<details>
<summary>Page text</summary>

```text
1018 Chapter 28  Graphs and Applications
Edges may be weighted or unweighted. For example, you can assign a weight for each edge 
in the graph in Figure 28.1 to indicate the flight time between the two cities.
Two vertices in a graph are said to be adjacent if they are connected by the same edge. 
Similarly, two edges are said to be adjacent if they are connected to the same vertex. An edge 
in a graph that joins two vertices is said to be incident to both vertices. The degree of a vertex 
is the number of edges incident to it.
Two vertices are called neighbors if they are adjacent. Similarly, two edges are called 
neighbors if they are adjacent.
A loop is an edge that links a vertex to itself. If two vertices are connected by two or more 
edges, these edges are called parallel edges. A simple graph is one that has doesn’t have any 
loops or parallel edges. In a complete graph, every two pairs of vertices are connected, as 
shown in Figure 28.3b.
A graph is connected if there exists a path between any two vertices in the graph. A 
subgraph of a graph G is a graph whose vertex set is a subset of that of G and whose edge set 
is a subset of that of G. For example, the graph in Figure 28.3c is a subgraph of the graph in 
Figure 28.3b.
Assume that the graph is connected and undirected. A cycle is a closed path that starts from 
a vertex and ends at the same vertex. A connected graph is a tree if it does not have cycles. 
A spanning tree of a graph G is a connected subgraph of G and the subgraph is a tree that 
contains all vertices in G.
Pedagogical Note
Before we introduce graph algorithms and applications, it is helpful to get acquainted with 
graphs using the interactive tool at www.cs.armstrong.edu/liang/animation/GraphLearningTool
.html, as shown in Figure 28.4. The tool allows you to add/remove/move vertices and 
draw edges using mouse gestures. You can also find depth-first search (DFS) trees and 
breadth-first search (BFS) trees, and a shortest path between two vertices.
weighted vs. unweighted 
graphs
adjacent vertices
incident edges
degree
neighbor
loop
parallel edge
simple graph
complete graph
connected graph
subgraph
cycle
tree
spanning tree
graph learning tool on 
Companion Website
FIGURE 28.4 You can use the tool to create a graph with mouse gestures and show DFS/BFS trees and shortest paths.
```

</details>


## PDF page 1042

<details>
<summary>Page text</summary>

```text
28.3 Representing Graphs  1019
28.1 What is the famous Seven Bridges of Königsberg problem?
28.2 What is a graph? Explain the following terms: undirected graph, directed graph, 
weighted graph, degree of a vertex, parallel edge, simple graph, complete graph, 
connected graph, cycle, subgraph, tree, and spanning tree.
28.3 How many edges are in a complete graph with 5 vertices? How many edges are in a 
tree of 5 vertices?
28.4 How many edges are in a complete graph with n vertices? How many edges are in a 
tree of n vertices?
28.3 Representing Graphs
Representing a graph is to store its vertices and edges in a program. The data 
structure for storing a graph is arrays or lists.
To write a program that processes and manipulates graphs, you have to store or represent data 
for the graphs in the computer.
28.3.1 Representing Vertices
The vertices can be stored in an array or a list. For example, you can store all the city names 
in the graph in Figure 28.1 using the following array:
String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
"Denver", "Kansas City", "Chicago", "Boston", "New York",
"Atlanta", "Miami", "Dallas", "Houston"};
Note
The vertices can be objects of any type. For example, you can consider cities as objects 
that contain the information such as its name, population, and mayor. Thus, you may 
define vertices as follows:
City city0 = new City("Seattle", 608660, "Mike McGinn");
...
City city11 = new City("Houston", 2099451, "Annise Parker");
City[] vertices = {city0, city1, ... , city11};
public class City {
private String cityName;
private int population;
private String mayor;
public City(String cityName, int population, String mayor) {
this.cityName = cityName;
this.population = population;
this.mayor = mayor;
  }
public String getCityName() {
return cityName;
  }
public int getPopulation() {
return population;
  }
✓Point✓
Check
Key
Point
vertex type
```

</details>


## PDF page 1043

<details>
<summary>Page text</summary>

```text
1020 Chapter 28  Graphs and Applications
public String getMayor() {
return mayor;
  }
public void setMayor(String mayor) {
this.mayor = mayor; 
  }
public void setPopulation(int population) {
this.population = population; 
  }
}
The vertices can be conveniently labeled using natural numbers 0, 1, 2, c, n - 1, for a 
graph for n vertices. Thus, vertices[0] represents "Seattle",vertices[1] represents 
"San Francisco", and so on, as shown in Figure 28.5.
FIGURE 28.5 An array stores the vertex names.
Seattle
San Francisco
Los Angeles
Dallas
Houston
Atlanta
New York
Boston
Chicago
Denver
Kansas City
Miami
vertices[0]
vertices[1]
vertices[2]
vertices[3]
vertices[4]
vertices[5]
vertices[6]
vertices[7]
vertices[8]
vertices[9]
vertices[10]
vertices[11]
Note
You can reference a vertex by its name or its index, whichever is more convenient. Obvi-
ously, it is easy to access a vertex via its index in a program.
28.3.2 Representing Edges: Edge Array
The edges can be represented using a two-dimensional array. For example, you can store all 
the edges in the graph in Figure 28.1 using the following array:
int[][] edges = {
  {0, 1}, {0, 3}, {0, 5},
  {1, 0}, {1, 2}, {1, 3},
  {2, 1}, {2, 3}, {2, 4}, {2, 10},
  {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
  {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
  {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
reference vertex
```

</details>


## PDF page 1044

<details>
<summary>Page text</summary>

```text
28.3 Representing Graphs  1021
  {6, 5}, {6, 7},
  {7, 4}, {7, 5}, {7, 6}, {7, 8},
  {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
  {9, 8}, {9, 11},
  {10, 2}, {10, 4}, {10, 8}, {10, 11},
  {11, 8}, {11, 9}, {11, 10}
 };
This representation is known as the edge array. The vertices and edges in Figure 28.3a can be 
represented as follows:
      String[] names = {"Peter", "Jane", "Mark", "Cindy", "Wendy"};
      int[][] edges = {{0, 2}, {1, 2}, {2, 4}, {3, 4}};
28.3.3 Representing Edges: Edge Objects
Another way to represent the edges is to define edges as objects and store the edges in a 
java.util.ArrayList. The Edge class can be defined as follows:
public class Edge {
int u;
int v;
public Edge(int u, int v) {
this.u = u;
this.v = v;
    }
public boolean equals(Object o) {
return u == ((Edge)o).u && v == ((Edge)o).v; 
    }
  }
For example, you can store all the edges in the graph in Figure 28.1 using the following list:
java.util.ArrayList<Edge> list = new java.util.ArrayList<>();
list.add(new Edge(0, 1));
list.add(new Edge(0, 3));
list.add(new Edge(0, 5));
...
StoringEdge objects in an ArrayList is useful if you don’t know the edges in advance.
While representing edges using an edge array or Edge objects in Section 28.3.2 and earlier 
in this section may be intuitive for input, it’s not efficient for internal processing. The next two 
sections introduce the representation of graphs using adjacency matrices and adjacency lists.
These two data structures are efficient for processing graphs.
28.3.4 Representing Edges: Adjacency Matrices
Assume that the graph has n vertices. You can use a two-dimensional n * n matrix, 
say adjacencyMatrix, to represent the edges. Each element in the array is 0 or 1.
adjacencyMatrix[i][j] is 1 if there is an edge from vertex i to vertex j; otherwise, 
adjacencyMatrix[i][j] is 0. If the graph is undirected, the matrix is symmetric, because 
adjacencyMatrix[i][j] is the same as adjacencyMatrix[j][i]. For example, the 
edges in the graph in Figure 28.1 can be represented using an adjacency matrix as follows:
int[][] adjacencyMatrix = {
  {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // Seattle
  {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // San Francisco
edge array
adjacency matrix
```

</details>


## PDF page 1045

<details>
<summary>Page text</summary>

```text
1022 Chapter 28  Graphs and Applications
  {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, // Los Angeles
  {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, // Denver
  {0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0}, // Kansas City
  {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}, // Chicago
  {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // Boston
  {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0}, // New York
  {0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1}, // Atlanta
  {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // Miami
  {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1}, // Dallas
  {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0} // Houston
};
Note
Since the matrix is symmetric for an undirected graph, to save storage you can use a 
ragged array.
The adjacency matrix for the directed graph in Figure 28.3a can be represented as follows:
int[][] a = {{0, 0, 1, 0, 0}, // Peter
             {0, 0, 1, 0, 0}, // Jane
             {0, 0, 0, 0, 1}, // Mark
             {0, 0, 0, 0, 1}, // Cindy
             {0, 0, 0, 0, 0} // Wendy
            };
28.3.5 Representing Edges: Adjacency Lists
You can represent edges using adjacency vertex lists or adjacency edge lists. An adjacency 
vertex list for a vertex i contains the vertices that are adjacent to i and an adjacency edge list 
for a vertex i contains the edges that are adjacent to i. You may define an array of lists. The 
array has n entries, and each entry is a list. The adjacency vertex list for vertex i contains all 
the vertices j such that there is an edge from vertex i to vertex j. For example, to represent the 
edges in the graph in Figure 28.1, you can create an array of lists as follows:
java.util.List<Integer>[] neighbors = new java.util.List[12];
neighbors[0] contains all vertices adjacent to vertex 0 (i.e., Seattle), neighbors[1] con-
tains all vertices adjacent to vertex 1 (i.e., San Francisco), and so on, as shown in Figure 28.6.
To represent the adjacency edge lists for the graph in Figure 28.1, you can create an array 
of lists as follows:
java.util.List<Edge>[] neighbors = new java.util.List[12];
neighbors[0] contains all edges adjacent to vertex 0 (i.e., Seattle), neighbors[1] con-
tains all edges adjacent to vertex 1 (i.e., San Francisco), and so on, as shown in Figure 28.7.
Note
You can represent a graph using an adjacency matrix or adjacency lists. Which one is 
better? If the graph is dense (i.e., there are a lot of edges), using an adjacency matrix is 
preferred. If the graph is very sparse (i.e., very few edges), using adjacency lists is better, 
because using an adjacency matrix would waste a lot of space.
Both adjacency matrices and adjacency lists can be used in a program to make algo-
rithms more efficient. For example, it takes O(1) constant time to check whether two 
vertices are connected using an adjacency matrix, and it takes linear time O(m) to print 
all edges in a graph using adjacency lists, where m is the number of edges.
ragged array
adjacency vertex lists
adjacency edge lists
adjacency matrices vs. 
adjacency lists
```

</details>


## PDF page 1046

<details>
<summary>Page text</summary>

```text
28.3 Representing Graphs  1023
Note
Adjacency vertex list is simpler for representing unweighted graphs. However, adjacency 
edge lists are more flexible for a wide range of graph applications. It is easy to add addi-
tional constraints on edges using adjacency edge lists. For this reason, this book will use 
adjacency edge lists to represent graphs.
You can use arrays, array lists, or linked lists to store adjacency lists. We will use lists 
instead of arrays, because the lists are easily expandable to enable you to add new vertices. 
Further we will use array lists instead of linked lists, because our algorithms only require 
searching for adjacent vertices in the list. Using array lists is more efficient for our algorithms. 
Using array lists, the adjacency edge list in Figure 28.6 can be built as follows:
List<ArrayList<Edge>> neighbors = new ArrayList<>();
neighbors.add(new ArrayList<Edge>());
neighbors.get(0).add(new Edge(0, 1));
adjacency vertex list vs. 
adjacency edge lists
using ArrayList
FIGURE 28.6 Edges in the graph in Figure 28.1 are represented using adjacency vertex lists.
1
0
0
1
2
0
5
4
4
8
2
8
Seattle
San Francisco
Los Angeles
Dallas
Houston
Atlanta
New York
Boston
Chicago
Denver
Kansas City
Miami
neighbors[0]
neighbors[1]
neighbors[2]
neighbors[3]
neighbors[4]
neighbors[5]
neighbors[6]
neighbors[7]
neighbors[8]
neighbors[9]
neighbors[10]
neighbors[11]
5
3
2
4
5
4
6
9
8
10
3
2
1
3
3
3
7
5
7
11
4
9
4
10
7
6
8
10
11
5
8
7
11
10
FIGURE 28.7 Edges in the graph in Figure 28.1 are represented using adjacency edge lists.
Edge(0, 1) Edge(0, 3) Edge(0, 5)
Edge(1, 0) Edge(1, 2) Edge(1, 3)
Edge(2, 1) Edge(2, 3) Edge(2, 4) Edge(2, 10)
Edge(3, 0) Edge(3, 1) Edge(3, 2) Edge(3, 4) Edge(3, 5)
Edge(4, 2) Edge(4, 3) Edge(4, 5) Edge(4, 7) Edge(4, 8) Edge(4, 10)
Edge(5, 0) Edge(5, 3) Edge(5, 4) Edge(5, 6) Edge(5, 7)
Edge(6, 5) Edge(6, 7)
Edge(7, 4) Edge(7, 5) Edge(7, 6) Edge(7, 8)
Edge(8, 4) Edge(8, 7) Edge(8, 9) Edge(8, 10) Edge(8, 11)
Edge(9, 8) Edge(9, 11)
Edge(10, 2) Edge(10, 4) Edge(10, 8) Edge(10, 11)
Edge(11, 8) Edge(11, 9) Edge(11, 10)
neighbors[0]
neighbors[1]
neighbors[2]
neighbors[3]
neighbors[4]
neighbors[5]
neighbors[6]
neighbors[7]
neighbors[8]
neighbors[9]
neighbors[10]
neighbors[11]
Seattle
San Francisco
Los Angeles
Denver
Kansas City
Chicago
Boston
New York
Atlanta
Miami
Dallas
Houston
```

</details>


## PDF page 1047

<details>
<summary>Page text</summary>

```text
1024 Chapter 28  Graphs and Applications
neighbors.get(0).add(new Edge(0, 3));
neighbors.get(0).add(new Edge(0, 5));
neighbors.add(new ArrayList<Edge>());
neighbors.get(1).add(new Edge(1, 0));
neighbors.get(1).add(new Edge(1, 2));
neighbors.get(1).add(new Edge(1, 3));
...
...
neighbors.get(11).add(new Edge(11, 8));
neighbors.get(11).add(new Edge(11, 9));
neighbors.get(11).add(new Edge(11, 10));
28.5 How do you represent vertices in a graph? How do you represent edges using an edge 
array? How do you represent an edge using an edge object? How do you represent 
edges using an adjacency matrix? How do you represent edges using adjacency lists?
28.6 Represent the following graph using an edge array, a list of edge objects, an adja-
cency matrix, an adjacency vertex list, and an adjacency edge list, respectively.
✓Point✓
Check
1
0
2
3
4
5
FIGURE 28.8 Graphs can be modeled using interfaces, abstract classes, and concrete classes.
Graph AbstractGraph
WeightedGraph
Concrete ClassesAbstract ClassInterface
UnweightedGraph
28.4 Modeling Graphs
TheGraph interface defines the common operations for a graph.
The Java Collections Framework serves as a good example for designing complex data struc-
tures. The common features of data structures are defined in the interfaces (e.g., Collection,
Set, List, Queue), as shown in Figure 20.1. Abstract classes (e.g., AbstractCollection,
AbstractSet, AbstractList) partially implement the interfaces. Concrete classes (e.g., 
HashSet,LinkedHashSet,TreeSet,ArrayList,LinkedList,PriorityQueue) provide 
concrete implementations. This design pattern is useful for modeling graphs. We will define an 
interface named Graph that contains all the common operations of graphs and an abstract class 
namedAbstractGraph that partially implements the Graph interface. Many concrete graphs can 
be added to the design. For example, we will define such graphs named UnweightedGraph and 
WeightedGraph. The relationships of these interfaces and classes are illustrated in Figure 28.8.
Key
Point
What are the common operations for a graph? In general, you need to get the number of 
vertices in a graph, get all vertices in a graph, get the vertex object with a specified index, get 
the index of the vertex with a specified name, get the neighbors for a vertex, get the degree for 
a vertex, clear the graph, add a new vertex, add a new edge, perform a depth-first search, and
```

</details>


## PDF page 1048

<details>
<summary>Page text</summary>

```text
28.4 Modeling Graphs  1025
perform a breadth-first search. Depth-first search and breadth-first search will be introduced 
in the next section. Figure 28.9 illustrates these methods in the UML diagram.
AbstractGraph does not introduce any new methods. A list of vertices and an edge adja-
cency list are defined in the AbstractGraph class. With these data fields, it is sufficient to 
FIGURE 28.9 TheGraph interface defines the common operations for all types of graphs.
UnweightedGraph<V>
+getSize(): int
+getVertices(): List<V>
+getVertex(index: int): V
+getIndex(v: V): int
+getNeighbors(index: int): List<Integer>
+getDegree(index: int): int
+printEdges(): void
+clear(): void
+addVertex(v, V): boolean
+addEdge(u: int, v: int): boolean
+dfs(v: int): AbstractGraph<V>.Tree
+bfs(v: int): AbstractGraph<V>.Tree
Returns the number of vertices in the graph.
Returns the vertices in the graph.
Returns the vertex object for the specified vertex index.
Returns the index for the specified vertex.
Returns the neighbors of vertex with the specified index.
Returns the degree for a specified vertex index.
Prints the edges.
Clears the graph.
Returns true if v is added to the graph. Returns false if v
     is already in the graph.
Adds an edge from u to v to the graph throws
IllegalArgumentException if u or v is invalid. Returns true
     if the edge is added and false if (u, v) is already in the graph.
Obtains a depth-first search tree starting from v.
Obtains a breadth-first search tree starting from v.
«interface»
Graph<V>
#vertices: List<V>
#neighbors: List<List<Edge>>
+UnweightedGraph()
+UnweightedGraph(vertices: V[], edges:
   int[][])
+UnweightedGraph(vertices: List<V>,
   edges: List<Edge>)
+UnweightedGraph(edges: List<Edge>,
   numberOfVertices: int)
+UnweightedGraph(edges: int[][],
   numberOfVertices: int)
AbstractGraph<V>
Vertices in the graph.
Neighbors for each vertex in the graph.
Constructs an empty graph.
Constructs a graph with the specified edges and vertices
     stored in arrays.
Constructs a graph with the specified edges and vertices
     stored in lists.
Constructs a graph with the specified edges in an array
     and the integer vertices 1, 2, ....
Constructs a graph with the specified edges in a list and
     the integer vertices 1, 2, ….
Adds an edge into the adjacency edge list.
Constructs an empty unweighted graph.
Constructs a graph with the specified edges and vertices
     in arrays.
Constructs a graph with the specified edges and vertices
     stored in lists.
Constructs a graph with the specified edges in an array
     and the integer vertices 1, 2, ....
Constructs a graph with the specified edges in a list and
     the integer vertices 1, 2, ….
The generic typeV is the type for vertices.
#AbstractGraph()
#AbstractGraph(vertices: V[], edges:
   int[][])
#AbstractGraph(vertices: List<V>, edges:
   List<Edge>)
#AbstractGraph(edges: int[][],
   numberOfVertices: int)
#AbstractGraph(edges: List<Edge>,
   numberOfVertices: int)
+addEdge(e: Edge): boolean
Inner classes Tree is defined here
```

</details>


## PDF page 1049

<details>
<summary>Page text</summary>

```text
1026 Chapter 28  Graphs and Applications
implement all the methods defined in the Graph interface. For convenience, we assume the 
graph is a simple graph, i.e., a vertex has no edge to itself and there are no parallel edges from 
vertex u to v.
AbstractGraph implements all the methods from Graph, and it does not introduce any 
new methods except a convenient addEdge(edge) method that adds an Edge object to the 
adjacency edge list. UnweightedGraph simply extends AbstractGraph with five construc-
tors for creating the concrete Graph instances.
Note
You can create a graph with any type of vertices. Each vertex is associated with an index, 
which is the same as the index of the vertex in the vertices list. If you create a graph 
without specifying the vertices, the vertices are the same as their indices.
Note
The AbstractGraph class implements all the methods in the Graph interface. So 
why is it defined as abstract? In the future, you may need to add new methods to 
the Graph interface that cannot be implemented in AbstractGraph. To make the 
classes easy to maintain, it is desirable to define the AbstractGraph class as abstract.
Assume all these interfaces and classes are available. Listing 28.1 gives a test program that 
creates the graph in Figure 28.1 and another graph for the one in Figure 28.3a.
LISTING 28.1 TestGraph.java
 1 public class TestGraph {
 2 public static void main(String[] args) {
 3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
 4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
 5 "Atlanta", "Miami", "Dallas", "Houston"};
 6
 7 // Edge array for graph in Figure 28.1
 8 int[][] edges = {
 9        {0, 1}, {0, 3}, {0, 5},
10        {1, 0}, {1, 2}, {1, 3},
11        {2, 1}, {2, 3}, {2, 4}, {2, 10},
12        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
13        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
14        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
15        {6, 5}, {6, 7},
16        {7, 4}, {7, 5}, {7, 6}, {7, 8},
17        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
18        {9, 8}, {9, 11},
19        {10, 2}, {10, 4}, {10, 8}, {10, 11},
20        {11, 8}, {11, 9}, {11, 10}
21      };
22
23 Graph<String> graph1 = new UnweightedGraph<>(vertices, edges);
24      System.out.println("The number of vertices in graph1: "
25        + graph1.getSize());
26      System.out.println("The vertex with index 1 is "
27        + graph1.getVertex(1));
28      System.out.println("The index for Miami is " + 
29 graph1.getIndex( "Miami"));
30      System.out.println("The edges for graph1:");
31 graph1.printEdges();
32
33 // List of Edge objects for graph in Figure 28.3a
34      String[] names = {"Peter", "Jane", "Mark", "Cindy", "Wendy"};
vertices and their indices
whyAbstractGraph?
vertices
edges
create a graph
number of vertices
get vertex
get index
print edges
```

</details>


## PDF page 1050

<details>
<summary>Page text</summary>

```text
28.4 Modeling Graphs  1027
35      java.util.ArrayList<AbstractGraph.Edge> edgeList
36        = new java.util.ArrayList<>();
37      edgeList.add(new AbstractGraph.Edge(0, 2));
38      edgeList.add(new AbstractGraph.Edge(1, 2));
39      edgeList.add(new AbstractGraph.Edge(2, 4));
40      edgeList.add(new AbstractGraph.Edge(3, 4));
41 // Create a graph with 5 vertices
42 Graph<String> graph2 = new UnweightedGraph<>
43 (java.util.Arrays.asList(names), edgeList);
44      System.out.println("\nThe number of vertices in graph2: "
45        + graph2.getSize());
46      System.out.println("The edges for graph2:");
47      graph2.printEdges();
48    }
49  }
list of Edge objects
create a graph
print edges
The number of vertices in graph1: 12
The vertex with index 1 is San Francisco
The index for Miami is 9
The edges for graph1:
Seattle (0): (0, 1) (0, 3) (0, 5) 
San Francisco (1): (1, 0) (1, 2) (1, 3) 
Los Angeles (2): (2, 1) (2, 3) (2, 4) (2, 10) 
Denver (3): (3, 0) (3, 1) (3, 2) (3, 4) (3, 5) 
Kansas City (4): (4, 2) (4, 3) (4, 5) (4, 7) (4, 8) (4, 10) 
Chicago (5): (5, 0) (5, 3) (5, 4) (5, 6) (5, 7) 
Boston (6): (6, 5) (6, 7) 
New York (7): (7, 4) (7, 5) (7, 6) (7, 8) 
Atlanta (8): (8, 4) (8, 7) (8, 9) (8, 10) (8, 11) 
Miami (9): (9, 8) (9, 11) 
Dallas (10): (10, 2) (10, 4) (10, 8) (10, 11) 
Houston (11): (11, 8) (11, 9) (11, 10) 
The number of vertices in graph2: 5
The edges for graph2:
Peter (0): (0, 2) 
Jane (1): (1, 2) 
Mark (2): (2, 4) 
Cindy (3): (3, 4) 
Wendy (4):
The program creates graph1 for the graph in Figure 28.1 in lines 3–23. The vertices for graph1
are defined in lines 3–5. The edges for graph1 are defined in 8–21. The edges are represented 
using a two-dimensional array. For each row i in the array, edges[i][0] and edges[i][1]
indicate that there is an edge from vertex edges[i][0] to vertex edges[i][1]. For exam-
ple, the first row, { 0, 1}, represents the edge from vertex 0 (edges[0][0]) to vertex 1
(edges[0][1]). The row {0,5} represents the edge from vertex 0 (edges[2][0]) to ver-
tex5 (edges[2][1]). The graph is created in line 23. Line 31 invokes the printEdges()
method on graph1 to display all edges in graph1.
The program creates graph2 for the graph in Figure 28.3a in lines 34–43. The edges 
for graph2 are defined in lines 37–40. graph2 is created using a list of Edge objects in 
line 43. Line 47 invokes the printEdges()  method on graph2 to display all edges in 
graph2.
Note that both graph1 and graph2 contain the vertices of strings. The vertices are asso-
ciated with indices 0,1, . . . , n-1. The index is the location of the vertex in vertices. For 
example, the index of vertex Miami is 9.
```

</details>


## PDF page 1051

<details>
<summary>Page text</summary>

```text
1028 Chapter 28  Graphs and Applications
Now we turn our attention to implementing the interface and classes. Listings 28.2, 28.3, 
and 28.4 give the Graph interface, the AbstractGraph class, and the UnweightedGraph
class, respectively.
LISTING 28.2 Graph.java
 1 public interface Graph<V> {
 2 /** Return the number of vertices in the graph */
 3 public int getSize();
 4
 5 /** Return the vertices in the graph */
 6 public java.util.List<V> getVertices();
 7
 8 /** Return the object for the specified vertex index */
 9 public V getVertex(int index); 
10
11 /** Return the index for the specified vertex object */
12 public int getIndex(V v); 
13
14 /** Return the neighbors of vertex with the specified index */
15 public java.util.List<Integer> getNeighbors(int index); 
16
17 /** Return the degree for a specified vertex */
18 public int getDegree(int v); 
19
20 /** Print the edges */
21 public void printEdges();
22
23 /** Clear the graph */
24 public void clear();
25
26 /** Add a vertex to the graph */
27 public void addVertex(V vertex); 
28
29 /** Add an edge to the graph */
30 public void addEdge(int u, int v); 
31
32 /** Obtain a depth-first search tree starting from v */
33 public AbstractGraph<V>.Tree dfs(int v); 
34
35 /** Obtain a breadth-first search tree starting from v */
36 public AbstractGraph<V>.Tree bfs(int v); 
37  }
LISTING 28.3 AbstractGraph.java
  1 import java.util.*;
  2
  3 public abstract class AbstractGraph<V> implements Graph<V> {
  4 protected List<V> vertices = new ArrayList<>(); // Store vertices
  5 protected List<List<Edge>> neighbors 
  6      = new ArrayList<>(); // Adjacency lists
  7
  8 /** Construct an empty graph */
  9 protected AbstractGraph() {
 10    }
 11
 12 /** Construct a graph from vertices and edges stored in arrays */
 13 protected AbstractGraph(V[] vertices, int[][] edges) {
getSize
getVertices
getVertex
getIndex
getNeighbors
getDegree
printEdges
clear
addVertex
addEdge
dfs
bfs
no-arg constructor
constructor
```

</details>


## PDF page 1052

<details>
<summary>Page text</summary>

```text
28.4 Modeling Graphs  1029
 14 for (int i = 0; i < vertices.length; i++)
 15        addVertex(vertices[i]);
 16
 17      createAdjacencyLists(edges, vertices.length);
 18    }
 19
 20 /** Construct a graph from vertices and edges stored in List */
 21 protected AbstractGraph(List<V> vertices, List<Edge> edges) {
 22 for (int i = 0; i < vertices.size(); i++)
 23        addVertex(vertices.get(i));
 24
 25      createAdjacencyLists(edges, vertices.size());
 26    }
 27
 28 /** Construct a graph for integer vertices 0, 1, 2 and edge list */
 29 protected AbstractGraph(List<Edge> edges, int numberOfVertices) {
 30 for (int i = 0; i < numberOfVertices; i++) 
 31        addVertex((V)(new Integer(i))); // vertices is {0, 1, ...}
 32
 33      createAdjacencyLists(edges, numberOfVertices);
 34    }
 35
 36 /** Construct a graph from integer vertices 0, 1, and edge array */
 37 protected AbstractGraph(int[][] edges, int numberOfVertices) {
 38 for (int i = 0; i < numberOfVertices; i++) 
 39        addVertex((V)(new Integer(i))); // vertices is {0, 1, ...}
 40
 41      createAdjacencyLists(edges, numberOfVertices);
 42    }
 43
 44 /** Create adjacency lists for each vertex */
 45 private void createAdjacencyLists(
 46 int[][] edges, int numberOfVertices) {
 47 for (int i = 0; i < edges.length; i++) {
 48        addEdge(edges[i][0], edges[i][1]);
 49      }
 50    }
 51
 52 /** Create adjacency lists for each vertex */
 53 private void createAdjacencyLists(
 54        List<Edge> edges, int numberOfVertices) {
 55 for (Edge edge: edges) {
 56        addEdge(edge.u, edge.v);
 57      }
 58    }
 59
 60    @Override /** Return the number of vertices in the graph */
61 public int getSize() {
 62 return vertices.size();
 63    }
 64
 65    @Override /** Return the vertices in the graph */
 66 public List<V> getVertices() {
 67 return vertices;
 68    }
 69
 70    @Override /** Return the object for the specified vertex */
 71 public V getVertex(int index) {
 72 return vertices.get(index);
 73    }
constructor
constructor
constructor
getSize
getVertices
getVertex
```

</details>


## PDF page 1053

<details>
<summary>Page text</summary>

```text
1030 Chapter 28  Graphs and Applications
 74
 75    @Override /** Return the index for the specified vertex object */
 76 public int getIndex(V v) {
 77 return vertices.indexOf(v);
 78    }
 79
 80    @Override /** Return the neighbors of the specified vertex */
 81 public List<Integer> getNeighbors(int index) {
 82      List<Integer> result = new ArrayList<>();
 83 for (Edge e: neighbors.get(index))
 84        result.add(e.v);
 85
 86 return result;
 87    }
 88
 89    @Override /** Return the degree for a specified vertex */
 90 public int getDegree(int v) {
 91 return neighbors.get(v).size();
 92    }
 93
 94    @Override /** Print the edges */
 95 public void printEdges() {
 96 for (int u = 0; u < neighbors.size(); u++) {
 97        System.out.print(getVertex(u) + " (" + u + "): ");
 98 for (Edge e: neighbors.get(u)) {
 99          System.out.print("(" + getVertex(e.u) + ", " +
100            getVertex(e.v) + ") ");
101        }
102        System.out.println();
103      }
104    }
105
106    @Override /** Clear the graph */
107 public void clear() {
108      vertices.clear();
109      neighbors.clear();
110    }
111
112    @Override /** Add a vertex to the graph */
113 public boolean addVertex(V vertex) {
114 if (!vertices.contains(vertex)) {
115        vertices.add(vertex);
116        neighbors.add(new ArrayList<Edge>());
117 return true;
118      }
119 else {
120 return false;
121      }
122    }
123
124 /** Add an edge to the graph */
125 protected boolean addEdge(Edge e) {
126 if (e.u < 0 || e.u > getSize() - 1)
127 throw new IllegalArgumentException("No such index: " + e.u);
128
129 if (e.v < 0 || e.v > getSize() - 1)
130 throw new IllegalArgumentException("No such index: " + e.v);
131
132 if (!neighbors.get(e.u).contains(e)) {
133        neighbors.get(e.u).add(e);
getIndex
getNeighbors
getDegree
printEdges
clear
addVertex
addEdge
```

</details>


## PDF page 1054

<details>
<summary>Page text</summary>

```text
28.4 Modeling Graphs  1031
134 return true;
135      }
136 else {
137 return false;
138      }
139    }
140
141    @Override /** Add an edge to the graph */
142 public boolean addEdge(int u, int v) {
143 return addEdge(new Edge(u, v));
144    }
145
146 /** Edge inner class inside the AbstractGraph class */
147 public static class Edge {
148 public int u; // Starting vertex of the edge
149 public int v; // Ending vertex of the edge
150
151 /** Construct an edge for (u, v) */
152 public Edge(int u, int v) {
153 this.u = u;
154 this.v = v;
155      }
156
157 public boolean equals(Object o) {
158 return u == ((Edge)o).u && v == ((Edge)o).v; 
159      }
160    }
161
162    @Override /** Obtain a DFS tree starting from vertex v */
163 /** To be discussed in Section 28.7 */
164 public Tree dfs(int v) {
165      List<Integer> searchOrder = new ArrayList<>();
166 int[] parent = new int[vertices.size()];
167 for (int i = 0; i < parent.length; i++)
168        parent[i] = -1; // Initialize parent[i] to -1
169
170 // Mark visited vertices
171 boolean[] isVisited = new boolean[vertices.size()];
172
173 // Recursively search
174      dfs(v, parent, searchOrder, isVisited);
175
176 // Return a search tree
177 return new Tree(v, parent, searchOrder);
178    }
179
180 /** Recursive method for DFS search */
181 private void dfs(int u, int[] parent, List<Integer> searchOrder,
182 boolean[] isVisited) {
183 // Store the visited vertex
184      searchOrder.add(u);
185      isVisited[u] = true; // Vertex v visited
186
187 for (Edge e : neighbors.get(u)) {
188 if (!isVisited[e.v]) {
189          parent[e.v] = u; // The parent of vertex e.v is u
190          dfs(e.v, parent, searchOrder, isVisited); // Recursive search
191        }
192      }
193    }
addEdge overloaded
Edge inner class
dfs method
```

</details>


## PDF page 1055

<details>
<summary>Page text</summary>

```text
1032 Chapter 28  Graphs and Applications
194
195    @Override /** Starting bfs search from vertex v */
196 /** To be discussed in Section 28.9 */
197 public Tree bfs(int v) {
198      List<Integer> searchOrder = new ArrayList<>();
199 int[] parent = new int[vertices.size()];
200 for (int i = 0; i < parent.length; i++)
201        parent[i] = -1; // Initialize parent[i] to -1
202
203      java.util.LinkedList<Integer> queue =
204 new java.util.LinkedList<>(); // list used as a queue
205 boolean[] isVisited = new boolean[vertices.size()];
206      queue.offer(v); // Enqueue v
207      isVisited[v] = true; // Mark it visited
208
209 while (!queue.isEmpty()) {
210 int u = queue.poll(); // Dequeue to u
211        searchOrder.add(u); // u searched
212 for (Edge e: neighbors.get(u)) {
213 if (!isVisited[e.v]) {
214            queue.offer(e.v); // Enqueue w
215            parent[e.v] = u; // The parent of w is u
216            isVisited[e.v] = true; // Mark it visited
217          }
218        }
219      }
220
221 return new Tree(v, parent, searchOrder);
222    }
223
224 /** Tree inner class inside the AbstractGraph class */
225 /** To be discussed in Section 28.6 */
226 public class Tree {
227 private int root; // The root of the tree
228 private int[] parent; // Store the parent of each vertex
229 private List<Integer> searchOrder; // Store the search order
230
231 /** Construct a tree with root, parent, and searchOrder */
232 public Tree(int root, int[] parent, List<Integer> searchOrder) {
233 this.root = root;
234 this.parent = parent;
235 this.searchOrder = searchOrder;
236      }
237
238 /** Return the root of the tree */
239 public int getRoot() {
240 return root;
241      }
242
243 /** Return the parent of vertex v */
244 public int getParent(int v) {
245 return parent[v];
246      }
247
248 /** Return an array representing search order */
249 public List<Integer> getSearchOrder() {
250 return searchOrder;
251      }
252
253 /** Return number of vertices found */
254 public int getNumberOfVerticesFound() {
bfs method
Tree inner class
```

</details>


## PDF page 1056

<details>
<summary>Page text</summary>

```text
28.4 Modeling Graphs  1033
255 return searchOrder.size();
256      }
257
258 /** Return the path of vertices from a vertex to the root */
259 public List<V> getPath(int index) {
260        ArrayList<V> path = new ArrayList<>();
261
262 do {
263          path.add(vertices.get(index));
264          index = parent[index];
265        }
266 while (index != -1);
267
268 return path;
269      }
270
271 /** Print a path from the root to vertex v */
272 public void printPath(int index) {
273        List<V> path = getPath(index);
274        System.out.print("A path from " + vertices.get(root) + " to " +
275          vertices.get(index) + ": ");
276 for (int i = path.size() - 1; i >= 0; i--)
277          System.out.print(path.get(i) + " ");
278      }
279
280 /** Print the whole tree */
281 public void printTree() {
282        System.out.println("Root is: " + vertices.get(root));
283        System.out.print("Edges: ");
284 for (int i = 0; i < parent.length; i++) {
285 if (parent[i] != -1) {
286 // Display an edge
287            System.out.print("(" + vertices.get(parent[i]) + ", " +
288              vertices.get(i) + ") ");
289          }
290        }
291        System.out.println();
292      }
293    }
294  } 
LISTING 28.4 UnweightedGraph.java
 1 import java.util.*;
 2
 3 public class UnweightedGraph<V> extends AbstractGraph<V> {
 4 /** Construct an empty graph */
 5 public UnweightedGraph() {
 6    }
 7
 8 /** Construct a graph from vertices and edges stored in arrays */
 9 public UnweightedGraph(V[] vertices, int[][] edges) {
10 super(vertices, edges);
11    }
12
13 /** Construct a graph from vertices and edges stored in List */
14 public UnweightedGraph(List<V> vertices, List<Edge> edges) {
15 super(vertices, edges);
16    }
17
18 /** Construct a graph for integer vertices 0, 1, 2 and edge list */
no-arg constructor
constructor
constructor
```

</details>


## PDF page 1057

<details>
<summary>Page text</summary>

```text
1034 Chapter 28  Graphs and Applications
19 public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
20 super(edges, numberOfVertices);
21    }
22
23 /** Construct a graph from integer vertices 0, 1, and edge array */
24 public UnweightedGraph(int[][] edges, int numberOfVertices) {
25 super(edges, numberOfVertices);
26    }
27  }
The code in the Graph interface in Listing 28.2 and the UnweightedGraph  class in 
Listing 28.4 are straightforward. Let us digest the code in the AbstractGraph  class in 
Listing 28.3.
TheAbstractGraph class defines the data field vertices (line 4) to store vertices and 
neighbors (line 5) to store edges in adjacency lists. neighbors.get(i) stores all edges adja-
cent to vertex i. Four overloaded constructors are defined in lines 9–42 to create a default graph, 
or a graph from arrays or lists of edges and vertices. The createAdjacencyLists(int[][] 
edges, int numberOfVertices) method creates adjacency lists from edges in an array (lines 
45–50). The createAdjacencyLists(List<Edge> edges, int numberOfVertices)
method creates adjacency lists from edges in a list (lines 53–58).
ThegetNeighbors(u) method (lines 81–87) returns a list of vertices adjacent to vertex 
u. The clear() method (lines 106–110) removes all vertices and edges from the graph. The 
addVertex(u) method (lines 112–122) adds a new vertex to vertices and returns true. It 
returns false if the vertex is already in the graph (line 120).
The addEdge(e) method (lines 124–139) adds a new edge the adjacency edge list and 
returns true. It returns false if the edge is already in the graph. This method may throw 
IllegalArgumentExcepiton if the edge is invalid (lines 126–130).
The printEdges() method (lines 95–104) displays all vertices and edges adjacent to 
each vertex.
The code in lines 164–293 gives the methods for finding a depth-first search tree and a 
breadth-first search tree, which will be introduced in Sections 28.7 and 28.9, respectively.
28.7 Describe the relationships among Graph,AbstractGraph, and UnweightedGraph.
28.8 For the code in Listing 28.1, TestGraph.java, what is graph1.getIndex("Seattle")?
What is graph1.getDegree(5)? What is graph1.getVertex(4)?
28.5 Graph Visualization
To display a graph visually, each vertex must be assigned a location.
The preceding section introduced how to model a graph using the Graph interface, 
AbstractGraph class, and UnweightedGraph class. This section discusses how to display 
graphs graphically. In order to display a graph, you need to know where each vertex is dis-
played and the name of each vertex. To ensure a graph can be displayed, we define an inter-
face named Displayable that has the methods for obtaining the x- andy-coordinates and 
their names, and make vertices instances of Displayable, in Listing 28.5.
LISTING 28.5 Displayable.java
1 public interface Displayable {
2 public int getX(); // Get x-coordinate of the vertex
3 public int getY(); // Get y-coordinate of the vertex
4 public String getName(); // Get display name of the vertex
5  }
A graph with Displayable vertices can now be displayed on a pane named GraphView,
as shown in Listing 28.6.
constructor
constructor
✓Point✓
Check
Key
Point
Displayable interface
```

</details>


## PDF page 1058

<details>
<summary>Page text</summary>

```text
28.5 Graph Visualization  1035
LISTING 28.6 GraphView.java
 1 import javafx.scene.layout.Pane;
 2 import javafx.scene.shape.Circle;
 3 import javafx.scene.shape.Line;
 4 import javafx.scene.text.Text;
 5
 6 public class GraphView extends Pane {
 7 private Graph<? extends Displayable> graph;
 8
 9 public GraphView(Graph<? extends Displayable> graph) {
10 this.graph = graph;
11
12 // Draw vertices
13      java.util.List<? extends Displayable> vertices 
14        = graph.getVertices();
15 for (int i = 0; i < graph.getSize(); i++) {
16 int x = vertices.get(i).getX();
17 int y = vertices.get(i).getY();
18        String name = vertices.get(i).getName();
19
20 getChildren().add( new Circle(x, y, 16)); // Display a vertex
21 getChildren().add( new Text(x - 8, y - 18, name));
22      }
23
24 // Draw edges for pairs of vertices
25 for (int i = 0; i < graph.getSize(); i++) {
26        java.util.List<Integer> neighbors = graph.getNeighbors(i);
27 int x1 = graph.getVertex(i).getX();
28 int y1 = graph.getVertex(i).getY();
29 for (int v: neighbors) {
30 int x2 = graph.getVertex(v).getX();
31 int y2 = graph.getVertex(v).getY();
32
33 // Draw an edge for (i, v)
34 getChildren().add( new Line(x1, y1, x2, y2));
35        }
36      }
37    }
38  }
To display a graph on a pane, simply create an instance of GraphView by passing the 
graph as an argument in the constructor (line 9). The class for the graph’s vertex must imple-
ment the Displayable interface in order to display the vertices (lines 13–22). For each 
vertex index i, invoking graph.getNeighbors(i) returns its adjacency list (line 26). From 
this list, you can find all vertices that are adjacent to i and draw a line to connect i with its 
adjacent vertex (lines 27–34).
Listing 28.7 gives an example of displaying the graph in Figure  28.1, as shown in 
Figure 28.10.
LISTING 28.7 DisplayUSMap.java
 1 import javafx.application.Application;
 2 import javafx.scene.Scene;
 3 import javafx.stage.Stage;
 4
 5 public class DisplayUSMap extends Application {
 6    @Override // Override the start method in the Application class
 7 public void start(Stage primaryStage) {
 8      City[] vertices = {new City("Seattle", 75, 50),
extendsPane
Displayable vertices
display a vertex
display a text
draw an edge
```

</details>


## PDF page 1059

<details>
<summary>Page text</summary>

```text
1036 Chapter 28  Graphs and Applications
 9 new City("San Francisco", 50, 210),
10 new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
11 new City("Kansas City", 400, 245),
12 new City("Chicago", 450, 100), new City("Boston", 700, 80),
13 new City("New York", 675, 120), new City("Atlanta", 575, 295),
14 new City("Miami", 600, 400), new City("Dallas", 408, 325),
15 new City("Houston", 450, 360) };
16
17 // Edge array for graph in Figure 28.1
18 int[][] edges = {
19        {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3},
20        {2, 1}, {2, 3}, {2, 4}, {2, 10},
21        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
22        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
23        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
24        {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8},
25        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
26        {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11},
27        {11, 8}, {11, 9}, {11, 10}
28      };
29
30 Graph<City> graph = new UnweightedGraph<>(vertices, edges);
31
32 // Create a scene and place it in the stage
33      Scene scene = new Scene(new GraphView(graph), 750, 450);
34      primaryStage.setTitle("DisplayUSMap"); // Set the stage title
35      primaryStage.setScene(scene); // Place the scene in the stage
36      primaryStage.show(); // Display the stage
37    }
38
39 static class City implements Displayable {
40 private int x, y;
41 private String name;
42
43 City(String name, int x, int y) {
44 this.name = name;
45 this.x = x;
46 this.y = y;
47      }
48
49      @Override 
50 public int getX() {
51 return x;
52      }
53
54      @Override 
55 public int getY() {
56 return y;
57      }
58
59      @Override 
60 public String getName() {
61 return name;
62      }
63    }
64  }
The class City is defined to model the vertices with their coordinates and names (lines 39–63). 
The program creates a graph with the vertices of the City type (line 30). Since City implements 
Displayable, a GraphView object created for the graph displays the graph in the pane (line 33).
As an exercise to get acquainted with the graph classes and interfaces, add a city (e.g., 
Savannah) with appropriate edges into the graph.
create a graph
create a GraphView
City class
```

</details>


## PDF page 1060

<details>
<summary>Page text</summary>

```text
28.6 Graph Traversals  1037
28.9 Will Listing 28.7 DisplayUSMap.java work, if the code in lines 30–34 in Listing 28.6 
GraphView.java is replaced by the following code?
if (i < v) {
int x2 = graph.getVertex(v).getX();
int y2 = graph.getVertex(v).getY();
// Draw an edge for (i, v)
  getChildren().add(new Line(x1, y1, x2, y2)); 
}
28.10 For the graph1 object created in Listing 28.1, TestGraph.java, can you create a 
GraphView object as follows?
GraphView view = new GraphView(graph1);
28.6 Graph Traversals
Depth-first and breadth-first are two common ways to traverse a graph.
Graph traversal is the process of visiting each vertex in the graph exactly once. There are two 
popular ways to traverse a graph: depth-first traversal (or depth-first search) and breadth-
first traversal (or breadth-first search). Both traversals result in a spanning tree, which can be 
modeled using a class, as shown in Figure 28.11. Note that Tree is an inner class defined in 
the AbstractGraph class. AbstractGraph<V>.Tree is different from the Tree interface 
defined in Section 25.2.5. AbstractGraph.Tree is a specialized class designed for describing 
the parent–child relationship of the nodes, whereas the Tree interface defines common opera-
tions such as searching, inserting, and deleting in a tree. Since there is no need to perform these 
operations for a spanning tree, AbstractGraph<V>.Tree is not defined as a subtype of Tree.
TheTree class is defined as an inner class in the AbstractGraph class in lines 226–293 
in Listing 28.3. The constructor creates a tree with the root, edges, and a search order.
The Tree class defines seven methods. The getRoot() method returns the root of the 
tree. You can get the order of the vertices searched by invoking the getSearchOrder()
method. You can invoke getParent(v) to find the parent of vertex v in the search. Invok-
inggetNumberOfVerticesFound() returns the number of vertices searched. The method 
getPath(index) returns a list of vertices from the specified vertex index to the root. Invok-
ingprintPath(v) displays a path from the root to v. You can display all edges in the tree 
using the printTree() method.
✓Point✓
Check
Key
Point
depth-first search
breadth-first search
FIGURE 28.10 The graph is displayed in the pane.
```

</details>


## PDF page 1061

<details>
<summary>Page text</summary>

```text
1038 Chapter 28  Graphs and Applications
Sections 28.7 and 28.9 will introduce depth-first search and breadth-first search, respec-
tively. Both searches will result in an instance of the Tree class.
28.11 DoesAbstractGraph<V>.Tree implement the Tree interface defined in Listing 25.3
Tree.java?
28.12 What method do you use to find the parent of a vertex in the tree?
28.7 Depth-First Search (DFS)
The depth-first search of a graph starts from a vertex in the graph and visits all 
vertices in the graph as far as possible before backtracking.
The depth-first search of a graph is like the depth-first search of a tree discussed in Section 25.2.4,
Tree Traversal. In the case of a tree, the search starts from the root. In a graph, the search can 
start from any vertex.
A depth-first search of a tree first visits the root, then recursively visits the subtrees of the 
root. Similarly, the depth-first search of a graph first visits a vertex, then it recursively visits 
all the vertices adjacent to that vertex. The difference is that the graph may contain cycles, 
which could lead to an infinite recursion. To avoid this problem, you need to track the vertices 
that have already been visited.
The search is called depth-first because it searches “deeper” in the graph as much as possible. 
The search starts from some vertex v. After visiting v, it visits an unvisited neighbor of v. If v has 
no unvisited neighbor, the search backtracks to the vertex from which it reached v. We assume 
that the graph is connected and the search starting from any vertex can reach all the vertices. If 
this is not the case, see Programming Exercise 28.4 for finding connected components in a graph.
28.7.1 Depth-First Search Algorithm
The algorithm for the depth-first search is described in Listing 28.8.
LISTING 28.8 Depth-First Search Algorithm
 Input: G = (V, E) and a starting vertex v
 Output: a DFS tree rooted at v
 1  Tree dfs(vertex v) {
2    visit v; 
✓Point✓
Check
Key
Point
visitv
FIGURE 28.11 TheTree class describes the nodes with parent–child relationships.
-root: int
-parent: int[]
-searchOrder: List<Integer>
+Tree(root: int, parent: int[],
   searchOrder: List<Integer>)
+printPath(index: int): void
+printTree(): void
AbstractGraph<V>.Tree
Constructs a tree with the specified root, parent, and
searchOrder.
The root of the tree.
The parents of the vertices.
The orders for traversing the vertices.
Returns the root of the tree.
Returns the order of vertices searched.
Returns the parent for the specified vertex index.
Returns the number of vertices searched.
Returns a list of vertices from the specified vertex index
     to the root.
Displays a path from the root to the specified vertex.
Displays tree with the root and all edges.
+getRoot(): int
+getSearchOrder(): List<Integer>
+getParent(index: int): int
+getNumberOfVerticesFound(): int
+getPath(index: int): List<V>
```

</details>


## PDF page 1062

<details>
<summary>Page text</summary>

```text
28.7 Depth-First Search (DFS)  1039
 3 for each neighbor w of v
 4 if (w has not been visited) {
 5        set v as the parent for w in the tree;
 6        dfs(w); 
 7      }
 8  }
You can use an array named isVisited to denote whether a vertex has been visited.
Initially, isVisited[i] is false for each vertex i. Once a vertex, say v, is visited, 
isVisited[v] is set to true.
Consider the graph in Figure 28.12a. Suppose we start the depth-first search from vertex 
0. First visit 0, then any of its neighbors, say 1. Now 1 is visited, as shown in Figure 28.12b. 
Vertex 1 has three neighbors—0, 2, and 4. Since 0 has already been visited, you will visit 
either 2 or 4. Let us pick 2. Now 2 is visited, as shown in Figure 28.12c. Vertex 2 has three 
neighbors: 0, 1, and 3. Since 0 and 1 have already been visited, pick 3. 3 is now visited, as 
shown in Figure 28.12d. At this point, the vertices have been visited in this order:
0, 1, 2, 3
Since all the neighbors of 3 have been visited, backtrack to 2. Since all the vertices of 2 
have been visited, backtrack to 1. 4 is adjacent to 1, but 4 has not been visited. Therefore, visit 
4, as shown in Figure 28.12e. Since all the neighbors of 4 have been visited, backtrack to 1. 
Since all the neighbors of 1 have been visited, backtrack to 0. Since all the neighbors of 0 have 
been visited, the search ends.
Since each edge and each vertex is visited only once, the time complexity of the dfs
method is O(|E| + |V|) , where |E| denotes the number of edges and |V| the number of 
vertices.
check a neighbor
recursive search
DFS time complexity
FIGURE 28.12 Depth-first search visits a node and its neighbors recursively.
0 1
2
34
(a)
0 1
2
34
0 1
2
34
(b) (c)
0 1
2
3 4
0 1
2
3 4
(d) (e)
28.7.2 Implementation of Depth-First Search
The algorithm for DFS in Listing 28.8 uses recursion. It is natural to use recursion to imple-
ment it. Alternatively, you can use a stack (see Programming Exercise 28.3).
```

</details>


## PDF page 1063

<details>
<summary>Page text</summary>

```text
1040 Chapter 28  Graphs and Applications
The dfs(int v) method is implemented in lines 164–193 in Listing 28.3. It returns an 
instance of the Tree class with vertex v as the root. The method stores the vertices searched in 
the list searchOrder (line 165), the parent of each vertex in the array parent (line 166), and 
uses the isVisited array to indicate whether a vertex has been visited (line 171). It invokes 
the helper method dfs(v, parent, searchOrder, isVisited) to perform a depth-first 
search (line 174).
In the recursive helper method, the search starts from vertex u.u is added to searchOrder
in line 184 and is marked as visited (line 185). For each unvisited neighbor of u, the method 
is recursively invoked to perform a depth-first search. When a vertex e.v is visited, the parent 
ofe.v is stored in parent[e.v] (line 189). The method returns when all vertices are visited 
for a connected graph, or in a connected component.
Listing 28.9 gives a test program that displays a DFS for the graph in Figure 28.1 start-
ing from Chicago. The graphical illustration of the DFS starting from Chicago is shown in 
Figure 28.13. For an interactive GUI demo of DFS, go to www.cs.armstrong.edu/liang/animation/
USMapSearch.html.
LISTING 28.9 TestDFS.java
 1 public class TestDFS {
 2 public static void main(String[] args) {
 3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
 4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
 5 "Atlanta", "Miami", "Dallas", "Houston"};
 6
 7 int[][] edges = {
 8        {0, 1}, {0, 3}, {0, 5},
 9        {1, 0}, {1, 2}, {1, 3},
10        {2, 1}, {2, 3}, {2, 4}, {2, 10},
11        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
12        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
13        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
14        {6, 5}, {6, 7},
15        {7, 4}, {7, 5}, {7, 6}, {7, 8},
16        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
17        {9, 8}, {9, 11},
18        {10, 2}, {10, 4}, {10, 8}, {10, 11},
19        {11, 8}, {11, 9}, {11, 10}
20      };
21
22 Graph<String> graph = new UnweightedGraph<>(vertices, edges);
23      AbstractGraph<String>.Tree dfs = 
24 graph.dfs(graph.getIndex( "Chicago"));
25
26 java.util.List<Integer> searchOrders = dfs.getSearchOrder();
27      System.out.println(dfs.getNumberOfVerticesFound() +
28 " vertices are searched in this DFS order:");
29 for (int i = 0; i < searchOrders.size(); i++)
30        System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
31      System.out.println();
32
33 for (int i = 0; i < searchOrders.size(); i++)
34 if (dfs.getParent(i) != -1)
35          System.out.println("parent of " + graph.getVertex(i) +
36 " is " + graph.getVertex(dfs.getParent(i)));
37    }
38  }
vertices
edges
create a graph
get DFS
get search order
U.S. Map Search
```

</details>


## PDF page 1064

<details>
<summary>Page text</summary>

```text
28.7 Depth-First Search (DFS)  1041
12 vertices are searched in this DFS order:
  Chicago Seattle San Francisco Los Angeles Denver 
  Kansas City New York Boston Atlanta Miami Houston Dallas 
parent of Seattle is Chicago
parent of San Francisco is Seattle
parent of Los Angeles is San Francisco
parent of Denver is Los Angeles
parent of Kansas City is Denver
parent of Boston is New York
parent of New York is Kansas City
parent of Atlanta is New York
parent of Miami is Atlanta
parent of Dallas is Houston
parent of Houston is Miami 
FIGURE 28.13 A DFS search starts from Chicago.
28.7.3 Applications of the DFS
The depth-first search can be used to solve many problems, such as the following:
 ■ Detecting whether a graph is connected. Search the graph starting from any vertex. 
If the number of vertices searched is the same as the number of vertices in the graph,
```

</details>


## PDF page 1065

<details>
<summary>Page text</summary>

```text
1042 Chapter 28  Graphs and Applications
the graph is connected. Otherwise, the graph is not connected. (See Programming 
Exercise 28.1.)
 ■ Detecting whether there is a path between two vertices (see Programming 
Exercise 28.5).
 ■ Finding a path between two vertices (see Programming Exercise 28.5).
 ■ Finding all connected components. A connected component is a maximal connected 
subgraph in which every pair of vertices are connected by a path (see Programming 
Exercise 28.4).
 ■ Detecting whether there is a cycle in the graph (see Programming Exercise 28.6).
 ■ Finding a cycle in the graph (see Programming Exercise 28.7).
 ■ Finding a Hamiltonian path/cycle. A Hamiltonian path in a graph is a path that visits 
each vertex in the graph exactly once. A Hamiltonian cycle visits each vertex in the 
graph exactly once and returns to the starting vertex (see Programming Exercise 28.17).
The first six problems can be easily solved using the dfs method in Listing 28.3. To 
find a Hamiltonian path/cycle, you have to explore all possible DFSs to find the one that 
leads to the longest path. The Hamiltonian path/cycle has many applications, including for 
solving the well-known Knight’s Tour problem, which is presented in Supplement VI.E on 
the Companion Website.
28.13 What is depth-first search? 
28.14 Draw a DFS tree for the graph in Figure 28.3b starting from node A.
28.15 Draw a DFS tree for the graph in Figure 28.1 starting from vertex Atlanta.
28.16 What is the return type from invoking dfs(v)?
28.17 The depth-first search algorithm described in Listing 28.8 uses recursion. Alterna-
tively, you can use a stack to implement it, as shown below. Point out the error in this 
algorithm and give a correct algorithm.
// Wrong version 
Tree dfs(vertex v) {
  push v into the stack;
  mark v visited;
while (the stack is not empty) {
    pop a vertex, say u, from the stack
    visit u;
for each neighbor w of u
if (w has not been visited)
        push w into the stack; 
  }
}
28.8 Case Study: The Connected Circles Problem
The connected circles problem is to determine whether all circles in a two-dimensional 
plane are connected. This problem can be solved using a depth-first traversal.
The DFS algorithm has many applications. This section applies the DFS algorithm to solve 
the connected circles problem.
In the connected circles problem, you determine whether all the circles in a two-dimen-
sional plane are connected. If all the circles are connected, they are painted as filled circles, as 
shown in Figure 28.14a. Otherwise, they are not filled, as shown in Figure 28.14b.
✓Point✓
Check
Key
Point
```

</details>


## PDF page 1066

<details>
<summary>Page text</summary>

```text
28.8 Case Study: The Connected Circles Problem  1043
We will write a program that lets the user create a circle by clicking a mouse in a blank 
area that is not currently covered by a circle. As the circles are added, the circles are repainted 
filled if they are connected or unfilled otherwise.
We will create a graph to model the problem. Each circle is a vertex in the graph. Two 
circles are connected if they overlap. We apply the DFS in the graph, and if all vertices are 
found in the depth-first search, the graph is connected.
The program is given in Listing 28.10.
LISTING 28.10 ConnectedCircles.java
 1 import javafx.application.Application;
 2 import javafx.geometry.Point2D;
 3 import javafx.scene.Node;
 4 import javafx.scene.Scene;
 5 import javafx.scene.layout.Pane;
 6 import javafx.scene.paint.Color;
 7 import javafx.scene.shape.Circle;
 8 import javafx.stage.Stage;
 9
10 public class ConnectedCircles extends Application {
11    @Override // Override the start method in the Application class
12 public void start(Stage primaryStage) {
13 // Create a scene and place it in the stage
14      Scene scene = new Scene(new CirclePane(), 450, 350);
15      primaryStage.setTitle("ConnectedCircles"); // Set the stage title
16      primaryStage.setScene(scene); // Place the scene in the stage
17      primaryStage.show(); // Display the stage
18    }
19
20 /** Pane for displaying circles */
21 class CirclePane extends Pane {
22 public CirclePane() {
23 this.setOnMouseClicked(e -> {
24 if (!isInsideACircle(new Point2D(e.getX(), e.getY()))) { 
25 // Add a new circle
26            getChildren().add(new Circle(e.getX(), e.getY(), 20));
27            colorIfConnected();
28          }
29        });
30      }
create a circle pane
pane for showing circles
handle mouse clicked
is it inside another circle?
add a new circle
color if all connected
FIGURE 28.14 You can apply DFS to determine whether the circles are connected.
(a) Circles are connected (b) Circles are not connected
```

</details>


## PDF page 1067

<details>
<summary>Page text</summary>

```text
1044 Chapter 28  Graphs and Applications
31
32 /** Returns true if the point is inside an existing circle */
33 private boolean isInsideACircle(Point2D p) {
34 for (Node circle: this.getChildren())
35 if (circle.contains(p))
36 return true;
37
38 return false;
39      }
40
41 /** Color all circles if they are connected */
42 private void colorIfConnected() {
43 if (getChildren().size() == 0)
44 return; // No circles in the pane
45
46 // Build the edges
47        java.util.List<AbstractGraph.Edge> edges 
48          = new java.util.ArrayList<>();
49 for (int i = 0; i < getChildren().size(); i++)
50 for (int j = i + 1; j < getChildren().size(); j++)
51 if (overlaps((Circle)(getChildren().get(i)), 
52                (Circle)(getChildren().get(j)))) {
53              edges.add(new AbstractGraph.Edge(i, j));
54              edges.add(new AbstractGraph.Edge(j, i));
55            }
56
57 // Create a graph with circles as vertices
58        Graph<Node> graph = new UnweightedGraph<>
59          ((java.util.List<Node>)getChildren(), edges);
60        AbstractGraph<Node>.Tree tree = graph.dfs(0); // a DFS tree
61 boolean isAllCirclesConnected = getChildren().size() == tree
62            .getNumberOfVerticesFound();
63
64 for (Node circle: getChildren()) {
65 if (isAllCirclesConnected) { // All circles are connected
66            ((Circle)circle).setFill(Color.RED);
67          } 
68 else {
69            ((Circle)circle).setStroke(Color.BLACK);
70            ((Circle)circle).setFill(Color.WHITE);
71          }
72        }
73      }
74    }
75
76 public static boolean overlaps(Circle circle1, Circle circle2) {
77 return new Point2D(circle1.getCenterX(), circle1.getCenterY()).
78        distance(circle2.getCenterX(), circle2.getCenterY())
79        <= circle1.getRadius() + circle2.getRadius();
80    }
81  }
The JavaFX Circle class contains the data fields x, y, and radius, which specify the 
circle’s center location and radius. It also defines the contains for testing if a point is in the 
circle. The overlaps method (lines 76–80) checks whether two circles overlap.
When the user clicks the mouse outside of any existing circle, a new circle is created cen-
tered at the mouse point and the circle is added to the pane (line 26).
To detect whether the circles are connected, the program constructs a graph (lines 46–59). 
The circles are the vertices of the graph. The edges are constructed in lines 49–55. Two circle 
contains the point?
create edges
create a graph
get a search tree
connected?
connected
not connected
two circles overlap?
```

</details>


## PDF page 1068

<details>
<summary>Page text</summary>

```text
28.9 Breadth-First Search (BFS)  1045
vertices are connected if they overlap (line 51). The DFS of the graph results in a tree (line 60). 
The tree’s getNumberOfVerticesFound() returns the number of vertices searched. If it is 
equal to the number of circles, all circles are connected (lines 61–62).
28.18 How is a graph created for the connected circles problem?
28.19 When you click the mouse inside a circle, does the program create a new circle?
28.20 How does the program know if all circles are connected? 
28.9 Breadth-First Search (BFS)
The breadth-first search of a graph visits the vertices level by level. The first level 
consists of the starting vertex. Each next level consists of the vertices adjacent to the 
vertices in the preceding level.
The breadth-first traversal of a graph is like the breadth-first traversal of a tree discussed in 
Section 25.2.4, Tree Traversal. With breadth-first traversal of a tree, the nodes are visited 
level by level. First the root is visited, then all the children of the root, then the grandchildren 
of the root, and so on. Similarly, the breadth-first search of a graph first visits a vertex, then all 
its adjacent vertices, then all the vertices adjacent to those vertices, and so on. To ensure that 
each vertex is visited only once, it skips a vertex if it has already been visited.
28.9.1 Breadth-First Search Algorithm
The algorithm for the breadth-first search starting from vertex v in a graph is described in 
Listing 28.11.
LISTING 28.11 Breadth-First Search Algorithm
 Input: G = (V, E) and a starting vertex v
 Output: a BFS tree rooted at v
 1 Tree bfs(vertex v) {
 2    create an empty queue for storing vertices to be visited; 
 3    add v into the queue; 
 4    mark v visited;
 5
 6 while (the queue is not empty) {
 7      dequeue a vertex, say u, from the queue;
 8      add u into a list of traversed vertices; 
 9 for each neighbor w of u
10 if w has not been visited {
11          add w into the queue; 
12          set u as the parent for w in the tree;
13          mark w visited;
14        }
15    }
16  }
Consider the graph in Figure 28.15a. Suppose you start the breadth-first search from vertex 
0. First visit 0, then visit all its neighbors, 1, 2, and 3, as shown in Figure 28.15b. Vertex 1 
has three neighbors: 0, 2, and 4. Since 0 and 2 have already been visited, you will now visit 
just 4, as shown in Figure 28.15c. Vertex 2 has three neighbors, 0, 1, and 3, which have all 
been visited. Vertex 3 has three neighbors, 0, 2, and 4, which have all been visited. Vertex 4 
has two neighbors, 1 and 3, which have all been visited. Hence, the search ends.
Since each edge and each vertex is visited only once, the time complexity of the bfs method 
isO(|E| + |V|), where |E| denotes the number of edges and |V| the number of vertices.
✓Point✓
Check
Key
Point
create a queue
enqueuev
dequeue into u
u traversed
check a neighbor w
isw visited?
enqueuew
BFS time complexity
```

</details>


## PDF page 1069

<details>
<summary>Page text</summary>

```text
1046 Chapter 28  Graphs and Applications
28.9.2 Implementation of Breadth-First Search
The bfs(int v)  method is defined in the Graph interface and implemented in the 
AbstractGraph class in Listing 28.3 (lines 197–222). It returns an instance of the Tree class 
with vertex v as the root. The method stores the vertices searched in the list searchOrder
(line 198), the parent of each vertex in the array parent (line 199), uses a linked list for a 
queue (lines 203–204), and uses the isVisited array to indicate whether a vertex has been 
visited (line 207). The search starts from vertex v.v is added to the queue in line 206 and is 
marked as visited (line 207). The method now examines each vertex u in the queue (line 210) 
and adds it to searchOrder (line 211). The method adds each unvisited neighbor e.v of u to 
the queue (line 214), sets its parent to u (line 215), and marks it as visited (line 216).
Listing 28.12 gives a test program that displays a BFS for the graph in Figure 28.1 start-
ing from Chicago. The graphical illustration of the BFS starting from Chicago is shown in 
Figure 28.16. For an interactive GUI demo of BFS, go to www.cs.armstrong.edu/liang/animation/
USMapSearch.html.
LISTING 28.12 TestBFS.java
 1 public class TestBFS {
 2 public static void main(String[] args) {
 3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
 4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
 5 "Atlanta", "Miami", "Dallas", "Houston"};
 6
 7 int[][] edges = {
 8        {0, 1}, {0, 3}, {0, 5},
 9        {1, 0}, {1, 2}, {1, 3},
10        {2, 1}, {2, 3}, {2, 4}, {2, 10},
11        {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
12        {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
13        {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
14        {6, 5}, {6, 7},
15        {7, 4}, {7, 5}, {7, 6}, {7, 8},
16        {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
17        {9, 8}, {9, 11},
18        {10, 2}, {10, 4}, {10, 8}, {10, 11},
19        {11, 8}, {11, 9}, {11, 10}
20      };
21
22      Graph<String> graph = new UnweightedGraph<>(vertices, edges);
23 AbstractGraph<String>.Tree bfs =
24 graph.bfs(graph.getIndex( "Chicago"));
25
26      java.util.List<Integer> searchOrders = bfs.getSearchOrder();
vertices
edges
create a graph
create a BFS tree
get search order
FIGURE 28.15 Breadth-first search visits a node, then its neighbors, then its neighbors’s 
neighbors, and so on.
0 1
2
34
(a)
0 1
2
34
0 1
2
34
(b) (c)
```

</details>


## PDF page 1070

<details>
<summary>Page text</summary>

```text
28.9 Breadth-First Search (BFS)  1047
27      System.out.println(bfs.getNumberOfVerticesFound() +
28 " vertices are searched in this order:");
29 for (int i = 0; i < searchOrders.size(); i++)
30        System.out.println(graph.getVertex(searchOrders.get(i)));
31
32 for (int i = 0; i < searchOrders.size(); i++)
33 if (bfs.getParent(i) != -1)
34          System.out.println("parent of " + graph.getVertex(i) + 
35 " is " + graph.getVertex(bfs.getParent(i)));
36    }
37  }
12 vertices are searched in this order:
  Chicago Seattle Denver Kansas City Boston New York
  San Francisco Los Angeles Atlanta Dallas Miami Houston
parent of Seattle is Chicago
parent of San Francisco is Seattle
parent of Los Angeles is Denver
parent of Denver is Chicago
parent of Kansas City is Chicago
parent of Boston is Chicago
parent of New York is Chicago
parent of Atlanta is Kansas City
parent of Miami is Atlanta
parent of Dallas is Kansas City
parent of Houston is Atlanta 
28.9.3 Applications of the BFS
Many of the problems solved by the DFS can also be solved using the BFS. Specifically, the 
BFS can be used to solve the following problems:
 ■ Detecting whether a graph is connected. A graph is connected if there is a path 
between any two vertices in the graph.
 ■ Detecting whether there is a path between two vertices.
 ■ Finding a shortest path between two vertices. You can prove that the path between 
the root and any node in the BFS tree is a shortest path between the root and the node. 
(See Check Point Question 28.25.)
 ■ Finding all connected components. A connected component is a maximal connected 
subgraph in which every pair of vertices are connected by a path.
 ■ Detecting whether there is a cycle in the graph (see Programming Exercise 28.6).
 ■ Finding a cycle in the graph (see Programming Exercise 28.7).
 ■ Testing whether a graph is bipartite. (A graph is bipartite if the vertices of the graph 
can be divided into two disjoint sets such that no edges exist between vertices in the 
same set.) (See Programming Exercise 28.8.)
28.21 What is the return type from invoking bfs(v)?
28.22 What is breadth-first search? 
28.23 Draw a BFS tree for the graph in Figure 28.3b starting from node A.
28.24 Draw a BFS tree for the graph in Figure 28.1 starting from vertex Atlanta.
28.25 Prove that the path between the root and any node in the BFS tree is a shortest path 
between the root and the node.
✓Point✓
Check
```

</details>


## PDF page 1071

<details>
<summary>Page text</summary>

```text
1048 Chapter 28  Graphs and Applications
28.10 Case Study: The Nine Tails Problem
The nine tails problem can be reduced to the shortest path problem.
The nine tails problem is as follows. Nine coins are placed in a three-by-three matrix with 
some face up and some face down. A legal move is to take a coin that is face up and reverse it, 
together with the coins adjacent to it (this does not include coins that are diagonally adjacent). 
Your task is to find the minimum number of moves that lead to all coins being face down. For 
example, start with the nine coins as shown in Figure 28.17a. After you flip the second coin in 
the last row, the nine coins are now as shown in Figure 28.17b. After you flip the second coin 
in the first row, the nine coins are all face down, as shown in Figure 28.17c.
Key
Point
FIGURE 28.16 BFS search starts from Chicago.
FIGURE 28.17 The problem is solved when all coins are face down.
H
(a)
H
(b)
T
(c)
T
T
T
T
T
T
T
T
H
T
T
H
T
H
T
T
H
T
H
H
T
H
T
H
We will write a program that prompts the user to enter an initial state of the nine coins and 
displays the solution, as shown in the following sample run.
```

</details>


## PDF page 1072

<details>
<summary>Page text</summary>

```text
28.10 Case Study: The Nine Tails Problem  1049
Each state of the nine coins represents a node in the graph. For example, the three states in 
Figure 28.17 correspond to three nodes in the graph. For convenience, we use a 3* 3 matrix to 
represent all nodes and use 0 for heads and 1 for tails. Since there are nine cells and each cell is 
either0 or 1, there are a total of 29 (512) nodes, labeled 0,1, . . . , and 511, as shown in Figure 28.18.
Enter the initial nine coins Hs and Ts: HHHTTTHHH
The steps to flip the coins are 
HHH
TTT
HHH
HHH
THT
TTT
TTT
TTT
TTT
FIGURE 28.18 There are total of 512 nodes labeled in this order: 0,1,2, . . . , 511.
.....
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
1
0
0
1
0
0
0
0
0
1
2
0
0
0
0
0
0
0
0
1
3
0
0
1
1
1
1
1
1
1
511
1
1
1
We assign an edge from node v to u if there is a legal move from u to v. Figure 28.19 shows 
a partial graph. Note there is an edge from 511 to 47, since you can flip a cell in node 47 to 
become node 511.
The last node in Figure 28.18 represents the state of nine face-down coins. For convenience,
we call this last node the target node. Thus, the target node is labeled 511. Suppose the initial 
state of the nine tails problem corresponds to the node s. The problem is reduced to finding 
a shortest path from node s to the target node, which is equivalent to finding a shortest path 
from node s to the target node in a BFS tree rooted at the target node.
Now the task is to build a graph that consists of 512 nodes labeled 0,1,2, . . . , 511, and 
edges among the nodes. Once the graph is created, obtain a BFS tree rooted at node 511. From 
the BFS tree, you can find a shortest path from the root to any vertex. We will create a class 
named NineTailModel, which contains the method to get a shortest path from the target 
node to any other node. The class UML diagram is shown in Figure 28.20.
Visually, a node is represented in a 3 * 3 matrix with the letters H and T. In our program, 
we use a single-dimensional array of nine characters to represent a node. For example, the 
node for vertex 1 in Figure 28.18 is represented as {'H','H','H','H','H','H','H','H',
'T'} in the array.
ThegetEdges() method returns a list of Edge objects.
The getNode(index) method returns the node for the specified index. For example, 
getNode(0) returns the node that contains nine Hs. getNode(511) returns the node that 
contains nine Ts. The getIndex(node) method returns the index of the node.
Note that the data field tree is defined as protected so that it can be accessed from the 
WeightedNineTail subclass in the next chapter.
ThegetFlippedNode(char[] node, int position)  method flips the node at the 
specified position and its adjacent positions. This method returns the index of the new node.
```

</details>


## PDF page 1073

<details>
<summary>Page text</summary>

```text
1050 Chapter 28  Graphs and Applications
The position is a value from 0 to 8, which points to a coin in the node, as shown in the 
following figure. 
FIGURE 28.19 If node u becomes node v after cells are flipped, assign an edge from v to u.
1
011
10
00
408
0
1
101
11
00
488
0
0
110
11
00
240
0
0
011
00
11
30
0
0
101
00
11
47
1
0
111
00
00
56
0
1
111
11
11
511
1
0
110
00
01
51
1
FIGURE 28.20 TheNineTailModel class models the nine tails problem using a graph.
NineTailModel
#tree: AbstractGraph<Integer>.Tree A tree rooted at node 511.
+NineTailModel()
+getShortestPath(nodeIndex: int):
  List<Integer>
-getEdges():
  List<AbstractGraph.Edge>
+getNode(index: int): char[]
+getIndex(node: char[]): int
+getFlippedNode(node: char[],
  position: int): int
+flipACell(node: char[], row: int,
  column: int): void
+printNode(node: char[]): void
Constructs a model for the nine tails problem and obtains the tree.
Returns a path from the specified node to the root. The path
     returned consists of the node labels in a list.
Flips the node at the specified row and column.
Displays the node on the console.
Returns a list of Edge objects for the graph.
Returns a node consisting of nine characters of Hs and Ts.
Returns the index of the specified node.
Flips the node at the specified position and its adjacent positions
     and returns the index of the flipped node.
For example, for node 56 in Figure 28.19, flip it at position 0, and you will get node 51. If 
you flip node 56 at position 1, you will get node 47.
TheflipACell(char[] node, int row, int column)  method flips a node at the 
specified row and column. For example, if you flip node 56 at row 0 and column 0, the new 
node is 408. If you flip node 56 at row 2 and column 0, the new node is 30.
0
H H H H T T T H H HH
T
H
T
H
H
T
H
0
1
0
0
1
0
1
0 Position is 2
here in a node
A node is an
array of nine
characters
```

</details>


## PDF page 1074

<details>
<summary>Page text</summary>

```text
28.10 Case Study: The Nine Tails Problem  1051
Listing 28.13 shows the source code for NineTailModel.java.
LISTING 28.13 NineTailModel.java
  1 import java.util.*;
  2
  3 public class NineTailModel {
  4 public final static int NUMBER_OF_NODES = 512;
  5 protected AbstractGraph<Integer>.Tree tree; // Define a tree
  6
  7 /** Construct a model */
  8 public NineTailModel() {
  9 // Create edges
 10      List<AbstractGraph.Edge> edges = getEdges();
 11
 12 // Create a graph
 13      UnweightedGraph<Integer> graph = new UnweightedGraph<>(
 14        edges, NUMBER_OF_NODES); 
 15
 16 // Obtain a BSF tree rooted at the target node
 17      tree = graph.bfs(511);
 18    }
 19
 20 /** Create all edges for the graph */
 21 private List<AbstractGraph.Edge> getEdges() {
 22      List<AbstractGraph.Edge> edges =
 23 new ArrayList<>(); // Store edges
 24
 25 for (int u = 0; u < NUMBER_OF_NODES; u++) {
 26 for (int k = 0; k < 9; k++) {
 27 char[] node = getNode(u); // Get the node for vertex u
 28 if (node[k] == 'H') {
 29 int v = getFlippedNode(node, k);
 30 // Add edge (v, u) for a legal move from node u to node v
 31            edges.add(new AbstractGraph.Edge(v, u)); 
 32          }
 33        }
 34      }
 35
 36 return edges;
 37    }
 38
 39 public static int getFlippedNode(char[] node, int position) {
 40 int row = position / 3;
 41 int column = position % 3;
 42
 43      flipACell(node, row, column);
 44      flipACell(node, row - 1, column);
 45      flipACell(node, row + 1, column);
 46      flipACell(node, row, column - 1);
 47      flipACell(node, row, column + 1);
 48
 49 return getIndex(node);
 50    }
 51
 52 public static void flipACell(char[] node, int row, int column) {
 53 if (row >= 0 && row <= 2 && column >= 0 && column <= 2) { 
54 // Within the boundary
 55 if (node[row * 3 + column] == 'H')
 56          node[row * 3 + column] = 'T'; // Flip from H to T
declare a tree
create edges
create graph
create tree
get edges
add an edge
flip cells
flip a cell
row
column
Flip
```

</details>


## PDF page 1075

<details>
<summary>Page text</summary>

```text
1052 Chapter 28  Graphs and Applications
 57 else
 58          node[row * 3 + column] = 'H'; // Flip from T to H
 59      }
 60    }
 61
 62 public static int getIndex(char[] node) {
 63 int result = 0;
 64
 65 for (int i = 0; i < 9; i++) 
 66 if (node[i] == 'T')
 67          result = result * 2 + 1;
 68 else
 69          result = result * 2 + 0;
 70
 71 return result;
 72    }
 73
 74 public static char[] getNode(int index) {
 75 char[] result = new char[9];
 76
 77 for (int i = 0; i < 9; i++) {
 78 int digit = index % 2;
 79 if (digit == 0)
 80          result[8 - i] = 'H';
 81 else
 82          result[8 - i] = 'T';
 83        index = index / 2;
 84      }
 85
 86 return result;
 87    }
 88
 89 public List<Integer> getShortestPath(int nodeIndex) {
 90 return tree.getPath(nodeIndex);
 91    }
 92
 93 public static void printNode(char[] node) {
 94 for (int i = 0; i < 9; i++)
 95 if (i % 3 != 2)
 96          System.out.print(node[i]);
 97 else
 98          System.out.println(node[i]);
 99
100      System.out.println();
101    }
102  }
The constructor (lines 8–18) creates a graph with 512 nodes, and each edge corresponds to 
the move from one node to the other (line 10). From the graph, a BFS tree rooted at the target 
node511 is obtained (line 17).
To create edges, the getEdges method (lines 21–37) checks each node u to see 
if it can be flipped to another node v. If so, add ( v, u) to the Edge list (line 31). The 
getFlippedNode(node, position)  method finds a flipped node by flipping an H cell 
and its neighbors in a node (lines 43–47). The flipACell(node, row, column) method 
actually flips an H cell and its neighbors in a node (lines 52–60).
The getIndex(node) method is implemented in the same way as converting a binary 
number to a decimal number (lines 62–72). The getNode(index) method returns a node 
consisting of the letters H and T (lines 74–87).
get index for a node
get node for an index
shortest path
display a node
node: HHHHHHHTT
H H H
H H H
H T T
index: 3 
For example:
For example: 
T H H 
H H H 
H T T
node: THHHHHHTT
index: 259
For example: 
T H H 
H H H 
H T T
node: THHHHHHTT
Output:
```

</details>


## PDF page 1076

<details>
<summary>Page text</summary>

```text
Key Terms  1053
The getShortestpath(nodeIndex) method invokes the getPath(nodeIndex)
method to get a vertices in a shortest path from the specified node to the target node 
(lines 89–91).
TheprintNode(node) method displays a node on the console (lines 93–101).
Listing 28.14 gives a program that prompts the user to enter an initial node and displays the 
steps to reach the target node.
LISTING 28.14 NineTail.java
 1 import java.util.Scanner;
 2
 3 public class NineTail {
 4 public static void main(String[] args) {
 5 // Prompt the user to enter nine coins' Hs and Ts
 6      System.out.print("Enter the initial nine coins Hs and Ts: ");
 7      Scanner input = new Scanner(System.in);
 8      String s = input.nextLine(); 
 9 char[] initialNode = s.toCharArray();
10
11 NineTailModel model = new NineTailModel();
12      java.util.List<Integer> path =
13 model.getShortestPath(NineTailModel.getIndex(initialNode));
14
15      System.out.println("The steps to flip the coins are ");
16 for (int i = 0; i < path.size(); i++)
17        NineTailModel.printNode(
18          NineTailModel.getNode(path.get(i).intValue()));
19    }
20  }
The program prompts the user to enter an initial node with nine letters with a combination 
ofHs and Ts as a string in line 8, obtains an array of characters from the string (line 9), creates 
a graph model to get a BFS tree (line 11), obtains a shortest path from the initial node to the 
target node (lines 12–13), and displays the nodes in the path (lines 16–18).
28.26 How are the nodes created for the graph in NineTailModel?
28.27 How are the edges created for the graph in NineTailModel?
28.28 What is returned after invoking getIndex("HTHTTTHHH".toCharArray()) in 
Listing 28.13? What is returned after invoking getNode(46) in Listing 28.13?
28.29 If lines 26 and 27 are swapped in Listing 28.13, NineTailModel.java, will the pro-
gram work? Why?
initial node
create model
get shortest path
✓Point✓
Check
KEY TERMS
adjacency list 1022
adjacency matrix 1021
adjacent vertices 1018
breadth-first search 1037
complete graph 1018
cycle 1018
degree 1018
depth-first search 1037
directed graph 1017
graph 1016
incident edges 1018
parallel edge 1018
Seven Bridges of Königsberg 1016
simple graph 1018
spanning tree 1018
tree 1018
undirected graph 1017
unweighted graph 1018
weighted graph 1018
```

</details>


## PDF page 1077

<details>
<summary>Page text</summary>

```text
1054 Chapter 28  Graphs and Applications
CHAPTER SUMMARY
1. A graph is a useful mathematical structure that represents relationships among entities 
in the real world. You learned how to model graphs using classes and interfaces, how to 
represent vertices and edges using arrays and linked lists, and how to implement opera-
tions for graphs.
2. Graph traversal is the process of visiting each vertex in the graph exactly once. You 
learned two popular ways for traversing a graph: the depth-first search  (DFS) and 
breadth-first search (BFS).
3. DFS and BFS can be used to solve many problems such as detecting whether a graph 
is connected, detecting whether there is a cycle in the graph, and finding a shortest path 
between two vertices.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
Sections 28.6–28.10
*28.1 (Test whether a graph is connected ) Write a program that reads a graph from 
a file and determines whether the graph is connected. The first line in the file 
contains a number that indicates the number of vertices ( n). The vertices are 
labeled as 0,1, . . . , n-1. Each subsequent line, with the format u v1 v2... ,
describes edges (u,v1), (u,v2), and so on. Figure 28.21 gives the examples of 
two files for their corresponding graphs.
FIGURE 28.21 The vertices and edges of a graph can be stored in a file.
(a) (b)
File
6
0 1 2
1 0 3
2 0 3 4
3 1 2 4 5
4 2 3 5
5 3 4
0
2
4
1
3
5
File
6
0 1 2 3
1 0 3
2 0 3
3 0 1 2
45
54
0
23
1
45
  Your program should prompt the user to enter the name of the file, then it should 
read data from the file, create an instance g of UnweightedGraph , invoke 
g.printEdges() to display all edges, and invoke dfs() to obtain an instance 
tree of AbstractGraph.Tree. If tree.getNumberOfVerticesFound()
is the same as the number of vertices in the graph, the graph is connected. Here 
is a sample run of the program:
```

</details>


## PDF page 1078

<details>
<summary>Page text</summary>

```text
Programming Exercises  1055
  ( Hint: Use new UnweightedGraph(list, numberOfVertices) to create 
a graph, where list contains a list of AbstractGraph.Edge objects. Use 
new AbstractGraph.Edge(u, v)  to create an edge. Read the first line to 
get the number of vertices. Read each subsequent line into a string s and use 
s.split("[\\s+]") to extract the vertices from the string and create edges 
from the vertices.)
*28.2 (Create a file for a graph) Modify Listing 28.1, TestGraph.java, to create a file 
representinggraph1. The file format is described in Programming Exercise 28.1. 
Create the file from the array defined in lines 8–21 in Listing 28.1. The number 
of vertices for the graph is 12, which will be stored in the first line of the file. 
The contents of the file should be as follows:
12
0 1 3 5
1 0 2 3
2 1 3 4 10
3 0 1 2 4 5
4 2 3 5 7 8 10
5 0 3 4 6 7
6 5 7
7 4 5 6 8
8 4 7 9 10 11
9 8 11
10 2 4 8 11
11 8 9 10
*28.3 (Implement DFS using a stack ) The depth-first search algorithm described in 
Listing 28.8 uses recursion. Design a new algorithm without using recursion. 
Describe it using pseudocode. Implement it by defining a new class named 
UnweightedGraphWithNonrecursiveDFS that extends UnweightedGraph
and overriding the dfs method. 
*28.4 (Find connected components) Create a new class named MyGraph as a subclass 
ofUnweightedGraph that contains a method for finding all connected com-
ponents in a graph with the following header:
public List<List<Integer>> getConnectedComponents();
  The method returns a List<List<Integer>>. Each element in the list is 
another list that contains all the vertices in a connected component. For exam-
ple, for the graph in Figure  28.21b, getConnectedComponents() returns 
[[0, 1, 2, 3], [4, 5]].
Enter a file name: c:\exercise\GraphSample1.txt
The number of vertices is 6
Vertex 0: (0, 1) (0, 2) 
Vertex 1: (1, 0) (1, 3) 
Vertex 2: (2, 0) (2, 3) (2, 4) 
Vertex 3: (3, 1) (3, 2) (3, 4) (3, 5) 
Vertex 4: (4, 2) (4, 3) (4, 5) 
Vertex 5: (5, 3) (5, 4) 
The graph is connected
```

</details>


## PDF page 1079

<details>
<summary>Page text</summary>

```text
1056 Chapter 28  Graphs and Applications
*28.5 (Find paths) Add a new method in AbstractGraph to find a path between two 
vertices with the following header:
public List<Integer> getPath(int u, int v);
  The method returns a List<Integer> that contains all the vertices in a path 
from u to v in this order. Using the BFS approach, you can obtain a shortest 
path from u to v. If there isn’t a path from u to v, the method returns null.
*28.6 (Detect cycles) Add a new method in AbstractGraph to determine whether 
there is a cycle in the graph with the following header:
public boolean isCyclic();
*28.7 (Find a cycle ) Add a new method in AbstractGraph to find a cycle in the 
graph with the following header:
public List<Integer> getACycle(int u);
  The method returns a List that contains all the vertices in a cycle starting from 
u. If the graph doesn’t have any cycles, the method returns null.
**28.8 (Test bipartite) Recall that a graph is bipartite if its vertices can be divided into 
two disjoint sets such that no edges exist between vertices in the same set. Add 
a new method in AbstractGraph with the following header to detect whether 
the graph is bipartite:
public boolean isBipartite();
**28.9 (Get bipartite sets) Add a new method in AbstractGraph with the following 
header to return two bipartite sets if the graph is bipartite:
public List<List<Integer>> getBipartite();
  The method returns a List that contains two sublists, each of which contains a 
set of vertices. If the graph is not bipartite, the method returns null.
28.10 (Find a shortest path ) Write a program that reads a connected graph from a 
file. The graph is stored in a file using the same format specified in Program-
ming Exercise 28.1. Your program should prompt the user to enter the name of 
the file, then two vertices, and should display a shortest path between the two 
vertices. For example, for the graph in Figure 28.21a, a shortest path between 0
and5 may be displayed as 0 1 3 5.
  Here is a sample run of the program:
Enter a file name: c:\exercise\GraphSample1.txt
Enter two vertices (integer indexes): 0 5
The number of vertices is 6
Vertex 0: (0, 1) (0, 2) 
Vertex 1: (1, 0) (1, 3) 
Vertex 2: (2, 0) (2, 3) (2, 4) 
Vertex 3: (3, 1) (3, 2) (3, 4) (3, 5) 
Vertex 4: (4, 2) (4, 3) (4, 5) 
Vertex 5: (5, 3) (5, 4) 
The path is 0 1 3 5
```

</details>


## PDF page 1080

<details>
<summary>Page text</summary>

```text
Programming Exercises  1057
**28.11 (Revise Listing 28.14, NineTail.java) The program in Listing 28.14 lets the user 
enter an input for the nine tails problem from the console and displays the result 
on the console. Write a program that lets the user set an initial state of the nine 
coins (see Figure 28.22a) and click the Solve button to display the solution, as 
shown in Figure 28.22b. Initially, the user can click the mouse button to flip a 
coin. Set a red color on the flipped cells.
FIGURE 28.22 The program solves the nine tails problem.
(a)( b)
**28.12 (Variation of the nine tails problem) In the nine tails problem, when you flip a 
coin, the horizontal and vertical neighboring cells are also flipped. Rewrite the 
program, assuming that all neighboring cells including the diagonal neighbors 
are also flipped.
**28.13 (4 * 4 16 tails problem ) Listing 28.14, NineTail.java, presents a solution for 
the nine tails problem. Revise this program for the 4 * 4 16 tails problem. 
Note that it is possible that a solution may not exist for a starting pattern. If so, 
report that no solution exists.
**28.14 (4 * 4 16 tails analysis) The nine tails problem in the text uses a 3* 3 matrix. 
Assume that you have 16 coins placed in a 4 * 4 matrix. Write a program to 
find out the number of the starting patterns that don’t have a solution.
*28.15 (4 * 4 16 tails GUI) Rewrite Programming Exercise 28.14 to enable the user to 
set an initial pattern of the 4 * 4 16 tails problem (see Figure 28.23a).  The user 
can click the Solve button to display the solution, as shown in Figure 28.23b. 
Initially, the user can click the mouse button to flip a coin. If a solution does not 
exist, display a message to report it.
FIGURE 28.23 The problem solves the 16 tails problem.
(b)(a)
```

</details>


## PDF page 1081

<details>
<summary>Page text</summary>

```text
1058 Chapter 28  Graphs and Applications
**28.16 (Induced subgraph ) Given an undirected graph G = (V, E) and an integer 
k, find an induced subgraph H of G of maximum size such that all vertices 
of H have a degree 7 = k, or conclude that no such induced subgraph exists. 
Implement the method with the following header:
public static Graph maxInducedSubgraph(Graph g, int k)
  The method returns null if such a subgraph does not exist.
  ( Hint: An intuitive approach is to remove vertices whose degree is less than k.
As vertices are removed with their adjacent edges, the degrees of other vertices 
may be reduced. Continue the process until no vertices can be removed, or all 
the vertices are removed.)
***28.17 (Hamiltonian cycle) The Hamiltonian path algorithm is implemented in Sup-
plement VI.E. Add the following getHamiltonianCycle method in the 
Graph interface and implement it in the AbstractGraph class:
/** Return a Hamiltonian cycle 
* Return null if the graph doesn't contain a Hamiltonian cycle */
public List<Integer> getHamiltonianCycle()
***28.18 (Knight’s Tour cycle ) Rewrite KnightTourApp.java in the case study in Sup-
plement VI.E to find a knight’s tour that visits each square in a chessboard and 
returns to the starting square. Reduce the Knight’s Tour cycle problem to the 
problem of finding a Hamiltonian cycle.
**28.19 (Display a DFS/BFS tree in a graph ) Modify GraphView in Listing 28.6 to 
add a new data field tree with a set method. The edges in the tree are dis-
played in red. Write a program that displays the graph in Figure 28.1 and the 
DFS/BFS tree starting from a specified city, as shown in Figures 28.13 and 
28.16. If a city not in the map is entered, the program displays an error mes-
sage in the label.
*28.20 (Display a graph) Write a program that reads a graph from a file and displays it. 
The first line in the file contains a number that indicates the number of vertices 
(n). The vertices are labeled 0,1, . . . , n-1. Each subsequent line, with the for-
matu x y v1 v2... , describes the position of u at (x,y) and edges (u, v1),
(u,v2), and so on. Figure 28.24a gives an example of the file for their corre-
sponding graph. Your program prompts the user to enter the name of the file, 
reads data from the file, and displays the graph on a pane using GraphView, as 
shown in Figure 28.24b.
FIGURE 28.24 The program reads the information about the graph and displays it visually.
(a) (b)
File
7
0  30  30 1 2
1  90  30 0 3 6
2  30  90 0 3 4
3  90  90 1 2 4 5
4  30 150 2 3 5
5  90 150 3 4 6
6 130  90 1 5
0
2
4
1
36
5
```

</details>


## PDF page 1082

<details>
<summary>Page text</summary>

```text
Programming Exercises  1059
**28.21 (Display sets of connected circles ) Modify Listing 28.10, 
ConnectedCircles. java, to display sets of connected circles in different colors. 
That is, if two circles are connected, they are displayed using the same color; 
otherwise, they are not in same color, as shown in Figure 28.25. ( Hint: See 
Programming Exercise 28.4.)
*28.22 (Move a circle ) Modify Listing 28.10, ConnectedCircles.java, to enable the 
user to drag and move a circle.
**28.23 (Connected rectangles) Listing 28.10, ConnectedCircles.java, allows the user 
to create circles and determine whether they are connected. Rewrite the pro-
gram for rectangles. The program lets the user create a rectangle by clicking a 
mouse in a blank area that is not currently covered by a rectangle. As the rec-
tangles are added, the rectangles are repainted as filled if they are connected or 
are unfilled otherwise, as shown in Figure 28.25b–c.
*28.24 (Remove a circle) Modify Listing 28.10, ConnectedCircles.java, to enable the 
user to remove a circle when the mouse is clicked inside the circle.
FIGURE 28.25 (a) Connected circles are displayed in the same color. (b) Rectangles are not filled with a color if they are 
not connected. (c) Rectangles are filled with a color if they are connected.
(a) (b )( c)
```

</details>


## PDF page 1083

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
