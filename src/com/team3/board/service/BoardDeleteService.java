package com.team3.board.service;

import com.team3.board.model.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteService implements BoardServiceImpl{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String s_id = request.getParameter("id");
        long id = Long.parseLong(s_id);

        BoardDAO dao = BoardDAO.getInstance();
        dao.deleteContent(id);
    }
}
