//modified from Class


/**
 * Interface for an edge in a graph. Edges are immutable.
 */
public class Edge<N,W> implements IEdge<N,W>{
  //Fields
  W weight;

  Node<N> s;
  Node<N> d;

  // Implementors should implement a construct that takes in the
  // source, destination, and weight
  public Edge(Node<N> so, Node<N> de, W w) {
      s = so;
      d = de;
      weight = w;
  }
  /**
   * The source node of the edge
   * @return the source node
   */
  public INode<N> getSource(){
    return s;
  }

  /**
   * The destination node of the edge
   * @return the destination node
   */
  public INode<N> getDestination(){
    return d;
  }

  /**
   * The weight of the edge
   * @return the weight
   */
  public W getWeight(){
    return weight;
  }

  /**
   * Test for equality of two edges.
   * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
   * and this.dst == o.dst
   * @param o the other edge
   * @return true if the edges are the same
   *
   *I changed object o to Edge<N,W> o in both bc i've no idea
   *What this stuff wuz
   */
  public boolean equals(Object o){
    Edge<N,W> O = (Edge<N,W>) o;
    if (this.s == O.s){
      if (this.d == O.d){
        return true;
      }
    }
    return false;
  }
}
