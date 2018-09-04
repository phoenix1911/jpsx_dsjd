package pojo;

import java.io.Serializable;

/**
 * Created by Tjl on 2018/8/29 9:51.
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Gender gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User(Integer id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public User() {
    }
}
