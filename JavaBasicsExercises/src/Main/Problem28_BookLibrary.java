package Main;

import java.util.*;

public class Problem28_BookLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Book> books = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String [] data = input.split(" ");
            String bookTitle = data[0];
            String bookAuthor = data[1];
            String bookPublisher = data[2];
            String releaseDate = data[3];
            String isbnNumber = data[4];
            double bookPrice = Double.parseDouble(data[5]);
            Book book = new Book(bookTitle, bookAuthor, bookPublisher, releaseDate, isbnNumber, bookPrice);
            books.add(book);
        }

        Library lib = new Library("Nothing", books);
        List<Author> authors = new ArrayList<>();
        lib.getBooks()
                .stream()
                .map(book -> book.getAuthor())
                .distinct()
                .forEach(author -> {
                    double sum = lib.getBooks()
                            .stream()
                            .filter(b -> b.getAuthor().equals(author))
                            .mapToDouble(b -> b.getPrice())
                            .sum();
                    Author currentAuthor = new Author(author, sum);
                    authors.add(currentAuthor);
        });

        authors
                .stream()
                .sorted(Comparator.comparing((Author author) -> author.getTotalSumOfPrices())
                        .reversed()
                        .thenComparing(Comparator.comparing((Author author)-> author.getName())))
                .forEach(pair -> {
                    System.out.printf("%s -> %.2f", pair.getName(), pair.getTotalSumOfPrices());
                    System.out.println();
        });
    }
}

final class Author{
    private final String name;
    private final double totalSumOfPrices;

    public Author(String name, double totalSumOfPrices) {
        this.name = name;
        this.totalSumOfPrices = totalSumOfPrices;
    }

    public final String getName() {
        return name;
    }

    public final double getTotalSumOfPrices() {
        return totalSumOfPrices;
    }

}

final class Library {
    private final String name;
    private final List<Book> books;

    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public final List<Book> getBooks() {
        return books;
    }
}

final class Book {
    private final String title;
    private final String author;
    private final String publisher;
    private final String releaseDate;
    private final String isbnNumber;
    private final double price;

    public Book(String title, String author, String publisher, String releaseDate, String isbnNumber, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.isbnNumber = isbnNumber;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

}
