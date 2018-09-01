package bean;

/**
 *
 * Created by Tjl on 2018/9/1 8:33.
 */

/**
 * session
 * 购物车对象   Map<bookid,购物车项ShopcartLine>
 */
public class ShopcartLine {
    private Book book;
    private int number;

    @Override
    public String toString() {
        return "ShopcartLine{" +
                "book=" + book +
                ", number=" + number +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShopcartLine() {
    }

    public ShopcartLine(Book book, int number) {
        this.book = book;
        this.number = number;
    }
}
