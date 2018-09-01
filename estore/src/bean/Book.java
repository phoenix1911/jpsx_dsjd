package bean;

/**
 * Created by Tjl on 2018/8/31 8:43.
 */
public class Book {
    private int id;
    private int categoryid;
    private String name;
    private Double price;
    private int state;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", categoryid=" + categoryid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Book(int id, int categoryid, String name, Double price, int state) {
        this.id = id;
        this.categoryid = categoryid;
        this.name = name;
        this.price = price;
        this.state = state;
    }

    public Book() {
    }
}
