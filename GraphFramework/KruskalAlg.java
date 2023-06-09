package GraphFramework;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlg extends MSTAlgorithm {

    public KruskalAlg(Graph graph) {
        super(graph);
    }

   

 
    
    //----------------------displayResultingMST------------------------------
    @Override
    public void displayResultingMST() {

        // Create a new List to store all edges
        ArrayList<Edge> allEdges = new ArrayList<>();
        for (Vertex v : graph.vertices) {
            allEdges.addAll(v.adjList);
        }
        //----------------------------------------------------
        // Sort the edges by weight using the sort method
        Collections.sort(allEdges, (e1, e2) -> e1.getWeight() - e2.getWeight());
        
        //----------------------------------------------------
        // Create an array to store the parent of each vertex
        int[] parents = new int[graph.getVeticesNo()];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        //----------------------------------------------------
        // Loop over all edges and add them to the MSTresultList if they connect two different trees
        for (Edge e : allEdges) {
            // Get the vertices connected to the current edge
            Vertex source = e.getSourceVertex();
            Vertex target = e.getTargetVertex();
            // Get the parents of these vertices from the findParent method
            int sourceParent = findParent(source, parents);
            int targetParent = findParent(target, parents);
            
            // If they have different parents, they are part of different trees and can be added to the MSTresultList
            if (sourceParent != targetParent) {
                MSTresultList.add(e);
                // Update the parents array to make sure both vertices have the same parent
                union(parents, targetParent, sourceParent);
            }  }
        //----------------------------------------------------
        print();
    }
    
    
    //----------------------print------------------------------
    public void print() {
        //print edges
      //  System.out.println("The phone network (minimum spanning tree) generated by Kruskal algorithm is as follows:\n");
        for (Edge edge : MSTresultList) {
            edge.displayInfo();
        }
        //print Total Cost
        int cost = 0;
        for (int i = 0; i < MSTresultList.size(); i++) {
            Edge edge = MSTresultList.get(i);
            cost += edge.getWeight();
        }
        System.out.println("\nThe cost of designed phone network: " + cost);
        
    }
    
    //----------------------findParent------------------------------
    private int findParent(Vertex v, int[] parent) {
    //return the parent vertex of a given vertex
        int vertexIndex = graph.vertices.indexOf(v);
        //if the vertex has the same label as its parents; it is the root 
        if (parent[vertexIndex] == vertexIndex) {
            return vertexIndex;
        }
        //else recursively find the root of the tree 
        return findParent(graph.vertices.get(parent[vertexIndex]), parent);
    }

    //----------------------union------------------------------
    private void union(int[] parent, int x, int y) {
    // --join the subset--
        int Xparent = findParent(graph.vertices.get(x), parent);
        int Yparent = findParent(graph.vertices.get(y), parent);
        //make x as parent of y
        parent[Yparent] = Xparent;
    }
}
