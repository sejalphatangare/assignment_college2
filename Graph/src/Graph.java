import java.util.*;

public class Graph {
    int vertices;
    int edges;
    int visited[]=new int[50];
    Scanner sc=new Scanner(System.in);

    public void create(ArrayList<Edge>[] l1, int vertices){
        for(int i=0;i<vertices;i++){
            l1[i]=new ArrayList<>();
        }
        for (int i=0;i<vertices;i++){
            System.out.println("Enter the value of the vertex: ");
            int s1=sc.nextInt();
            do{
                System.out.println("Enter the Destination of the vertex: ");
                int d1=sc.nextInt();
                System.out.println("Enter the weight of the edge: ");
                int w1=sc.nextInt();
                Edge newe=new Edge(s1,d1,w1);
                l1[i].add(newe);
                System.out.println("Do you want to add another edge: press1 ");
            }while(sc.nextInt()==1);
        }

    }
    public void display(ArrayList<Edge> l1[],int vertices){
        System.out.println("S        D      W    ");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<l1[i].size();j++){
                Edge e=l1[i].get(j);
                System.out.print(e.source+"-->"+e.destination+"-->"+e.weight);
                System.out.println(" ");
            }

        }
    }
    public void bfs(ArrayList<Edge> l1[],int start){
        Queue<Integer> q1=new LinkedList<>();
        visited =new int[l1.length];
        q1.add(start);
        while(!q1.isEmpty()){
            int cur=q1.remove();
            if(visited[cur]!=1){
                System.out.println(cur);
                visited[cur]=1;
                for(int i=0;i<l1[i].size();i++){
                    Edge e=l1[cur].get(i);
                    q1.add(e.destination);
                }
            }
        }
    }
    public static void main(String[] args){
        Graph g1=new Graph();
        Scanner sc1=new Scanner(System.in);
        System.out.println("\n\tEnter the no of Vertices Do you want to add : ");
        int v=sc1.nextInt();
        ArrayList[] l2 =new ArrayList[v];

        g1.create(l2,v);
        g1.display(l2,v);
        do {
            System.out.println("Enter the Start vertex :");
            int start = sc1.nextInt();
            g1.bfs(l2, start);
            System.out.println("Do you want to change the start vertex: press 1 :");
        }while (sc1.nextInt()==1);
    }
}
