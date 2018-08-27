package handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import pojo.PhoneNumber;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Tjl on 2018/8/25 10:18.
 */
public class PhoneNumberHander extends BaseTypeHandler<PhoneNumber> {
    //1.ps.setType(i,parameter)
    //遇到PreparedStatement进行设置值的时候
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
        System.out.println("要去保存一个电话号了,怎么保存,要做set处理");
        preparedStatement.setString(i,phoneNumber.getAsString());
    }
    //怎么把数据库中phone字段的值转换为PhoneNumber类型对象
    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new PhoneNumber(resultSet.getString(s));
    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new PhoneNumber(resultSet.getString(i));
    }

    @Override
    public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new PhoneNumber(callableStatement.getString(i));
    }
}
