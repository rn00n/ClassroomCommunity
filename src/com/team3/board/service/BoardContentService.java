package com.team3.board.service;

import com.team3.board.model.BoardDAO;
import com.team3.board.model.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardContentService implements BoardServiceImpl {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String s_id = request.getParameter("id");
        long l_id = Long.parseLong(s_id);
        BoardDAO dao = BoardDAO.getInstance();
        BoardDTO dto = dao.getContent(l_id);
        request.setAttribute("dto", dto);
    }
}
