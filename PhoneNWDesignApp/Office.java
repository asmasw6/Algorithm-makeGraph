import GraphFramework.Vertex;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sabah baothman
 */

//represent the single node in the graph

public class Office extends Vertex {
    
    private String officeName;
    
    public Office(String label) {
        super(label);
        this.officeName = "O" + (label.charAt(0)-65+1);
    }

    public void setLabel(String officeName) {
        this.officeName = officeName;
    }

    public String getLabel() {
        return officeName;
    }
    
    
    @Override
    public String  displayInfo() {
        // if Vertex A >> officeName: O1, Vertex B >> officeName: O2
        return "Office NO." + getLabel();
    }
    
    
    
    
}

