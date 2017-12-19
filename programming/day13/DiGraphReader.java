import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {}

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        Graph graph = new Graph();
        // Open the file
        Scanner s = new Scanner(new File(filename));
        BufferedReader br=new BufferedReader(new FileReader(filename));

        int rows=0;
        while(br.readLine() != null){
          rows++;
        }

        s.useDelimiter(":|\n");
        for (int i = 0; i<rows; i++){
          // Parse the lines. If a line does not have exactly 3 fields, ignore the line
          //Derp. . .
            // if (s.next() == null || s.next() == null ||p s.next() == null){
            //   continue;
            // }
            // For each line, add the nodes and edge

          String st = s.next();
          //System.out.println(st);

          String d = s.next();
          //System.out.println(d);

          String w = s.next();
          Double ww = Double.parseDouble(w);
          //System.out.println(ww);

          //Like add node but checks for dublicates
          //Only adds to nodes if not already there
          INode<String> stN = graph.makerOfNode(st);
          INode<String> dN = graph.makerOfNode(d);
          // Node<String> stNode =  (Node<String>) graph.makerOfNode(st);
          // Node<String> dNode = (Node<String>) graph.makerOfNode(d);

          graph.addEdge(stN, dN, w);
          //System.out.println(graph.getEdgeSet());
        }
        // Return the graph instance
        return graph;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}


// public void readInFile(String fname) throws Exception {
//     // Figure out how big the array needs to be
//     int rows=1; // how many lines in the file
//     int cols;
//     BufferedReader br=new BufferedReader(new FileReader(fname));
//     cols = br.readLine().length();
//     while(br.readLine()!=null) {
//         rows++;
//     }
//     // lines now has the row count and cols has column count
//     map = new char[rows][cols];
//
//     // Read in the file into array
//     br=new BufferedReader(new FileReader(fname));
//     for(int r=0; r<rows; r++) {
//         String l=br.readLine();
//         // Work through the characters
//         for(int c=0; c<l.length(); c++) {
//             // each character... add to the 2D array
//             map[r][c] = l.charAt(c);
//             if(l.charAt(c)=='s') { sx=r; sy=c; }
//             if(l.charAt(c)=='e') { ex=r; ey=c; }
//         }
//     }
// }
