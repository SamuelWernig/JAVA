package at.htlle.sam.BetterBuecherei;
import java.util.Scanner;
public class Liabrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Book book1 = new Book("Es war einmal", "Johnny cash", "Nein");
        Book book2 = new Book("Ein man ein Leben", "Albert Hartmann", "Nein");

        System.out.println("Author: "+book1.getAuthor()+", Title: "+book1.getTitle());
        System.out.println("Author: "+book2.getAuthor()+", Title: "+book2.getTitle());
        System.out.println("-------------------------------------------------");

        Reader reader1 = new Reader("Stefan", 0);
        Reader reader2 = new Reader("Phil", 0);
        String input = " ";
        while (!endWhile(input)){
            System.out.println("Please enter your a name and afterwards a book wich got borrowed.");

            ribEingabe(scan,reader1,reader2, book1, book2);
        }


    }

    private static void ribEingabe(Scanner scan, Reader reader1, Reader reader2,Book book1, Book book2) {
        String input = scan.nextLine().trim();

        if (input.equals(reader1.getName())) {
            reader1.setBorrowedBooks(reader1.getBorrowedBooks()+1);
            System.out.println(reader1.getName()+" borrowed "+reader1.getBorrowedBooks());
        }
        else if (input.equals(reader2.getName())) {
            reader2.setBorrowedBooks(reader2.getBorrowedBooks()+1);
            System.out.println(reader2.getName()+" borrowed "+reader2.getBorrowedBooks());
        }
        input = scan.nextLine().trim();
        if (input.equals(book1.getTitle())) {
            book1.setBorrowed("Ja");
            System.out.println("Borrowed: "+book1.getBorrowed()+", Title: "+book1.getTitle());
        }
        else if (input.equals(book2.getTitle())) {
            book2.setBorrowed("Ja");
            System.out.println("Borrowed: "+book2.getBorrowed()+", Title: "+book2.getTitle());
        }
    }

    private static boolean endWhile(String input){
        return input.equals("0");
    }

}
