/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

import java.util.*;

/**
 *
 * @author sabah baothman
 */
public abstract class MSTAlgorithm {

    //Attribute
    Graph graph;
    ArrayList<Edge> MSTresultList;

    //-----constrain---------
    MSTAlgorithm(Graph graph) {
        this.graph = graph;
        // store the parent of the vertex and the weight needed by the MST algorithem
        this.MSTresultList = new ArrayList<Edge>(graph.verticesNo);
    }

    //Edge MSTresultList;
    // abstract method>> the body implement bt the subclasses (override)
    public abstract void displayResultingMST();
}