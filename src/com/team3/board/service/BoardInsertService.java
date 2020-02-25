package com.team3.board.service;

import com.team3.board.model.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInsertService implements BoardServiceImpl {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String user_id = request.getParameter("user_id");

        BoardDAO dao = BoardDAO.getInstance();
        dao.insertBoard(title, content, user_id);
    }
}
