import java.io.*;
import java.util.*;
class book{
String Bookn,Authorn,Publication;
int isbn;
book(String Bookn,String Authorn,String Publication,int isbn){
    this.Bookn=Bookn;
    this.Authorn=Authorn;
    this.Publication=Publication;
    this.isbn=isbn;

}
}
public class library {
    int k=0;
    Scanner sc1 = new Scanner(System.in);
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
     book[] book_data = new book[50];

    void accept_book_details() throws IOException {

        do{
            System.out.println("Enter the Book Name:");
            String Bookn = br.readLine();
            System.out.println("Enter the Author's name:");
            String Authorn = br.readLine();
            System.out.println("Enter the Publication's name:");
            String Publication = br.readLine();
            System.out.println("Enter the ISBN number:");
            int isbn = sc1.nextInt();

            book_data[k++] = new book(Bookn, Authorn, Publication, isbn);
            System.out.println("Do you want to add more books press 0");
        }while(sc1.nextInt()==0);

    }

    void insert_Book(){

    }
    void display_book_details() {
        if(k==0){
            System.out.println("Library is Empty");
            return;
        }
        for (int i = 0; i < k; i++) {
            System.out.println("Book Number " + (i + 1) + " details:");
            System.out.println("Name of the book:" + book_data[i].Bookn);
            System.out.println("Author of the book:" + book_data[i].Authorn);
            System.out.println("Publication of the book:" + book_data[i].Publication);
            System.out.println("ISBN number of the book:" + book_data[i].isbn);
            System.out.println(" ");
        }
    }

    void search_isbn() {
//linear search
        System.out.println("Enter the isbn no to be searched:");
        int num = sc1.nextInt();
        int i = 0;
        for (i = 0; i < k; i++) {
            if (book_data[i].isbn==num) {
                break;
            }
        }
        if (i == k) {
            System.out.println("Book not Found!");
        }
        else {
            System.out.println("Book found at " + (i + 1) + " location");
            System.out.println("Book Details:" + "\nBook Name:" + book_data[i].Bookn);
            System.out.println("\nAuthor Name:" + book_data[i].Authorn);
            System.out.println("\nPublication Name:" + book_data[i].Publication);
            System.out.println("\nISBN Number of the book:" + book_data[i].isbn);
        }

    }

    public void sort_books() {
        int temp;
        // Sorting strings using bubble sort
        for (int i = 0; i< k - 1; i++) {
            for (int j =1; j < (k-i); j++) {
                if (book_data[j-1].isbn>book_data[j].isbn) {
                    temp = book_data[j-1].isbn;
                    book_data[j-1].isbn = book_data[j].isbn;
                    book_data[j].isbn = temp;
                }
            }
        }
        System.out.println("Sorted Array with respect to Author Name:");
        System.out.print("[");
        for (int i = 0; i < k; i++)
            System.out.print(book_data[i].isbn+" ");
        System.out.print("]");
        System.out.println(" ");
    }

    void search_authorn() throws IOException {

        //linear search
        /*
        String search;

        int flag=0,var = 0;
        System.out.println("Enter the String you want to search:");
        search=br.readLine();
        for (int i=0;i<k;i++) {
            int m=search.compareTo(book_data[i].Authorn);
            if (m == 0) {
                flag=1;
                var=i;
                continue;
            }
        }
        if (flag==1) {
            System.out.println("Author Name Found at: "+(var+1)+" position");
            System.out.println("Book Name: "+book_data[var].Bookn);
            System.out.println("Author Name: "+book_data[var].Authorn);
            System.out.println("Publication Name: "+book_data[var].Publication);
            System.out.println("ISBN Number: "+book_data[var].isbn);



        } else {
                System.out.println("element not found");


            }
        */

        String search;
        int flag=0;

        System.out.println("Enter the String you want to search:");
        search=br.readLine();
        for (int i=0;i<k;i++) {
            int m=search.compareTo(book_data[i].Authorn);
            if (m == 0) {

                System.out.println("Author Name Found at: "+(i+1)+" position");
                System.out.println("Book Name: "+book_data[i].Bookn);
                System.out.println("Author Name: "+book_data[i].Authorn);
                System.out.println("Publication Name: "+book_data[i].Publication);
                System.out.println("ISBN Number: "+book_data[i].isbn);
                flag=1;
            }
        }
        if(flag==0) {
            System.out.println("element not found");
        }


    }
    void remove_book() throws IOException {
        String book_to_search;
        int flag=0;
        System.out.println("Enter the book name to be searched:");
        book_to_search = br.readLine();
        int i = 0,pos = 0;
        for (i = 0; i < k; i++) {
            if (book_data[i].Bookn.equals(book_to_search)) {
                System.out.println("Author Name Found at: "+(i+1)+" position");
                System.out.println("Book Name: "+book_data[i].Bookn);
                System.out.println("Author Name: "+book_data[i].Authorn);
                System.out.println("Publication Name: "+book_data[i].Publication);
                System.out.println("ISBN Number: "+book_data[i].isbn);
                pos=i;
                flag=1;
                for(int j=pos;j<(k-1);j++){
                    book_data[i]=book_data[i+1];
                }
                book_data[k].Bookn=null;
                k--;
                }

        }
        if(flag==0) {
            System.out.println("element not found");
        }




    }
    public static void main(String args[]) throws IOException {
        Scanner sc1=new Scanner(System.in);
        library l1=new library();
        int n;

        do {
        System.out.println("Enter your Choice:");
        System.out.println("1]Insert a book\n2]Display the details of books\n3]Search Book by isbn no:\n4]Sort books based on ISBN numbers:\n5]List all books of specific author");
        int choice=sc1.nextInt();


            switch (choice) {
                case 1:
                    l1.accept_book_details();
                    break;
                case 2:
                    l1.display_book_details();
                    break;
                case 3:
                    l1.search_isbn();
                    break;
                case 4:
                    l1.sort_books();

                    break;
                case 5:
                    l1.search_authorn();
                    break;
                case 6:
                    l1.remove_book();
            }
            System.out.println("Do you want to continue:");
            System.out.println("Enter 1 for YES\nEnter 0 for NO");
            n=sc1.nextInt();
}
while (n==1);



    }


}
