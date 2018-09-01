package test;

import bean.Book;
import common.util.SqlSessionFactoryUtil;
import dao.BookDaoMapper;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 11:20.
 */
public class BookTest {
    @Test
    public void selcet2Books() {
        BookDaoMapper mapper = SqlSessionFactoryUtil.getSqlSession(true).getMapper(BookDaoMapper.class);
//        List<Book> books = mapper.select2BooksByCategoryId(1);

//        System.out.println(books);

        List<Integer> integers = mapper.selectBestSeller3Books2();
        System.out.println(integers);

    }
}
