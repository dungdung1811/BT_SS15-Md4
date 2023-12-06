package com.ra.model.dao;

import com.ra.model.entity.User;
import com.ra.ulti.ConnectionDatabase;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Boolean create(User user) {
        return null;
    }

    @Override
    public Boolean update(User user, Integer integer) {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User login(User user) {
        Connection connection = ConnectionDatabase.openconnection();
        String sql = "SELECT * FROM user.user WHERE email = ?";
        User getDBUser = new User();
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,user.getEmail());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                getDBUser.setId(rs.getInt("id"));
                getDBUser.setUserName(rs.getString("name"));
                getDBUser.setEmail(rs.getString("email"));
                getDBUser.setPassword(rs.getString("password"));
                getDBUser.setRole(rs.getBoolean("role"));
            }

            if (BCrypt.checkpw(user.getPassword(),getDBUser.getPassword())){
                return getDBUser;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }

        return null;
    }
    @Override
    public Boolean register(User user) {
        Connection connection = ConnectionDatabase.openconnection();
        String sql = "INSERT INTO  user.user(name, email, password) values (?,?,?)";
        String salt = BCrypt.gensalt(12);
        String hashedPass = BCrypt.hashpw(user.getPassword(),salt);
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,user.getUserName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3,hashedPass);
            int check = pstm.executeUpdate();
            if(check > 0 ){
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }

        return false;
    }
}
