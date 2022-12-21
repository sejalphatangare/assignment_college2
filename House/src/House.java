import java.util.*;
public class House {
    Scanner sc = new Scanner(System.in);
    int[][] adjMat = new int[10][10];
    int  e, n;
    int start,end;

    public House() {
       n=0;
       e=0;

    }

    public void create() {
// assume undirected graph
        System.out.println("\n\tEnter the Number of ");
        n = sc.nextInt();
        do {
            System.out.println("\n\tEnter House Node: ");
            n = sc.nextInt();
            System.out.println("\n\tEnter Lane Node: ");
            e= sc.nextInt();
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
            System.out.println("\n\tDo you want to add more House Number? Enter 1 for Yes And 0 for NO: ");
        } while (sc.nextInt() == 1);

    }

    void show() {
        System.out.println("\n\t*****Graph*****");
        for (int i = 0; i < n; i++) {
            System.out.println("\n\t");
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + adjMat[i][j]);
            }
        }
    }

    public void dfs(int start) {
        int visited[] = new int[10];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }
        visited[start] = 1;
        s.push(start);
        while (!s.isEmpty()) {
            int cur = s.peek();
            s.pop();
            System.out.print(" "+cur);
            for (int i = 0; i < adjMat.length; i++) {
                if (adjMat[cur][i] == 1 && visited[i] == 0) {
                    s.push(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public void bfs(int start){
        int visited[]=new int[20];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=1;
        while(!q.isEmpty()){
            int cur=q.poll();
            System.out.println(" "+cur);
            for (int i=0;i<adjMat.length;i++){
                if (visited[i]==0 && adjMat[cur][i]==1){
                    q.add(i);
                    visited[i]=1;

                }
            }

        }
    }
    public static void main(String args[]) {
        House h1=new House();
        Scanner sc=new Scanner(System.in);
        h1.create();
        h1.show();
        System.out.println("\n\tEnter the Start Node: ");
        int start=sc.nextInt();
        h1.dfs(start);
    }

}


/*class graph
{
int n; //number of vertices
int e; //number of edges
int[][] adjMat; //adjacency matrix of the graph
Node [] head; //array of heads of linked list used for adjacency//list
graph()
{
n = 0;
e = 0;
}
Scanner sc = new Scanner(System.in);
void createUsingAdjMat()
{
System.out.print("\nEnter the number of houses: ");
 n = sc.nextInt();

System.out.print("Enter the number of lanes: ");
 e = sc.nextInt();

adjMat = new int[n][n];

for(int i=0;i<n;i++) {
	adjMat[i] = new int[n];
	for(int j=0;j<n;j++) {
		adjMat[i][j] = 0;
	}
}

for(int i=0;i<e;i++) {

	System.out.print("\nEnter the first house: ");
	int x = sc.nextInt();

	System.out.print("Enter the connected house: ");
	int y = sc.nextInt();

	adjMat[x][y] = 1; //both ways - since it is an undirected graph
	adjMat[y][x] = 1;

}

}



void displayAdjMat()
{
	System.out.println("Adjacency matrix:");
	for(int i=0;i<n;i++) {
		System.out.print("\t");
		for(int j=0;j<n;j++) {
			System.out.print(adjMat[i][j]+" ");
		}
		System.out.println();
	}

}*/
