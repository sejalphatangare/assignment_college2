import java.util.*;
class reverse{
    Scanner sc1=new Scanner(System.in);
    String exp;
    char ch;
    char reverse_array[]=new char[89];
    int top;
    reverse(){
        top=-1;
    }
    char push(char ch) {
        if (top== exp.length()-1){
            System.out.println("Stack is full");
        }
        else {
            reverse_array[++top]=ch;
        }

        return ch;

    }
    char pop() {
        if(top==-1){
            System.out.println("Stack is Empty");
        }else {
            ch=reverse_array[top--];
        }
        return ch;

    }
    void reverse_String() {
        System.out.println("Enter the String:");
        exp=sc1.next();
        for(int i = 0;i<exp.length();i++) {
            ch=exp.charAt(i);
            if (Character.isAlphabetic(ch)){
                push(ch);
            }
            else {
                System.out.println("Enter the valid String");
            }
        }
        for(int i=0;i<exp.length();i++) {
            System.out.print(pop());
        }
        System.out.println();

    }
}
class Stackfinal{

    Scanner sc=new Scanner(System.in);
    String post;
    Double st[];
    int top;
    int maxsize;
    Stackfinal(int n){
        top=-1;
        maxsize=n;
        st = new Double[maxsize];
    }
    Double push(Double v){

        if (top== maxsize-1){
            System.out.println("Stack is full");
        }
        else {
            st[++top]=v;
        }
        return v;
    }
    Double pop() {
        Double v = 0.0;
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            v = st[top--];
        }
        return v;
    }
    double eval(double op1, char op, double op2){
        if(op=='+')
        {
            return (op1+op2);
        }
        else if(op=='-')
        {
            return (op1-op2);
        }
        else if (op=='*')
        {
            return (op1*op2);
        }
        else
            return (op1 / op2);

    }
    void post_eval(){
        int len,i;
        Double v,op1,op2;
        char ch;
        len=post.length();
        for (i=0;i<len;i++){
            ch=post.charAt(i);
            if (Character.isAlphabetic(ch)){
                System.out.println("\n\tEnter value for "+ch);
                v=sc.nextDouble();
                push(v);
//                st[++top]=v;
            }
            else{

                op2=pop();
                op1=pop();
                v=eval(op1,ch,op2);
                push(v);
            }
        }

        System.out.println("\n\tResult is "+pop());

    }
    void reverse() {
        for(int i=0;i<maxsize;i++) {
            System.out.println("enter elements:");
            Double c=sc.nextDouble();
            push(c);
        }   for(int i=0;i<maxsize;i++) {
            System.out.println(pop());
        }




    }
    public static void main(String args[]){
        Scanner sc1=new Scanner(System.in);
        reverse r1=new reverse();
        System.out.println("Enter size of stack:");
        int n=sc1.nextInt();
        Stackfinal p1=new Stackfinal(n);
        System.out.println("Enter the expression for evaluation: ");
        p1.post=sc1.next();
        int ch;
        int choice;
        do {
            System.out.println("\n\t1]Evaluation of Expression:\n\t2]Reverse a string:");
            System.out.println("\n\tEnter your choice:");
            choice=sc1.nextInt();
            switch (choice) {
                case 1: p1.post_eval();
                    break;

                case 2:
                    r1.reverse_String();
                    break;
                default:System.out.println("Invalid Input!");

            }
            System.out.println("Do you want to continue");
            System.out.println("Enter 1 for YES\nEnter 0 for NO");
            ch=sc1.nextInt();

        }while(ch!=0);
        System.out.println("Exit"); }

}

