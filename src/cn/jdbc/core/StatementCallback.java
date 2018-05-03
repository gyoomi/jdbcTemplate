/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * ResultSet 回调接口
 *
 * @author Leon
 * @version 2018/5/3 10:17
 */
public interface StatementCallback {

    Object handleResultSet(Statement st) throws SQLException;
}
