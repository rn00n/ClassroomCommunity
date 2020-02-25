package com.team3.board.service;

import com.team3.board.model.BoardDAO;
import com.team3.board.model.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//게시판 리스트 조회
public class BoardListService implements BoardServiceImpl {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        BoardDAO dao = BoardDAO.getInstance();
        ArrayList<BoardDTO> list = dao.getBoardList();
        request.setAttribute("list", list);
    }
}
