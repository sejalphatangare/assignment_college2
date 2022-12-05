import java.util.*;
public class BinaryTree{
    Scanner sc=new Scanner(System.in);
    BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }
    public void create(){
        BinaryTreeNode ptr,cur;
        if (root==null){
            System.out.println("Enter the Data you want to add:");
            int d=sc.nextInt();
            ptr=new BinaryTreeNode(d);
            root=ptr;
        }
        else{

        }
    }
}