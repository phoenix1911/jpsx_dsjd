package pojo;

/**
 * Created by Tjl on 2018/8/25 10:00.
 */
//内存中PhoneNumber对象 --数据库中students表中的一个字段phone(varchar2)
//    #{phone}
public class PhoneNumber {
    private String countryCode;
    private String stateCode;
    private String number;


    //将一个PhoneNumber类型的对象转换为一个字符串
    public String getAsString() {
        return countryCode+"-"+stateCode+"-"+number;
    }

    //将一个"xxx-xxx-xxx"字符串转换成PhoneNumber对象
    public PhoneNumber(String dbString) {
        if (dbString != null) {
            String[] split = dbString.split("-");
            countryCode = split[0];
            stateCode = split[1];
            number = split[2];
        }
    }


    @Override
    public String toString() {
        return "PhoneNumber{" +
                "countryCode='" + countryCode + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public PhoneNumber() {
    }
}
