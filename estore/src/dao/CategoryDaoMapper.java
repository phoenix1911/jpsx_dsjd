package dao;

import bean.Book;
import bean.Category;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 9:13.
 */
public interface CategoryDaoMapper {

    public List<Category> findAllCategory();

    public List<Category> find5rowCategory(RowBounds rowBounds);

    public List<Book> select2BooksByCategoryId(Integer id);


}
