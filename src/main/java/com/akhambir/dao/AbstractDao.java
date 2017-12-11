package com.akhambir.dao;

import com.akhambir.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDao<T> implements GenericDao<T> {

    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public T findById(Long id) {
        String sql = null;

        return null;
    }

    public T update(T t) {
        String sql = null;
        PreparedStatement statement = null;
        try {
            sql = getSql(t);
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getSql(T t) throws Exception {

        String tableName = t.getClass().getAnnotation(Table.class).value();
        String id = getId(t);
        String values = processValues(getValues(t));

        return "UPDATE " +
                tableName +
                " SET " +
                values +
                " WHERE ID = " +
                id;

    }

    private String processValues(Map<String, String> values) {
        return values.entrySet().stream()
                .map(k -> String.format("%s='%s'", k.getKey(), k.getValue()))
                .collect(Collectors.joining(", "));

    }

    private String getId(T t) {
        for (Field f : t.getClass().getDeclaredFields()) {
            Id id = f.getAnnotation(Id.class);
            if (id != null) {
                f.setAccessible(true);
                try {
                    return f.get(t).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

    private Map<String, String> getValues(T t) {
        Map<String, String> result = new HashMap<>();

        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                try {
                    result.put(column.value(), field.get(t).toString());
                } catch (IllegalAccessException e) {
                    System.out.println("Exception getMap");
                }
            }
        }
        return result;

    }

        /*
        field.setAccessible(true);
        Column column = field.getAnnotation(Column.class);
        map.put(column.value(), field.get(t).toString());
        Optional.ofNullable(column)
                .map(new Fu)
    }

    private Map<String, Object> toMap(Column column) {
        Map<String, Object> result = new HashMap<>();
        result.put(column.value(), )
    }*/


    /*private Map<String, Object> getValues(Field[] fields, Class<T> clazz) {



                //.collect(HashMap::new, (m, a) -> m.put(a.value(), getValueField))
        return null;
    }*/
}
