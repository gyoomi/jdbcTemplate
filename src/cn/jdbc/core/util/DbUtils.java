/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/4/8 14:46
 */
public class DbUtils {

    /**
     * 得到mysql连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pink", "root", "root");
    }

    public void test(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pink", "root", "root");
            //conn.prepareStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
