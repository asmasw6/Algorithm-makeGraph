package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Graph {

    int verticesNo;
    int edgeNo;
    Boolean isDigraph;
    ArrayList<Vertex> vertices;
    //ArrayList<Graph> graphs;
    ArrayList<String> label;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.label = new ArrayList<>();
    }
    
     public Graph(int veticesNo , int edgeNo) {
        this.verticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.vertices = new ArrayList<>();
        this.label = new ArrayList<>();
    }
    
    public Graph(int veticesNo , int edgeNo , boolean isDigraph) {
        this.verticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new ArrayList<>();
        this.label = new ArrayList<>();
    }

    public int getVeticesNo() {
        return verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public Boolean getIsDigraph() {
        return isDigraph;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setVeticesNo(int veticesNo) {
        this.verticesNo = veticesNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public void setIsDigraph(Boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    //-----------------------------------------
    //-- craete Vertex --
    public Vertex createVertex(String label) {
        
        return  new Vertex(label);
    }
    //-- craete Edge --
    public Edge createEdge( Vertex  sourceVertex, Vertex targetVertex , int w) {
     
        return new Edge(sourceVertex, targetVertex, w);
    }
    //-----------------------------------------
    
    
    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        //-- Craete scanner to read file -- 

        Scanner read = new Scanner(fileName);

        // >> Check if type of graph is directe | Undirecte
        String graphType = read.nextLine();
        if (graphType.equalsIgnoreCase("digraph 0")) {
            isDigraph = false;
        }
        if (graphType.equalsIgnoreCase("digraph 1")) {
            isDigraph = true;
        }

        //----------------------------------------------------
        // >> Raed the numbers of vertices & edges
        verticesNo = read.nextInt();
        edgeNo = read.nextInt();
        //-------------------------------------------------------------

        if (!isDigraph) {// is Undirecte :. duplicate the edges
            edgeNo *= 2;
        }

        //----------------------------------------------------
        int eNo = 0; //counter for edges
        //-- declare variable--
         Vertex source = null, target = null;
        while (eNo < edgeNo) {
           
            // -- read eadge --
            String sourceVertex = read.next();
            String targetVertex = read.next();
            int weight = read.nextInt();

            // -- check duplicate nodes --
            //-- source --
            if (!label.contains(sourceVertex)) {
                label.add(sourceVertex);
                source = createVertex(sourceVertex);
                vertices.add(source);
            } else {
                source = vertices.get(label.indexOf(sourceVertex));
            }

            //-- target --
            if (!label.contains(targetVertex)) {
                label.add(targetVertex);
                target = createVertex(targetVertex);
                vertices.add(target);
            } else {
                target = vertices.get(label.indexOf(targetVertex));
            }

            // -- make edge --  
            addEdge(source , target , weight);

            // >> increment number of Edges
            if (!isDigraph) {
                eNo += 2;
            } else {
                eNo++;
            }
        }

        read.close();

    }

    public void addEdge(Vertex v , Vertex u , int w) throws NullPointerException {
        Edge newEdge;

        //-- create new edge --
        newEdge = createEdge(v, u, w);
        // -- add edge to the vertex --
        v.adjList.add(newEdge);
        // -- spcial case << Graph is Undirecte >>
        if (isDigraph) {//#################################################################### Hadeel - changed from !isDigraph to isDigraph
            // -- make the opposite direction from target to sourse (target >> source) 
            newEdge = createEdge(u, v, w) ; 
            // -- add edge to the vertex --
            u.adjList.add(newEdge);

        }

    }
    
    public void make_graph() {
        // Clear existing graph
        this.vertices.clear();
        this.label.clear();

        // Create vertices
        for (int i = 0; i < verticesNo; i++) {
            //String vertexLabel = "V" + (i + 1);
            char random = (char)(Math.random()*26+65);
            String vertexLabel = Character.toString(random);
            Vertex vertex = createVertex(vertexLabel);
            vertices.add(vertex);
            label.add(vertexLabel);
        }

        // Create edges
        Random random = new Random();
        for (int i = 0; i < edgeNo; i++) {

            // Choose a random source vertex
            Vertex sourceVertex = vertices.get(random.nextInt(verticesNo));

            // Choose a random destination vertex
            Vertex targetVertex = vertices.get(random.nextInt(verticesNo));

            // Generate a random edge weight from 1 to 50
            int weight = random.nextInt(50) + 1;

            // Skip if sourceVertex and targerVertex are the same or already have an edge between them
            if (sourceVertex.equals(targetVertex) || hasEdge(sourceVertex , targetVertex) || hasEdge(targetVertex , sourceVertex)) {
                i--;
                continue;
            }
            
            addEdge(sourceVertex , targetVertex , weight);
        }
    }

    public boolean hasEdge(Vertex source , Vertex destination) {
        if (source.getAdjList().stream().anyMatch((edge) -> (edge.getTargetVertex().equals(destination)))) {
            return true;
        }
        return false;
    }

}
