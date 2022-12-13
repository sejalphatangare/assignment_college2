import java.util.*;
public class House{
    Scanner sc=new Scanner(System.in);
    int[][] adjMat =new int[10][10];
    int vertices,edges,n;
    public House() {
        for(vertices=0;vertices<10;vertices++) {
            for(edges=0;edges<10;edges++){
                adjMat[vertices][edges]=0;
            }
        }
    }
    public void create() {
// assume undirected graph
        System.out.println("\n\tHow many Houses You Want to Add: ");
        n=sc.nextInt();
        do {
            System.out.println("\n\tEnter House Node: ");
            vertices=sc.nextInt();
            System.out.println("\n\tEnter Lane Node: ");
            edges=sc.nextInt();
            adjMat[vertices][edges]=1;
            adjMat[edges][vertices]=1;
            System.out.println("\n\tDo you want to add more House Number? Enter 1 for Yes And 0 for NO: ");
        }while(sc.nextInt()==1);

    }
    void show() {
        System.out.println("\n\t*****Graph*****");
        for(int i=0;i<n;i++) {
            System.out.println("\n\t");
            for(int j=0;j<n;j++) {
                System.out.print("\t"+adjMat[i][j]);
            }
        }
    }
    public void dfs() {

    }
    public static void main(String args[]) {
        House h1=new House();
        h1.create();
        h1.show();

    }

}

