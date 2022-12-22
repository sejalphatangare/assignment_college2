import java.util.*;
import java.io.*;
public class Table {
    int size;
    Customer[] hashtable;
    public Table(int size) {
        this.size = size;
        hashtable=new Customer[size];

    }
    Scanner sc=new Scanner(System.in);
    InputStreamReader ir=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ir);


//    create a hash method for generating the hash address :
    public int hash(double id){
        return (int) id % size;
    }

//    method for finding if the hashtable is Full or not:
    public boolean isFull(){
        for(int i=0;i<size;i++){
            if(hashtable[i]==null){
                return false;
            }
        }
        return true;
    }
//    method for finding if the hashtable is Empty or not:
    public boolean isEmpty(){
        for(int i=0;i<size;i++){
            if(hashtable[i]!=null){
                return false;
            }
        }
        return true;
    }
//    method to create the hashtable:
    public void create(double id,String name,double balance) throws IOException {
        if(isFull()){
            System.out.println("\n\tHashTable Is Full!");
        }
        else{
           Customer c1=new Customer(id,name,balance);
           int hashvalue=hash(id);
           if(hashtable[hashvalue]!=null){
               System.out.println("\n\tCollision Occurred!");
           }

//          linear probing
            while(hashtable[hashvalue]!=null){
                   hashvalue=(hashvalue+1)%size;
            }
            hashtable[hashvalue]=c1;
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("\n\tHashTable Is Empty!");
        }
        else{
            for(int i=0;i<size;i++){
                if(hashtable[i]!=null){
                    System.out.println("\n\tName of the Customer : "+hashtable[i].name);
                    System.out.println("\n\tCustomer ID : "+hashtable[i].id);
                    System.out.println("\n\tBalance Amount: "+hashtable[i].balance);
                    System.out.println("\n\t ");

                }
            }
        }
    }
    public void search() {
            System.out.println("\n\tEnter the Account Number: ");
            double tosearch = sc.nextInt();

            int hashvalue = hash(tosearch);
            int flag = 0;
            int count = size;
            while (hashtable[hashvalue] != null && count!=0) {
                if (hashtable[hashvalue].id == tosearch) {
                    flag = 1;
                    System.out.println("\n\tSuccesfully Found!");
                    System.out.println("\n\tName: " + hashtable[hashvalue].name);
                    System.out.println("\n\tID: " + hashtable[hashvalue].id);
                    System.out.println("\n\tBalance Amount: " + hashtable[hashvalue].balance);
                    System.out.println("\n\t");
                    break;
                }
//                System.out.println("Hello1");
                count--;
                hashvalue = (hashvalue + 1) % size;
            }
            if (flag == 0) {
                System.out.println("\n\tAccount Not Found!");
            }
    }
            /*if(hashtable[hashvalue]!=null){
                while(count!=0 && hashtable[hashvalue].id!=tosearch) {
                    hashvalue = (hashvalue + 1) % size;
                    count--;//so that we dont traverse same element twice
                }
            }
            if(count==0 || hashtable[hashvalue]==null){
                System.out.println("\n\tAccount Number not Found!");
            }
            else{
                System.out.println("\n\tSuccesfully Found!");
                System.out.println("\n\tName: "+hashtable[hashvalue].name);
                System.out.println("\n\tID: "+hashtable[hashvalue].id);
                System.out.println("\n\tBalance Amount: "+hashtable[hashvalue].balance);
                System.out.println("\n\t");
            }
        }*/


    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        InputStreamReader ir1 = new InputStreamReader(System.in);
        BufferedReader br1 = new BufferedReader(ir1);
        System.out.println("\n\tEnter the Size of the HashTable: ");
        int size = sc1.nextInt();
        Table t1 = new Table(size);

        do {
            System.out.println("Enter the choices \n1-insert\n2-display\n3-search");
            switch (sc1.nextInt()){
                case 1:{
                    System.out.println("\n\tEnter your Account number : ");
                    double id = sc1.nextDouble();
                    System.out.println("\n\tEnter your Name: ");
                    String name = br1.readLine();
                    System.out.println("\n\tEnter the Balance Amount : ");
                    double balance = sc1.nextDouble();
                    t1.create(id, name, balance);
                    break;
                }
                case 2:{
                    t1.display();
                    break;
                }
                case 3:{
                    t1.search();
                    break;
                }
            }
            System.out.println("\n\tDo you want to Continue press 1: ");
        } while (sc1.nextInt() == 1);

    }
}
