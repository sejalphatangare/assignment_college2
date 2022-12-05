import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Pizza> l1;
    private double total;
    private String cname;
    private String cphno;
    Node next;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphno() {
        return cphno;
    }

    public void setCphno(String cphno) {
        this.cphno = cphno;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Node(List<Pizza> l1){
        total=0;
        next=null;
        this.l1=l1;
    }

    public List<Pizza> getL1() {
        return l1;
    }

    public void setL1(List<Pizza> l1) {
        this.l1 = l1;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
