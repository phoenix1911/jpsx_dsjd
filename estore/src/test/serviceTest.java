package test;

import bean.Book;
import bean.Category;
import org.junit.Test;
import service.CategoryService;
import service.serviceImpl.CategoryServiceImpl;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 9:39.
 */
public class serviceTest {
    @Test
    public void CategoryTest() {

        CategoryService categoryService = new CategoryServiceImpl();

//        List<Category> allCategory = categoryService.findAllCategory();
//        System.out.println(allCategory);

//        List<Category> rowCategory = categoryService.find5rowCategory();
//        System.out.println(rowCategory);

//        List<List<Book>> categoryWith2Books = categoryService.findCategoryWith2Books();
    }




}
