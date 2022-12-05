import java.util.*;
class postEval {

    Scanner sc=new Scanner(System.in);
    String post;
    int st[] = new int[10];
    int top;
    postEval(){
        top=-1;
    }
    int push(int v){

        if (top== st.length-1){
            System.out.println("Stack is full");
        }
        else {
            st[++top]=v;
        }
        return v;
    }
    int pop() {
        int v = 0;
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            v = st[top--];
        }
        return v;
    }
    int eval(double op1, char op, double op2){
        if(op=='+')
        {
           return (int) (op1+op2);
        }
        else if(op=='-')
        {
            return (int) (op1-op2);
        }
        else if (op=='*')
        {
            return (int) (op1*op2);
        }
        else
            return (int) (op1 / op2);

    }
    void post_eval(){
        int len,i,v,op1,op2;
        char ch;
        len=post.length();
        for (i=0;i<len;i++){
            ch=post.charAt(i);
            if (Character.isAlphabetic(ch)){
                System.out.println("\n\tEnter value for "+ch);
                v=sc.nextInt();
                push(v);
//                st[++top]=v;
            }
            else{

                op2=pop();
                op1=pop();
                v=eval(op1,ch,op2);
//                st[++top]=v;
                push(v);
            }
        }
//        pop();
//        v=st[top--];
        System.out.println("\n\tResult is "+pop());

    }
     void reverse() {
        String[] arr2= new String[10];
        String st2=sc.next();
        String v = null;
        int top=-1;

        for (int i=0;i< st2.length();i++){
            arr2[++top]=v;
        }
        for (int i=st2.length();i<0;i--){
            String a = arr2[top--];
            System.out.print(v);
        }

    }
    public static void main(String args[]){
        postEval p1=new postEval();
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter the expression for evaluation: ");
        p1.post=sc1.nextLine();
        int choice;
        do {
            System.out.println("\n\t1]Evaluation of Expression:\n\t2]Reverse a string:");
            System.out.println("\n\tEnter your choice:");
            choice=sc1.nextInt();

            switch (choice) {
                case 1: p1.post_eval();
                break;
                case 2:p1.reverse();
                break;
                case 3:System.out.println("Exit");
                break;
            }
        }
        while(choice!=3);
    }

}