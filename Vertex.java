package GraphFramework;

import java.util.ArrayList;

public class Vertex {
    
    String label;
    boolean isVisited;
    ArrayList<Edge> adjList;

    // Constructor
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new ArrayList<>();
    }

    // Getters
    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public ArrayList<Edge> getAdjList() {
        return adjList;
    }

    // Setters
    public void setLabel(String label) {
        this.label = label;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setAdjList(ArrayList<Edge> adjList) {
        this.adjList = adjList;
    }

    // Methods
    public String displayInfo() {
        return label;
    }
    
    

}