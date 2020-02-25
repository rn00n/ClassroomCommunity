package com.team3.board.service;

import com.team3.board.model.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardAnswerInsertService implements BoardServiceImpl {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("2");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String user_id = request.getParameter("user_id");
        int groups = Integer.parseInt(request.getParameter("groups"));
        int depth = Integer.parseInt(request.getParameter("depth"));
        int sort = Integer.parseInt(request.getParameter("sort"));

        System.out.println("3");
        BoardDAO dao = BoardDAO.getInstance();
        dao.insertBoard(title, content, user_id, groups, depth, sort);
        System.out.println("7");
    }
}
