package service;

import bean.Book;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 14:32.
 */
public interface BookService {
    public List<Book> selectRecommendedBooks();

    public List<Book> selectBestSeller3Books();

    public List<Book> selectBooksByCategory(int id);

    public Book selectBookById(int id);

}
