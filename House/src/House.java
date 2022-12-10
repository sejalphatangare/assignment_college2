import java.util.*;

public class House {
    private int vertices;
    private int edges;
    private int [] [] adjMat;
    private Node[] head;
    Scanner sc=new Scanner(System.in);

    public House(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }

    public void setAdjMat(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public Node[] getHead() {
        return head;
    }

    public void setHead(Node[] head) {
        this.head = head;
    }



    public void createUsingAdjMat(){
        System.out.println("\n\tEnter the Number of Houses: ");
        setVertices(sc.nextInt());
        System.out.println("\n\tEnter the Number of Lanes: ");
        setEdges(sc.nextInt());
    }

}
