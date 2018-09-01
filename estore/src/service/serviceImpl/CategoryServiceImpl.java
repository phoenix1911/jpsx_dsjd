package service.serviceImpl;

import bean.Book;
import bean.Category;
import common.util.SqlSessionFactoryUtil;
import dao.CategoryDaoMapper;
import org.apache.ibatis.session.RowBounds;
import service.CategoryService;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 9:32.
 */
//分类的数据访问层
public class CategoryServiceImpl implements CategoryService {
    private CategoryDaoMapper categoryDaoMapper;
    {
        categoryDaoMapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(CategoryDaoMapper.class);
    }
    @Override
    public List<Category> findAllCategory() {
        List<Category> allCategory = categoryDaoMapper.findAllCategory();
        for (Category c: allCategory) {
            List<Book> books = categoryDaoMapper.select2BooksByCategoryId(c.getId());
            c.setBooks(books);
        }
        System.out.println(allCategory);
        return allCategory;
    }

    @Override
    public List<Category> find5rowCategory() {
        int offset = 0;
        int limit = 5;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return categoryDaoMapper.find5rowCategory(rowBounds);
    }


}
