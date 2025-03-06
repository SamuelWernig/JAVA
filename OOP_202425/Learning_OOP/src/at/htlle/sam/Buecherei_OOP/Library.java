package at.htlle.sam.Buecherei_OOP;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Reader reader1 = new Reader("Anton", 0);
        Reader reader2 = new Reader("Steven", 0);

        Book book1 = new Book("Fluch der Karibik 1", true);
        Book book2 = new Book("Der Angst im Fluge", true);

        Reader[] readers = {reader1, reader2};
        Book[] books = {book1, book2};

        String userInput;

        while (true) {
            // Eingabe des Lesers
            System.out.println("Gib den Namen eines Lesers ein (Anton oder Steven): ");
            userInput = scan.nextLine().trim(); // Eingabe für Lesername

            if (userInput.equals("Anton")) {
                reader1.setBooksOwned(reader1.getBooksOwned() + 1);
            } else if (userInput.equals("Steven")) {
                reader2.setBooksOwned(reader2.getBooksOwned() + 1);
            } else {
                System.out.println("Ungültiger Lesername.");
            }

            printStats(readers, books);
            System.out.println("----------------------------");

            // Eingabe des Buchtitels
            System.out.println("Gib den Titel eines Buches ein (Fluch der Karibik 1 oder Der Angst im Fluge): ");
            userInput = scan.nextLine().trim(); // Eingabe für Buchtitel

            // Überprüfung und Markierung der Buchverfügbarkeit
            if (userInput.equals(book1.getBook())) {
                book1.setAvailable(false);
            } else if (userInput.equals(book2.getBook())) {
                book2.setAvailable(false);
            } else {
                System.out.println("Ungültiger Buchtitel.");
            }

            printStats(readers, books);
        }
    }

    private static void printStats(Reader[] readers, Book[] books) {
        // Ausgabe der Statistiken der Leser
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].getNames() + ", Bücher: " + readers[i].getBooksOwned());
        }

        System.out.println("--------------------------------");

        // Ausgabe der Buchverfügbarkeit
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBook() + ": " + (books[i].getAvailable() ? "verfügbar" : "ausgeliehen"));
        }
    }
}
//Test Test
