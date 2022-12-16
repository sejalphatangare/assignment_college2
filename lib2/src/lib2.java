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
public class lib2 {
    int k = 0;
    Scanner sc1 = new Scanner(System.in);
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    book[] book_data = new book[50];

    void accept_book_details() throws IOException {

        do {
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
        } while (sc1.nextInt() == 0);
        System.out.println("k is "+k);
    }

    void display_book_details() {
        if (k == 0) {
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
//binary search
        sort_books();
        System.out.println("Enter the isbn no to be searched:");
        int num = sc1.nextInt();

        int min = 0;
        int max = k - 1;
        int mid = 0;
        int flag = 0;
        while (min <= max) {
            mid = (max + min) / 2;
            if (num == book_data[mid].isbn) {
                System.out.println("Book Number " + (mid + 1) + " details found at " + (mid + 1) + "location");
                System.out.println("Name of the book:" + book_data[mid].Bookn);
                System.out.println("Author of the book:" + book_data[mid].Authorn);
                System.out.println("Publication of the book:" + book_data[mid].Publication);
                System.out.println("ISBN number of the book:" + book_data[mid].isbn);
                flag = 1;
                break;
            } else {
                if (num > book_data[mid].isbn) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }


        }


        if (flag == 0) {
            System.out.println("Book Not Found");
        }
    }


    public void sort_books() {
        int temp;
        // Sorting strings using bubble sort

        for (int i = 0; i < k - 1; i++) {
            for (int j = 1; j < (k - i); j++) {
                if (book_data[j - 1].isbn > book_data[j].isbn) {
                    temp = book_data[j - 1].isbn;
                    book_data[j - 1].isbn = book_data[j].isbn;
                    book_data[j].isbn = temp;
                }
            }
        }
        System.out.println("Sorted Array with respect to Isbn no:");
        System.out.print("[");
        for (int i = 0; i < k; i++)
            System.out.print(" Isbn Number: " + book_data[i].isbn);
        System.out.print("]");
        System.out.println(" ");
        System.out.println("***********************************************************************************");
        System.out.println("Sorted Array with respect to isbn no:");
        System.out.print("[");
        for (int i = 0; i < k; i++)
            System.out.print("\nBook Name: " + book_data[i].Bookn + " \nIsbn Number: " + book_data[i].isbn + "\nAuthor Name: " + book_data[i].Authorn + " \nPublication: " + book_data[i].Publication + " \n");
        System.out.print("]");
        System.out.println(" ");
    }

    void search_authorn() throws IOException {
        String search;
        int flag = 0;
//Linear Search
        System.out.println("Enter the Author Name you want to search:");
        search = br.readLine();
        for (int i = 0; i < k; i++) {
            int m = search.compareTo(book_data[i].Authorn);
            if (m == 0) {

                System.out.println("Author Name Found at: " + (i + 1) + " position");
                System.out.println("Book Name: " + book_data[i].Bookn);
                System.out.println("Author Name: " + book_data[i].Authorn);
                System.out.println("Publication Name: " + book_data[i].Publication);
                System.out.println("ISBN Number: " + book_data[i].isbn);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("element not found");
        }


    }

    public static void main(String args[]) throws IOException {
        Scanner sc1 = new Scanner(System.in);
        lib2 l1 = new lib2();
        int n;

        do {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Enter your Choice:");
            System.out.println("\n\t1]Insert a book\n\t2]Display the details of books\n\t3]Search Book by isbn no:\n\t4]Sort books based on ISBN numbers:\n\t5]List all books of specific author");

            int choice = sc1.nextInt();

            System.out.println("-------------------------------------------------------------------------------");

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

            }
            System.out.println("Do you want to continue:");
            System.out.println("Enter 1 for YES\nEnter 0 for NO");
            n = sc1.nextInt();
        } while (n == 1);
        System.out.println("Thank You!");
    }
}


