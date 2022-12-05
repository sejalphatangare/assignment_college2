import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class pizza_parlour{
    Node front,rear;
    double total=0;
    public pizza_parlour(Node front, Node rear) {
        this.front = front;
        this.rear = rear;
    }
    public void enqueue() throws IOException {

        Scanner sc = new Scanner(System.in);
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        List<Pizza> p1 = new ArrayList<>();




            System.out.println("**************\t Menu\t*****************");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n1]Margerita\n\t\t\tsmall\t\t\t99\n\t\t\tmedium\t\t\t199\n\t\t\tlarge\t\t\t299");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n2]Cheese & Corn\n\t\t\tsmall\t\t\t199\n\t\t\tmedium\t\t\t299\n\t\t\tlarge\t\t\t399");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n3]Paneer and Onion\n\t\t\tsmall\t\t\t299\n\t\t\tmedium\t\t\t399\n\t\t\tlarge\t\t\t499");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n4]Mushroom and onion\n\t\t\tsmall\t\t\t399\n\t\t\tmedium\t\t\t499\n\t\t\tlarge\t\t\t599");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n5]Pepper Barbeque Chicken\n\t\t\tsmall\t\t\t200\n\t\t\tmedium\t\t\t300\n\t\t\tlarge\t\t\t500");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n6]Chicken Tikka\n\t\t\tsmall\t\t\t300\n\t\t\tmedium\t\t\t400\n\t\t\tlarge\t\t\t600");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n7]Chicken Fiesta\n\t\t\tsmall\t\t\t400\n\t\t\tmedium\t\t\t500\n\t\t\tlarge\t\t\t700");
            System.out.println("**************************************************************************************************");
            System.out.println("Pizza\t\t\tQuantity\t\tPrice\n8]Chicken Dominator\n\t\t\tsmall\t\t\t500\n\t\t\tmedium\t\t\t600\n\t\t\tlarge\t\t\t800");
            System.out.println("**************************************************************************************************");
            System.out.println("Enter Your name:");
            String temp_cname= br.readLine();
            System.out.println("Enter your Contact Number");
            String temp_cno= br.readLine();
            do {
            System.out.println("Enter no. of pizzas do you want to order:");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                Pizza p2 = new Pizza();
                System.out.println("Choose Pizza name:");
                int temp_name = sc.nextInt();

                if (temp_name == 1) {
                    p2.setPizzaname("Margerita");
                } else if (temp_name == 2) {
                    p2.setPizzaname("Cheese and Corn");
                } else if (temp_name == 3) {
                    p2.setPizzaname("Paneer and Onion");
                } else if (temp_name == 4) {
                    p2.setPizzaname("Mushroom and Onion");
                } else if (temp_name == 5) {
                    p2.setPizzaname("Pepper Barbeque Chicken");
                } else if (temp_name == 6) {
                    p2.setPizzaname("Chicken Tikka");
                } else if (temp_name == 7) {
                    p2.setPizzaname("Chicken Fiesta");
                } else if (temp_name == 8) {
                    p2.setPizzaname("Chicken Dominator");
                }
                System.out.println("Enter the Size of the Pizza:\n1]Small\n2]Medium\n3]Large");
                int temp_size = sc.nextInt();
                if (temp_size == 1) {
                    p2.setSize("S");
                } else if (temp_size == 2) {
                    p2.setSize("M");
                } else if (temp_size == 3) {
                    p2.setSize("L");
                }
                if (Objects.equals(p2.getPizzaname(), "Margerita") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(99);
                }
                if (Objects.equals(p2.getPizzaname(), "Margerita") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(199);
                }
                if (Objects.equals(p2.getPizzaname(), "Margerita") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(299);
                }
                if (Objects.equals(p2.getPizzaname(), "Cheese and Corn") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(199);
                }
                if (Objects.equals(p2.getPizzaname(), "Cheese and Corn") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(299);
                }
                if (Objects.equals(p2.getPizzaname(), "Cheese and Corn") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(399);
                }
                if (Objects.equals(p2.getPizzaname(), "Paneer and Onion") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(299);
                }
                if (Objects.equals(p2.getPizzaname(), "Paneer and Onion") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(399);
                }
                if (Objects.equals(p2.getPizzaname(), "Paneer and Onion") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(499);
                }
                if (Objects.equals(p2.getPizzaname(), "Mushroom and Onion") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(399);
                }
                if (Objects.equals(p2.getPizzaname(), "Mushroom and Onion") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(499);
                }
                if (Objects.equals(p2.getPizzaname(), "Mushroom and Onion") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(599);
                }
                if (Objects.equals(p2.getPizzaname(), "Pepper Barbeque Chicken") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(200);
                }
                if (Objects.equals(p2.getPizzaname(), "Pepper Barbeque Chicken") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(300);
                }
                if (Objects.equals(p2.getPizzaname(), "Pepper Barbeque Chicken") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(500);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Tikka") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(300);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Tikka") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(400);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Tikka") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(600);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Fiesta") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(400);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Fiesta") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(500);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Fiesta") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(700);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Dominator") && Objects.equals(p2.getSize(), "S")) {
                    p2.setPrice(500);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Dominator") && Objects.equals(p2.getSize(), "M")) {
                    p2.setPrice(600);
                }
                if (Objects.equals(p2.getPizzaname(), "Chicken Dominator") && Objects.equals(p2.getSize(), "L")) {
                    p2.setPrice(800);
                }
                p1.add(p2);
                System.out.println(p1);
                total += p2.getPrice();
            }
            System.out.println("Do you want to add more Pizza's to your list:");
        }while(sc.nextInt()==1);

        Node node=new Node(p1);
        node.setTotal(total);
        node.setCname(temp_cname);
        node.setCphno(temp_cno);
        System.out.println("Your Order Details");
        for (int i = 0; i <node.getL1().size(); i++) {
            Pizza p3 = node.getL1().get(i);
            System.out.println((i + 1)+"\n\t" + "\n\t"+node.getCname() + "\n\t"+p3.getPizzaname() +"\n\t"+ p3.getSize()+"\n\t" + p3.getPrice()+"\n\t" + node.getCphno() + "\n\t" + node.getTotal());

            System.out.println("-------------------------------------------------------------------------------------------------------");
        }
        if (rear == null) {
            this.front = this.rear =node;
            System.out.println("Completed First Order:");
        } else {
            this.rear.next =node;
            this.rear =node;
            System.out.println("Order Succesfully added:");
        }

    }
    public void dequeue(){
        if (this.front==null) {
            System.out.println("........No Orders.......");
            return;
        }
            Node ptr=this.front;
            this.front=this.front.next;
            System.out.println("\n\tSuccefully delivered following details:\n\t"+ptr.getL1()+"\n\t************Pay Bill*************"+"\n\t"+ptr.getTotal()+ptr.getCname()+ptr.getCphno());
            ptr=null;
            if (this.front==null){
                this.rear=null;
            }
        }
    public void display(){
        Node ptr=front;
        if (front==null){
            System.out.println("........No Orders......");
        }
        else {
            System.out.println("****************Orders****************");
            while(ptr!=null){

                for (int i = 0; i <ptr.getL1().size(); i++) {
                    Pizza p3 = ptr.getL1().get(i);
                    System.out.println((i + 1) + ptr.getCname() + p3.getPizzaname() + p3.getSize() + p3.getPrice() + ptr.getCphno() + "\n\t" + ptr.getTotal());
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                }

                ptr=ptr.next;
            }

        }
    }

    public static void main(String args[]) throws IOException {
        pizza_parlour p3=new pizza_parlour(null,null);
        Scanner sc=new Scanner(System.in);
        int choice;
        System.out.println("*************WELCOME TO PIZZA FACTORY************** ");
        do {
            System.out.println("\n\t1]Order Pizza\n\t2]Deliver Order\n\t3]Display Order");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();

            switch(choice){
                case 1:{
                    p3.enqueue();
                    break;
                }
                case 2:{
                    p3.dequeue();
                    break;
                }
                case 3:{
                    p3.display();
                    break;
                }

            }
            System.out.println("Do you want to Continue press 1:");
        }while(sc.nextInt()==1);
    }
}


