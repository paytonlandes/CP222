//modified from class
import java.util.*;
import java.util.Arrays;

/**
 * Interface for a directed graph data structure
 */
public class Graph<N, W> implements IGraph<N, W>{
  Node<N>[] nodes; // maybe?
  Edge<N,W>[] edges; // maybe?
  Node<N> curr; // current node in the graph?
  int nodesSize;
  int edgesSize;

  public Graph(){
    int nodesSize = 0;
    int nodesEdge = 0;
  }
    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
      return nodes;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
      IEdge<N,W>[] from = getEdgesFrom(n);
      IEdge<N,W>[] to = getEdgesTo(n);
      int NeighborsSize = from.length + to.length;
      Node<N>[] neighbors = (Node<N>[]) new Node[NeighborsSize];
      int idx = 0;
      for (IEdge<N,W> i : from){
        neighbors[idx++] = (Node<N>) i.getDestination();
      }
      for (IEdge<N,W> i : to){
        neighbors[idx++] = (Node<N>) i.getSource();
      }
      return neighbors;
    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v){
      Node<N> n = new Node<N>(v);
      curr = n;
      Node<N>[] temp = (Node<N>[]) new Node[nodesSize++];
      int idx = 0;
      for (Node<N> i : nodes){
        temp[idx++] = i;
      }
      temp[nodesSize-1] = n;
      nodes = temp;

      return n;
    }

    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet(){
      return edges;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
      int edgesFromSize = 0;

      for (Edge<N,W> i : edges){
        if (i.getSource() == n){
          edgesFromSize++;
          }
      }

      int idx = 0;
      Edge<N,W>[] edgesFrom = (Edge<N,W>[]) new Edge[edgesFromSize];
      for (Edge<N,W> i : edges){
        if (i.getSource() == n){
          edgesFrom[idx] = i;
          idx++;
        }
      }
      return edgesFrom;
    }


    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
      int edgesToSize = 0;

      for (Edge<N,W> i : edges){
        if (i.getDestination() == n){
          edgesToSize++;
          }
      }

      int idx = 0;
      Edge<N,W>[] edgesTo = (Edge<N,W>[]) new Edge[edgesToSize];
      for (Edge<N,W> i : edges){
        if (i.getDestination() == n){
          edgesTo[idx] = i;
          idx++;
        }
      }
      return edgesTo;
    }


    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w){
      Edge<N,W> n = new Edge<N,W>((Node<N>)s,(Node<N>)d,w);
      for(int i = 0; i <edgesSize; i++){
          if (n.equals(edges[i])){
            break;
          }
        }
      Edge<N,W>[] temp = (Edge<N,W>[]) new Edge[edgesSize+1];

      for(int i = 0; i <edgesSize; i++){
        temp[i] = edges[i];
      }
      temp[edgesSize] = n;
      edges = temp;
      edgesSize++;
    }

    public INode<N> makerOfNode(N v){
      Node<N> n = new Node<N>(v);
      curr = n;

      boolean bool = true;
      for (int i = 0;i<nodesSize;i++){
        if (n.getValue().equals(nodes[i].getValue())){
          bool = false;
        }
      }

      if (bool == true){
      Node<N>[] temp = (Node<N>[]) new Node[nodesSize+1];
      for (int i = 0;i<nodesSize;i++){
        temp[i] = (Node<N>) nodes[i];
      }
      temp[nodesSize] = n;
      nodes = temp;
      nodesSize++;
    }
      return n;
    }

}
