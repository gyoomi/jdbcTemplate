/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core;

import cn.jdbc.core.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/3 10:14
 */
public class Test {
    public static Object query1(String sql)throws SQLException{
        // 局部内部类方式
        class queryStatementCallback implements StatementCallback{

            @Override
            public Object handleResultSet(Statement st) throws SQLException {
                ResultSet rsToUse = st.executeQuery(sql);
                User user = null;
                List<User> list = new ArrayList<>();
                while (rsToUse.next()){
                    user = new User();
                    user.setId(rsToUse.getInt("id"));
                    user.setUsername(rsToUse.getString("username"));
                    user.setSex(rsToUse.getString("sex"));
                    user.setAddress(rsToUse.getString("address"));
                    user.setRemark(rsToUse.getString("remark"));
                    list.add(user);
                }
                return list;
            }
        }
        JdbcTemplate jdbc = new JdbcTemplate();
        Object obj = jdbc.query(new queryStatementCallback());
        return obj;
    }

    public static Object query2(String sql) throws SQLException {
        // 匿名内部类方式
        return new JdbcTemplate().query(new StatementCallback() {
            @Override
            public Object handleResultSet(Statement st) throws SQLException {
                ResultSet rsToUse = st.executeQuery(sql);
                User user = null;
                List<User> list = new ArrayList<>();
                while (rsToUse.next()){
                    user = new User();
                    user.setId(rsToUse.getInt("id"));
                    user.setUsername(rsToUse.getString("username"));
                    user.setSex(rsToUse.getString("sex"));
                    user.setAddress(rsToUse.getString("address"));
                    user.setRemark(rsToUse.getString("remark"));
                    list.add(user);
                }
                return list;
            }
        });
    }


    public static void main(String[] args) throws SQLException {
        String sql = " select t.* from t_user t ";
        List<User> list1 = (List<User>) Test.query1(sql);
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        List<User> list2 = (List<User>) Test.query2(sql);
        list2.forEach(System.out::println);
    }
}
