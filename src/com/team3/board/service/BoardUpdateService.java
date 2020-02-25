package com.team3.board.service;

import com.team3.board.model.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//제목, 본문을 수정
public class BoardUpdateService implements BoardServiceImpl{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String s_id = request.getParameter("id");
        long id = Long.parseLong(s_id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateContent(id, title, content);
    }
}
