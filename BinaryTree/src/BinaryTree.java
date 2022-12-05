import java.awt.*;
import java.util.*;
import java.io.*;
public class BinaryTree{
    Scanner sc=new Scanner(System.in);
    InputStreamReader ir=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ir);
    static BinaryTreeNode root;
    private String Direction;
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }


    public BinaryTree() {
        this.root = null;
    }
    public void create() throws IOException {
        BinaryTreeNode ptr=null,cur;
        do{
            if (root==null){
                System.out.println("Enter the Data you want to add at the root:");
                int d=sc.nextInt();
                ptr=new BinaryTreeNode(d);
                root=ptr;
            }
            else{
                cur=root;
                while(cur!=null){
                    ptr=new BinaryTreeNode();
                    System.out.println("\n\tChoose the Direction:\n\tEnter 'Left' for Left\n\tEnter 'Right' for Right:");
                    setDirection(br.readLine().trim());
                    if (getDirection().equalsIgnoreCase("Left")){
                        if (cur.left==null){
                            System.out.println("\n\tAdding the Node to the Left of the "+cur.getData()+" :");
                            System.out.println("Enter the Data to add:");
                            ptr.setData(sc.nextInt());
                            cur.left=ptr;
                            System.out.println("Data Added to the left of the "+cur.getData());
                            break;
                        }else {
                            System.out.println("Moving Left of the Data "+cur.left.getData()+ " :");
                            cur=cur.left;
                            System.out.println("Initial Data is:"+cur.getData());
                        }
                    } else if (getDirection().equalsIgnoreCase("Right")) {
                        if (cur.right==null){
                            System.out.println("Adding the Node to the right of the Data "+cur.right);
                            System.out.println("Enter the Data:");
                            ptr.setData(sc.nextInt());
                            cur.right=ptr;
                            System.out.println("Data added to the right of the "+cur.getData());
                            break;
                        }
                        else{
                            System.out.println("Moving Right of the Data "+cur.right.getData()+" :");
                            cur=cur.right;
                            System.out.println("Initial Data Is:"+cur.getData());

                        }
                    }else{
                        System.out.println("\n\tEnter Valid String:");
                        break;
                    }
                }
            }
            System.out.println("\n\tDo you want to add more Nodes:\n\tPress 1:");
        }while(sc.nextInt()==1);
    }
    public void inorder(BinaryTreeNode cur){
        if(root!=null) {
            inorder(cur.left);
            System.out.println(cur.getData());
            inorder(cur.right);
        }
    }
    public static void main(String args[]) throws IOException {
        BinaryTree b1=new BinaryTree();
        b1.create();
        b1.inorder(root);
    }
}