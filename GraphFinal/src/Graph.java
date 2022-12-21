import java.util.*;

public class Graph {
    int n; //no of vertices
    int e; //no of edges
    int n1;
    int e1;
    int source;
    int destination;
    Node[] head=new Node[20];

    int adjMat[][];

    public Graph(){
        n=0;
        e=0;

    }
    Scanner sc=new Scanner(System.in);

    public void createMat(){
        System.out.println("\n\tEnter the no of vertices :");
        n=sc.nextInt();
        System.out.println("\n\tEnter the no of Edges: ");
        e=sc.nextInt();
        adjMat=new int [n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjMat[i][j]=0; //initializing matrix making all it values as 0
            }
        }
        for (int i=0;i<e;i++){
            System.out.println("\n\tEnter the Start: ");
            source=sc.nextInt();
            System.out.println("\n\tEnter the Destination : ");
            destination=sc.nextInt();
            adjMat[source][destination]=1;
            adjMat[destination][source]=1;
        }
    }
    public void displayMat(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public void bfsMat(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[50];
        for(int i=0;i<50;i++){
            visited[i]=0;
        }
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp+" ");
            for (int i = 0; i < adjMat.length; i++) {
                if (visited[i] == 0 && adjMat[temp][i] == 1) {
                    q.add(i);
                    visited[i] = 1;
                }

            }
        }
    }
    public void dfsMat(int start){
        int[] visited=new int[50];
        for(int i=0;i<n;i++){
            visited[i]=0;
        }
        Stack<Integer> s=new Stack<>();
        s.push(start);
        visited[start]=1;
        while(!s.isEmpty()){
            int temp=s.peek();
            s.pop();

            System.out.print(temp+" ");
            for (int i=0;i<n;i++){
                if(visited[i]==0 && adjMat[temp][i]==1){
                    s.push(i);
                    visited[i]=1;
                }
            }
        }

    }
    public void createList(){
        System.out.println("\n\tEnter the number of Houses : ");
        n1=sc.nextInt();
        System.out.println("\n\tEnter the number of Edges : ");
        e1=sc.nextInt();

        for(int i=0;i<n1;i++){
            System.out.println("Enter the source and destination : ");
            source=sc.nextInt();
            destination=sc.nextInt();
            insert(source,destination);
            insert(destination,source);
        }
    }
    public void insert(int u,int v){
        Node ptr=new Node(v);
        if(head[u]==null){
            head[u]=ptr;
        }
        else{
            Node cur=head[u];
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=ptr;

        }
    }
    public void displayList(){
        for(int i=0;i<n1;i++){
            Node cur=head[i];
            System.out.print(i+" ");
            while(cur!=null){
                System.out.print("-->"+cur.data +cur);
                cur=cur.next;
            }
            System.out.println(" ");
        }
    }
    public void dfsList(int start){
        int[] visited=new int[20];
        for(int i=0;i<n1;i++){
            visited[i]=0;
        }
        Stack<Integer> s=new Stack<>();
        s.push(start);
        visited[start]=1;
        while(!s.isEmpty()){
            int temp=s.peek();
            Node cur=head[temp];
            s.pop();
            System.out.println(temp);
            while(cur!=null){
                if(visited[cur.data]==0){
                    s.push(cur.data);
                    visited[cur.data]=1;
                }
                cur=cur.next;
            }
        }
    }
    public void bfs_list(int start){
        System.out.print("Enter the starting house: ");
        int v = sc.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();
        int[] visited = new int[n];

        for(int i =0;i<n;i++){
            visited[i]=0;
        }

        q.add(head[v].data);
        visited[v] = 1;

        System.out.print("\nBreadth First Search: ");

        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i+" ");

            Node ptr = head[i];
            while(ptr!=null) {
                if(visited[ptr.data]==0) {
                    q.add(ptr.data);
                    visited[ptr.data] = 1;
                }
                ptr = ptr.next;
            }

        }
    }
    public static void main(String[] args){
        Graph g1=new Graph();
        Scanner sc1=new Scanner(System.in);
        System.out.println("Created Matrix: ");
        g1.createMat();
        System.out.println("Adjcency Matrix :");
        g1.displayMat();
        System.out.println("\n\tEnter the Start Vertex :");
        int start=sc1.nextInt();
        System.out.println("BFS Matrix");
        g1.bfsMat(start);
        System.out.println("DFS Matrix");
        g1.dfsMat(start);
        System.out.println("Creating Adjacency List: ");
        g1.createList();
        System.out.println("Display Adjacency List: ");
        g1.displayList();
        System.out.println("DFS List :");
        g1.dfsList(start);
        System.out.println("BFS List");
        g1.bfs_list(start);
    }
}
