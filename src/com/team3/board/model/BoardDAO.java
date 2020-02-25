package com.team3.board.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BoardDAO {
    final String SELECT_CONTENT = "SELECT * FROM board WHERE id = ?";
    final String SELECT_CONTENT_LIST = "SELECT * FROM board ORDER BY groups DESC, sort ASC ";
    final String INSERT_NEW_CONTENT = "INSERT into board (id, title, content, users_id, createdTime, updatedTime, category, groups, depth, sort, hit) values (board_seq.nextval, ?, ?, ?, ?, ?, 0, board_seq.currval, 0, 0, 0)";
    final String INSERT_ANSWER_CONTENT = "INSERT into board (id, title, content, users_id, createdTime, updatedTime, category, groups, depth, sort, hit) values (board_seq.nextval, ?, ?, ?, ?, ?, 0, ?, ?, ?, 0)";
    final String UPDATE_CONTENT = "UPDATE board SET title=?, content=?, updatedTime=? WHERE id = ?";
    final String UPDATE_SORT = "UPDATE board SET sort=sort+1 WHERE groups = ? and sort > ?";
    final String UPDATE_HIT = "UPDATE board SET hit=hit+1 WHERE id = ?";
    final String DELETE = "DELETE board WHERE id = ?";

    //Singleton pattern
    private static BoardDAO dao = new BoardDAO();

    private DataSource dataSource;

    private BoardDAO() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            dataSource = (DataSource)envCtx.lookup("jdbc/orcl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BoardDAO getInstance() {
        if (dao == null) {
            dao = new BoardDAO();
        }
        return dao;
    }

    //새 게시물 작성
    public void insertBoard(String title, String content, String user_id) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(INSERT_NEW_CONTENT);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, user_id);
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //답글 작성(오버로드)
    public void insertBoard(String title, String content, String user_id, int groups, int depth, int sort) {
        System.out.println("4");

        addSort(groups, depth + 1, sort);

        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(INSERT_ANSWER_CONTENT);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, user_id);
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setInt(6, groups);
            pstmt.setInt(7, depth + 1);
            pstmt.setInt(8, sort + 1);
            System.out.println("5");
            pstmt.executeUpdate();
            System.out.println("6");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //게시물 조회
    public BoardDTO getContent(Long _id) {
        BoardDTO dto = null;

        addHit(_id); //게시물에 조회할때 조회수 증가

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(SELECT_CONTENT);
            pstmt.setLong(1, _id);

            resultSet = pstmt.executeQuery();

            if(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String user_id = "1";
                Timestamp createdTime = resultSet.getTimestamp("createdTime");
                Timestamp updatedTime = resultSet.getTimestamp("updatedTime");
                int category = resultSet.getInt("category");
                int groups = resultSet.getInt("groups");
                int depth = resultSet.getInt("depth");
                int sort = resultSet.getInt("sort");
                int hit = resultSet.getInt("hit");

                dto = new BoardDTO(id, title, content, user_id, createdTime, updatedTime, category, groups, depth, sort, hit);
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

    //게시물 수정
    public void updateContent(long id, String title, String content) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(UPDATE_CONTENT);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setLong(4, id);

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //게시물 삭제
    public void deleteContent(long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(DELETE);

            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //getBoardList
    public ArrayList<BoardDTO> getBoardList() {
        ArrayList<BoardDTO> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(SELECT_CONTENT_LIST);

            resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String user_id = "1";
                Timestamp createdTime = resultSet.getTimestamp("createdTime");
                Timestamp updatedTime = resultSet.getTimestamp("updatedTime");
                int category = resultSet.getInt("category");
                int groups = resultSet.getInt("groups");
                int depth = resultSet.getInt("depth");
                int sort = resultSet.getInt("sort");
                int hit = resultSet.getInt("hit");

                BoardDTO dto = new BoardDTO(id, title, content, user_id, createdTime, updatedTime, category, groups, depth, sort, hit);

                list.add(dto);
            }

            return list;
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
        return list;
    }

    //조회수
    private void addHit(long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(UPDATE_HIT);

            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //sort증가
    public void addSort(int groups, int depth, int sort) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement(UPDATE_SORT);

            pstmt.setInt(1, groups);
            pstmt.setInt(2, sort);

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(pstmt != null) pstmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
