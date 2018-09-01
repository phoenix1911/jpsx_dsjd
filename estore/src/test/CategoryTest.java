package test;

import bean.Category;
import common.util.SqlSessionFactoryUtil;
import dao.CategoryDaoMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 9:16.
 */
public class CategoryTest {
    @Test
    public void demo1_find5rowCategory() {
        CategoryDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(CategoryDaoMapper.class);

        int offset=0;
        int limit = 5;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Category> allCategory = mapper.find5rowCategory(rowBounds);
        for (int i = 0; i < allCategory.size(); i++) {
            System.out.println(allCategory.get(i));
        }
    }


}
