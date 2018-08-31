package service.serviceImpl;

import bean.User;
import common.util.SqlSessionFactoryUtil;
import dao.UserDaoMapper;
import service.UserService;

/**
 * Created by Tjl on 2018/8/30 14:16.
 */
public class UserServiceImpl implements UserService {

    //用户的数据访问层
    private UserDaoMapper userDao;
    {
        userDao = SqlSessionFactoryUtil.getSqlSession(true).getMapper(UserDaoMapper.class);
    }

    /**
     * 注册方法
     * 实现思路
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
//        try{
//            if (user.getUsername()==null||user.getPassword()==null||user.getPhone()==null||user.getEmail()==null||user.getZip()==null){
//                return false;
//            }
//            SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            mapper.insertUserAutoId(user);
//            sqlSession.commit();
//            return true;
//        }catch (Exception e){
//            return false;
//        }


//       * 1.先判断用户名和密码是否为空,如果为空,则返回false
//        前台不输入会传入空字符串,不是null
        if ("".equals(user.getUsername())) {
            return false;
        }if ("".equals(user.getPassword())) {
            return false;
        }
//        * 2.再判断用户名是不是唯一,如果不是唯一的,则返回false
        User dbUser = userDao.findUserByUsername(user.getUsername());
        if (dbUser != null) {
            return false;
        }
//        * 3.将用户信息插入到数据库中(操作数据)
        int update = userDao.insertUserAutoId(user);
//        * 4.如果插入成功,则返回true
        if (update > 0) {
            return true;
        }
//        * 5.如果插入失败,则返回false
        else{
            return false;
        }

    }

    /**
     * 登陆方法
     * @param user
     * @return
     */
    @Override
    public boolean login(User user) {
//        1.首先判断用户名,密码是否为空字符串
        if ("".equals(user.getUsername())||"".equals(user.getPassword())) {
            return false;
        }
//        2.用数据库里查询到的信息和前台传来的信息进行比对
        User dbUser = userDao.findUserByUsername(user.getUsername());
        if (user.getPassword().equals(dbUser.getPassword())) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public boolean UpdateUserById(String id,String zip, String phone, String email) {
        //获取该user

        System.out.println(id);
        User dbUser = userDao.findUserById(Integer.parseInt(id));
        System.out.println(dbUser+"执行了?");
        dbUser.setZip(zip);
        dbUser.setPhone(phone);
        dbUser.setEmail(email);
        int i = userDao.updateUser(dbUser);
        if (i==1){
            return true;
        }else{
            System.out.println(i);
            return false;
        }

    }

    @Override
    public int updateUserPwdByUsername(String username, String oldpassword, String newpassword, String repassword) {
        System.out.println("username"+username+" ???");
        System.out.println("oldpassword"+oldpassword);
        System.out.println("newpassword"+newpassword);
        System.out.println("repassword"+repassword);
        User user = userDao.findUserByUsername(username);
        System.out.println(user);

        //旧密码和数据库密码不匹配 或旧密码为空 返回0
        if (!oldpassword.equals(user.getPassword())||"".equals(oldpassword)) {
            System.out.println();
            return 0;
        }
        //新密码为空或重复密码为空返回 1
        if ("".equals(newpassword) || "".equals(repassword)) {
            return 1;
        }
        //新密码等于重复密码 修改成功 返回3
        if (newpassword.equals(repassword)) {
            user.setPassword(newpassword);
            userDao.updateUser(user);
            return 3;
        } else {//新密码不等于确认密码 返回2
            return 2;
        }

    }

//    public static void main(String[] args) {
//        User aaa = new UserServiceImpl().findUserByUsername("aaa");
//        System.out.println(aaa);
//    }
}
