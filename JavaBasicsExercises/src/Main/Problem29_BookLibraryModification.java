package Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Problem29_BookLibraryModification {
    public static DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int counts = Integer.parseInt(scanner.nextLine());
        List<BookModified> books = new ArrayList<>(counts);
        for (int i = 0; i < counts; i++) {
            String line = scanner.nextLine();
            String [] bookData = line.split(" ");
            BookModified book = new BookModified(
                    bookData[0],
                    bookData[3]);
            books.add(book);
        }

        String delimiterDate = scanner.nextLine();
        Date date = df.parse(delimiterDate);
        HashSet<String> titlesPrinted = new HashSet<>();
        books
                .stream()
                .filter(book -> book.getReleaseDate().compareTo(date) == 1)
                .sorted(Comparator.comparing((BookModified book)-> book.getReleaseDate())
                        .thenComparing(Comparator.comparing((BookModified book)-> book.getTitle())))
                .forEach(book-> {
                    String title = book.getTitle();
                    String releaseDate = df.format(book.getReleaseDate());
                    titlesPrinted.add(title);
                    System.out.printf("%s -> %s",title, releaseDate);
                    System.out.println();
                });
    }
}

final class BookModified {
    private final String title;
    private Date releaseDate;

    public BookModified(String title, String releaseDate) {
        this.title = title;
        this.setReleaseDate(releaseDate);
    }


    public final Date getReleaseDate() {
        return this.releaseDate;
    }

    public final String getTitle(){
        return this.title;
    }

    private void setReleaseDate(String date){
        try{
            this.releaseDate = Problem29_BookLibraryModification.df.parse(date);
        }catch (ParseException pE){

        }
    }

}