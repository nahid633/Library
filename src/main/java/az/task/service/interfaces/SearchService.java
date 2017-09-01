package az.task.service.interfaces;
import az.task.model.Book;
import java.util.List;

public interface SearchService {
    List<Book> queryGoogleBooks(String query) throws Exception;
}
