public class BinarySearchTreeNode {
    private String word;
    private String meaning;
    BinarySearchTreeNode left,right;

    public BinarySearchTreeNode(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
    public BinarySearchTreeNode(){

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
}
