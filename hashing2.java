import java.util.*;
class account {
    int id;
    String name;
    int balance;
    int chain;

    public account( int id, String nm, int bal) {
        this.id = id;
        name = nm;
        balance = bal;
        chain=-1;
    }
}
class Table {
    int  size;
    int  index;
    int count;
    int flag=0;
    account[] hashtable;
    Table(int size){
        this.size=size;
        hashtable=new account[size];
    }
    Scanner sc = new Scanner(System.in);
    int getindex(int  id) {
        return id%size;
    }
    void create()
    {   boolean p=false;

        int a=0;
        int c=0;


        do {
            int i=0;
            count=0;

            while(i<size){
                if(hashtable[i]==null){
                    count++;
                }
                i++;
            }

            if(count==0){
                System.out.println("Table is full");
            }
            else {

                System.out.println("Enter the ID of the customer:");
                int id = sc.nextInt();
                System.out.println("Enter the name of the customer:");
                String name = sc.next();
                System.out.println("Enter the balance of the customer:");
                int bal = sc.nextInt();
                index = getindex(id);
                int q=index;
                account data = new account(id, name, bal);
                while (hashtable[index] != null) {
                    if(hashtable[index] != null && q==index){
                        p = true;
                        c = index;
                    }
                    index = (++index) % size;
                }

                if (p) {
                    hashtable[c].chain = index;
                }

                hashtable[index] = data;
            }
            System.out.println("Do you want to add another account data enter 1 if yes otherwise enter any number");
            a=sc.nextInt();
        }while (a==1);
    }
    void display() {
        int i = 0;
        int flag = 0;
        while (i < size) {

            if (hashtable[i] == null) {
                flag++;
            } else if (hashtable[i] != null) {
                System.out.println(i + ".Customer:-");
                System.out.println("Customer id: " + hashtable[i].id);
                System.out.println("Customer name: " + hashtable[i].name);
                System.out.println("Total balance: " + hashtable[i].balance);
                System.out.println("Chain number: " + hashtable[i].chain);
            }
            i++;
        }
        if (flag == size) {
            System.out.println("Empty Hashtable");
        }
    }
    void search() {
        flag=0;
        System.out.println("Enter the customer Id to be searched: ");
        int ID1 = sc.nextInt();
        int b = (ID1 % size);
        while (hashtable[b] != null) {
            if (hashtable[b].id == ID1) {
                System.out.println("Customer found!");
                System.out.println("Customer name:" + hashtable[b].name);
                System.out.println("Customer balance:" + hashtable[b].balance);
                break;
            } else if (hashtable[b].id != ID1) {
                b = (b + 1) % size;
                flag++;
                if (flag == size) {
                    System.out.println("Customer not found!");
                    break;
                }}}}
    void delete()
    {
        flag=0;
        System.out.println("Enter the customer Id to be deleted: ");
        int ID1 = sc.nextInt();
        int b = (ID1 % size);
        while (hashtable[b] != null) {
            if (hashtable[b].id == ID1) {
                hashtable[b]=null;
                break;
            }
            else if(hashtable[b].id != ID1){
                b = (b + 1) % size;
                flag++;
                if(flag==size){
                    System.out.println("Customer not found!");
                    break;
                }
            }}}}

public class hashing2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s;
        System.out.println("Enter the size of the table: ");
        s= sc.nextInt();
        Table t = new Table(s);

        int choice;

        do {
            System.out.println("1.INSERT \n2.DISPLAY\n3.SEARCH\n4.DELETE\n0.EXIT");
            System.out.println("Enter the option : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    t.create();
                    break;
                case 2:
                    t.display();
                    break;
                case 3:
                    t.search();
                    break;
                case 4:
                    t.delete();
                    break;

                default: System.out.println("INVALID INPUTS");
                    break;
            }
            System.out.println("Do you want to continue if yes then enter 1 otherwise enter any number");
            choice=sc.nextInt();
        } while (choice != 0);
    } }