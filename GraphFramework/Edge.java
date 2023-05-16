package GraphFramework;

/**
 *
 * @author 
 */
public class Edge {
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private Vertex parentVertex;
    private int weight;

    public Edge(Vertex sourceVertex, Vertex destinationVertex, Vertex parentVertex, int weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = destinationVertex;
        this.parentVertex = parentVertex;
        this.weight = weight;
    }

    public Edge(Vertex sourceVertex , Vertex targetVertex , int weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public Vertex getParentVertex() {
        return parentVertex;
    }

    public void setParentVertex(Vertex parentVertex) {
        this.parentVertex = parentVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void displayInfo() {
        System.out.print(sourceVertex.displayInfo()+ " - ");
        System.out.print(targetVertex.displayInfo());
        //System.out.println(weight);
    }
}
