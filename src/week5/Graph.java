package week5;
import java.io.*;
import java.util.*;
import java.util.LinkedList;
// represents an undirected graph using adjacency list
public class Graph {
  private int V; 
  // Array of lists for Adjacency List Representation
  private LinkedList<Integer> adj[];
  int time = 0;
  static final int NIL = -1;
  // Constructor
  Graph(int v)
  {
      V = v;
      adj = new LinkedList[v];
      for (int i=0; i<v; ++i)
          adj[i] = new LinkedList();
  }
  //Function to add an edge into the graph
  void addEdge(int v, int w)
  {
      adj[v].add(w); // Add w to v's list.
      adj[w].add(v); //Add v to w's list
  }

  // A recursive function that find articulation points using DFS
  // u --> The vertex to be visited next
  // visited[] --> keeps tract of visited vertices
  // disc[] --> Stores discovery times of visited vertices
  // parent[] --> Stores parent vertices in DFS tree
  // ap[] --> Store articulation points
  void APUtil(int u, boolean visited[], int disc[],
              int low[], int parent[], boolean ap[])
  {


      // Count of children in DFS Tree
      int children = 0;
 
      // Mark the current node as visited
      visited[u] = true;
      
      // Initialize discovery time and low value
      disc[u] = low[u] = ++time; 

      // Go through all vertices adjacent to this
      Iterator<Integer> i = adj[u].iterator();
      while (i.hasNext())
      {
    	  // v is current adjacent of u
          int v = i.next();
          
          // If v is not visited yet, then make it a child of u
          // in DFS tree and recur for it
          if (!visited[v])
          {
              children++;
              parent[v] = u;
              APUtil(v, visited, disc, low, parent, ap);

              // Check if the subtree rooted with v has a connection to
              // one of the ancestors of u
              low[u] = Math.min(low[u], low[v]);

              // u is an articulation point in following cases

              // (1) u is root of DFS tree and has two or more children.
              if (parent[u] == NIL && children > 1)
                  ap[u] = true;


              // (2) If u is not root and low value of one of its child
              // is more than discovery value of u.
              if (parent[u] != NIL && low[v] >= disc[u])
                  ap[u] = true;
          }


          // Update low value of u for parent function calls.
          else if (v != parent[u])
              low[u] = Math.min(low[u], disc[v]);
      }
  }

 
  // The function to do DFS traversal. It uses recursive function APUtil()
  void AP()
  {  
    // Mark all the vertices as not visited
      boolean visited[] = new boolean[V];
      int disc[] = new int[V];
      int low[] = new int[V];
      int parent[] = new int[V];
      boolean ap[] = new boolean[V];
      // To store articulation points

 
      // Initialize parent and visited, and ap(articulation point)
      // arrays
      for (int i = 0; i < V; i++)
      {
          parent[i] = NIL;
          visited[i] = false;
          ap[i] = false;
      }


      // Call the recursive helper function to find articulation
      // points in DFS tree rooted with vertex 'i'
      for (int i = 0; i < V; i++)
          if (visited[i] == false)
              APUtil(i, visited, disc, low, parent, ap);
      
      // Now ap[] contains articulation points, print them
      for (int i = 0; i < V; i++)
          if (ap[i] == true)
              System.out.print(i+" ");
  }
  // Driver method
  public static void main(String args[])
  {
      // Create graphs given in above diagrams
      System.out.println("Vulnerable Points ");
      Graph g1 = new Graph(14);
      g1.addEdge(5, 7);
      g1.addEdge(7, 9);
      g1.addEdge(9, 5);
      g1.addEdge(7, 12);
      g1.addEdge(12, 13);
      g1.AP();
  
  }
}