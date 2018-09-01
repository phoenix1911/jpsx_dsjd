package service;

import bean.Book;
import bean.Category;

import java.util.List;

/**
 * Created by Tjl on 2018/8/31 9:32.
 */
public interface CategoryService {
    public List<Category> findAllCategory();

    public List<Category> find5rowCategory();


}
