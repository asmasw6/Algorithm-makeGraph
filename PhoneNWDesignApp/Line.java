import GraphFramework.Edge;
import GraphFramework.Vertex;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author
 */

public class Line extends Edge {
    
    private int lLength;
    
    public Line(Vertex sourceVertex, Vertex TargetVertex, Vertex parentVertex, int weight) {
        super(sourceVertex, TargetVertex, parentVertex, weight);
        this.lLength = weight*5;
    }
    public Line(Vertex sourceVertex, Vertex TargetVertex,int weight){
        super(sourceVertex,TargetVertex,weight);
                this.lLength = weight*5;

    }

    public int getlLength() {
        return lLength;
    }

    public void setlLength(int lLength) {
        this.lLength = lLength;
    }
    
    
    //display info about the line edge 
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(": line Length:" + lLength);
    } 
    
     
    
 
}
