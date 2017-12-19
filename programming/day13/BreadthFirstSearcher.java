public class BreadthFirstSearcher{

  /**
   * Determines if there is a path without returning the path
   * @param g the graph to search in
   * @param s node to start from
   * @param e node to end at
   * @return if a path of any length exists
   */
  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
      DoubleLinkList visList =  new DoubleLinkList();
      ArrayQueue<INode<N>> Q = new ArrayQueue<INode<N>>(g.nodesSize());
      Q.enqueue(s);
      visList.append(s);
      while (Q.size > 0){ // Process each vertex on Q
        INode<N> v = Q.dequeue();
        for(INode<N> i : g.getNeighbors(s)){
          for(INode<N> j : visList){
            if (i.equals(e)){return true;}
            if (i.equals(j)){continue;}
            Q.enqueue(i);
          }
        }
      }
    }



    //returns array of nodes
    //g.getNeighbors(s)
    //need to queue those nodes and search them
  //   while goQ len !=0
  //   for(INode<N> i : g.getNeighbors(s)){
  //     for(INode<N> j : visArray){
  //       if (i.equals(j)){continue;}
  //       goQ.enqueue(i)
  //     }
  //   }

  /**
   * Finds a path based on the properties of the search algorithm.
   * If there is no path in graph g from node s to node e, null should be
   * returned. If node s and node e are the same, an empty list should be returned.
   * @param g the graph to search in
   * @param s node to start from
   * @param e node to end at
   * @return the list of nodes in the path
   */
  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
  }
}


// Breadth first (queue-based) search from textbook
// static void BFS(Graph g, int start) {
//   Queue<Integer> Q = new AQueue<Integer>(g.n());
//   Q.enqueue(start);
//   g.setMark(start, VISITED);
//   while (Q.length() > 0) { // Process each vertex on Q
//     int v = Q.dequeue();
//   PreVisit(g, v); // Take appropriate action
//   for (int w = g.first(v); w < g.n(); w = g.next(v, w))
//     if (g.getMark(w) == UNVISITED) { // Put neighbors on Q
//       g.setMark(w, VISITED);
//       Q.enqueue(w);
//   }
//   PostVisit(g, v); // Take appropriate action
//   }
// }
