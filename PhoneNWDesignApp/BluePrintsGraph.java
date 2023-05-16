
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;


public class BluePrintsGraph extends Graph {

    public BluePrintsGraph() {
    }

    public BluePrintsGraph(int veticesNo, int edgeNo) {
        super(veticesNo, edgeNo);
    }

    public BluePrintsGraph(int veticesNo, int edgeNo, boolean isDigraph) {
        super(veticesNo, edgeNo, isDigraph);
    }
    
   
  @Override
    public Edge createEdge(Vertex sourceVertex, Vertex targetVertex, int w) { 
        return new  Line(sourceVertex, targetVertex, w); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex createVertex(String label) {
        return  new Office(label); //To change body of generated methods, choose Tools | Templates.
    }   
}
