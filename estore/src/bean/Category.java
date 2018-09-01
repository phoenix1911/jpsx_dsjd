package bean;

/**
 * Created by Tjl on 2018/8/31 8:39.
 */

import java.util.List;

/**
 * 书籍分类表
 */
public class Category {
    private int id;
    private String name;
    private String info;
    private List<Book> books; //该分类下的推荐书籍

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", books=" + books +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Category(int id, String name, String info, List<Book> books) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.books = books;
    }

    public Category(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Category() {
    }
}
