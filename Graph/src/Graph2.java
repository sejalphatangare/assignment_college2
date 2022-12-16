import java.util.*;

public class Graph2 {
    int n;
    int e;
    int source;
    int destination;
    Node[] head=new Node[20];
    int[] visited =new int[10];
    Scanner sc=new Scanner(System.in);

    public void adjList(){
        head=new Node[10];
        System.out.println("Enter the no of Houses: ");
        n=sc.nextInt();
        System.out.println("Enter the no of lanes: ");
        e=sc.nextInt();
        for (int i=0;i<e;i++){
            System.out.println("Enter the start ");
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
    void display(){
        for (int i=0;i<n;i++){
            Node cur=head[i];
            System.out.print(i+" ");
            while(cur!=null){
                System.out.print("-->"+cur.data+" ");
                cur=cur.next;
            }
            System.out.println(" ");


        }
    }
    public void bfs(){
        for (int i=0;i<n;i++){
            visited[i]=0;
        }
        Queue<Integer> q=new LinkedList<>();
        System.out.println("Enter start: ");
        int start=sc.nextInt();
        q.add(start);
        visited[start]=1;
        while(!q.isEmpty()){
            int remove=q.remove();
            Node cur=head[remove];
            System.out.print(remove);
            while(cur!=null){
                if (visited[cur.data]!=1) {
                    q.add(cur.data);
                    visited[cur.data]=1;
                }
                cur=cur.next;
            }
        }
    }
    public void dfs(){
        Stack<Integer> s1=new Stack<>();
        int visited[]=new int[10];
        System.out.println("Enter the start");
        int start=sc.nextInt();
        s1.push(start);
        visited[start]=1;
        while(!s1.isEmpty()){
            Integer popped=s1.peek();
            Node cur=head[popped];
            s1.pop();
            System.out.println(popped);
            while (cur!=null){
                if(visited[cur.data]!=1){
                    s1.push(cur.data);
                    visited[cur.data]=1;

                }
                cur=cur.next;
            }



        }
    }
    public static void main(String[] args){
        Graph2 g2=new Graph2();
        g2.adjList();
        g2.display();
        g2.bfs();
        g2.dfs();
    }
}
