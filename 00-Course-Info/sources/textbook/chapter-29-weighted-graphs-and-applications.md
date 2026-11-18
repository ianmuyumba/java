# Chapter 29 Weighted Graphs and Applications

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 1084

<details>
<summary>Page text</summary>

```text
WEIGHTED GRAPHS
AND APPLICATIONS
Objectives
■ To represent weighted edges using adjacency matrices and adjacency 
lists (§29.2).
■ To model weighted graphs using the WeightedGraph class that 
extends the AbstractGraph class (§29.3).
■ To design and implement the algorithm for finding a minimum 
spanning tree (§29.4).
■ To define the MST class that extends the Tree class (§29.4).
■ To design and implement the algorithm for finding single-source 
shortest paths (§29.5).
■ To define the ShortestPathTree class that extends the Tree class 
(§29.5).
■ To solve the weighted nine tails problem using the shortest-path 
algorithm (§29.6).
CHAPTER
29
```

</details>


## PDF page 1085

<details>
<summary>Page text</summary>

```text
1062 Chapter 29  Weighted Graphs and Applications
29.1 Introduction
A graph is a weighted graph if each edge is assigned a weight. Weighted graphs have 
many practical applications.
Figure 28.1 assumes that the graph represents the number of flights among cities. You 
can apply the BFS to find the fewest number of flights between two cities. Assume that 
the edges represent the driving distances among the cities as shown in Figure 29.1. How 
do you find the minimal total distances for connecting all cities? How do you find the 
shortest path between two cities? This chapter will address these questions. The former 
is known as the minimum spanning tree (MST) problem  and the latter as the shortest path
problem .
Key
Point
problem
FIGURE 29.1 The graph models the distances among the cities.
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
807
381
1267
2097
1331
1663
496
239
1187
810
661
781
864
888
214
1435
1003
533
599
1260
983
787
1015 Kansas City (4)
Miami (9)
The preceding chapter introduced the concept of graphs. You learned how to represent 
edges using edge arrays, edge lists, adjacency matrices, and adjacency lists, and how to model 
a graph using the Graph interface, the AbstractGraph class, and the UnweightedGraph
class. The preceding chapter also introduced two important techniques for traversing graphs: 
depth-first search and breadth-first search, and applied traversal to solve practical prob-
lems. This chapter will introduce weighted graphs. You will learn the algorithm for finding 
a minimum spanning tree in Section  29.4 and the algorithm for finding shortest paths in 
Section 29.5.
Pedagogical Note
Before we introduce the algorithms and applications for weighted graphs, it is helpful to 
get acquainted with weighted graphs using the GUI interactive tool at www.cs.armstrong
.edu/liang/animation/WeightedGraphLearningTool.html, as shown in Figure  29.2. The tool 
allows you to enter vertices, specify edges and their weights, view the graph, and find 
an MST and all shortest paths from a single source, as shown in Figure 29.2.
weighted graph learning tool 
on Companion Website
```

</details>


## PDF page 1086

<details>
<summary>Page text</summary>

```text
29.2 Representing Weighted Graphs  1063
29.2 Representing Weighted Graphs
Weighted edges can be stored in adjacency lists.
There are two types of weighted graphs: vertex weighted and edge weighted. In a vertex-
weighted graph , each vertex is assigned a weight. In an edge-weighted graph , each edge 
is assigned a weight. Of the two types, edge-weighted graphs have more applications. This 
chapter considers edge-weighted graphs.
Weighted graphs can be represented in the same way as unweighted graphs, except that 
you have to represent the weights on the edges. As with unweighted graphs, the vertices in 
weighted graphs can be stored in an array. This section introduces three representations for 
the edges in weighted graphs.
29.2.1 Representing Weighted Edges: Edge Array
Weighted edges can be represented using a two-dimensional array. For example, you can 
store all the edges in the graph in Figure 29.3a using the array in Figure 29.3b.
Note
Weights can be of any type: Integer, Double, BigDecimal, and so on. You 
can use a two-dimensional array of the Object type to represent weighted edges as 
follows:
Object[][] edges = {
  {new Integer(0), new Integer(1), new SomeTypeForWeight(2)},
  {new Integer(0), new Integer(3), new SomeTypeForWeight(8)},
  ...
};
Key
Point
vertex-weighted graph
edge-weighted graph
FIGURE 29.2 You can use the tool to create a weighted graph with mouse gestures and show the MST and shortest paths.
```

</details>


## PDF page 1087

<details>
<summary>Page text</summary>

```text
1064 Chapter 29  Weighted Graphs and Applications
29.2.2 Weighted Adjacency Matrices
Assume that the graph has n vertices. You can use a two-dimensional n * n matrix, say 
weights, to represent the weights on edges. weights[i][j] represents the weight on 
edge (i,j). If vertices i and j are not connected, weights[i][j] is null. For example, 
the weights in the graph in Figure 29.3a can be represented using an adjacency matrix as 
follows:
Integer[][] adjacencyMatrix = {
  {null, 2, null, 8, null},
  {2, null, 7, 3, null},
  {null, 7, null, 4, 5},
  {8, 3, 4, null, 6},
  {null, null, 5, 6, null}
};
29.2.3 Adjacency Lists
Another way to represent the edges is to define edges as objects. TheAbstractGraph.Edge
class was defined to represent an unweighted edge in Listing 28.3. For weighted edges, we 
define the WeightedEdge class as shown in Listing 29.1.
LISTING 29.1 WeightedEdge.java
 1 public class WeightedEdge extends AbstractGraph.Edge
 2 implements Comparable<WeightedEdge> {
 3 public double weight; // The weight on edge (u, v)
 4
 5 /** Create a weighted edge on (u, v) */
 6 public WeightedEdge(int u, int v, double weight) {
 7 super(u, v);
 8 this.weight = weight;
 9    }
10
11    @Override /** Compare two edges on weights */
12 public int compareTo(WeightedEdge edge) {
13 if (weight > edge.weight) 
14 return 1;
15 else if (weight == edge.weight) 
16 return 0;
17 else
18 return -1;
19    }
20  }
edge weight
constructor
compare edges
012 34
0 null 2 null 8 null
1 2 null 7 3 null
2 null 7 null 4 5
3 8 3 4 null 6
4 null null 5 6 null
FIGURE 29.3 Each edge is assigned a weight in an edge-weighted graph.
(a) (b)
int[][] edges = {{0, 1, 2}, {0, 3, 8},
{1, 0, 2}, {1, 2, 7}, {1, 3, 3},
{2, 1, 7}, {2, 3, 4}, {2, 4, 5},
{3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
{4, 2, 5}, {4, 3, 6}
};
weightvertex
42
7
8
3
6
5
0
1 2
34
```

</details>


## PDF page 1088

<details>
<summary>Page text</summary>

```text
29.3 The WeightedGraph Class 1065
AbstractGraph.Edge is an inner class defined in the AbstractGraph class. It represents 
an edge from vertex u to v. WeightedEdge extends AbstractGraph.Edge with a new 
propertyweight.
To create a WeightedEdge object, use new WeightedEdge(i, j, w) , where w is the 
weight on edge (i,j). Often you need to compare the weights of the edges. For this reason,
theWeightedEdge class implements the Comparable interface.
For unweighted graphs, we use adjacency lists to represent edges. For weighted graphs, we 
still use adjacency lists, the adjacency lists for the vertices in the graph in Figure 29.3a can be 
represented as follows:
java.util.List<WeightedEdge>[] list = new java.util.List[5];
WeightedEdge(0, 1, 2) WeightedEdge(0, 3, 8)
WeightedEdge(1, 0, 2) WeightedEdge(1, 2, 3) WeightedEdge(1, 2, 7)
WeightedEdge(2, 3, 4) WeightedEdge(2, 4, 5) WeightedEdge(2, 1, 7)
WeightedEdge(3, 1, 3) WeightedEdge(3, 2, 4) WeightedEdge(3, 4, 6)
WeightedEdge(4, 2, 5) WeightedEdge(4, 3, 6)
WeightedEdge(3, 0, 8)
list[0]
list[1]
list[2]
list[3]
list[4]
list[i] stores all edges adjacent to vertex i.
For flexibility, we will use an array list rather than a fixed-sized array to represent list
as follows:
List<List<WeightedEdge>> list = new java.util.ArrayList<>();
29.1 For the code WeightedEdge edge = new WeightedEdge(1, 2, 3.5), what is 
edge.u,edge.v, and edge.weight?
29.2 What is the output of the following code?
    List<WeightedEdge> list = new ArrayList<>();
    list.add(new WeightedEdge(1, 2, 3.5));
    list.add(new WeightedEdge(2, 3, 4.5));
    WeightedEdge e = java.util.Collections.max(list);
    System.out.println(e.u);
    System.out.println(e.v);
    System.out.println(e.weight);
29.3 The WeightedGraph Class
TheWeightedGraph class extends AbstractGraph.
The preceding chapter designed the Graph interface, the AbstractGraph class, and 
the UnweightedGraph class for modeling graphs. Following this pattern, we design 
WeightedGraph as a subclass of AbstractGraph, as shown in Figure 29.4.
WeightedGraph simply extends AbstractGraph with five constructors for creating con-
creteWeightedGraph instances. WeightedGraph inherits all methods from AbstractGraph,
overrides the clear and addVertex methods, implements a new addEdge  method for add-
ing a weighted edge, and also introduces new methods for obtaining minimum spanning trees 
and for finding all single-source shortest paths. Minimum spanning trees and shortest paths will 
be introduced in Sections 29.4 and  29.5, respectively.
Listing 29.2 implements WeightedGraph. Edge adjacency lists (lines 38–63) are used 
internally to store adjacent edges for a vertex. When a WeightedGraph is constructed, its edge 
✓Point✓
Check
Key
Point
```

</details>


## PDF page 1089

<details>
<summary>Page text</summary>

```text
1066 Chapter 29  Weighted Graphs and Applications
adjacency lists are created (lines 47 and 57). The methods getMinimumSpanningTree()
(lines 99–138) and getShortestPath() (lines 156–197) will be introduced in upcoming 
sections.
LISTING 29.2 WeightedGraph.java
  1 import java.util.*;
  2
  3 public class WeightedGraph<V> extends AbstractGraph<V> {
  4 /** Construct an empty */
  5 public WeightedGraph() {
  6    }
  7
  8 /** Construct a WeightedGraph from vertices and edged in arrays */
  9 public WeightedGraph(V[] vertices, int[][] edges) {
 10      createWeightedGraph(java.util.Arrays.asList(vertices), edges);
 11    }
 12
 13 /** Construct a WeightedGraph from vertices and edges in list */
 14 public WeightedGraph(int[][] edges, int numberOfVertices) {
 15      List<V> vertices = new ArrayList<>();
 16 for (int i = 0; i < numberOfVertices; i++)
 17        vertices.add((V)(new Integer(i)));
 18
 19      createWeightedGraph(vertices, edges);
 20    }
 21
no-arg constructor
constructor
constructor
FIGURE 29.4 WeightedGraph extends AbstractGraph.
AbstractGraph<V>
WeightedGraph<V>
+WeightedGraph()
+WeightedGraph(vertices: V[], edges: int[][])
+WeightedGraph(vertices: List<V>, edges:
   List<WeightedEdge>)
+WeightedGraph(edges: int[][],
   numberOfVertices: int)
+WeightedGraph(edges: List<WeightedEdge>,
   numberOfVertices: int)
+printWeightedEdges(): void
+getWeight(int u, int v): double
+addEdges(u: int, v: int, weight: double): void
+getMinimumSpanningTree(): MST
+getMinimumSpanningTree(index: int): MST
+getShortestPath(index: int): ShortestPathTree
Constructs an empty graph.
Constructs a weighted graph with the specified edges and the
     number of vertices in arrays.
Constructs a weighted graph with the specified edges and the
     number of vertices.
Constructs a weighted graph with the specified edges in an 
     array and the number of vertices.
Constructs a weighted graph with the specified edges in a list
     and the number of vertices.
Displays all edges and weights.
Returns the weight on the edge from u to v. Throw an
     exception if the edge does not exist.
Adds a weighted edge to the graph and throws an
IllegalArgumentException if u,v,  or w is invalid. If
(u,v)  is already in the graph, the new weight is set.
Returns a minimum spanning tree starting from vertex 0.
Returns a minimum spanning tree starting from vertex v.
Returns all single-source shortest paths. 
«interface»
Graph<V>
```

</details>


## PDF page 1090

<details>
<summary>Page text</summary>

```text
29.3 The WeightedGraph Class 1067
 22 /** Construct a WeightedGraph for vertices 0, 1, 2 and edge list */
 23 public WeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
 24      createWeightedGraph(vertices, edges);
 25    }
 26
 27 /** Construct a WeightedGraph from vertices 0, 1, and edge array */
 28 public WeightedGraph(List<WeightedEdge> edges,
 29 int numberOfVertices) {
 30      List<V> vertices = new ArrayList<>();
 31 for (int i = 0; i < numberOfVertices; i++)
 32        vertices.add((V)(new Integer(i)));
 33
 34      createWeightedGraph(vertices, edges);
 35    }
 36
 37 /** Create adjacency lists from edge arrays */
 38 private void createWeightedGraph(List<V> vertices, int[][] edges) {
 39 this.vertices = vertices;
 40
 41 for (int i = 0; i < vertices.size(); i++) {
 42        neighbors.add(new ArrayList<Edge>());// Create a list for vertices
 43      }
 44
 45 for (int i = 0; i < edges.length; i++) {
 46 neighbors.get(edges[i][ 0]).add(
 47 new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
 48      }
 49    }
 50
 51 /** Create adjacency lists from edge lists */
 52 private void createWeightedGraph(
 53 List<V> vertices, List<WeightedEdge> edges) {
 54 this.vertices = vertices;
 55
 56 for (int i = 0; i < vertices.size(); i++) {
 57 neighbors.add( new ArrayList<Edge>());// Create a list for vertices
 58      }
 59
 60 for (WeightedEdge edge: edges) {
 61 neighbors.get(edge.u).add(edge); // Add an edge into the list
 62      }
 63    }
 64
 65 /** Return the weight on the edge (u, v) */
 66 public double getWeight(int u, int v) throws Exception {
 67 for (Edge edge : neighbors.get(u)) {
 68 if (edge.v == v) {
 69 return ((WeightedEdge)edge).weight;
 70        }
 71      }
 72
 73 throw new Exception("Edge does not exit");
 74    }
 75
 76 /** Display edges with weights */
 77 public void printWeightedEdges() {
 78 for (int i = 0; i < getSize(); i++) {
 79        System.out.print(getVertex(i) + " (" + i + "): ");
 80 for (Edge edge : neighbors.get(i)) {
 81          System.out.print("(" + edge.u +
constructor
constructor
create list for vertices
create a weighted edge
create list for vertices
print edges
get edge weight
```

</details>


## PDF page 1091

<details>
<summary>Page text</summary>

```text
1068 Chapter 29  Weighted Graphs and Applications
 82 ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
 83        }
 84        System.out.println();
 85      }
 86    }
 87
 88 /** Add edges to the weighted graph */
 89 public boolean addEdge(int u, int v, double weight) {
 90 return addEdge(new WeightedEdge(u, v, weight));
 91    }
 92
 93 /** Get a minimum spanning tree rooted at vertex 0 */
 94 public MST getMinimumSpanningTree() {
 95 return getMinimumSpanningTree(0);
 96    }
 97
 98 /** Get a minimum spanning tree rooted at a specified vertex */
 99 public MST getMinimumSpanningTree(int startingVertex) {
100 // cost[v] stores the cost by adding v to the tree
101 double[] cost = new double[getSize()];
102 for (int i = 0; i < cost.length; i++) {
103        cost[i] = Double.POSITIVE_INFINITY; // Initial cost 
104      }
105      cost[startingVertex] = 0; // Cost of source is 0
106
107 int[] parent = new int[getSize()]; // Parent of a vertex
108      parent[startingVertex] = -1; // startingVertex is the root
109 double totalWeight = 0; // Total weight of the tree thus far
110
111 List<Integer> T = new ArrayList<>();
112
113 // Expand T
114 while (T.size() < getSize()) {
115 // Find smallest cost v in V - T 
116 int u = -1; // Vertex to be determined
117 double currentMinCost = Double.POSITIVE_INFINITY;
118 for (int i = 0; i < getSize(); i++) {
119 if (!T.contains(i) && cost[i] < currentMinCost) {
120 currentMinCost = cost[i];
121 u = i;
122          }
123        }
124
125 T.add(u); // Add a new vertex to T
126 totalWeight += cost[u]; // Add cost[u] to the tree
127
128 // Adjust cost[v] for v that is adjacent to u and v in V - T
129 for (Edge e : neighbors.get(u)) {
130 if (!T.contains(e.v) && cost[e.v] > ((WeightedEdge)e).weight) {
131 cost[e.v] = ((WeightedEdge)e).weight;
132 parent[e.v] = u;
133          }
134        }
135      } // End of while
136
137 return new MST(startingVertex, parent, T, totalWeight);
138    }
139
140 /** MST is an inner class in WeightedGraph */
141 public class MST extends Tree {
add edge
get an MST
start from vertex 0
MST from a starting vertex
initialize cost
initialize parent
minimum spanning tree
exapnd MST
update total cost
vertex with smallest coust
add to tree
adjust cost
create an MST
MST inner class
```

</details>


## PDF page 1092

<details>
<summary>Page text</summary>

```text
29.3 The WeightedGraph Class 1069
142 private double totalWeight; // Total weight of all edges in the tree
143
144 public MST(int root, int[] parent, List<Integer> searchOrder,
145 double totalWeight) {
146 super(root, parent, searchOrder);
147 this.totalWeight = totalWeight;
148      }
149
150 public double getTotalWeight() {
151 return totalWeight;
152      }
153    }
154
155 /** Find single source shortest paths */
156 public ShortestPathTree getShortestPath(int sourceVertex) {
157 // cost[v] stores the cost of the path from v to the source
158 double[] cost = newdouble[getSize()];
159 for (int i = 0; i < cost.length; i++) {
160        cost[i] = Double.POSITIVE_INFINITY; // Initial cost set to infinity
161      }
162      cost[sourceVertex] = 0; // Cost of source is 0
163
164 // parent[v] stores the previous vertex of v in the path
165 int[] parent = newint[getSize()];
166      parent[sourceVertex] = -1; // The parent of source is set to -1
167
168 // T stores the vertices whose path found so far
169 List<Integer> T = new ArrayList<>();
170
171 // Expand T
172 while (T.size() < getSize()) {
173 // Find smallest cost v in V - T 
174 int u = -1; // Vertex to be determined
175 double currentMinCost = Double.POSITIVE_INFINITY;
176 for (int i = 0; i < getSize(); i++) {
177 if (!T.contains(i) && cost[i] < currentMinCost) {
178 currentMinCost = cost[i];
179 u = i;
180          }
181        }
182
183 T.add(u); // Add a new vertex to T
184
185 // Adjust cost[v] for v that is adjacent to u and v in V - T
186 for (Edge e : neighbors.get(u)) {
187 if (!T.contains(e.v) 
188              && cost[e.v] > cost[u] + ((WeightedEdge)e).weight) {
189 cost[e.v] = cost[u] + ((WeightedEdge)e).weight;
190 parent[e.v] = u;
191          }
192        }
193      } // End of while
194
195 // Create a ShortestPathTree
196 return new ShortestPathTree(sourceVertex, parent, T, cost);
197    }
198
199 /** ShortestPathTree is an inner class in WeightedGraph */
200 public class ShortestPathTree extends Tree {
201 private double[] cost; // cost[v] is the cost from v to source
total weight in tree
getShortestPath
initialize cost
shortest path tree
expand tree
vertex with smallest cost
add to T
adjust cost 
adjust parent
create a tree
shortest path tree
cost
```

</details>


## PDF page 1093

<details>
<summary>Page text</summary>

```text
1070 Chapter 29  Weighted Graphs and Applications
202
203 /** Construct a path */
204 public ShortestPathTree(int source, int[] parent, 
205          List<Integer> searchOrder, double[] cost) {
206 super(source, parent, searchOrder);
207 this.cost = cost;
208      }
209
210 /** Return the cost for a path from the root to vertex v */
211 public double getCost(int v) {
212 return cost[v];
213      }
214
215 /** Print paths from all vertices to the source */
216 public void printAllPaths() {
217        System.out.println("All shortest paths from " +
218          vertices.get(getRoot()) + " are:");
219 for (int i = 0; i < cost.length; i++) {
220          printPath(i); // Print a path from i to the source
221          System.out.println("(cost: " + cost[i] + ")"); // Path cost
222        }
223      }
224    }
225  }
The WeightedGraph class extends the AbstractGraph class (line 3). The properties
vertices and neighbors in AbstractGraph are inherited in WeightedGraph.
neighbors is a list. Each element is the list is another list that contains edges. For unweighted 
graph, each edge is an instance of AbstractGraph.Edge. For a weighted graph, each edge 
is an instance of WeightedEdge. WeightedEdge is a subtype of Edge. So you can add a 
weighted edge into neighbors.get(i) for a weighted graph (line 47).
Listing 29.3 gives a test program that creates a graph for the one in Figure 29.1 and another 
graph for the one in Figure 29.3a.
LISTING 29.3 TestWeightedGraph.java
 1 public class TestWeightedGraph {
 2 public static void main(String[] args) {
 3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
 4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
 5 "Atlanta", "Miami", "Dallas", "Houston"};
 6
 7 int[][] edges = {
 8        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
 9        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
10        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
11        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
12          {3, 5, 1003},
13        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
14          {4, 8, 864}, {4, 10, 496},
15        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
16          {5, 6, 983}, {5, 7, 787},
17        {6, 5, 983}, {6, 7, 214},
18        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
19        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
20          {8, 10, 781}, {8, 11, 810},
21        {9, 8, 661}, {9, 11, 1187},
22        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
23        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
constructor
get cost
print all paths
vertices
edges
```

</details>


## PDF page 1094

<details>
<summary>Page text</summary>

```text
29.3 The WeightedGraph Class 1071
24      };
25
26 WeightedGraph<String> graph1 =
27 new WeightedGraph<>(vertices, edges);
28      System.out.println("The number of vertices in graph1: "
29        + graph1.getSize());
30      System.out.println("The vertex with index 1 is "
31        + graph1.getVertex(1));
32      System.out.println("The index for Miami is " + 
33        graph1.getIndex("Miami"));
34      System.out.println("The edges for graph1:");
35 graph1.printWeightedEdges();
36
37      edges = new int[][] {
38        {0, 1, 2}, {0, 3, 8},
39        {1, 0, 2}, {1, 2, 7}, {1, 3, 3},
40        {2, 1, 7}, {2, 3, 4}, {2, 4, 5},
41        {3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
42        {4, 2, 5}, {4, 3, 6}
43      };
44 WeightedGraph<Integer> graph2 = new WeightedGraph<>(edges, 5);
45      System.out.println("\nThe edges for graph2:");
46 graph2.printWeightedEdges();
47    }
48  }
create graph
print edges
edges
create graph
print edges
The number of vertices in graph1: 12
The vertex with index 1 is San Francisco
The index for Miami is 9
The edges for graph1:
Vertex 0: (0, 1, 807) (0, 3, 1331) (0, 5, 2097) 
Vertex 1: (1, 2, 381) (1, 0, 807) (1, 3, 1267) 
Vertex 2: (2, 1, 381) (2, 3, 1015) (2, 4, 1663) (2, 10, 1435) 
Vertex 3: (3, 4, 599) (3, 5, 1003) (3, 1, 1267) 
  (3, 0, 1331) (3, 2, 1015) 
Vertex 4: (4, 10, 496) (4, 8, 864) (4, 5, 533) (4, 2, 1663) 
  (4, 7, 1260) (4, 3, 599) 
Vertex 5: (5, 4, 533) (5, 7, 787) (5, 3, 1003) 
  (5, 0, 2097) (5, 6, 983) 
Vertex 6: (6, 7, 214) (6, 5, 983) 
Vertex 7: (7, 6, 214) (7, 8, 888) (7, 5, 787) (7, 4, 1260) 
Vertex 8: (8, 9, 661) (8, 10, 781) (8, 4, 864) 
  (8, 7, 888) (8, 11, 810) 
Vertex 9: (9, 8, 661) (9, 11, 1187) 
Vertex 10: (10, 11, 239) (10, 4, 496) (10, 8, 781) (10, 2, 1435) 
Vertex 11: (11, 10, 239) (11, 9, 1187) (11, 8, 810) 
The edges for graph2:
Vertex 0: (0, 1, 2) (0, 3, 8) 
Vertex 1: (1, 0, 2) (1, 2, 7) (1, 3, 3) 
Vertex 2: (2, 3, 4) (2, 1, 7) (2, 4, 5) 
Vertex 3: (3, 1, 3) (3, 4, 6) (3, 2, 4) (3, 0, 8) 
Vertex 4: (4, 2, 5) (4, 3, 6)
The program creates graph1 for the graph in Figure 29.1 in lines 3–27. The vertices for 
graph1 are defined in lines 3–5. The edges for graph1 are defined in lines 7–24. The edges 
are represented using a two-dimensional array. For each row i in the array, edges[i][0]
and edges[i][1]  indicate that there is an edge from vertex edges[i][0]  to vertex
```

</details>


## PDF page 1095

<details>
<summary>Page text</summary>

```text
1072 Chapter 29  Weighted Graphs and Applications
edges[i][1]  and the weight for the edge is edges[i][2] . For example, { 0, 1, 807}
(line 8) represents the edge from vertex 0 (edges[0][0] ) to vertex 1 (edges[0][1] )
with weight 807 (edges[0][2] ). {0, 5, 2097} (line 8) represents the edge from ver-
tex 0 (edges[2][0] ) to vertex 5 (edges[2][1] ) with weight 2097 (edges[2][2] ). 
Line 35 invokes the printWeightedEdges()  method on graph1 to display all edges 
in graph1.
The program creates the edges for graph2 for the graph in Figure 29.3a in lines 37–44. 
Line 46 invokes the printWeightedEdges() method on graph2 to display all edges in 
graph2.
29.3 If a priority queue is used to store weighted edges, what is the output of the following 
code?
PriorityQueue<WeightedEdge> q = new PriorityQueue<>();
q.offer(new WeightedEdge(1, 2, 3.5));
q.offer(new WeightedEdge(1, 6, 6.5));
q.offer(new WeightedEdge(1, 7, 1.5));
System.out.println(q.poll().weight);
System.out.println(q.poll().weight);
System.out.println(q.poll().weight);
29.4 If a priority queue is used to store weighted edges, what is wrong in the following 
code? Fix it and show the output.
List<PriorityQueue<WeightedEdge>> queues = new ArrayList<>();
queues.get(0).offer(new WeightedEdge(0, 2, 3.5));
queues.get(0).offer(new WeightedEdge(0, 6, 6.5));
queues.get(0).offer(new WeightedEdge(0, 7, 1.5));
queues.get(1).offer(new WeightedEdge(1, 0, 3.5));
queues.get(1).offer(new WeightedEdge(1, 5, 8.5));
queues.get(1).offer(new WeightedEdge(1, 8, 19.5));
System.out.println(queues.get(0).peek()
  .compareTo(queues.get(1).peek()));
29.4 Minimum Spanning Trees
A minimum spanning tree of a graph is a spanning tree with the minimum total 
weights.
A graph may have many spanning trees. Suppose that the edges are weighted. A minimum span-
ning tree has the minimum total weights. For example, the trees in Figures 29.5b, 29.5c, 29.5d are 
spanning trees for the graph in Figure 29.5a. The trees in Figures 29.3c and 29.3d are minimum 
spanning trees.
The problem of finding a minimum spanning tree has many applications. Consider a com-
pany with branches in many cities. The company wants to lease telephone lines to connect all 
the branches together. The phone company charges different amounts of money to connect 
different pairs of cities. There are many ways to connect all branches together. The cheapest 
way is to find a spanning tree with the minimum total rates.
29.4.1 Minimum Spanning Tree Algorithms
How do you find a minimum spanning tree? There are several well-known algorithms for 
doing so. This section introduces Prim’s algorithm. Prim’s algorithm starts with a spanning 
treeT that contains an arbitrary vertex. The algorithm expands the tree by repeatedly adding a 
vertex with the lowest-cost edge incident to a vertex already in the tree. Prim’s algorithm is a 
greedy algorithm, and it is described in Listing 29.4.
✓Point✓
Check
Key
Point
minimum spanning tree
Prim’s algorithm
```

</details>


## PDF page 1096

<details>
<summary>Page text</summary>

```text
29.4 Minimum Spanning Trees  1073
LISTING 29.4 Prim’s Minimum Spanning Tree Algorithm
 Input: A connected undirected weighted G = (V, E) with non-negative weights
 Output: MST (a minimum spanning tree)
 1  MST minimumSpanningTree() {
 2    Let T be a set for the vertices in the spanning tree;
 3    Initially, add the starting vertex to T; 
 4
 5 while (size of T < n) {
 6      Find u in T and v in V – T with the smallest weight 
 7        on the edge (u, v), as shown in Figure 29.6;
 8      Add v to T and set parent[v] = u; 
 9    }
10  }
add initial vertex
more vertices?
find a vertex
add to tree
FIGURE 29.5 The trees in (c) and (d) are minimum spanning trees of the graph in (a).
(d)(c)
(b)(a)
56
10
5
8
7
7
12
7
10
8
8
5
5
10
77 8
5
5
6
7 7 8
5
5
6
7
7 8
FIGURE 29.6 Find a vertex u in T that connects a vertex v in V – T with the smallest weight.
u
v
T
V – T
Vertices already in
the spanning tree
Vertices not currently in
the spanning tree
The algorithm starts by adding the starting vertex into T. It then continuously adds a vertex 
(sayv) from V – T into T.v is the vertex that is adjacent to the vertex in T with the smallest 
weight on the edge. For example, there are five edges connecting vertices in T and V – T as example
```

</details>


## PDF page 1097

<details>
<summary>Page text</summary>

```text
1074 Chapter 29  Weighted Graphs and Applications
shown in Figure 29.6, and ( u, v) is the one with the smallest weight. Consider the graph in 
Figure 29.7. The algorithm adds the vertices to T in this order:
1. Add vertex 0 to T.
2. Add vertex 5 to T, since Edge(5,0,5)  has the smallest weight among all edges inci-
dent to a vertex in T, as shown in Figure 29.7a. The arrow line from 0 to 5 indicates that 
0 is the parent of 5.
3. Add vertex 1 to T, since Edge(1,0,6)  has the smallest weight among all edges inci-
dent to a vertex in T, as shown in Figure 29.7b.
4. Add vertex 6 to T, since Edge(6,1,7)  has the smallest weight among all edges inci-
dent to a vertex in T, as shown in Figure 29.7c.
FIGURE 29.7 The adjacent vertices with the smallest weight are added successively to T.
(b)
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1
(c)
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1
(e)
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1
(f)
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1T
T
T
T
T
T
(a)
5 4
5
12
77 8
6 3
2
0
56
10
8
7
10
8
1
(d)
```

</details>


## PDF page 1098

<details>
<summary>Page text</summary>

```text
29.4 Minimum Spanning Trees  1075
5. Add vertex 2 to T, since Edge(2, 6, 5) has the smallest weight among all edges 
incident to a vertex in T, as shown in Figure 29.7d.
6. Add vertex 4 to T, since Edge(4, 6, 7) has the smallest weight among all edges 
incident to a vertex in T, as shown in Figure 29.7e.
7. Add vertex 3 to T, since Edge(3, 2, 8) has the smallest weight among all edges 
incident to a vertex in T, as shown in Figure 29.7f.
Note
A minimum spanning tree is not unique. For example, both (c) and (d) in Figure 29.5 
are minimum spanning trees for the graph in Figure 29.5a. However, if the weights are 
distinct, the graph has a unique minimum spanning tree.
Note
Assume that the graph is connected and undirected. If a graph is not connected or 
directed, the algorithm will not work. You can modify the algorithm to find a spanning 
forest for any undirected graph. A spanning forest is a graph in which each connected 
component is a tree. 
29.4.2 Refining Prim’s MST Algorithm
To make it easy to identify the next vertex to add into the tree, we use cost[v] to store the 
cost of adding a vertex v to the spanning tree T.  Initially cost[s] is 0 for a starting vertex 
and assign infinity to cost[v] for all other vertices. The algorithm repeatedly finds a vertex 
u in V – T with the smallest cost[u] and moves u to T. The refined version of the alogrithm 
is given in Listing 29.5.
LISTING 29.5 Refined Version of Prim’s Algorithm
Input: A connected undirected weighted G = (V, E) with non-negative weights
Output: a minimum spanning tree with the starting vertex s as the root
 1  MST getMinimumSpanngingTree(s) {
 2    Let T be a set that contains the vertices in the spanning tree; 
 3    Initially T is empty;
 4    Set cost[s] = 0; and cost[v] = infinity for all other vertices in V;
 5
 6 while (size of T < n) {
 7      Find u not in T with the smallest cost[u];
 8      Add u to T;
 9      for (each v not in T and (u, v) in E) 
10        if (cost[v] > w(u, v)) { // Adjust cost[v]
11          cost[v] = w(u, v); parent[v] = u;
12        }
13    }
14  }
29.4.3 Implementation of the MST Algorithm
ThegetMinimumSpanningTree(int v) method is defined in the WeightedGraph class. 
It returns an instance of the MST class, as shown in Figure 29.4. The MST class is defined 
as an inner class in the WeightedGraph class, which extends the Tree class, as shown in 
Figure 29.8. The Tree class was shown in Figure 28.11. The MST class was implemented in 
lines 141–153 in Listing 29.2.
unique tree?
connected and undirected
find next vertex
add a vertex to T
adjust cost[v] 
getMinimumSpanningTree()
```

</details>


## PDF page 1099

<details>
<summary>Page text</summary>

```text
1076 Chapter 29  Weighted Graphs and Applications
The refined version of the Prim’s algoruthm greatly simplifies the implementation. The 
getMinimumSpanningTree method was implemented using the refined version of the 
Prim’s algorithm in lines 99–138 in Listing 29.2. The getMinimumSpanningTree(int
startingVertex) method sets cost[startingVertex] to 0 (line 105) and cost[v] to 
infinity for all other verties (lines 102–104). The parent of startingVertex is set to -1 (line 
108).T is a list that stores the vertices added into the spanning tree (line 111). We use a list for 
T rather than a set in order to record the order of the vertices added to T.
Initially,T is empty. To expand T, the method performs the following operations:
1. Find the vertex u with the smallest cost[u] (lines 118–123 and add it into T (line 125). 
2. After adding u in T, update cost[v] and parent[v] for each v adjacent to u in V-T if 
cost[v] > w(u, v) (lines 129–134).
After a new vertex is added to T,totalWeight is updated (line 126). Once all vertices are 
added to T, an instance of MST is created (line 137). Note that the method will not work if the 
graph is not connected. However, you can modify it to obtain a partial MST.
The MST class extends the Tree class (line 141). To create an instance of MST, pass 
root, parent, T, and totalWeight (lines 144-145). The data fields root, parent,
and searchOrder are defined in the Tree class, which is an inner class defined in 
AbstractGraph.
Note that testing whether a vertex i is in T by invoking T.conatins(i) takes O(n) time, 
sinceT is a list. Therefore, the overall time complexity for this implemention is O(n 3). Inter-
ested readers may see Programming Exercise 29.20 for improving the implementation and 
reduce the complexity to O(n2).
Listing 29.6 gives a test program that displays minimum spanning trees for the graph in 
Figure 29.1 and the graph in Figure 29.3a, respectively.
LISTING 29.6 TestMinimumSpanningTree.java
 1 public class TestMinimumSpanningTree {
 2 public static void main(String[] args) {
 3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
 4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
 5 "Atlanta", "Miami", "Dallas", "Houston"};
 6
 7 int[][] edges = {
 8        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
 9        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
10        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
11        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
time complexity
create vertices
create edges
FIGURE 29.8 TheMST class extends the Tree class.
AbstractGraph.Tree
WeightedGraph.MST
-totalWeight: int 
+MST(root: int, parent: int[], searchOrder:
  List<Integer> totalWeight: int)
+getTotalWeight(): int
Total weight of the tree. 
Constructs an MST with the specified root, parent array, 
searchOrder, and total weight for the tree.
Returns the totalWeight of the tree.
```

</details>


## PDF page 1100

<details>
<summary>Page text</summary>

```text
29.4 Minimum Spanning Trees  1077
12          {3, 5, 1003},
13        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
14          {4, 8, 864}, {4, 10, 496},
15        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
16          {5, 6, 983}, {5, 7, 787},
17        {6, 5, 983}, {6, 7, 214},
18        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
19        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
20          {8, 10, 781}, {8, 11, 810},
21        {9, 8, 661}, {9, 11, 1187},
22        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
23        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
24      };
25
26 WeightedGraph<String> graph1 =
27 new WeightedGraph<>(vertices, edges);
28 WeightedGraph<String>.MST tree1 = graph1.getMinimumSpanningTree();
29      System.out.println("Total weight is " + tree1.getTotalWeight());
30      tree1.printTree();
31
32      edges = new int[][]{
33        {0, 1, 2}, {0, 3, 8},
34        {1, 0, 2}, {1, 2, 7}, {1, 3, 3},
35        {2, 1, 7}, {2, 3, 4}, {2, 4, 5},
36        {3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
37        {4, 2, 5}, {4, 3, 6}
38      };
39
40 WeightedGraph<Integer> graph2 = new WeightedGraph<>(edges, 5);
41 WeightedGraph<Integer>.MST tree2 =
42 graph2.getMinimumSpanningTree( 1);
43      System.out.println("\nTotal weight is " + tree2.getTotalWeight());
44      tree2.printTree();
45    }
46  }
creategraph1
MST for graph1
total weight
print tree
create edges
creategraph2
MST for graph2
total weight
print tree
Total weight is 6513.0
Root is: Seattle
Edges: (Seattle, San Francisco) (San Francisco, Los Angeles) 
  (Los Angeles, Denver) (Denver, Kansas City) (Kansas City, Chicago)
  (New York, Boston) (Chicago, New York) (Dallas, Atlanta) 
  (Atlanta, Miami) (Kansas City, Dallas) (Dallas, Houston) 
Total weight is 14.0
Root is: 1
Edges: (1, 0) (3, 2) (1, 3) (2, 4)
The program creates a weighted graph for Figure  29.1 in line 27. It then invokes 
getMinimumSpanningTree()  (line 28) to return an MST that represents a minimum span-
ning tree for the graph. Invoking printTree() (line 30) on the MST object displays the 
edges in the tree. Note that MST is a subclass of Tree. The printTree() method is defined 
in the Tree class.
The graphical illustration of the minimum spanning tree is shown in Figure 29.9. The ver-
tices are added to the tree in this order: Seattle, San Francisco, Los Angeles, Denver, Kansas 
City, Dallas, Houston, Chicago, New York, Boston, Atlanta, and Miami.
graphical illustration
```

</details>


## PDF page 1101

<details>
<summary>Page text</summary>

```text
1078 Chapter 29  Weighted Graphs and Applications
29.5 Find a minimum spanning tree for the following graph.
✓Point✓
Check
FIGURE 29.9 The edges in a minimum spanning tree for the cities are highlighted.
Seattle
Los Angeles
Denver
Chicago
Houston
Boston
New York
Atlanta
Miami
661
888
1187
810
Dallas
1331
2097
1003
807
381
1015
1267
1663
1435
239
496
781
864
1260
983
787
214
533
599
San Francisco
Kansas City
2
1
3
4
5
7
8
10
11
9
6
5 4
5
2
77 8
6 3
2
0
75
10
2
7
10
8
1
29.6 Is a minimum spanning tree unique if all edges have different weights?
29.7 If you use an adjacency matrix to represent weighted edges, what will be the time 
complexity for Prim’s algorithm?
29.8 What happens to the getMinimumSpanningTree() method in WeightedGraph
if the graph is not connected? Verify your answer by writing a test program that cre-
ates an unconnected graph and invokes the getMinimumSpanningTree() method. 
How do you fix the problem by obtaining a partial MST?
29.5 Finding Shortest Paths
The shortest path between two vertices is a path with the minimum total weights.
Given a graph with nonnegative weights on the edges, a well-known algorithm for finding a 
shortest path between two vertices was discovered by Edsger Dijkstra, a Dutch computer sci-
entist. In order to find a shortest path from vertex s to vertex v, Dijkstra’s algorithm finds the 
Key
Point
shortest path
Dijkstra’s algorithm
```

</details>


## PDF page 1102

<details>
<summary>Page text</summary>

```text
29.5 Finding Shortest Paths  1079
shortest path from s to all vertices. So Dijkstra’s algorithm is known as a single-sourceshortest 
path algorithm. The algorithm uses cost[v] to store the cost of a shortest path from vertex v to 
the source vertex s.cost[s] is 0. Initially assign infinity to cost[v] for all other vertices. The 
algorithm repeatedly finds a vertex u in V – T with the smallest cost[u] and moves u to T.
The algorithm is described in Listing 29.7.
LISTING 29.7 Dijkstra’s Single-Source Shortest-Path 
Algorithm
Input: a graph G = (V, E) with non-negative weights
Output: a shortest path tree with the source vertex s as the root
 1  ShortestPathTree getShortestPath(s) {
 2    Let T be a set that contains the vertices whose 
 3      paths to s are known; Initially T is empty;
 4    Set cost[s] = 0; and cost[v] = infinity for all other vertices in V;
 5
 6 while (size of T < n) {
 7      Find u not in T with the smallest cost[u];
 8      Add u to T;
 9      for (each v not in T and (u, v) in E) 
10        if (cost[v] > cost[u] + w(u, v)) {
11          cost[v] = cost[u] + w(u, v); parent[v] = u;
12        }
13    }
14  }
This algorithm is very similar to Prim’s for finding a minimum spanning tree. Both algorithms 
divide the vertices into two sets: T and V - T. In the case of Prim’s algorithm, set T contains 
the vertices that are already added to the tree. In the case of Dijkstra’s, set T contains the 
vertices whose shortest paths to the source have been found. Both algorithms repeatedly find 
a vertex from V–  T and add it to T. In the case of Prim’s algorithm, the vertex is adjacent 
to some vertex in the set with the minimum weight on the edge. In Dijkstra’s algorithm, the 
vertex is adjacent to some vertex in the set with the minimum total cost to the source.
The algorithm starts by setting cost[s] to 0 (line 4), sets cost[v] to infinity for all other 
vertices. It then continuously adds a vertex (say u) from V – T into T with smallest cost[u]
(lines 7–8), as shown in Figure 29.10a. After adding u to T, the algorithm updates cost[v]
andparent[v] for each v not in T if (u, v) is in T and cost[v] > cost[u] + w(u, v)
(lines 10–11).
single-source shortest path
find next vertex
add a vertex to T
adjust cost[v] 
FIGURE 29.10 (a) Find a vertex u in V – T with the smallest cost[u]. (b) Update cost[v] for v in V – T and v is 
adjacent to u.
s
v1
v2
v3
u
T
V –T
T contains
vertices whose
shortest path to s
are known
V – T contains vertices whose shortest
path to s are not known yet.
s
v1
v2
v3
u
T
V –T
T contains
vertices whose
shortest path to s
are known
V – T contains vertices whose shortest
path to s are not known yet.
(a) Before moving u to T (b) After moving u to T
```

</details>


## PDF page 1103

<details>
<summary>Page text</summary>

```text
1080 Chapter 29  Weighted Graphs and Applications
Let us illustrate Dijkstra’s algorithm using the graph in Figure 29.11a. Suppose the source 
vertex is 1. Therefore, cost[1] = 0 and the costs for all other vertices are initially ∞, as 
shown in Figure 29.11b. We use the parent[i] to denote the parent of i in the path. For 
convenience, set the parent of the source node to -1.
FIGURE 29.11 The algorithm will find all shortest paths from source vertex 1.
0123456
parent
–1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1
0123456
0
cost
/H11009/H11009/H11009 /H11009 /H11009 /H11009
Initially set T is empty. The algorithm selects the vertex with the smallest cost. In this case, 
the vertex is 1. The algorithm adds 1 to T, as shown in Figure 29.12a. Afterwrads, it adjusts 
the cost for each vertex adjacent to 1. The cost for vertices 2, 0, 6, and 3 and their parents are 
now updated, as shown, as shown in Figure 29.12b. 
FIGURE 29.12 Now vertex 1 is in set T.
0123456
parent
–1 111 1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1T
0123456
08
cost
51 0 /H11009/H11009 9
Vertices 2,0,6, and 3 are adjacent to the source vertex, and vertex 2 is the one in V-T
with the smallest cost, so add 2 to T, as shown in Figure 29.13 and update the cost and 
parent for vertices in V-T and adjacent to 2.cost[0] is now updated to 6 and its parent is 
set to 2. The arrow line from 1 to 2 indicates that 1 is the parent of 2 after 2 is added into T.
```

</details>


## PDF page 1104

<details>
<summary>Page text</summary>

```text
29.5 Finding Shortest Paths  1081
NowT contains {1,2}. Vertex 0 is the one in V-T with the smallest cost, so add 0 to T, as 
shown in Figure 29.14 and update the cost and parent for vertices in V-T and adjacent to 0
if applicable. cost[5] is now updated to 10 and its parent is set to 0 and cost[6] is now 
updated to 8 and its parent is set to 0.
FIGURE 29.13 Now vertices 1 and 2 are in set T.
0123456
parent
21 1 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
T 10
8
9
8
8
1
0123456
0
cost
561 0 /H11009/H11009 9
1
FIGURE 29.14 Now vertices {1,2,0} are in set T.
0123456
parent
21 1 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
T 10
8
9
8
8
1
0123456
0
cost
561 0 /H11009 10 8
00
NowT contains {1,2,0}. Vertex 6 is the one in V-T with the smallest cost, so add 6 to T,
as shown in Figure 29.15 and update the cost and parent for vertices in V-T and adjacent to 6
if applicable.
FIGURE 29.15 Now vertices {1,2,0,6} are in set T.
0123456
parent
21 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1T
0123456
0
cost
561 0 /H11009 10 8
010
```

</details>


## PDF page 1105

<details>
<summary>Page text</summary>

```text
1082 Chapter 29  Weighted Graphs and Applications
NowT contains {1,2,0,6}. Vertex 3 or 5 is is the one in V-T with the smallest cost. You 
may add either 3 or 5 into T. Let us add 3 to T, as shown in Figure 29.16 and update the cost 
and parent for vertices in V-T and adjacent to 3 if applicable. cost[4] is now updated to 18
and its parent is set to 3.
FIGURE 29.16 Now vertices {1,2,0,6,3} are in set T.
0123456
parent
21 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1
0123456
0
cost
561 0 1 8 1 0 8
010 3
T
FIGURE 29.17 Now vertices {1,2,0,6,3,5} are in set T.
0123456
parent
21 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1T
0123456
0
cost
561 0 1 5 1 08
010 5
NowT contains {1,2,0,6,3}. Vertex 5 is the one in V-T with the smallest cost, so add 5
toT, as shown in Figure 29.17 and update the cost and parent for vertices in V-T and adjacent 
to5 if applicable. cost[4] is now updated to 10 and its parent is set to 5.
NowT contains {1,2,0,6,3,5}. Vertex 4 is the one in V-T with the smallest cost, so add 
4 to T, as shown in Figure 29.18. 
As you can see, the algorithm essentially finds all shortest paths from a source ver-
tex, which produces a tree rooted at the source vertex. We call this tree a single-source 
all-shortest-path tree  (or simply a shortest-path tree ). To model this tree, define a class 
named ShortestPathTree  that extends the Tree class, as shown in Figure  29.19. 
ShortestPathTree  is defined as an inner class in WeightedGraph  in lines 200–224 
in Listing 29.2.
ThegetShortestPath(int sourceVertex) method was implemented in lines 156–197 
in Listing 29.2. The method sets cost[sourceVertex] to 0  (line 162) and cost[v] to 
shortest-path tree
```

</details>


## PDF page 1106

<details>
<summary>Page text</summary>

```text
29.5 Finding Shortest Paths  1083
infinity for all other vertices (lines 159–161). The parent of sourceVertex is set to -1
(line 166). T is a list that stores the vertices added into the shortest path tree (line 169). We use 
a list for T rather than a set in order to record the order of the vertices added to T.
Initially,T is empty. To expand T, the method performs the following operations:
1. Find the vertex u with the smallest cost[u] (lines 175–181) and add it into T (line 183). 
2. After adding u in T, update cost[v] and parent[v] for each v adjacent to u in V-T if 
cost[v] > cost[u] + w(u, v) (lines 186–192).
Once all vertices from s are added to T, an instance of ShortestPathTree  is created 
(line 196). 
The ShortestPathTree class extends the Tree class (line 200). To create an instance 
of ShortestPathTree, pass sourceVertex, parent, T, and cost (lines 204–205). 
sourceVertex becomes the root in the tree. The data fields root,parent, and searchOrder
are defined in the Tree class, which is an inner class defined in AbstractGraph.
Note that testing whether a vertex i is in T by invoking T.conatins(i) takes O(n) time, 
sinceT is a list. Therefore, the overall time complexity for this implemention is O(n3). Inter-
ested readers may see Programming Exercise 29.20 for improving the implementation and 
reducing the complexity to O(n2).
Dijkstra’s algorithm is a combination of a greedy algorithm and dynamic programming. It 
is a greedy algorithm in the sense that it always adds a new vertex that has the shortest distance 
to the source. It stores the shortest distance of each known vertex to the source and uses it 
later to avoid redundant computing, so Dijkstra’s algorithm also uses dynamic programming.
ShortestPathTree class
Dijkstra’s algorithm time 
complexity
greedy and dynamic 
programming
FIGURE 29.19 WeightedGraph.ShortestPathTree extends AbstractGraph.Tree.
WeightedGraph.ShortestPathTree
-cost: int[]
+ShortestPathTree(source: int, parent: int[],
searchOrder: List<Integer>, cost: int[])
+getCost(v: int): int
+printAllPaths(): void
cost[v] stores the cost for the path from the source to v.
Constructs a shortest path tree with the specified source,
parent array, searchOrder, and cost array.
Returns the cost for the path from the source to vertex v.
Displays all paths from the source.
AbstractGraph.Tree
FIGURE 29.18 Now vertices {1,2,6,0,3,5,4} are in set T.
0123456
parent
21 –1
(b)(a)
0 5
1
4
72 5
6 4
3
2
55
10
8
9
8
8
1T
0123456
0
cost
561 0 1 5 1 08
010 5
```

</details>


## PDF page 1107

<details>
<summary>Page text</summary>

```text
1084 Chapter 29  Weighted Graphs and Applications
Pedagogical Note
Go to www.cs.armstrong.edu/liang/animation/ShortestPathAnimation.html to use a GUI inter-
active program to find a shortest path between any two cities, as shown in Figure 29.20.shortest path animation on 
Companion Website
FIGURE 29.20  The animation tool displays a shortest path between two cities.
Listing 29.8 gives a test program that displays the shortest paths from Chicago to all other 
cities in Figure  29.1 and the shortest paths from vertex 3 to all vertices for the graph in 
Figure 29.3a, respectively.
LISTING 29.8 TestShortestPath.java
  1 public class TestShortestPath {
  2 public static void main(String[] args) {
  3      String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
  4 "Denver", "Kansas City", "Chicago", "Boston", "New York",
  5 "Atlanta", "Miami", "Dallas", "Houston"};
  6
  7 int[][] edges = {
  8        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
  9        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
 10        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
 11        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
 12          {3, 5, 1003},
 13        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
 14          {4, 8, 864}, {4, 10, 496},
 15        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
 16          {5, 6, 983}, {5, 7, 787},
 17        {6, 5, 983}, {6, 7, 214},
 18        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
 19        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
 20          {8, 10, 781}, {8, 11, 810},
 21        {9, 8, 661}, {9, 11, 1187},
vertices
edges
```

</details>


## PDF page 1108

<details>
<summary>Page text</summary>

```text
29.5 Finding Shortest Paths  1085
 22        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
 23        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
 24      };
 25
 26 WeightedGraph<String> graph1 =
 27 new WeightedGraph<>(vertices, edges);
 28 WeightedGraph<String>.ShortestPathTree tree1 =
 29 graph1.getShortestPath(graph1.getIndex( "Chicago"));
 30      tree1.printAllPaths();
 31
 32 // Display shortest paths from Houston to Chicago
 33      System.out.print("Shortest path from Houston to Chicago: ");
 34      java.util.List<String> path 
 35        = tree1.getPath(graph1.getIndex("Houston"));
 36 for (String s: path) {
 37        System.out.print(s + " ");
 38      }
 39
 40      edges = new int[][] {
 41        {0, 1, 2}, {0, 3, 8},
 42        {1, 0, 2}, {1, 2, 7}, {1, 3, 3},
 43        {2, 1, 7}, {2, 3, 4}, {2, 4, 5},
 44        {3, 0, 8}, {3, 1, 3}, {3, 2, 4}, {3, 4, 6},
 45        {4, 2, 5}, {4, 3, 6}
 46      };
 47 WeightedGraph<Integer> graph2 = new WeightedGraph<>(edges, 5);
 48 WeightedGraph<Integer>.ShortestPathTree tree2 =
 49 graph2.getShortestPath( 3);
 50      System.out.println("\n");
 51      tree2.printAllPaths();
 52    }
 53  }
creategraph1
shortest path
create edges
creategraph2
print paths
All shortest paths from Chicago are:
A path from Chicago to Seattle: Chicago Seattle (cost: 2097.0)
A path from Chicago to San Francisco: 
  Chicago Denver San Francisco (cost: 2270.0)
A path from Chicago to Los Angeles: 
  Chicago Denver Los Angeles (cost: 2018.0)
A path from Chicago to Denver: Chicago Denver (cost: 1003.0)
A path from Chicago to Kansas City: Chicago Kansas City (cost: 533.0)
A path from Chicago to Chicago: Chicago (cost: 0.0)
A path from Chicago to Boston: Chicago Boston (cost: 983.0)
A path from Chicago to New York: Chicago New York (cost: 787.0)
A path from Chicago to Atlanta: 
  Chicago Kansas City Atlanta (cost: 1397.0)
A path from Chicago to Miami: 
  Chicago Kansas City Atlanta Miami (cost: 2058.0)
A path from Chicago to Dallas: Chicago Kansas City Dallas (cost: 1029.0)
A path from Chicago to Houston: 
  Chicago Kansas City Dallas Houston (cost: 1268.0)
Shortest path from Houston to Chicago: 
  Houston Dallas Kansas City Chicago 
All shortest paths from 3 are:
A path from 3 to 0: 3 1 0 (cost: 5.0)
A path from 3 to 1: 3 1 (cost: 3.0)
A path from 3 to 2: 3 2 (cost: 4.0)
A path from 3 to 3: 3 (cost: 0.0)
A path from 3 to 4: 3 4 (cost: 6.0)
```

</details>


## PDF page 1109

<details>
<summary>Page text</summary>

```text
1086 Chapter 29  Weighted Graphs and Applications
The program creates a weighted graph for Figure  29.1 in line 27. It then invokes the 
getShortestPath(graph1.getIndex("Chicago")) method to return a Path
object that contains all shortest paths from Chicago. Invoking printAllPaths() on the 
ShortestPathTree object displays all the paths (line 30).
The graphical illustration of all shortest paths from Chicago is shown in Figure 29.21. The 
shortest paths from Chicago to the cities are found in this order: Kansas City, New York, 
Boston, Denver, Dallas, Houston, Atlanta, Los Angeles, Miami, Seattle, and San Francisco.
FIGURE 29.21 The shortest paths from Chicago to all other cities are highlighted.
Seattle
San Francisco
Los Angeles
Denver
Chicago
Kansas City
Houston
Boston
New York
Atlanta
Miami
661
888
1187
810
Dallas
1331
2097
1003807
381
1015
1267
1663
1435
239
496
781
864
1260
983
787
214
533
599
1
2
3
4
6
7
8
9
11
10
5
29.9 Trace Dijkstra’s algorithm for finding shortest paths from Boston to all other cities in 
Figure 29.1.
29.10 Is a shortest path between two vertices unique if all edges have different weights?
29.11 If you use an adjacency matrix to represent weighted edges, what would be the time 
complexity for Dijkstra’s algorithm?
29.12 What happens to the getShortestPath() method in WeightedGraph if the source 
vertex cannot reach all vertieces in the graph? Verify your answer by writing a test 
program that creates an unconnected graph and invoke the getShortestPath()
method. How do you fix the problem by obtaining a partial shortest path tree?
29.13 If there is no path from vertex v to the source vertex, what will be cost[v]?
29.14 Assume that the graph is connected; will the getShortestPath method find the 
shortest paths correctly if lines 159–161 in WeightedGraph are deleted?
29.6 Case Study: The Weighted Nine Tails Problem
The weighted nine tails problem can be reduced to the weighted shortest path problem.
Section 28.10 presented the nine tails problem and solved it using the BFS algorithm. This 
section presents a variation of the problem and solves it using the shortest-path algorithm.
✓Point✓
Check
Key
Point
```

</details>


## PDF page 1110

<details>
<summary>Page text</summary>

```text
29.6 Case Study: The Weighted Nine Tails Problem  1087
The nine tails problem is to find the minimum number of the moves that lead to all coins 
facing down. Each move flips a head coin and its neighbors. The weighted nine tails problem 
assigns the number of flips as a weight on each move. For example, you can change the coins 
in Figure 29.22a to those in Figure 29.22b by flipping the first coin in the first row and its two 
neighbors. Thus, the weight for this move is 3. You can change the coins in Figure 29.22c to 
Figure 29.22d by flipping the center coin and its four neighbors. So the weight for this move is 5.
FIGURE 29.22 The weight for each move is the number of flips for the move.
H
TTT
HH
HHH
(a)
T
HT T
TH
HHH
(b)
T
HHT
TH
HHH
(c)
T
TTH
HH
HT H
(d)
The weighted nine tails problem can be reduced to finding a shortest path from a starting 
node to the target node in an edge-weighted graph. The graph has 512 nodes. Create an edge 
from node v to u if there is a move from node u to node v. Assign the number of flips to be 
the weight of the edge.
Recall that in Section 28.10 we defined a class NineTailModel for modeling the nine 
tails problem. We now define a new class named WeightedNineTailModel that extends 
NineTailModel, as shown in Figure 29.23.
FIGURE 29.23 TheWeightedNineTailModel class extends NineTailModel.
WeightedNineTailModel
+WeightedNineTailModel() Constructs a model for the weighted nine tails problem
     and obtains a ShortestPathTree rooted from the target
     node.
NineTailModel
#tree: AbstractGraph<Integer>.Tree A tree rooted at node 511.
+NineTailModel() Constructs a model for the nine tails problem and obtains the
     tree.
+getShortestPath(nodeIndex: int):
  List<Integer>
Returns a path from the specified node to the root. The path
     returned consists of the node labels in a list.
Returns a list of Edge objects for the graph.
Flips the node at the specified position and returns the index
     of the flipped node.
Returns a node consisting of nine characters of H’s and T’s.
Returns the index of the specified node.
Flips the node at the specified row and column.
Displays the node to the console.
+getNumberOfFlips(u: int): int Returns the number of flips from node u to the target
     node 511.
-getNumberOfFlips(u: int, v: int): int Returns the number of different cells between the two
     nodes.
-getEdges(): List<WeightedEdge> Gets the weighted edges for the weighted nine tail
     problem.
-getEdges():
  List<AbstractGraph.Edge>
+getNode(index: int): char[]
+getIndex(node: char[]): int
+getFlippedNode(node: char[],
  position: int): int
+flipACell(node: char[], row: int,
  column: int): void
+printNode(node: char[]): void
```

</details>


## PDF page 1111

<details>
<summary>Page text</summary>

```text
1088 Chapter 29  Weighted Graphs and Applications
TheNineTailModel class creates a Graph and obtains a Tree rooted at the target node 
511. WeightedNineTailModel is the same as NineTailModel except that it creates a 
WeightedGraph and obtains a ShortestPathTree rooted at the target node 511.Weight-
edNineTailModel extends NineTailModel. The method getEdges() finds all edges in 
the graph. The getNumberOfFlips(int u, int v)  method returns the number of flips 
from node u to node v. The getNumberOfFlips(int u) method returns the number of flips 
from node u to the target node. 
Listing 29.9 implements WeightedNineTailModel.
LISTING 29.9 WeightedNineTailModel.java
 1 import java.util.*;
 2
 3 public class WeightedNineTailModel extends NineTailModel {
 4 /** Construct a model */
 5 public WeightedNineTailModel() {
 6 // Create edges
 7 List<WeightedEdge> edges = getEdges();
 8
 9 // Create a graph
10 WeightedGraph<Integer> graph = new WeightedGraph<>(
11 edges, NUMBER_OF_NODES);
12
13 // Obtain a shortest path tree rooted at the target node
14 tree = graph.getShortestPath( 511);
15    }
16
17 /** Create all edges for the graph */
18 private List<WeightedEdge> getEdges() {
19 // Store edges
20      List<WeightedEdge> edges = new ArrayList<>(); 
21
22 for (int u = 0; u < NUMBER_OF_NODES; u++) {
23 for (int k = 0; k < 9; k++) {
24 char[] node = getNode(u); // Get the node for vertex u
25 if (node[k] == ’H’) {
26 int v = getFlippedNode(node, k);
27 int numberOfFlips = getNumberOfFlips(u, v);
28
29 // Add edge (v, u) for a legal move from node u to node v
30            edges.add(new WeightedEdge(v, u, numberOfFlips));
31          }
32        }
33      }
34
35 return edges;
36    }
37
38 private static int getNumberOfFlips(int u, int v) {
39 char[] node1 = getNode(u);
40 char[] node2 = getNode(v);
41
42 int count = 0; // Count the number of different cells
43 for (int i = 0; i < node1.length; i++)
44 if (node1[i] != node2[i]) count++;
45
46 return count;
47    }
48
extendsNineTailModel
constructor
get edges
create a graph
get a tree
get weighted edges
get adjacent node
weight
add an edge
number of flips
```

</details>


## PDF page 1112

<details>
<summary>Page text</summary>

```text
29.6 Case Study: The Weighted Nine Tails Problem  1089
49 public int getNumberOfFlips(int u) {
50 return (int)((WeightedGraph<Integer>.ShortestPathTree)tree)
51        .getCost(u);
52    }
53  }
WeightedNineTailModel extends NineTailModel to build a WeightedGraph to model 
the weighted nine tails problem (lines 10–11). For each node u, the getEdges() method 
finds a flipped node v and assigns the number of flips as the weight for edge (v,u) (line 30). 
ThegetNumberOfFlips(int u, int v) method returns the number of flips from node u
to node v (lines 38–47). The number of flips is the number of the different cells between the 
two nodes (line 44).
The WeightedNineTailModel obtains a ShortestPathTree rooted at the target 
node511 (line 14). Note that tree is a protected data field defined in NineTailModel and 
ShortestPathTree is a subclass of Tree. The methods defined in NineTailModel use 
thetree property.
ThegetNumberOfFlips(int u) method (lines 49–52) returns the number of flips from 
nodeu to the target node, which is the cost of the path from node u to the target node. This cost 
can be obtained by invoking the getCost(u) method defined in the ShortestPathTree
class (line 51).
Listing 29.10 gives a program that prompts the user to enter an initial node and displays the 
minimum number of flips to reach the target node.
LISTING 29.10 WeightedNineTail.java
 1 import java.util.Scanner;
 2
 3 public class WeightedNineTail {
 4 public static void main(String[] args) {
 5 // Prompt the user to enter the nine coins’ Hs and Ts
 6      System.out.print("Enter an initial nine coins’ Hs and Ts: ");
 7      Scanner input = new Scanner(System.in);
 8      String s = input.nextLine(); 
 9 char[] initialNode = s.toCharArray();
10
11 WeightedNineTailModel model = new WeightedNineTailModel();
12      java.util.List<Integer> path =
13 model.getShortestPath(NineTailModel.getIndex(initialNode));
14
15      System.out.println("The steps to flip the coins are ");
16 for (int i = 0; i < path.size(); i++)
17        NineTailModel.printNode(NineTailModel.getNode(path.get(i)));    
18
19      System.out.println("The number of flips is " + 
20 model.getNumberOfFlips(NineTailModel.getIndex(initialNode)));
21    }
22  }
total number of flips
initial node
create model
get shortest path
print node
number of flips
Enter an initial nine coins Hs and Ts: HHHTTTHHH
The steps to flip the coins are 
HHH
TTT
HHH
```

</details>


## PDF page 1113

<details>
<summary>Page text</summary>

```text
1090 Chapter 29  Weighted Graphs and Applications
The program prompts the user to enter an initial node with nine letters with a combination of 
Hs and Ts as a string in line 8, obtains an array of characters from the string (line 9), creates a 
model (line 11), obtains the shortest path from the initial node to the target node (lines 12–13), 
displays the nodes in the path (lines 16–17), and invokes getNumberOfFlips to get the 
number of flips needed to reach the target node (line 20).
29.15 Why is the tree data field in NineTailModel in Listing 28.13 defined protected?
29.16 How are the nodes created for the graph in WeightedNineTailModel?
29.17 How are the edges created for the graph in WeightedNineTailModel?
✓Point✓
Check
KEY TERMS
Dijkstra’s algorithm 1078
edge-weighted graph 1063
minimum spanning tree 1072
Prim’s algorithm 1072
shortest path 1078
single-source shortest path 1079
vertex-weighted graph 1063
HHH
THT
TTT
TTT
TTT
TTT
The number of flips is 8 
CHAPTER SUMMARY
1. You can use adjacency matrices or lists to store weighted edges in graphs.
2. A spanning tree of a graph is a subgraph that is a tree and connects all vertices in the graph.
3. Prim’s algorithm for finding a minimum spanning tree works as follows: the algorithm starts 
with a spanning tree that contains an arbitrary vertex. The algorithm expands the tree by 
adding a vertex with the minimum-weight edge incident to a vertex already in the tree.
4. Dijkstra’s algorithm starts search from the source vertex and keeps finding vertices that have 
the shortest path to the source until all vertices are found.
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
*29.1 (Kruskal’s algorithm) The text introduced Prim’s algorithm for finding a mini-
mum spanning tree. Kruskal’s algorithm is another well-known algorithm for 
finding a minimum spanning tree. The algorithm repeatedly finds a minimum-
weight edge and adds it to the tree if it does not cause a cycle. The process ends
```

</details>


## PDF page 1114

<details>
<summary>Page text</summary>

```text
Programming Exercises  1091
when all vertices are in the tree. Design and implement an algorithm for finding 
an MST using Kruskal’s algorithm.
*29.2 (Implement Prim’s algorithm using an adjacency matrix) The text implements 
Prim’s algorithm using lists for adjacent edges. Implement the algorithm using 
an adjacency matrix for weighted graphs. 
*29.3 (Implement Dijkstra’s algorithm using an adjacency matrix ) The text imple-
ments Dijkstra’s algorithm using lists for adjacent edges. Implement the algo-
rithm using an adjacency matrix for weighted graphs. 
*29.4 (Modify weight in the nine tails problem ) In the text, we assign the number of 
the flips as the weight for each move. Assuming that the weight is three times 
of the number of flips, revise the program. 
*29.5 (Prove or disprove ) The conjecture is that both NineTailModel and 
WeightedNineTailModel result in the same shortest path. Write a program to 
prove or disprove it. (Hint: Let tree1 and tree2 denote the trees rooted at node 
511 obtained from NineTailModel and WeightedNineTailModel, respec-
tively. If the depth of a node u is the same in tree1 and in tree2, the length of 
the path from u to the target is the same.) 
**29.6 (Weighted 4 * 4 16 tails model ) The weighted nine tails problem in the text 
uses a 3 * 3 matrix. Assume that you have 16 coins placed in a 4 * 4 matrix. 
Create a new model class named WeightedTailModel16. Create an instance 
of the model and save the object into a file named WeightedTailModel16.dat.
**29.7 (Weighted 4 * 4 16 tails) Revise Listing 29.9, WeightedNineTail.java, for the 
weighted 4 * 4 16 tails problem. Your program should read the model object 
created from the preceding exercise. 
**29.8 (Traveling salesperson problem ) The traveling salesperson problem (TSP) is 
to find a shortest round-trip route that visits each city exactly once and then 
returns to the starting city. The problem is equivalent to finding a shortest 
Hamiltonian cycle in Programming Exercise 28.17. Add the following method 
in the WeightedGraph class:
// Return a shortest cycle
// Return null if no such cycle exists
public List<Integer> getShortestHamiltonianCycle()
*29.9 (Find a minimum spanning tree) Write a program that reads a connected graph 
from a file and displays its minimum spanning tree. The first line in the file 
contains a number that indicates the number of vertices ( n). The vertices are 
labeled as 0,1, ..., n-1. Each subsequent line describes the edges in the form 
ofu1, v1, w1 | u2, v2, w2 | ... . Each triplet in this form describes 
an edge and its weight. Figure 29.24 shows an example of the file for the cor-
responding graph. Note that we assume the graph is undirected. If the graph has 
FIGURE 29.24 The vertices and edges of a weighted graph can be stored in a file.
(a) (b)
0 100
40
5
9
2
4
1
32 0
25
3
5
File
6
0, 1, 100 | 0, 2, 3
1, 3, 20
2, 3, 40 | 2, 4, 2
3, 4, 5 | 3, 5, 5
4, 5, 9
```

</details>


## PDF page 1115

<details>
<summary>Page text</summary>

```text
1092 Chapter 29  Weighted Graphs and Applications
an edge (u, v), it also has an edge ( v, u). Only one edge is represented in the 
file. When you construct a graph, both edges need to be added.
  Your program should prompt the user to enter the name of the file, read data from the 
file, create an instance g of WeightedGraph, invoke g.printWeightedEdges()
to display all edges, invoke getMinimumSpanningTree() to obtain an instance 
tree of WeightedGraph.MST, invoke tree.getTotalWeight() to display the 
weight of the minimum spanning tree, and invoke tree.printTree() to display 
the tree. Here is a sample run of the program:
Enter a file name: c:\exercise\WeightedGraphSample.txt
The number of vertices is 6
Vertex 0: (0, 2, 3) (0, 1, 100) 
Vertex 1: (1, 3, 20) (1, 0, 100) 
Vertex 2: (2, 4, 2) (2, 3, 40) (2, 0, 3) 
Vertex 3: (3, 4, 5) (3, 5, 5) (3, 1, 20) (3, 2, 40) 
Vertex 4: (4, 2, 2) (4, 3, 5) (4, 5, 9) 
Vertex 5: (5, 3, 5) (5, 4, 9) 
Total weight in MST is 35
Root is: 0
Edges: (3, 1) (0, 2) (4, 3) (2, 4) (3, 5)
12
0, 1, 807 | 0, 3, 1331 | 0, 5, 2097
1, 2, 381 | 1, 3, 1267
2, 3, 1015 | 2, 4, 1663 | 2, 10, 1435
3, 4, 599 | 3, 5, 1003
4, 5, 533 | 4, 7, 1260 | 4, 8, 864 | 4, 10, 496
5, 6, 983 | 5, 7, 787
6, 7, 214
7, 8, 888
8, 9, 661 | 8, 10, 781 | 8, 11, 810
9, 11, 1187
10, 11, 239 
  ( Hint: Use new WeightedGraph(list, numberOfVertices)  to create 
a graph, where list contains a list of WeightedEdge objects. Use new 
WeightedEdge(u, v, w) to create an edge. Read the first line to get the number 
of vertices. Read each subsequent line into a string s and use s.split("[\\|]")
to extract the triplets. For each triplet, use triplet.split("[,]") to extract 
vertices and weight.)
*29.10 (Create a file for a graph ) Modify Listing 29.3, TestWeightedGraph.java, 
to create a file for representing graph1. The file format is described in 
Programming Exercise 29.9. Create the file from the array defined in lines 7–24 
in Listing 29.3. The number of vertices for the graph is 12, which will be stored 
in the first line of the file. An edge (u,v) is stored if u < v. The contents of the 
file should be as follows:
*29.11 (Find shortest paths) Write a program that reads a connected graph from a file. 
The graph is stored in a file using the same format specified in Programming
Exercise 29.9. Your program should prompt the user to enter the name of 
the file then two vertices, and should display a shortest path between the two
```

</details>


## PDF page 1116

<details>
<summary>Page text</summary>

```text
Programming Exercises  1093
vertices. For example, for the graph in Figure 29.23, a shortest path between 0
and1 can be displayed as 0 2 4 3 1.
  Here is a sample run of the program:
Enter a file name: WeightedGraphSample2.txt
Enter two vertices (integer indexes): 0 1
The number of vertices is 6
Vertex 0: (0, 2, 3) (0, 1, 100) 
Vertex 1: (1, 3, 20) (1, 0, 100) 
Vertex 2: (2, 4, 2) (2, 3, 40) (2, 0, 3) 
Vertex 3: (3, 4, 5) (3, 5, 5) (3, 1, 20) (3, 2, 40) 
Vertex 4: (4, 2, 2) (4, 3, 5) (4, 5, 9) 
Vertex 5: (5, 3, 5) (5, 4, 9) 
A path from 0 to 1: 0 2 4 3 1
*29.12 (Display weighted graphs ) Revise GraphView in Listing 28.6 to display a 
weighted graph. Write a program that displays the graph in Figure  29.1 as 
shown in Figure 29.25. (Instructors may ask students to expand this program 
by adding new cities with appropriate edges into the graph).
FIGURE 29.25 Programming Exercise 29.12 displays a weighted graph. 
*29.13 (Display shortest paths ) Revise GraphView in Listing 28.6 to display  a 
weighted graph and a shortest path between the two specified cities, as shown 
in Figure 29.19. You need to add a data field path in GraphView. If a path
is not null, the edges in the path are displayed in red. If a city not in the map is 
entered, the program displays a text to alert the user.
*29.14 (Display a minimum spanning tree ) Revise GraphView in Listing 28.6 
to display  a weighted graph and a minimum spanning tree for the graph in 
Figure 29.1, as shown in Figure 29.26. The edges in the MST are shown in red.
***29.15 (Dynamic graphs) Write a program that lets the users create a weighted graph 
dynamically. The user can create a vertex by entering its name and location, as 
shown in Figure 29.27. The user can also create an edge to connect two verti-
ces. To simplify the program, assume that vertex names are the same as vertex
```

</details>


## PDF page 1117

<details>
<summary>Page text</summary>

```text
1094 Chapter 29  Weighted Graphs and Applications
indices. You have to add the vertex indices 0,1, . . ., and n, in this order. The user 
can specify two vertices and let the program display their shortest path in red.
***29.16 (Display a dynamic MST) Write a program that lets the user create a weighted 
graph dynamically. The user can create a vertex by entering its name and loca-
tion, as shown in Figure 29.28. The user can also create an edge to connect two 
vertices. To simplify the program, assume that vertex names are the same as 
those of vertex indices. You have to add the vertex indices 0,1, . . ., and n, in 
this order. The edges in the MST are displayed in red. As new edges are added, 
the MST is redisplayed.
***29.17 (Weighted graph visualization tool ) Develop a GUI program as shown in 
Figure 29.2, with the following requirements: (1) The radius of each vertex is 
20 pixels. (2) The user clicks the left mouse button to place a vertex centered 
at the mouse point, provided that the mouse point is not inside or too close to 
an existing vertex. (3) The user clicks the right mouse button inside an exist-
ing vertex to remove the vertex. (4) The user presses a mouse button inside 
a vertex and drags to another vertex and then releases the button to create an 
FIGURE 29.26 Programming Exercise 29.14 displays an MST.
FIGURE 29.27 The program can add vertices and edges and display a shortest path between 
two specified vertices.
```

</details>


## PDF page 1118

<details>
<summary>Page text</summary>

```text
Programming Exercises  1095
edge, and the distance between the two vertices is also displayed. (5) The user 
drags a vertex while pressing the CTRL key to move a vertex. (6) The verti-
ces are numbers starting from 0. When a vertex is removed, the vertices are 
renumbered. (7) You can click the Show MST or Show All SP From the Source
button to display an MST or SP tree from a starting vertex. (8) You can click 
the Show Shortest Path  button to display the shortest path between the two 
specified vertices.
***29.18 (Alternative version of Dijkstra algorithm) An alternative version of the Dijk-
stra algorithm can be described as follows:
Input: a weighted graph G = (V, E) with non-negative weights
Output: A shortest path tree from a source vertex s
 1  ShortestPathTree getShortestPath(s) {
 2    Let T be a set that contains the vertices whose 
 3      paths to s are known;
 4    Initially T contains source vertex s with cost[s] = 0;
 5    for (each u in V – T) 
 6       cost[u] = infinity;
 7
 8 while (size of T < n) {
 9      Find v in V – T with the smallest cost[u] + w(u, v) value 
10        among all u in T; 
11      Add v to T and set cost[v] = cost[u] + w(u, v); 
12      parent[v] = u;
13    }
14  }
  The algorithm uses cost[v] to store the cost of a shortest path from vertex v
to the source vertex s. cost[s] is 0. Initially assign infinity to cost[v] to 
indicate that no path is found from v to s. LetV denote all vertices in the graph 
andT denote the set of the vertices whose costs are known. Initially, the source 
vertexs is in T. The algorithm repeatedly finds a vertex u in T and a vertex v
inV – T  such that cost[u] + w(u, v)  is the smallest, and moves v to T.
The shortest path algorithm given in the text coninously update the cost and 
parent for a vertex in V – T . This algorithm initializes the cost to infinity for 
each vertex and then changes the cost for a vertex only once when the vertex is 
added into T. Implement this algorithm and use Listing 29.7, TestShortestPath.
java, to test your new algorithm.
add initial vertex
more vertex
find next vertex
add a vertex
FIGURE 29.28 The program can add vertices and edges and display MST dynamically.
```

</details>


## PDF page 1119

<details>
<summary>Page text</summary>

```text
1096 Chapter 29  Weighted Graphs and Applications
***29.19 (Find u with smallest cost[u] efficiently) The getShortestPath method 
finds a u with the smallest cost[u] using a linear search, which takes O( /H20841 V /H20841).
The search time can be reduced to O(log/H20841 V /H20841) using an AVL tree. Modify the 
method using an AVL tree to store the vertices in V – T . Use Listing 29.7, 
TestShortestPath.java, to test your new implementation. 
***29.20 (Test if a vertex u is in T efficiently ) Since T is implemented using a list 
in  the getMinimumSpanningTree and getShortestPath methods in 
Listing 29.2 WeightedGraph.java, testing whether a vertex u is in T by invoking 
T.contains(u) takes O(n) time. Modify these two methods by introducing 
an array named isInT. Set isInT[u] to true when a vertex u is added to T.
Testing whether a vertex u is in T can now be done in O(1) time. Write a test 
program using the following code, where graph1 is created from Figure 29.1.
WeightedGraph<String> graph1 = new WeightedGraph<>(edges, vertices);
WeightedGraph<String>.MST tree1 = graph1.getMinimumSpanningTree();
System.out.println("Total weight is " + tree1.getTotalWeight());
tree1.printTree();
WeightedGraph<String>.ShortestPathTree tree2 = 
  graph1.getShortestPath(graph1.getIndex("Chicago"));
tree2.printAllPaths();
```

</details>
