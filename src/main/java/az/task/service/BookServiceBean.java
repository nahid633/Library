package az.task.service;

import az.task.model.Book;
import az.task.service.interfaces.SearchService;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
@Service("bookService")
public class BookServiceBean implements SearchService {
    private static final String APPLICATION_NAME = "bookapi";
    @Override
    public  List<Book> queryGoogleBooks(String query)  throws Exception {
        ClientCredentials.errorIfNotSpecified();
        List<Book> listBooks = new ArrayList<>();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName(APPLICATION_NAME)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
                .build();
        // Set query string and filter only Google eBooks.
        System.out.println("Query: [" + query + "]");
        Books.Volumes.List volumesList = books.volumes().list(query);
//        volumesList.setFilter("ebooks");
        // Execute the query.
        Volumes volumes = volumesList.execute();
        if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
            System.out.println("No matches found.");
            return null;
        }
        // Output results.
        for (Volume volume : volumes.getItems()) {
            Book book = new Book();
            Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
            Volume.SaleInfo saleInfo = volume.getSaleInfo();
            System.out.println("==========");
            // Title.
            System.out.println("Title: " + volumeInfo.getTitle());
            book.setTitle(volumeInfo.getTitle());
            // Author(s).
            List<String> authors = volumeInfo.getAuthors();
            if (authors != null && !authors.isEmpty()) {
                System.out.print("Author(s): ");
                book.setAuthors(authors);
                authors.stream().forEach(System.out::println);
            }
            // Description (if any).
            if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
                System.out.println("Description: " + volumeInfo.getDescription());
                book.setDescription(volumeInfo.getDescription());
            }
            // Ratings (if any).
            if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
                int fullRating = (int) Math.round(volumeInfo.getAverageRating().doubleValue());
                System.out.print("User Rating: ");
                book.setRating(volumeInfo.getRatingsCount());
                for (int i = 0; i < fullRating; ++i) {
                    System.out.print("*");
                }
                System.out.println(" (" + volumeInfo.getRatingsCount() + " rating(s))");
            }
            System.out.println(volumeInfo.getInfoLink());
        listBooks.add(book);
        }

        System.out.println("==========");
        System.out.println(
                volumes.getTotalItems() + " total results at http://books.google.com/ebooks?q="
                        + URLEncoder.encode(query, "UTF-8"));
    return listBooks;
    }

}
