package com.aidyninho.greet.dao;

import com.aidyninho.greet.model.User;
import com.aidyninho.greet.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final String DELETE_SQL = "DELETE FROM users WHERE id = ?";
    private static final String SELECT_SQL = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO users (firstname, lastname) VALUES (?, ?)";
    private static final String UPDATE_SQL = "UPDATE users SET firstname = ?, lastname = ? WHERE id = ?";

    private UserDao() {}

    public boolean delete(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, user.firstname());
            preparedStatement.setString(2, user.lastname());
            preparedStatement.setLong(3, user.id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, user.firstname());
            preparedStatement.setString(2, user.lastname());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getById(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);
            preparedStatement.setLong(1, id);
            User user = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname")
                );
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
