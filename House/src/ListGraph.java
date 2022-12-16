import java.util.*;
public class ListGraph {
    int v, w, n;
    Scanner sc1=new Scanner(System.in);

    List<Integer> a[];
    Queue<Integer> q;
    int desti;
    public ListGraph(int n) {
        a = new ArrayList[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new ArrayList<>();
        }
        q=new LinkedList<>();
    }
    public void addEdge(int source,int desti){
//        a[source].add(0,desti);
        a[source].add(desti);
        a[desti].add(source);

//        a[desti].add(source);

    }

    public void display() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "-->" + a[i]);
        }
    }
    public void bfs(int start){
        int visited[]=new int[20];
        visited[start]=1;
        q.add(start);
        System.out.println(start);
        while(q.size()!=0){
            int cur=q.poll();
            for (int i=0;i<a[cur].size();i++){
                int ele=a[cur].get(i);
                if (visited[ele]!=1){
                    visited[ele]=1;
                    q.add(ele);
                    System.out.println(ele);
                }
            }
        }


       /* graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);
        graph.insertEdge(6, 5);
        graph.insertEdge(7, 5);
        graph.insertEdge(7, 8);
        start=2
        Answer = 2 4 7 5 8   */

    }
    public void dfs(int start) {
        int visited[] = new int[10];
        Stack<Integer> s = new Stack<>();
        visited[start] = 1;
        s.push(start);
        while (!s.isEmpty()) {
            int cur = s.peek();
            System.out.print(cur + " ");

            s.pop();
            if (visited[cur] != 1) {
                visited[cur] = 1;
                for (int i = 0; i < a[cur].size(); i++) {
                    int ele = a[cur].get(i);
                    if (visited[ele] != 1) {
                        s.push(ele);
                    }
                }
            }
        }
    }


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("\n\tEnter the Number of Vertices: ");
        int n=sc.nextInt();
        ListGraph g=new ListGraph(n);
        do{
            System.out.println("\n\tEnter the Source: ");
            int source = sc.nextInt();
            System.out.println("\n\tEnter the Destination: ");
            int desti = sc.nextInt();
            g.addEdge(source, desti);
            System.out.println("Do you want to continue adding node: ");
        }while(sc.nextInt()==1);
        g.display();
       /* System.out.println("\n\tEnter the Source to Search if it is connected or not: ");
        int temp_source=sc.nextInt();
        System.out.println("\n\tEnter the destination to Search if it is connected or not: ");
        int temp_desti=sc.nextInt();*/
        System.out.println("\n\tEnter the Start Node: ");
        int start=sc.nextInt();
        g.bfs(start);
        System.out.println("");
        g.dfs(start);

//        System.out.println(g.(temp_source,temp_desti));

    }

}


