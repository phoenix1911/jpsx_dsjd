package dao;

import bean.Book;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 11:01.
 */
public interface BookDaoMapper {
    //根据ID查书
    public Book selectBookById(int id);

    public List<Book> select2BooksByCategoryId(Integer id);

    //查看推荐书籍
    public List<Book> selectRecommendedBooks();


    //查看前3畅销书籍
    public List<Book> selectBestSeller3Books();
    public List<Integer> selectBestSeller3Books2();

    //按分类获取书
    public List<Book> selectBookByCategoryId(int id);
}
