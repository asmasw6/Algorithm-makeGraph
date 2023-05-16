package GraphFramework;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MHPrimAlg extends MSTAlgorithm {

    public MHPrimAlg(Graph graph) {
        super(graph);
    }


    @Override
    public void displayResultingMST() {

        // Create a Min-Heap (Priority Queue) to store the edges, ordered by their weights
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1 , e2) -> Integer.compare(e1.getWeight() , e2.getWeight()));
     
        
        // Create an ArrayList to store the visited vertices
        ArrayList<Vertex> visited = new ArrayList<>();

        // Choose a vertex as starting vertex, here we choose the first vertex of the graph
        Vertex startVertex = graph.getVertices().get(0);

        // Mark the start vertex as visited and add it to the visited list
        visited.add(startVertex);
        startVertex.setIsVisited(true);

        // Add all edges of the start vertex to the min-heap
        startVertex.getAdjList().forEach((edge) -> {
            minHeap.add(edge);
        });

        // While the min-heap is not empty and all vertices are not visited yet
        while (!minHeap.isEmpty() && visited.size() < graph.getVeticesNo()) {

            // Extract the minimum weight edge from the min-heap
            Edge minEdge = minHeap.poll();
            Vertex destination = minEdge.getTargetVertex();

            // Check if the destination vertex is not visited, then add it to MSTresultList
            if (!destination.isVisited()) {

                // // Mark the destination vertex as visited and add it to the visited list
                visited.add(destination);
                destination.setIsVisited(true);

                // Add the destination vertex to the MSTresultList
                MSTresultList.add(minEdge);

                // Add all edges of destination to the min-heap
                for (Edge edge : destination.getAdjList()) {
                    if (!edge.getTargetVertex().isVisited()) {
                        minHeap.add(edge);
                    }
                }
            }
        }
        print();
    }

    public void print() {
        
        
        
        //print edges
        //System.out.println("The phone network (minimum spanning tree) generated by Prim algorithm is as follows:");
        for (Edge edge : MSTresultList) {
            edge.displayInfo();
        }
        //print Total Cost
        int cost = 0;
        for (int i = 0; i < MSTresultList.size(); i++) {
            Edge edge = MSTresultList.get(i);
            cost += edge.getWeight();
        }
        System.out.println("\nThe cost of designed phone network: "+cost);
    }
}