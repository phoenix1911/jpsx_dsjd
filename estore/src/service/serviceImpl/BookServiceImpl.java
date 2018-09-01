package service.serviceImpl;

import bean.Book;
import common.util.SqlSessionFactoryUtil;
import dao.BookDaoMapper;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjl on 2018/8/31 14:33.
 */
public class BookServiceImpl implements BookService {

    private BookDaoMapper bookDaoMapper;
    {
        bookDaoMapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(BookDaoMapper.class);
    }

    @Override
    public List<Book> selectRecommendedBooks() {
        return bookDaoMapper.selectRecommendedBooks();
    }

    @Override
    public List<Book> selectBestSeller3Books() {
        List<Integer> integers = bookDaoMapper.selectBestSeller3Books2();
        Book book1 = bookDaoMapper.selectBookById(integers.get(0));
        Book book2 = bookDaoMapper.selectBookById(integers.get(1));
        Book book3 = bookDaoMapper.selectBookById(integers.get(2));
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }

    @Override
    public List<Book> selectBooksByCategory(int id) {
        return bookDaoMapper.selectBookByCategoryId(id);
    }

    @Override
    public Book selectBookById(int id) {
        return bookDaoMapper.selectBookById(id);
    }
}
