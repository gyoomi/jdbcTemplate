/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core;

import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * beanRowMapper
 *
 * @author Leon
 * @version 2018/4/9 9:21
 */
public class BeanRowMapper<T> implements RowMapper<T> {

    private Class targetClazz;

    private Map<String,Field> fieldMap;

    public BeanRowMapper(Class targetClazz) {
        this.targetClazz = targetClazz;
        fieldMap = new HashMap<>();
        Field[] fields = this.targetClazz.getDeclaredFields();
        for (Field field : fields) {
            fieldMap.put(field.getName(), field);
        }
    }

    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        T obj = null;
        try {
            obj = (T) targetClazz.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            String columnName = null;
            for (int j = 0; j < columnCount; j++) {
                columnName = metaData.getColumnName(j);
                Class<?> type = fieldMap.get(columnName).getType();
                Field field = fieldMap.get(columnName);
                field.setAccessible(true);
                if (type == Integer.class){
                    field.set(obj, resultSet.getInt(columnName));
                } else if(type == Double.class) {
                    field.set(obj, resultSet.getInt(columnName));
                } else if(type == Boolean.class) {
                    field.set(obj, resultSet.getBoolean(columnName));
                }else if(type == String.class) {
                    field.set(obj, resultSet.getString(columnName));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
