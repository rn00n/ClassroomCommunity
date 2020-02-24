package com.team3.user.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    final String SELECT = "SELECT * FROM users WHERE id=?";
    final String INSERT = "INSERT INTO users VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE users SET pw=?";
    final String DELETE = "DELETE FROM users WHERE id=?;";

    private static UserDAO dao = new UserDAO();

    private DataSource dataSource;

    private UserDAO() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            dataSource = (DataSource)envCtx.lookup("jdbc/orcl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserDAO getInstance() {
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }

    //insert
    public void insert(String id, String name, String pw, String phone) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(INSERT);

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pw);
            pstmt.setString(4, phone);

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //select
    public UserDTO select(String _id) {
        UserDTO dto = null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(SELECT);
            pstmt.setString(1, _id);

            resultSet = pstmt.executeQuery();

            if(resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String pw = resultSet.getString("pw");
                String phone = resultSet.getString("phone");

                dto = new UserDTO(id, name, pw, phone);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(pstmt != null) pstmt.close();
                if(connection != null) connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return dto;
    }

    //update
    public void update() {

    }

    //delete
    public void delete() {

    }

}
