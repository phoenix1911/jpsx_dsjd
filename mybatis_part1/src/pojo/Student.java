package pojo;

import java.util.Date;

/**
 * Created by Tjl on 2018/8/24 14:26.
 */
public class Student {
    private int stuId;
    private String name;
    private String email;
    private Date dob;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Student(int stuId, String name, String email, Date dob) {
        this.stuId = stuId;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {
    }
}
