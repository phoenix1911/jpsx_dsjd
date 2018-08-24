package test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pojo.Student;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

/**
 * Created by Tjl on 2018/8/24 14:28.
 * 封装:提供sava(Object obj),将对象中的数据保存再数据库表中
 * 1.类型--表的应关系
 * 2.类型中的属性--表中的字段 的对应关系
 * 可以由配置文件建立student.xml
 * 3.save保存功能,需要考虑sql语句的生成
 * 不固定的地方:insert into tableName1(columnNames2) values(?3);
 *              prep.setType4(index,value5);
 *  也可以由配置文件解决 --object
 */
public class ORMUtil {

    //保存全类名与表名的对应关系 :key :全类名 values:表名
    private Map<String, String> tableMap = new HashMap<>();
    //保存类中的属性[property] 与表中字段的对应关系
    private Map<String, String> columnMap = new HashMap<>();

    public ORMUtil() {
        this("mybatis_part1/src/test/student.xml");
    }
    public ORMUtil(String configPath){
        //解析配置文件,获取需要的信息
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(configPath));
            //获取根元素<class name="pojo.Student" table="students">
            Element rootElement = document.getRootElement();
            //获取class标签中的name属性值与table属性值
            String classname = rootElement.attributeValue("name");
            String tablename = rootElement.attributeValue("table");
            System.out.println(classname+" : "+tablename);
            tableMap.put(classname, tablename);
            //获取class标签内的所有子标签<property name="stuId" column="stud_id"></property>
            List<Element> propertyList = rootElement.elements();
            //遍历所有property子标签,获取name属性值和column属性值
            for (int i = 0; i < propertyList.size(); i++) {
                //获取到每一个property子标签
                Element propertyElement = propertyList.get(i);
                //获取name属性值和column属性值
                String propertyName = propertyElement.attributeValue("name");
                String columnName = propertyElement.attributeValue("column");
                System.out.println(propertyName+" : "+columnName);
                columnMap.put(propertyName, columnName);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(tableMap);
        System.out.println(columnMap);
    }

    public void save(Object obj) {
        Class<? extends Object> objClass = obj.getClass();
        String className = objClass.getName();
        String tableName = tableMap.get(className);
        System.out.println(className+" : "+tableName);
        //根据遍历属性-字段的集合,生成字段列表字符串,问号字符串,每个索引位置字段对应的属性的值,类型
        String columnNameStr = "";
        String wenhaostr = "";
        //声明一个遍历记录记录当前是第几个问号
        int index = 1;
        //声明两个集合,保存第几个问号是什么值,什么类型 key:索引 value:值/类型
        Map<Integer, Object> fieldValues = new HashMap<>();
        Map<Integer, Object> fieldTypeNames = new HashMap<>();





        //获取到所有当前类型的属性名列表
        Set<String> keySet = columnMap.keySet();
        for (String fieldName : keySet) {
            //获取到每一个字段名
            String columnName = columnMap.get(fieldName);
            //拼接到字段名列表字符串上
            columnNameStr += columnName + ",";
            wenhaostr += "?,";
            System.out.println("*************"+columnNameStr);
            try {
                //根据columnMap的key ,也就是属性名,以及
                Field declaredField = objClass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object fieldVlaue = declaredField.get(obj);
                String fieldTypeName = declaredField.getType().getName();
                System.out.println("第"+index+"个问号,对应的字段是 "+ columnName+"属性是:"+fieldName+" : "+fieldVlaue+" : "+fieldTypeName);
                //key:序号 value:类型的值
                fieldValues.put(index, fieldVlaue);
                fieldTypeNames.put(index, fieldTypeName);

            } catch (Exception e) {
                e.printStackTrace();
            }

            index++;
        }
        String sql = "insert into "+tableName+"("+subString(columnNameStr)+") values("+subString(wenhaostr)+")";
        System.out.println(sql);
        System.out.println(fieldValues);
        System.out.println(fieldTypeNames);
        Connection conn = null;
        PreparedStatement preparedStatement=null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORACLE","briup","123456");
            preparedStatement = conn.prepareStatement(sql);
            Set<Integer> indexKeys = fieldValues.keySet();
            for (int indexkey :
                    indexKeys) {
                Object value = fieldValues.get(indexkey);
                String valueType = (String) fieldTypeNames.get(indexkey);
                if (valueType.contains("String")) {
                    preparedStatement.setString(indexkey,(String)value);
                }else if (valueType.contains("int")) {
                    preparedStatement.setInt(indexkey,(int)value);
                }else if (valueType.contains("Date")) {
                    preparedStatement.setDate(indexkey, new java.sql.Date(((Date)value).getTime()));
                }
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String subString(String s) {
        return s.substring(0,s.length() - 1);
    }

    public static void main(String[] args) {
        ORMUtil ormUtil = new ORMUtil();
        Student student = new Student(100, "tom", "123.qq.com", new Date());
        ormUtil.save(student);

    }
}
