import java.util.*;

public class BinaryTreeNode{
    BinaryTreeNode left,right;
    private int data;
    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }
    public int getData() {
        return data;
    }
}
