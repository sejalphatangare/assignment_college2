import java.util.*;
 class operation {
    int p,q,m,n;
     int a[][] = new int[100][100];
     int b[][] = new int[100][100];
     int c[][]=new int[100][100];
    Scanner sc=new Scanner(System.in);
    void accept() {
        System.out.println("Enter number of rows in first matrix:");
        p = sc.nextInt();
        System.out.println("Enter number of columns in first matrix:");
        q = sc.nextInt();
        System.out.println("Enter number of rows in second matrix:");
        m = sc.nextInt();
        System.out.println("Enter number of columns in second matrix:");
        n = sc.nextInt();

        System.out.println("Enter value of elements for first matrix:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter value of elements for second matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }
    }
    void display() {
            System.out.println("First Matrix:");
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < q; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println(" ");
            }
            System.out.println("Second matrix");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(b[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
    void square(){
        System.out.println("For first:");
        if (p==q){
            System.out.println("First Matrix is Square Matrix");
        }
        else{
            System.out.println("It is not a Sqaure Matrix");
        }
        System.out.println("For second:");
        if (m==n){
            System.out.println("Second matrix is square matrix");
        }
        else{
            System.out.println("it is not a Square matrix");
        }
        }
    void uppertriangular(){
        int flag=0;

        for (int i=1;i<p;i++){
            for(int j=0;j<i;j++){
                if(a[i][j] != 0){
                    flag=0;
                }
                else{
                    flag=1;
                }
            }
        }
        if(flag==1){
            System.out.println("First matrix is Upper Triangular Matrix");
        }
        else{
            System.out.println("First matrix is not upper triangular matrix");
        }
        int t=0;
        for (int i=1;i<m;i++){
            for(int j=0;j<i;j++){
                if(b[i][j] != 0){
                    t=0;
                }
                else{
                    t=1;
                }
            }
        }
        if(t==1){
            System.out.println("Second matrix is Upper Triangular Matrix");
        }
        else{
            System.out.println("Second matrix is not an upper triangular matrix");
        }
    }
    void transpose(){
        System.out.println("Transpose of a Matrix is:");
        for(int i=0;i<p;i++){
            for (int j=0;j<q;j++){
                System.out.print(a[j][i]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("Transpose of a Matrix is:");
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(b[j][i]+" ");
            }
            System.out.println(" ");
        }

    }
     void add(){
        if(p==m && q==n){

            for (int i = 0; i < p; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < q; k++) {
                        c[i][j] = a[i][j] + b[i][j];
                    }
                }
            }
            System.out.println("Matrix after Addition");
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(c[i][j] + " ");
                }
                    System.out.println(" ");
            }
        }
        else{
            System.out.println("Addition is not possible");
        }
    }
    void multiply(){
        if(p==n){
            System.out.println("Multiplying the matrices.....");
            for(int i=0;i<p;i++){
                for(int j=0;j<n;j++){
                    c[i][j]=0;
                    for(int k=0;k<m;k++){

                        c[i][j]+=a[i][k]*b[k][j];
                    }

                }
            }
            System.out.println("the product is:");
            for (int i=0;i<p;i++){
                for(int j=0;j<q;j++){
                    System.out.print(c[i][j]+" ");
                }
                System.out.println(" ");
            }
        }
    }


}
class matrix{
    public static void main(String args[]){
        Scanner sc1=new Scanner(System.in);
        operation m=new operation();
        m.accept();
        m.display();

        int var=0;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1]Check if matrix is a Square:");
            System.out.println("2]Check if matrix is Upper triangular:");
            System.out.println("3]Transpose of matrix:");
            System.out.println("4]Addition:");
            System.out.println("5]Multiplication:");
            int choice = sc1.nextInt();
            switch (choice) {
                case 1:
                    m.square();
                    break;
                case 2:
                    m.uppertriangular();
                    break;
                case 3:
                    m.transpose();
                    break;
                case 4:
                    m.add();
                    break;
                case 5:
                    m.multiply();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("Do you want to continue:");
            System.out.println("Enter 1 for yes:\nEnter 0 for no:");
            var = sc1.nextInt();
        }
            while (var==1);




    }
}
