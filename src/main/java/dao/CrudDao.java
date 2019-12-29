package dao;


import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T, U> {
    void add(T object);

    List<T> getAll();

    T getById(U id) throws SQLException;

    void update(T object) throws SQLException;

    void delete(T object) throws SQLException;

}