/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core;

import cn.jdbc.core.util.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JdbcTemplate Class
 *
 * @author Leon
 * @version 2018/5/3 10:13
 */
public class JdbcTemplate {

    public final Object execute(StatementCallback sc){
        Connection conn = null;
        Statement stmt = null;
        Object obj = null;
        try {
            conn = DbUtils.getConnection();
            stmt = conn.createStatement();
            obj = sc.handleResultSet(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public Object query(StatementCallback sc) throws SQLException{
        return execute(sc);
    }
}
