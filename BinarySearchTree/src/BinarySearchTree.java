import java.util.*;
import java.io.*;
public class BinarySearchTree {
    Scanner sc = new Scanner(System.in);
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    static BinarySearchTreeNode root;
    int ch;

    BinarySearchTree() {
        root = null;
    }

    public void create() throws IOException {
        do {
            BinarySearchTreeNode ptr = null, cur;
            ptr = new BinarySearchTreeNode();
            System.out.println("\n\tEnter the Word in the Dictionary:");
            ptr.setWord(br.readLine());
            System.out.println("\n\tEnter the Meaning of the word entered:");
            ptr.setMeaning(br.readLine());

            if (root == null) {

//                ptr.x = v;
                ptr.left = null;
                ptr.right = null;
                root = ptr;
                System.out.println("Inserted the root");
            } else {
                cur = root;
                ptr = new BinarySearchTreeNode(ptr.getWord(), ptr.getMeaning());
//                ptr.x = v;
                ptr.left = null;
                ptr.right = null;
                while (cur != null) {
                    if (cur.getWord().compareTo(ptr.getWord()) > 0) {
                        if (cur.left == null) {
                            cur.left = ptr;
                            break;
                        } else {
                            cur = cur.left;
                        }
                    } else {
                        if (cur.right == null) {
                            cur.right = ptr;
                            break;
                        } else {
                            cur = cur.right;
                        }
                    }


                }
            }
            System.out.println("Do you want to add more nodes\nEnter 1 for yes and 0 for no");
            ch = sc.nextInt();
        } while (ch == 1);
    }

    public void inorderRecursive(BinarySearchTreeNode cur) {
        if (cur != null) {
            inorderRecursive(cur.left);
            System.out.println(cur.getWord() + " : " + cur.getMeaning());
            inorderRecursive(cur.right);
        }
    }

    public BinarySearchTreeNode search() throws IOException {
        BinarySearchTreeNode cur;
        System.out.println("\n\tEnter the Word you want to Search:");
        String key = br.readLine();
        cur = root;
        int flag = 0;
        while (cur != null) {
            if (cur.getWord().compareTo(key) == 0) {
                flag = 1;
                System.out.println("Data found" + "Word: " + cur.getWord() + "  Meaning: " + cur.getMeaning());
                break;
            }
            if (cur.getWord().compareTo(key) > 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (flag == 0) {
            System.out.println("Data not Found!");
        }
        return cur;
    }

    /*public void update() throws IOException {
        System.out.println("\n\t1]Update Word in the Dictionary:\n\t2]Update Meaning in the Dictionary:");
        int temp = sc.nextInt();
        if (temp == 1) {
            BinarySearchTreeNode ans = search();
            if (ans != null) {
                System.out.println("Enter the New Word to Update : ");
                String newWord = br.readLine();
                ans.setWord(newWord);
            } else {
                System.out.println("Data Not Found");
            }
        } else {
            BinarySearchTreeNode ans = search();
            if (ans != null) {
                System.out.println("Enter the New Meaning to Update:");
                String newMeaning = br.readLine();
                ans.setMeaning(newMeaning);

            }
        }
    }*/

    public void deletion(BinarySearchTreeNode cur, String ele) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTreeNode b = new BinarySearchTreeNode();
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            BinarySearchTreeNode parent = null;
            cur = root;

            while (cur != null && cur.getWord().compareToIgnoreCase(ele)!=0) {
                parent = cur;
                if (cur.getWord().compareToIgnoreCase(ele) > 0) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }

            }
            if (cur == null) {
                System.out.println("data " + ele + " Not found");
            } else {
//                cur is the node to be deleted
                if (cur.right == null && cur.left == null) {
                    if (parent == null) {
                        root = null;
                        cur = null;
                        System.out.println("Deleted The only node");
                    } else {
                        if (parent.getWord().compareToIgnoreCase(ele) > 0) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }

                        System.out.println("Deleted " + cur.getWord() + " : " + cur.getMeaning());
                        cur = null;
                    }
                } else if (cur.left != null && cur.right == null) {
                    if (parent == null) {
//                        root is the node to delete and therfore parent ==null
                        root = cur.left;
                        cur.left = null;
                        cur = null;
                    } else {
                        if (parent.getWord().compareToIgnoreCase(ele) > 0) {
//                        node (left subtree) to delete is present on the left side
                            parent.left = cur.left;
                            cur.left = null;
                            cur = null;
                        } else {
//                        node to be deleted(left subtree ) is present on the right side of the root
                            parent.right = cur.left;
                            cur.left = null;
                            cur = null;
                        }
                    }
                } else if (cur.right != null && cur.left == null) {
                    if (parent == null) {
                        root = cur.right;
                        cur.right = null;
                    } else {
                        if (parent.getWord().compareToIgnoreCase(ele) < 0) {
//                            node to be deleted(right subtree) is to be found on the right side of the root
                            parent.right = cur.right;
                            cur.right = null;
                            cur = null;
                        } else {
//                            node to be deleted(right subtree) is to be found on the left side of the root
                            parent.left = cur.right;
                            cur.right = null;
                            cur = null;
                        }
                    }
                } else if (cur.right != null && cur.left != null) {
                    BinarySearchTreeNode temp = cur.left;
                    BinarySearchTreeNode parent1 = cur;
                    while (temp.right != null) {
                        parent1 = temp;
                        temp = temp.right;
                    }

                    cur.setWord(temp.getWord());
                    cur.setMeaning(temp.getMeaning());

                    if (parent1.right == temp) {
                        if (temp.left != null) {
                            parent1.right = temp.left;
                        } else {
                            parent1.right = null;
                        }
                    } else {
                        if (temp.left != null) { // parent.left is temp
                            parent1.left = temp.left;
                        } else {
                            parent1.left = null;
                        }
                    }
                }

            }


        }
    }

    public static void main(String args[]) throws IOException {
        BinarySearchTree b1 = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        do {
            System.out.println("\n\t1]Create Dictionary\n\t2]Display Dictionary\n\t3]Search Dictionary\n\t4]Update Dictionary");
            System.out.println("\n\tEnter your Choice:");
            switch (sc.nextInt()) {
                case 1: {
                    b1.create();
                    break;
                }
                case 2: {
                    b1.inorderRecursive(root);
                    break;
                }
                case 3: {
                    b1.search();
                    break;
                }

                case 5: {
                    System.out.println("\n\tEnter the Word to be Deleted:");
                    String del_word = br.readLine();
                    b1.deletion(root, del_word);
                }
            }
            System.out.println("\n\tDo you want to continue:");
        } while (sc.nextInt() == 1);
    }
}
