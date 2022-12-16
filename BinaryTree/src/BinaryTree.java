import java.awt.*;
import java.util.*;
import java.io.*;
public class BinaryTree{
    Scanner sc=new Scanner(System.in);
    InputStreamReader ir=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ir);
    BinaryTreeNode root;
    private String Direction;
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }


    public BinaryTree() {
        root = null;
    }
    public void create() throws IOException {
        BinaryTreeNode ptr,cur;
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
                    System.out.println("\n\tChoose the Direction:\n\tEnter 'Left' for Left\n\tEnter 'Right' for Right:");
                    setDirection(br.readLine().trim());
                    if (getDirection().equalsIgnoreCase("Left")){
                        if (cur.left==null){
                            System.out.println("\n\tAdding the Node to the Left of the "+cur.getData()+" :");
                            System.out.println("Enter the Data to add:");
                            ptr=new BinaryTreeNode(sc.nextInt());
                            cur.left=ptr;
                            System.out.println("Data Added to the left of the "+cur.getData());
                            break;
                        }else {
                            System.out.println("Moving Left of the Data "+cur.left.getData()+ " :");
                            cur=cur.left;
                            System.out.println("Pointer is now at: "+cur.getData());

                        }
                    } else if (getDirection().equalsIgnoreCase("Right")) {
                        if (cur.right==null){
                            System.out.println("Adding the Node to the right of the Data "+cur.getData()+" :");
                            System.out.println("Enter the Data:");
                            ptr=new BinaryTreeNode(sc.nextInt());
                            cur.right=ptr;
                            System.out.println("Data added to the right of the "+cur.getData());
                            break;
                        }
                        else{
                            System.out.println("Moving Right of the Data "+cur.right.getData()+" :");
                            cur=cur.right;
                            System.out.println("Pointer is at: "+cur.getData());

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
        if(cur!=null) {
            inorder(cur.left);
            System.out.print(cur.getData()+" ");
            inorder(cur.right);
        }
    }
    public void preorder_recursive(BinaryTreeNode cur){
        if (cur!=null){
            System.out.print(cur.getData()+" ");
            preorder_recursive(cur.left);
            preorder_recursive(cur.right);
        }
    }
    public void postorder_recursive(BinaryTreeNode cur){
        if (cur!=null){
            postorder_recursive(cur.left);
            postorder_recursive(cur.right);
            System.out.print(cur.getData()+" ");
        }
    }
    public void inorderNonrecursive() {
        Stack<BinaryTreeNode> s1 = new Stack<>();
        BinaryTreeNode cur;
        if (root == null) {
            System.out.println("Tree is Empty");
        } else {
            cur = root;
            while (cur != null || s1.size() > 0) {
                if (cur != null) {
                    s1.push(cur);
                    cur = cur.left;
                } else {
                    if (!s1.isEmpty()) {
                        cur = s1.pop();
                        System.out.print(cur.getData() + " ");
                        cur = cur.right;
                    }
                }
            }
        }
    }
    public void preorder_nonrecursive1() {
        Stack<BinaryTreeNode> s1=new Stack<>();
        BinaryTreeNode cur;
        if (root==null) {
            System.out.println("Tree is empty");
        }
        else{
//            cur=root;
            s1.push(root);
            while (!s1.isEmpty()){
                cur=s1.pop();
                System.out.print(cur.getData()+" ");
                if (cur.right!=null){
                    s1.push(cur.right);
                }
                if (cur.left!=null){
                    s1.push(cur.left);
                }

            }
        }
    }
    public void postorder_nonrecursive() {
        Stack<BinaryTreeNode> st = new Stack<>();
        Stack<BinaryTreeNode> st1 = new Stack<>();
        BinaryTreeNode cur;

        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            st.push(root);
            while (!st.isEmpty()) {
                cur = st.pop();
                st1.push(cur);
                if (cur.left != null) {
                    st.push(cur.left);
                }
                if (cur.right != null) {
                    st1.push(cur.right);
                }

            }
            while (!st1.isEmpty()) {
                cur = st1.pop();
                System.out.print(cur.getData() + " ");
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BinaryTree b1=new BinaryTree();
        do {

            System.out.println("\n\t1]Create Binary Tree\n\t2]Inorder Recursive Traversal\n\t3]Preorder Recursive Traversal\n\t4]Postorder Recursive Traversal\n\t5]Inorder Nom-Recursive Traversal\n\t6]Preorder Non-Recursive Traversal\n\t7]Postorder Non-Recursive Traversal");
            System.out.println("\n\tEnter your Choice:");
            switch (sc.nextInt()) {
                case 1: {
                    b1.create();
                    System.out.println("\n\t********Binary Tree Created*********");
                    break;
                }
                case 2: {
                    System.out.println("\n\tInorder Recursive Traversal");
                    b1.inorder(b1.root);
                    break;
                }
                case 3: {
                    System.out.println("\n\tPreorder Recursive Traversal:");
                    b1.preorder_recursive(b1.root);
                    break;
                }
                case 4: {
                    System.out.println("\n\tPostorder Pecursive Traversal:");
                    b1.postorder_recursive(b1.root);
                    break;
                }
                case 5: {
                    System.out.println("\n\tInorder Non-Recursive Traversal:");
                    b1.inorderNonrecursive();
                    break;
                }
                case 6: {
                    System.out.println("\n\tPreorder Non-Recursive Traversal:");
                    b1.preorder_nonrecursive1();
                    break;
                }
                case 7: {
                    System.out.println("\n\tPostorder Non-Recursive Traversal:");
                    b1.postorder_nonrecursive();
                    break;
                }
            }
            System.out.println("\n\tDo you want to Continue:\n\tyes:1\tno:0");

        }while (sc.nextInt()==1);









    }
}